package com.tophire.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tophire.dto.JobDto;
import com.tophire.entities.Job;
import com.tophire.entities.JobListing;
import com.tophire.form.JobForm;
import com.tophire.form.JobSearchCriteriaForm;
import com.tophire.repositories.JobRepository;

@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;

	@Transactional(readOnly = true)
	public List<JobDto> getTopJobs() {

		return jobRepository.findJobListing(Sort.by("jobId").descending()).stream().map(JobListing -> {
			JobDto jobDto = new JobDto();
			BeanUtils.copyProperties(JobListing, jobDto);
			return jobDto;
		}).collect(Collectors.toList());

	}

	@Transactional(readOnly = true)
	public JobDto getJobDetails(int jobId) {
		JobDto jobDto = null;
		Optional<Job> job = null;

		job = jobRepository.findById(jobId);
		jobDto = new JobDto();
		BeanUtils.copyProperties(job.get(), jobDto);
		return jobDto;

	}

	@Transactional(readOnly = false)
	public List<JobDto> searchJobs(JobSearchCriteriaForm jobSearchCriteriaForm) {
		List<JobDto> matchingJobs = null;
		List<JobListing> jobListings = null;
		String designation=null;
		String organizationName=null;
		String requiredSkill=null;

		designation=(jobSearchCriteriaForm.getDesignation() != null
				&& jobSearchCriteriaForm.getDesignation().trim().length() > 0) ? jobSearchCriteriaForm.getDesignation()
						: "%";

		organizationName=(jobSearchCriteriaForm.getOrganizationName() != null
				&& jobSearchCriteriaForm.getOrganizationName().trim().length() > 0)
						? "%" + jobSearchCriteriaForm.getOrganizationName() + "%"
						: "%";
		
		requiredSkill=(jobSearchCriteriaForm.getRequiredSkill() != null
				&& jobSearchCriteriaForm.getRequiredSkill().trim().length() > 0)
						? "%" + jobSearchCriteriaForm.getRequiredSkill() + "%"
						: "%";
		
		jobListings = jobRepository
				.findJobByExperianceGreaterThanEqualAndDesignationLikeAndOrganizationNameLikeAndRequiredSkillLike(
						jobSearchCriteriaForm.getExperiance(),designation,organizationName,requiredSkill);

		matchingJobs= jobListings.stream().map(jobListing ->{
			JobDto jobDto=new JobDto();
			BeanUtils.copyProperties(jobListing, jobDto);
			return jobDto;
			
		}).collect(Collectors.toList());
		return matchingJobs;
	}

	@Transactional(readOnly = true)
	public List<String> getJobDesignation(){
//		return jobRepository.findJobDesignations(Sort.by("designation").ascending()).stream().map(jobDesignation -> {
//			return jobDesignation.getDesignation();
//			
//		}).collect(Collectors.toList());
		return jobRepository.findJobDesignations(Sort.by("designation").ascending());
	}
	@Transactional(readOnly = false)
	public int postJob(JobForm jobForm) {
		Job job=null;
		Job saveJob=null;
		
		job=new Job();
		BeanUtils.copyProperties(jobForm, job);
		saveJob=jobRepository.save(job);
		return saveJob.getJobId();
		
	}
	@Transactional(readOnly = false)
	public void updateJob(JobForm jobForm) {
		Job job=null;
		
		
		job=new Job();
		BeanUtils.copyProperties(jobForm, job);
		jobRepository.save(job);
		
	}
}
