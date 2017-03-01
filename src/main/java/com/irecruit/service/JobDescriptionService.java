package com.irecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.pojo.JobDescription;;

@Service
public class JobDescriptionService implements IJobDescriptionService{
	
	@Autowired
	com.irecruit.mongo.repository.JobDescriptionRepository jobDescriptionRepository;
	
	@Override
	public List<JobDescription> retrieveJobDescriptions() {
		return jobDescriptionRepository.findAll();
	}

	@Override
	public void prepareJobDescription(JobDescription jobDescription) {
			jobDescriptionRepository.save(jobDescription);
	}

	@Override
	public void updateJobDescription(JobDescription jobDescription) {
		jobDescriptionRepository.save(jobDescription);
	}
	@Override
	public void deleteJobDescription(String jobDescription) {
		jobDescriptionRepository.delete(jobDescription);
		
	}
	@Override
	public List<JobDescription> validateJDName(String jdName) {
		return jobDescriptionRepository.findByJobDescriptionName(jdName);
	}

	@Override
	public JobDescription retrieveJobDescriptionsById(String id) {
		return jobDescriptionRepository.findOne(id);
	}
	
	@Override
	public List<JobDescription> retrieveJobDescriptionsByClient(String client) {
		return jobDescriptionRepository.findByClient(client);
	}
}