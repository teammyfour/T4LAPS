package edu.iss.t4laps.controller;

import java.util.ArrayList;
import java.util.HashMap;

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

	@RequestMapping(value = "/detail/display/{id}", method = RequestMethod.GET)
	public ModelAndView newDepartmentPage(@PathVariable int id) {
		LeaveHistory leaveHistory = lService.findLeaveHistory(id);
		ModelAndView mav = new ModelAndView("manager-leave-details", "leaveHistory", leaveHistory);
		mav.addObject("approve", new Approve());

		return mav;

	}

	@RequestMapping(value = "/detail/edit/{id}", method = RequestMethod.POST)
	public ModelAndView approveOrRejectLeave(@ModelAttribute("approve") Approve approve, BindingResult result,
			@PathVariable Integer id, HttpSession session, final RedirectAttributes redirectAttributes) {
		if (result.hasErrors())
			return new ModelAndView("manager-leave-details");
		LeaveHistory l = lService.findLeaveHistory(id);
		UserSession us = (UserSession) session.getAttribute("USERSESSION");
		if (approve.getDecision().equalsIgnoreCase(LeaveHistory.APPROVED)) {
			l.setStatus(LeaveHistory.APPROVED);
		} else {
			l.setStatus(LeaveHistory.REJECTED);
		}
		lService.changeLeaveHistory(l);
		ModelAndView mav = new ModelAndView("redirect:/manager/approval");
		String message = "Your Status was successfully updated.";
		redirectAttributes.addFlashAttribute("message", message);

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
