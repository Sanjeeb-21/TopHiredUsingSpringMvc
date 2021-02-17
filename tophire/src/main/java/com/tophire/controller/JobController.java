package com.tophire.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tophire.dto.JobDto;
import com.tophire.form.JobForm;
import com.tophire.service.JobService;
import com.tophire.validators.JobFormValidator;

@Controller
@RequestMapping("/job")
public class JobController {
	@Autowired
	private JobService jobService;
	@Autowired
	private JobFormValidator jobFormValidator;
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		System.out.println("initBinder()");
		webDataBinder.setValidator(jobFormValidator);
	}
	
	
	@GetMapping("/{jobId}/details.htm")
	public String jobDetails(@PathVariable("jobId") int jobId, ModelMap model) {
		
		JobDto jobDto=jobService.getJobDetails(jobId);
		model.addAttribute("job",jobDto);
		return "job-details";
	}
	@GetMapping("/new.htm")
	public String showPostJobForm(Model model) {
		JobForm jobForm=null;
		
		jobForm=new JobForm();
		model.addAttribute("postJobForm" ,jobForm);
		return "post-job";
		
	}
	@PostMapping("/new.htm")
	public String postJob(@ModelAttribute("postJobForm") @Validated JobForm jobForm, BindingResult errors) {
		//if(jobFormValidator.supports(jobForm.getClass())) {
			//jobFormValidator.validate(jobForm, errors);
			if(errors.hasErrors()) {
				return "post-job";
			}
		//}
		jobService.postJob(jobForm);
		return "redirect:/top-jobs.htm?postjob=success";
	}
	
	@GetMapping("/{jobId}/edit.htm")
	public String showEditJobForm(@PathVariable("jobId") int jobId,Model model) {
		JobDto jobDto=null;
		JobForm jobForm=null;
		
		jobDto=jobService.getJobDetails(jobId);
		jobForm=new JobForm();
		BeanUtils.copyProperties(jobDto, jobForm);
		model.addAttribute("editJobForm",jobForm);
		return "edit-job";
	}
	@PostMapping("/edit.htm")
	public String updateJob(@ModelAttribute("editJobForm") @Validated JobForm jobForm,BindingResult errors) {
		
		if(errors.hasErrors()) {
			return "edit-job";
		}
		jobService.updateJob(jobForm);
		return "redirect:/top-jobs.htm?editjob=success";
	}
	
	@ModelAttribute("designation")
public List<String> populateDesignations(){
	return jobService.getJobDesignation();
	
}
}
