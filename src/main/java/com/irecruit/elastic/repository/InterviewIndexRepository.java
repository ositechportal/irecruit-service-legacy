package com.irecruit.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.irecruit.pojo.InterviewDetails;


public interface InterviewIndexRepository extends ElasticsearchRepository<InterviewDetails, String>{
	
	 List<InterviewDetails> findByJobCodeContainsOrCandidateNameStartingWithOrProgressStartingWithAllIgnoreCase(String jobCode, String candidateName, String progress);
	 List<InterviewDetails> findByInterviewerEmailStartingWith(String interviewerEmail);
}
