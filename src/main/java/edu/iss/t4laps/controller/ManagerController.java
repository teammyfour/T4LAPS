package edu.iss.t4laps.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.iss.t4laps.javabeans.Approve;
import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.model.LeaveHistory;
import edu.iss.t4laps.service.LeaveHistoryService;
import edu.iss.t4laps.validator.EmailNotification;

@RequestMapping(value = "/manager")
@Controller
public class ManagerController {

	@Autowired
	private LeaveHistoryService lService;

	@InitBinder
	private void initBinder(WebDataBinder binder) {

	}

	@RequestMapping(value = "/approval")
	public ModelAndView decideApprovals(HttpSession session) {

		HashMap<EmployeeDetails, ArrayList<LeaveHistory>> appmap = new HashMap<EmployeeDetails, ArrayList<LeaveHistory>>();
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null) {
			for (EmployeeDetails employee : us.getSubordinates()) {
				ArrayList<LeaveHistory> lhlist = lService.findSubmittedLeaveHistoryByEID(employee.getEmployeeId());
				appmap.put(employee, lhlist);
			}
			mav = new ModelAndView("manager-approval-leavehistory");
			mav.addObject("approvalhistory", appmap);

		}

		return mav;

	}
	
	@RequestMapping(params="cancel" , method=RequestMethod.POST)
	public String cancelButton(HttpServletRequest request){
		return "redirect:/manager/approval.html";
	}

	@RequestMapping(value = "/detail/display/{id}", method = RequestMethod.GET)
	public ModelAndView newDepartmentPage(@PathVariable int id,HttpServletRequest req) {
		LeaveHistory leaveHistory = lService.findLeaveHistory(id);
		int emplyeeId =Integer.parseInt(req.getParameter("empid")) ;
		req.getSession().setAttribute("employeeId", emplyeeId);
		System.out.println(emplyeeId);
		ModelAndView mav = new ModelAndView("manager-leave-details", "leaveHistory", leaveHistory);
		mav.addObject("approve", new Approve());

		return mav;

	}

	@RequestMapping(value = "/detail/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectLeave(@ModelAttribute("approve") Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes,HttpServletRequest req) {
		if (result.hasErrors())
			return new ModelAndView("manager-leave-details");
		LeaveHistory l = lService.findLeaveHistory(id);
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		int emplyeeId =(int) req.getSession().getAttribute("employeeId");
	
		if (approve.getDecision().equalsIgnoreCase(LeaveHistory.APPROVED)) {
			l.setStatus(LeaveHistory.APPROVED);
		} else {
			l.setStatus(LeaveHistory.REJECTED);
		}
		lService.changeLeaveHistory(l);
		String status=l.getStatus();
		ModelAndView mav = new ModelAndView("redirect:/manager/approval");
		String message = "Your Status was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);
		  String email_id=lService.findEmpEmailId(emplyeeId);
		    EmailNotification emailNotification=new EmailNotification();
		    emailNotification.sendApprovalEmail(email_id, emplyeeId, status);

		return mav;

	}

	@RequestMapping(value = "/shistory", method = RequestMethod.GET)
	public ModelAndView subordinatesHistory(HttpSession session) {

		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		HashMap<EmployeeDetails, ArrayList<LeaveHistory>> submap = new HashMap<EmployeeDetails, ArrayList<LeaveHistory>>();

		for (EmployeeDetails subordinate : us.getSubordinates()) {
			submap.put(subordinate, lService.findAll(subordinate.getEmployeeId()));
		}

		ModelAndView mav = new ModelAndView("login");
		if (us.getSessionId() != null && us.getSubordinates() != null) {
			mav = new ModelAndView("/subordinates-leave-history");
			mav.addObject("submap", submap);
			return mav;
		}
		return mav;
	}
}
