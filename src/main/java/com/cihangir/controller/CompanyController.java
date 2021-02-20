package com.cihangir.controller;

import com.cihangir.model.Company;
import com.cihangir.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;

	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}


	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showFormForAddBook() {
		return "company-user/company-user-profile";
	}



	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAddBook(Model theModel) {

		// create model attribute to bind form data
		Company theBook=new Company();

		theModel.addAttribute("newCompany", theBook);

		return "company-user/new-company";
	}



	@RequestMapping("/company-list")
	public String getCompanyList(Model model) {

		Iterable<Company> companies = companyService.findAllByUserId(null);

		model.addAttribute("companies", companies);

		return "company-user/company-list";
	}


	@RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("newCompany") Company company) {

		company.setUserId(5L);
		companyService.saveCompany(company);
		return "redirect:/company/company-list";
	}



}
