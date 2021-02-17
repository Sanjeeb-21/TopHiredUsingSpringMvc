package com.tophire.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tophire.entities.Job;
import com.tophire.entities.JobListing;

public interface JobRepository extends JpaRepository<Job, Integer> {
	@Query("select j from Job j")
	List<JobListing> findJobListing(Sort inSort);

	List<JobListing> findJobByExperianceGreaterThanEqualAndDesignationLikeAndOrganizationNameLikeAndRequiredSkillLike(int experiance,
			String designation, String organizationName, String requiredSkill);
	@Query("select distinct(j.designation) from Job j")
	List<String> findJobDesignations(Sort sort);
}
