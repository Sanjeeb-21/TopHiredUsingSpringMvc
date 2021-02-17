package com.tophire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tophire.dto.JobDto;
import com.tophire.form.JobSearchCriteriaForm;
import com.tophire.service.JobService;

@Controller
public class JobSearchController {
	@Autowired
	private JobService jobService;
	
	@GetMapping("/job-search.htm")
	public String showJobSearchPage() {
		return "job-search";
	}

	@ModelAttribute("designation")
	public List<String> bindDesignations(){
		return jobService.getJobDesignation();
	}
	
	@GetMapping("/search-jobs.htm")
	public String searchJobs( @ModelAttribute("jobSearchCriteriaForm") JobSearchCriteriaForm jobSearchCriteriaForm, BindingResult errors, ModelMap model) {
		List<JobDto> matchingJobs=null;
		if(errors.hasErrors()) {
			return "job-search";
		}
		matchingJobs=jobService.searchJobs(jobSearchCriteriaForm);
		model.addAttribute("matchingJobs", matchingJobs);
		return "matching-jobs";
	}
}
