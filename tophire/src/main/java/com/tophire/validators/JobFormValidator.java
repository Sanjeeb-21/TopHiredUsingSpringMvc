package com.tophire.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tophire.form.JobForm;

@Component
public class JobFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("Class: " +clazz.getCanonicalName());
		return clazz.isAssignableFrom(JobForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JobForm jobForm=(JobForm) target;
		
		System.out.println("Validate()");
		
		if(jobForm.getJobTitle() == null || jobForm.getJobTitle().trim().length()==0) {
			errors.rejectValue("jobTitle", "jobTitle.blank");
		}
		if(jobForm.getDescription() == null || jobForm.getDescription().length() == 0){
			errors.rejectValue("description", "description.blank");
		}else if(jobForm.getDescription().length() > 500) {
			errors.rejectValue("description", "description.limitExceeded");	
		}
		if(jobForm.getOrganizationName() == null || jobForm.getOrganizationName().length() == 0) {
			errors.rejectValue("organizationName", "organizationName.blank");
			
		}
		if(jobForm.getDesignation()==null || jobForm.getDesignation().trim().length() ==0) {
			errors.rejectValue("designation", "designation.blank");
			
		}
		if(errors.hasFieldErrors("experiance")==false) {
			if(jobForm.getExperiance()==null){
				errors.rejectValue("experiance", "experiance.invalid");
			}else if (jobForm.getExperiance()<0||jobForm.getExperiance()>45) {
				errors.rejectValue("experiance", "experiance.invalid");
			}
		}
		if(jobForm.getLocation()==null || jobForm.getLocation().trim().length()==0) {
			errors.rejectValue("location", "location.blank");
		}
		if(jobForm.getRequiredSkill()==null || jobForm.getRequiredSkill().trim().length()==0) {
			errors.rejectValue("requiredSkill", "requiredSkill.blank");
		}
		if(jobForm.getJobStatus()==null || jobForm.getJobStatus().trim().length()==0) {
			errors.rejectValue("jobStatus", "jobStatus.blank");
		}
	}

}
