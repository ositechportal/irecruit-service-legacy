package com.irecruit.service;

import java.util.List;

import com.irecruit.pojo.JobDescription;

public interface IJobDescriptionService {
	List<JobDescription> retrieveJobDescriptions();
	JobDescription retrieveJobDescriptionsById(String id);
	void prepareJobDescription(JobDescription jobDescription);
	void updateJobDescription(JobDescription jobDescription);
	void deleteJobDescription(String jobDescription);
	List<JobDescription> validateJDName(String jdName);
	List<JobDescription> retrieveJobDescriptionsByClient(String client);
}