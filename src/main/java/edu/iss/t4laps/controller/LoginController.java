package edu.iss.t4laps.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.model.User;
import edu.iss.t4laps.service.EmployeeService;
import edu.iss.t4laps.service.UserService;

@Controller
@RequestMapping(value = "/home")
public class LoginController {

	@Autowired
	private UserService uService;

	@Autowired
	private EmployeeService eService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logic(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors())
			return mav;
		UserSession us = new UserSession();
		if (user.getName() != null && user.getPassword() != null) {
			User u = uService.authenticate(user.getName(), user.getPassword());
			us.setUser(u);
			// PUT CODE FOR SETTING SESSION ID
			us.setSessionId(session.getId());
			us.setEmployee(eService.findEmployee(us.getUser().getEmployeeId()));
			mav = new ModelAndView("redirect:/staff/viewleavehistoryPage");
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}

}
