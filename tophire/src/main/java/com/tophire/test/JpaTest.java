package com.tophire.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.tophire.config.PersistenceConfig;
import com.tophire.entities.Job;
import com.tophire.entities.JobListing;
import com.tophire.repositories.JobRepository;

public class JpaTest {

	public static void main(String[] args) {

		ApplicationContext context=new AnnotationConfigApplicationContext(PersistenceConfig.class);
		JobRepository jobRepository=context.getBean("jobRepository", JobRepository.class);
		
//		List<Job> jobs=jobRepository.findAll();
//		jobs.forEach(System.out::println);
		
		List<JobListing> jobListings=jobRepository.findJobByExperianceGreaterThanEqualAndDesignationLikeAndOrganizationNameLikeAndRequiredSkillLike(2,
				"%", "%","%");
		jobListings.stream().forEach(jobListing-> System.out.println(jobListing.getjobTitle()));
	}

}
