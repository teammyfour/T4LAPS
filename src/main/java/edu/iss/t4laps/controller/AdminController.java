package edu.iss.t4laps.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

import edu.iss.t4laps.exception.EmployeeNotFound;
import edu.iss.t4laps.exception.EntitlementNotFound;
import edu.iss.t4laps.exception.OvertimeNotFound;
import edu.iss.t4laps.model.CombinedCommand;
import edu.iss.t4laps.model.EmpUserRole;
import edu.iss.t4laps.model.EmployeeDetails;
import edu.iss.t4laps.model.LeaveEntitlement;
import edu.iss.t4laps.model.Overtime;
import edu.iss.t4laps.model.User;
import edu.iss.t4laps.service.EmployeeService;
import edu.iss.t4laps.service.EmployeeUserRoleService;
import edu.iss.t4laps.service.EntitlementService;
import edu.iss.t4laps.service.OvertimeService;
import edu.iss.t4laps.service.UserRoleService;
import edu.iss.t4laps.service.UserService;
import edu.iss.t4laps.validator.CombinedCommandValidator;
import edu.iss.t4laps.validator.EmployeeValidator;
import edu.iss.t4laps.validator.OvertimeValidator;

@Controller
@RequestMapping(value="/admin")
public class AdminController{
	
	@Autowired
	private OvertimeService otService;
	
	@Autowired
	private EmployeeService eService;
	
	@Autowired
	private EntitlementService enService;
	
	@Autowired
	private UserRoleService urService;
	
	@Autowired
	private EmployeeUserRoleService eurService;
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private OvertimeValidator otValidator;
	
	@Autowired
	private EmployeeValidator eValidator;
	
	@Autowired
	private CombinedCommandValidator ccValidator;
	
	@InitBinder("overtime")
	private void initOvertimeBinder(WebDataBinder binder) {
		binder.addValidators(otValidator);
	}
	
	@InitBinder("employee")
	private void initEmployeeBinder(WebDataBinder binder) {
		binder.addValidators(eValidator);
	}
	
	@InitBinder("combinedCommand")
	private void initCombinedCommandBinder(WebDataBinder binder) {
		binder.addValidators(ccValidator);
	}
	
	@RequestMapping(value = "/overtime/create", method = RequestMethod.GET)
	public ModelAndView newOvertimePage() {
		ModelAndView mav = new ModelAndView("admin-overtime-create", "overtime", new Overtime());
		return mav;
	}
	
	@RequestMapping(value = "/overtime/create", method = RequestMethod.POST)
	public ModelAndView createNewRecord(@Valid @ModelAttribute("overtime") Overtime overtime, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("admin-overtime-create");

		ModelAndView mav = new ModelAndView();
		String message = "Employee of id: " + overtime.getEmployeeId() + ", overtime on date: "+overtime.getDate().toString()+ "was successfully created.";

		otService.createOvertime(overtime);
		mav.setViewName("redirect:/admin/overtime/general");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/overtime/general", method = RequestMethod.GET)
	public ModelAndView adminOvertime() {
		ModelAndView mav = new ModelAndView("admin-overtime");
		List<Overtime> overtimeList = otService.findAllOvertime();
		mav.addObject("overtimeList", overtimeList);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/overtime/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editOvertime(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("admin-overtime-edit");
		Overtime overtime = otService.findOvertime(id);
		mav.addObject("overtime", overtime);
		ArrayList<Integer> list = eService.findAllID();
		mav.addObject("managerList", list);
		return mav;
	}
	
	@RequestMapping(value = "/overtime/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteOvertime(@PathVariable int id, final RedirectAttributes redirectAttributes)
			throws OvertimeNotFound 
	{

		ModelAndView mav = new ModelAndView("redirect:/admin/overtime/general");
		Overtime overtime = otService.findOvertime(id);
		otService.removeOvertime(overtime);
		String message = "The overtime record for employee with id" + overtime.getEmployeeId() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/overtime/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editOvertime(@Valid @ModelAttribute("overtime") Overtime overtime, BindingResult result, @PathVariable int id,
			final RedirectAttributes redirectAttributes) throws OvertimeNotFound 
	{

		if (result.hasErrors())
			return new ModelAndView("admin-overtime-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/overtime/general");
		String message = "Overtime record was successfully updated.";

		otService.removeOvertime(otService.findOvertime(id));
		overtime.setOvertimeId(id);
		otService.changeOvertime(overtime);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/employee/create", method = RequestMethod.GET)
	 public ModelAndView newEmployeePage() {
	  //EmployeeDetails employee=new EmployeeDetails();
	  ModelAndView mav = new ModelAndView("admin-employee-create", "combinedCommand", new CombinedCommand());
	  ArrayList<Integer> list = eService.findAllID();
	  mav.addObject("managerList", list);
	  ArrayList<String> list2 = urService.findAllRoleId();
	  mav.addObject("roleList", list2);
	  return mav;
	 }
	 
	 @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
	 public ModelAndView createNewEmployeeRecord(@Valid @ModelAttribute("combinedCommand") CombinedCommand cc, BindingResult result,
	   final RedirectAttributes redirectAttributes) {
	  if (result.hasErrors())
	  {
	   ModelAndView mav = new ModelAndView("admin-employee-create");
	   ArrayList<Integer> list = eService.findAllID();
	   mav.addObject("managerList", list);
	   ArrayList<String> list2 = urService.findAllRoleId();
	   mav.addObject("roleList", list2);
	   return mav;
	  }
	  
	  
	  ModelAndView mav = new ModelAndView();
	  
	  String message = "Employee of name: " + cc.getEmployee().getEmp_name()+", id " + cc.getEmployee().getEmployeeId() + "and userid "+cc.getUser().getUserId()+"was successfully created.";
	  
	  
	  eService.createEmployee(cc.getEmployee());
	  User newUser=cc.getUser();
	  newUser.setName(cc.getEmployee().getEmp_name());
	  newUser.setPassword(cc.getEmployee().getEmp_name());
	  newUser.setEmployeeId(cc.getEmployee().getEmployeeId());
	  uService.createUser(newUser);
	  EmpUserRole ur = cc.getUserRole();
	  ur.setUserID(newUser.getUserId());
	  eurService.createEmpUserRole(ur);
	  mav.setViewName("redirect:/admin/employee/general");
	  redirectAttributes.addFlashAttribute("message", message);
	  return mav;
	 }
			
	@RequestMapping(value = "/employee/general", method = RequestMethod.GET)
	public ModelAndView adminEmployee() {
		ModelAndView mav = new ModelAndView("admin-employee");
		List<EmployeeDetails> employeeList = eService.findAllEmployees();
		mav.addObject("employeeList", employeeList);
		return mav;
	}
	
	@RequestMapping(value = "/employee/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("admin-employee-edit");
		EmployeeDetails employee = eService.findEmployee(id);
		mav.addObject("employee", employee);
		ArrayList<Integer> list = eService.findAllID();
		mav.addObject("managerList", list);
		return mav;
	}
	
	

	
	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(@PathVariable int id, final RedirectAttributes redirectAttributes)
			throws EmployeeNotFound 
	{

		ModelAndView mav = new ModelAndView("redirect:/admin/employee/general");
		EmployeeDetails employee = eService.findEmployee(id);
		//User u = uService.findUserByEmployeeId(id);
		eService.removeEmployee(employee);
		//uService.removeUser(u);
		String message = "The record for employee " + employee.getEmp_name() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/employee/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEmployee(@Valid @ModelAttribute("employee") EmployeeDetails employee, BindingResult result, @PathVariable int id,
			final RedirectAttributes redirectAttributes) throws EmployeeNotFound 
	{

		if (result.hasErrors())
			return new ModelAndView("admin-employee-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/employee/general");
		String message = "Employee record was successfully updated.";


		eService.removeEmployee(employee);
		//User u = uService.findUserByEmployeeId(id);
		//uService.removeUser(u);
		employee.setEmployeeId(id);
		eService.changeEmployee(employee);
		//uService.changeUser(u);
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/entitlement/create", method = RequestMethod.GET)
	public ModelAndView newEntitlementPage() {
		ModelAndView mav = new ModelAndView("admin-entitlement-create", "entitlement", new LeaveEntitlement());
		return mav;
	}
	
	@RequestMapping(value = "/entitlement/create", method = RequestMethod.POST)
	public ModelAndView createNewEntitlementRecord(@ModelAttribute @Valid LeaveEntitlement entitlement, BindingResult result,
			final RedirectAttributes redirectAttributes) {

		if (result.hasErrors())
			return new ModelAndView("admin-entitlement-create");

		ModelAndView mav = new ModelAndView();
		String message = "Leave Entitlement for designation " + entitlement.getDesignation() + " was successfully created.";

		enService.createEntilement(entitlement);
		mav.setViewName("redirect:/admin/entitlement/general");

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
	@RequestMapping(value = "/entitlement/general", method = RequestMethod.GET)
	public ModelAndView adminEntitlement() {
		ModelAndView mav = new ModelAndView("admin-entitlement");
		List<LeaveEntitlement> entitlementList = enService.findAllEntitlements();
		mav.addObject("entitlementList", entitlementList);
		return mav;
	}
	
	
	
	@RequestMapping(value = "/entitlement/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEntitlement(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("admin-entitlement-edit");
		LeaveEntitlement entitlement = enService.findEntitlement(id);
		mav.addObject("entitlement", entitlement);
		return mav;
	}
	
	@RequestMapping(value = "/entitlement/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteEntitlement(@PathVariable String id, final RedirectAttributes redirectAttributes)
			throws EntitlementNotFound 
	{

		ModelAndView mav = new ModelAndView("redirect:/admin/entitlement/general");
		LeaveEntitlement entitlement = enService.findEntitlement(id);
		enService.removeEntitlement(entitlement);
		String message = "The leave entitlement record for designation " + entitlement.getDesignation() + " was successfully deleted.";

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/entitlement/edit/{id}", method = RequestMethod.POST)
	public ModelAndView editEntitlement(@ModelAttribute @Valid LeaveEntitlement entitlement, BindingResult result, @PathVariable String id,
			final RedirectAttributes redirectAttributes) throws EntitlementNotFound 
	{

		if (result.hasErrors())
			return new ModelAndView("admin-entitlement-edit");

		ModelAndView mav = new ModelAndView("redirect:/admin/entitlement/general");
		String message = "Entitlement record was successfully updated.";

		enService.removeEntitlement(enService.findEntitlement(id));
		entitlement.setDesignation(id);
		enService.changeEntitlement(entitlement);

		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:/home/login";

	}
	

	

}
