package com.tophire.entities;

import java.io.Serializable;

public interface JobListing extends Serializable {
	int getJobId();

	String getjobTitle();
	
	String getOrganizationName();

	int getExperiance();

	String getRequiredSkill();

}
