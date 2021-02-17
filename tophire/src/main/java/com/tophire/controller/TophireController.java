package com.tophire.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tophire.dto.JobDto;
import com.tophire.service.JobService;

@Controller
public class TophireController {
	@Autowired
	private JobService jobService;
	
	
	@GetMapping("/top-jobs.htm")
	public String listTopJobs(ModelMap modelMap) {
		List<JobDto> jobs=null;
		jobs=jobService.getTopJobs();
		modelMap.addAttribute("jobs", jobs);
		return "top-jobs";
		
	}

}
