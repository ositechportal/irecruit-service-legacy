package com.irecruit.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.InterviewRepository;
import com.irecruit.pojo.InterviewDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InterviewService implements IInterviewService{
	@Autowired
	private InterviewRepository interviewRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private InterviewSearchService interviewSearchService;
	
	public void prepareInterview(InterviewDetails interview) {
		try {
			interviewSearchService.addInterviewDetailsIndex(interview);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		interviewRepository.save(interview);
	}
	
	public List<InterviewDetails> interviewCheck(String candidateId) {
		MongoOperations mongoOperations = (MongoOperations) mongoTemplate;
		Query query = new Query();
		query.addCriteria(Criteria.where("candidateId").regex(Pattern.compile(candidateId, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		List<InterviewDetails> checkDetails = mongoOperations.find(query, InterviewDetails.class);
		return checkDetails;
	}
	
	public List<InterviewDetails> getAllInterviewDetails(){
		return interviewRepository.findAll();
	}
}
