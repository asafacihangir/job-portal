package com.cihangir.controller;


import com.cihangir.model.Book;
import com.cihangir.model.Company;
import com.cihangir.model.Jobs;
import com.cihangir.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/jobs")
public class JobsController {
    private final JobsService jobsService;

    @Autowired
    public JobsController(JobsService jobsService) {
        this.jobsService = jobsService;
    }



    @RequestMapping(value = "/showFormForEdit", method = RequestMethod.GET)
    public String showFormForEditBook(@RequestParam("id") Long theId, Model theModel) {

        // create model attribute to bind form data
        Jobs theBook=jobsService.findOne(theId);

        //add theBook to the model
        theModel.addAttribute("newJobs", theBook);

        return "jobs-user/jobs-define";

    }

    @RequestMapping(value = "/deleteJobs", method = RequestMethod.GET)
    public String deleteBook(@RequestParam("id") Long theId) {

        //delete the book
        jobsService.deleteBook(theId);

        return "redirect:bookList";
    }


    @RequestMapping(value = "/showFormForAdd", method = RequestMethod.GET)
    public String showFormForAddBook(Model theModel) {

        // create model attribute to bind form data
        Jobs theBook=new Jobs();

        theModel.addAttribute("newJobs", theBook);

        return "jobs-user/new-jobs";
    }



    @RequestMapping("/jobs-list")
    public String getCompanyList(Model model) {

        Iterable<Jobs> jobs = jobsService.findAllByUserId(null);

        model.addAttribute("jobs", jobs);

        return "jobs-user/jobs-list";
    }


    @RequestMapping(value = "/saveJobs", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute("newJobs") Jobs jobs) {
        jobsService.saveJobs(jobs);
        return "redirect:/jobs/jobs-list";
    }

}
