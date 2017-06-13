package edu.iss.t4laps.controller;


import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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


import edu.iss.t4laps.exception.PublicHolidayNotfound;
import edu.iss.t4laps.model.PublicHolidays;
import edu.iss.t4laps.service.PublicHolidayService;
import edu.iss.t4laps.validator.PublicHolidayValidator;




@RequestMapping(value="/adminholiday")
@Controller
public class AdminPublicHolidayController {
	@Autowired
	private PublicHolidayService phService;
	@Autowired
	private PublicHolidayValidator phValidator;
	
	@InitBinder("publicholiday")
	private void initRoleBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
		binder.addValidators(phValidator);
		
	}

		@RequestMapping(value = "/publicholiday/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/home/login";

		}		
		
	@RequestMapping(value = "/publicholiday/create", method = RequestMethod.GET)
	public ModelAndView newRolePage() {
		ModelAndView mav = new ModelAndView("publicholiday-new");
		mav.addObject("publicholiday", new PublicHolidays());
		return mav;
	}
	
	

	@RequestMapping(value = "/publicholiday/create", method = RequestMethod.POST)
	public ModelAndView createNewPublicHoliday(@Valid @ModelAttribute("publicholiday") PublicHolidays publicholiday, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("publicholiday-new");

		ModelAndView mav = new ModelAndView();
		String message = "New public holiday " + publicholiday.getHoliday_date() + " was successfully created.";
		
//		publicholiday.setHoliday_date(publicholiday.getHoliday_date());
		
		phService.createPublicHoliday(publicholiday);
		mav.setViewName("redirect:/adminholiday/publicholiday/list");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/publicholiday/list", method = RequestMethod.GET)
	public ModelAndView publicholidayListPage() {
		
//		UserSession us = (UserSession) session.getAttribute("USERSESSION");
//		ModelAndView mav = new ModelAndView("login");
//		if (us.getSessionId() != null) {
		
		ModelAndView mav = new ModelAndView("publicholiday-list");
		List<PublicHolidays> publicholidayList = phService.findAllHoliday();
		mav.addObject("publicholidayList", publicholidayList);
//			return mav;
//		}
		return mav;
	}

	@RequestMapping(value = "/publicholiday/edit/{occasion}", method = RequestMethod.GET)
	public ModelAndView editpublicholidayPage(@PathVariable String occasion) {
		ModelAndView mav = new ModelAndView("publicholiday-edit");
		PublicHolidays holiday = phService.findPublicHoldiayByOcasion(occasion);
		mav.addObject("publicholiday",holiday);
		return mav;
	}

	@RequestMapping(value = "/publicholiday/edit/{occasion}", method = RequestMethod.POST)
	public ModelAndView editRole(@Valid @ModelAttribute("publicholiday") PublicHolidays publicholiday, BindingResult result, @PathVariable String occasion,
			final RedirectAttributes redirectAttributes)throws PublicHolidayNotfound
	{

		if (result.hasErrors())
			return new ModelAndView("publicholiday-edit");

		ModelAndView mav = new ModelAndView("redirect:/adminholiday/publicholiday/list");
		String message = "Publicholiday was successfully updated.";

		phService.changePublicHoliday(publicholiday);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/publicholiday/delete/{occasion}", method = RequestMethod.GET)
	public ModelAndView deleteRole(@PathVariable String occasion, final RedirectAttributes redirectAttributes)
			throws PublicHolidayNotfound
	{

		ModelAndView mav = new ModelAndView("redirect:/adminholiday/publicholiday/list");
		PublicHolidays publicholiday = phService.findPublicHoldiayByOcasion(occasion);
		phService.removePublicHoliday(publicholiday);
		String message = "The Public Holiday " + publicholiday.getHoliday_date() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	
}
