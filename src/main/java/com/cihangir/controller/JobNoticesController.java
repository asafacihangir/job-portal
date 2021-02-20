package com.cihangir.controller;


import com.cihangir.model.Company;
import com.cihangir.model.JobNotice;
import com.cihangir.model.User;
import com.cihangir.security.UserService;
import com.cihangir.service.CompanyService;
import com.cihangir.service.JobNoticeService;
import java.util.List;
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
@RequestMapping("/job-notices")
public class JobNoticesController {

  private final CompanyService companyService;
  private final JobNoticeService jobsService;
  private final UserService userService;

  @Autowired
  public JobNoticesController(CompanyService companyService,
      JobNoticeService jobsService, UserService userService) {
    this.companyService = companyService;
    this.jobsService = jobsService;
    this.userService = userService;
  }


  @RequestMapping(value = "/showFormForEdit", method = RequestMethod.GET)
  public String showFormForEditBook(@RequestParam("id") Long theId, Model theModel) {

    // create model attribute to bind form data
    JobNotice jobNotice = jobsService.findOne(theId);

    //add theBook to the model
    theModel.addAttribute("jobNotice", jobNotice);

    return "company-user/job-notice-new";
  }

  @RequestMapping(value = "/deleteJobs", method = RequestMethod.GET)
  public String deleteBook(@RequestParam("id") Long theId) {

    //delete the book
    jobsService.deleteBook(theId);

    return "redirect:/job-notices/jobs-list";
  }


  @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
  public String showFormForAddBook(Model theModel) {

    // create model attribute to bind form data
    JobNotice jobNotice = new JobNotice();

    List<Company> companies = companyService.findCompanyByCurrentUser();

    theModel.addAttribute("jobNotice", jobNotice);
    theModel.addAttribute("userCompanies", companies);

    return "company-user/job-notice-new";
  }


  @RequestMapping("/jobs-list")
  public String getCompanyList(Model model) {
    List<Company> companies = companyService.findCompanyByCurrentUser();
    Iterable<JobNotice> jobs = jobsService.findAllByCompanyIdIn(companies);

    model.addAttribute("jobNotices", jobs);

    return "company-user/job-notice-list";
  }


  @RequestMapping(value = "/saveJobNotice", method = RequestMethod.POST)
  public String saveBook(@ModelAttribute("newJobs") JobNotice jobs) {
    jobsService.saveJobs(jobs);
    return "redirect:/job-notices/jobs-list";
  }

  private User getCurrentUser() {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    return userService.findUserByUserName(auth.getName());
  }


}
