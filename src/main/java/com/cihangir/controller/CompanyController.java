package com.cihangir.controller;

import com.cihangir.dao.ApplicantRepository;
import com.cihangir.dao.UserRepository;
import com.cihangir.model.Applicant;
import com.cihangir.model.Company;
import com.cihangir.model.JobApply;
import com.cihangir.model.JobNotice;
import com.cihangir.model.User;
import com.cihangir.security.UserService;
import com.cihangir.service.CompanyService;
import com.cihangir.service.JobNoticeService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/company")
public class CompanyController {

	private final CompanyService companyService;

	private final UserService userService;

	private final JobNoticeService jobNoticeService;

	private final ApplicantRepository applicantRepository;

	private final UserRepository userRepository;

	@Autowired
	public CompanyController(CompanyService companyService,
			UserService userService, JobNoticeService jobNoticeService,
			ApplicantRepository applicantRepository, UserRepository userRepository) {
		this.companyService = companyService;
		this.userService = userService;
		this.jobNoticeService = jobNoticeService;
		this.applicantRepository = applicantRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String showMainPage(Model model) {
		setCurrentUser(model);
		return "company-user/company-user-profile";
	}


	@RequestMapping(value = "/job-notices", method = RequestMethod.GET)
	public String getJobNotices(Model model) {

		User currentUser = getCurrentUser();
		List<Company> companies = companyService.findCompanyByCurrentUser();
		Iterable<JobNotice> jobs = jobNoticeService.findAllByCompanyIdIn(companies);

		model.addAttribute("jobNotices", jobs);
		model.addAttribute("currentUser",currentUser);
		return "company-user/job-notice-list";
	}

	@RequestMapping(value = "/job-notices/saveJobNotice", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("jobNotice") JobNotice jobs) {
		jobNoticeService.saveJobs(jobs);
		return "redirect:/company/job-notices";
	}


	@RequestMapping(value = "/job-notices/showFormForEdit", method = RequestMethod.GET)
	public String showFormForEditJobNotice(@RequestParam("id") Long theId, Model theModel) {

		List<Company> companies = companyService.findCompanyByCurrentUser();

		// create model attribute to bind form data
		JobNotice jobNotice = jobNoticeService.findOne(theId);

		//add theBook to the model
		theModel.addAttribute("jobNotice", jobNotice);
		theModel.addAttribute("userCompanies", companies);
		setCurrentUser(theModel);


		return "company-user/job-notice-new";
	}

	@RequestMapping(value = "/job-notices/showApplicants", method = RequestMethod.GET)
	public String showApplicants(@RequestParam("id") Long theId, Model theModel) {

		// create model attribute to bind form data
		JobNotice jobNotice = jobNoticeService.findOne(theId);

		List<Applicant> applicants = jobNotice.getJobApplies().stream().map(JobApply::getApplicant).distinct().collect(
				Collectors.toList());


		//add theBook to the model
		theModel.addAttribute("applicants", applicants);
		theModel.addAttribute("jobNotice", jobNotice);

		setCurrentUser(theModel);

		return "company-user/applicant-list";
	}

	@RequestMapping(value = "/applicant/showProfile", method = RequestMethod.GET)
	public String showApplicantInfo(@RequestParam("id") Long theId,Model model) {
		setCurrentUser(model);

		Applicant applicant = applicantRepository.findOne(theId);
		model.addAttribute("applicantInfo", applicant);

		return "company-user/applicant-info";
	}






	@RequestMapping(value = "/job-notices/delete", method = RequestMethod.GET)
	public String deleteJobNotice(@RequestParam("id") Long theId) {

		//delete the book
		jobNoticeService.deleteBook(theId);

		return "redirect:/company/job-notices";
	}


	@RequestMapping(value = "/job-notices/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAddJobNotice(Model theModel) {

		// create model attribute to bind form data
		JobNotice jobNotice = new JobNotice();

		List<Company> companies = companyService.findCompanyByCurrentUser();

		theModel.addAttribute("jobNotice", jobNotice);
		theModel.addAttribute("userCompanies", companies);

		return "company-user/job-notice-new";
	}


	@RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
	public String showFormForAddBook(Model theModel) {

		// create model attribute to bind form data
		Company theBook=new Company();

		theModel.addAttribute("newCompany", theBook);
		setCurrentUser(theModel);

		return "company-user/new-company";
	}

	@RequestMapping(value = "/showFormForEdit", method = RequestMethod.GET)
	public String showFormForEditBook(@RequestParam("companyId") Long theId, Model theModel) {

		// create model attribute to bind form data
		Company jobNotice = companyService.findOne(theId);

		//add theBook to the model
		theModel.addAttribute("newCompany", jobNotice);
		//theModel.addAttribute("userCompanies", companies);

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

	@RequestMapping(value = "/showUserInfo", method = RequestMethod.GET)
	public String showUserInfo(Model theModel) {

		Map<String, String> userTypes = new HashMap<>();
		userTypes.put("USER","İş Arayan");
		userTypes.put("COMPANY_USER","İşveren");

		theModel.addAttribute("userTypes", userTypes);
		User theUser = getCurrentUser();
		theModel.addAttribute("currentUser", theUser);

		return "company-user/user-info";
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
