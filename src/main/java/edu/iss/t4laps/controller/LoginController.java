package edu.iss.t4laps.controller;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.model.User;
import edu.iss.t4laps.service.EmployeeService;
import edu.iss.t4laps.service.UserService;
import edu.iss.t4laps.validator.UserValidator;

@Controller
@RequestMapping(value = "/home")
public class LoginController {

	@Autowired
	private UserService uService;

	@Autowired
	private EmployeeService eService;
	
	@Autowired
	private UserValidator uValidator;
	
	@InitBinder("user")
	private void initRoleBinder(WebDataBinder binder) {
		binder.addValidators(uValidator);
		
		
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@Valid @ModelAttribute("user") User user, HttpSession session, BindingResult result,HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		int output= uService.validateUser(user.getUserId(), user.getPassword());
		if(output==1)
		{
		if (user.getUserId() != null && user.getPassword() != null) {
			User u = uService.authenticate(user.getUserId(), user.getPassword());
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			us.setEmployee(eService.findEmployee(us.getUser().getEmployeeId()));
			String name=eService.EmployeeName(us.getUser().getEmployeeId());
			req.getSession().setAttribute("empName", name);		
			ArrayList<EmployeeDetails> subordinates = eService.findSubordinates(us.getUser().getEmployeeId());
			if (subordinates != null) {
				us.setSubordinates(subordinates);
			}
			mav = new ModelAndView("redirect:/staff/viewleavehistoryPage");
		} 
		}
		else {
			String message="The UserId or Password you entered is incorrect";
			req.setAttribute("message", message);
			return new ModelAndView("login");
		}
		session.setAttribute("USERSESSION", us);
		
		return mav;
	}

}
