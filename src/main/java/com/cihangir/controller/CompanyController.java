package com.cihangir.controller;

import com.cihangir.model.Company;
import com.cihangir.model.User;
import com.cihangir.security.UserService;
import com.cihangir.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;

	private final UserService userService;

	@Autowired
	public CompanyController(CompanyService companyService,
			UserService userService) {
		this.companyService = companyService;
		this.userService = userService;
	}


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showMainPage(Model model) {
		setCurrentUser(model);
		return "company-user/company-user-profile";
	}



	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAddBook(Model theModel) {

		// create model attribute to bind form data
		Company theBook=new Company();

		theModel.addAttribute("newCompany", theBook);
		setCurrentUser(theModel);

		return "company-user/new-company";
	}



	@RequestMapping("/company-list")
	public String getCompanyList(Model model) {


		User currentUser = getCurrentUser();
		Iterable<Company> companies = companyService.findAllByUserId(currentUser.getId());

		model.addAttribute("companies", companies);
		model.addAttribute("currentUser", currentUser);

		return "company-user/company-list";
	}


	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("newCompany") Company company) {

		User currentUser = getCurrentUser();
		company.setUserId(currentUser.getId());
		companyService.saveCompany(company);
		return "redirect:/company/company-list";
	}

	private void setCurrentUser(Model model){

		User currentUser = getCurrentUser();
		model.addAttribute("currentUser", currentUser);
	}

	private User getCurrentUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return userService.findUserByUserName(auth.getName());
	}



}
