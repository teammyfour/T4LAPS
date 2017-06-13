package edu.iss.t4laps.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.t4laps.model.LeaveHistory;
import edu.iss.t4laps.service.LeaveHistoryService;
import edu.iss.t4laps.validator.EmailNotification;
import edu.iss.t4laps.validator.LeaveDateValidator;

@Controller
@RequestMapping(value = "/staff")
public class staffController {

	@Autowired
	private LeaveHistoryService leaveHistoryService;

	@RequestMapping(value = "/applyleave")
	public String applyLeave(HttpServletRequest req, HttpServletResponse res) {
		return "applyleave";
	}
	@RequestMapping(value = "/homepage")
	public String goToHome(HttpServletRequest req, HttpServletResponse res) {
		return "home";
	}

	@RequestMapping(value = "/viewleavehistory")
	public ModelAndView viewLeaveHistory(HttpServletRequest req, HttpServletResponse res,HttpSession session) {
		Date date = null;
		Date date1 = null;
		UserSession us= (UserSession) session.getAttribute("USERSESSION");
		int emplyeeId = (us.getEmployee().getEmployeeId());
		String name = req.getParameter("txtname");
		String leavetype = req.getParameter("leavetype");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String reason = req.getParameter("txtreason");
		String status = "SUBMITTED";
		req.getSession().setAttribute("empId", emplyeeId);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		try {
			date = format.parse(startDate);
			date1 = format.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, that's not valid. Please try again.");
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/DD");
		java.sql.Date startDateSql = new java.sql.Date(date.getTime());
		java.sql.Date endDateSql = new java.sql.Date(date1.getTime());
		LeaveDateValidator datevalidation = new LeaveDateValidator();
		int workingDays=datevalidation.getWorkingDaysBetweenTwoDates(date, date1);
		int numOfPublicholidays = leaveHistoryService.findDates(startDateSql, endDateSql);
	    workingDays=workingDays-numOfPublicholidays;
	    int appliedLeaveDays=leaveHistoryService.findTotalDays(emplyeeId,leavetype);
	    int annualLeaves=leaveHistoryService.findAnualWorkingDays(emplyeeId);
	    int medicalLeaves=leaveHistoryService.findMedicalWorkingDays(emplyeeId);
	    int remaining_workingDays=annualLeaves-appliedLeaveDays;
	    ModelAndView mv=new ModelAndView();
	    
	    if(appliedLeaveDays <= annualLeaves && workingDays<=14  && workingDays <=remaining_workingDays)
	    {
	    LeaveHistory leavehistory = new LeaveHistory(emplyeeId, leavetype, date, date1, reason, status,workingDays);
	    leaveHistoryService.insertLeave(leavehistory);
	    ArrayList<LeaveHistory> leaveHistoryList=leaveHistoryService.findAll(emplyeeId);
	    String email_id=leaveHistoryService.findEmailId(emplyeeId);
	    EmailNotification emailNotification=new EmailNotification();
	    emailNotification.sendEmail(email_id,emplyeeId);
	  
	    mv.setViewName("viewleavehistory");
	    mv.addObject("leavehistoryList",leaveHistoryList);
	    }
	    else
	    {
	    	mv.setViewName("noLeavesBalance");
	    }
	 
		return mv;
	}
	@RequestMapping(value = "/viewleavehistoryPage")
	public ModelAndView viewleavehistoryPage(HttpServletRequest req, HttpServletResponse res,HttpSession session)
	{
		UserSession us= (UserSession) session.getAttribute("USERSESSION");
		int empId=us.getEmployee().getEmployeeId();
		req.getSession().setAttribute("empId",empId);
		
		 ArrayList<LeaveHistory> leaveHistoryList=leaveHistoryService.findAll(us.getEmployee().getEmployeeId());
		    ModelAndView mv=new ModelAndView();
		    mv.setViewName("viewleavehistory");
		    mv.addObject("leavehistoryList",leaveHistoryList);
		    return mv;
	}
	@RequestMapping(value = "/applyleave_edit")
   public ModelAndView applyleaveEdit(HttpServletRequest req, HttpServletResponse res)
   {
		
	   int leaveId=Integer.parseInt(req.getParameter("id"));
	   req.getSession().setAttribute("leaveId", leaveId);
	   LeaveHistory leavehistoryedit=leaveHistoryService.findEditLeaveDetails(leaveId);
	   String empName=leaveHistoryService.findEmpName(leaveId);
	   req.getSession().setAttribute("empName", empName);
	   ModelAndView mv=new ModelAndView();
	   mv.setViewName("applyleave-edit");
	   mv.addObject("leavehistoryedit",leavehistoryedit);
	 
	   return mv;
   }
	@RequestMapping(value="/leavehistory_edit")
	public ModelAndView leaveHistoryEdit(HttpServletRequest req, HttpServletResponse res,HttpSession session)
	{
		Date date = null;
		Date date1 = null;
		int leaveId=(int) (req.getSession().getAttribute("leaveId"));
		UserSession us= (UserSession) session.getAttribute("USERSESSION");
		int emplyeeId = (us.getEmployee().getEmployeeId());
		req.getSession().setAttribute("empId", emplyeeId);
		String name = req.getParameter("txtname");
		String leavetype = req.getParameter("leavetype");
		String startDate = req.getParameter("startDate");
		String endDate = req.getParameter("endDate");
		String reason = req.getParameter("txtreason");
		String status = "UPDATED";
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		try {
			date = format.parse(startDate);
			date1 = format.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Sorry, that's not valid. Please try again.");
		}
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/DD");
		java.sql.Date startDateSql = new java.sql.Date(date.getTime());
		java.sql.Date endDateSql = new java.sql.Date(date1.getTime());
		LeaveDateValidator datevalidation = new LeaveDateValidator();
		int workingDays=datevalidation.getWorkingDaysBetweenTwoDates(date, date1);
		int numOfPublicholidays = leaveHistoryService.findDates(startDateSql, endDateSql);
	    workingDays=workingDays-numOfPublicholidays;
	    //LeaveHistory leavehistory = new LeaveHistory(leaveId,emplyeeId, leavetype, date, date1, reason, status,workingDays);
	    
	    int rows_affected=leaveHistoryService.updateLeaveHistory(leaveId,emplyeeId, leavetype, startDateSql,  endDateSql, reason, status,workingDays);
	    ArrayList<LeaveHistory> leaveHistoryList=leaveHistoryService.findAll(emplyeeId);
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("viewleavehistory");
	    mv.addObject("leavehistoryList",leaveHistoryList);
		
		return mv;
	}
	@RequestMapping(value="/applyleave_cancel")
	public ModelAndView leaveHistoryCancel(HttpServletRequest req, HttpServletResponse res,HttpSession session)
	{
		int leaveId=Integer.parseInt(req.getParameter("leaveid"));
		System.out.println(req.getParameter("leaveid"));
		UserSession us= (UserSession) session.getAttribute("USERSESSION");
		int employeeId = (us.getEmployee().getEmployeeId());
		
		System.out.println(req.getParameter("empid"));
		String status="CANCELLED";
		int rows_affected=leaveHistoryService.updateStatus(leaveId, status);
		ArrayList<LeaveHistory> leaveHistoryList=leaveHistoryService.findAll(employeeId);
		ModelAndView mv=new ModelAndView();
		mv.setViewName("viewleavehistory");
		mv.addObject("leavehistoryList",leaveHistoryList);
		return mv;
	}
	@RequestMapping(value="/applycompensationleave")
	public String applyLeaveCompensation(HttpServletRequest req, HttpServletResponse res)
	{
		return "leavecompenstation";
	}
	
	@RequestMapping(value="/leavecompensationPage")
	public String leaveCompensationSubmittedPage(HttpServletRequest req, HttpServletResponse res)
	{
		return "compensation-leave-submitted";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/home/login";

	}
	
}
