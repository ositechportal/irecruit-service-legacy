package com.irecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.irecruit.elastic.repository.InterviewIndexRepository;
import com.irecruit.pojo.InterviewDetails;

//import com.google.common.collect.Lists;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class InterviewSearchService {
	
	@Autowired
	private InterviewIndexRepository interviewIndexRepository;
	
	public List<InterviewDetails> getAllInterviewDetails(){
		List<InterviewDetails> interviewDetailsList = null;
		try {
		Iterable<InterviewDetails> interviewDetails = interviewIndexRepository.findAll();
		interviewDetailsList = Lists.newArrayList(interviewDetails);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return interviewDetailsList;
	}
	
	public List<InterviewDetails> getInterviewDetailsByNameAndStatus(String jobCode, String candidateName, String progress){
		List<InterviewDetails> interviewDetailsList = null;
		try {
			interviewDetailsList = interviewIndexRepository.findByJobCodeContainsOrCandidateNameStartingWithOrProgressStartingWithAllIgnoreCase(jobCode,candidateName, progress);	
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		
		return interviewDetailsList;
	}
	public List<InterviewDetails> getInterviewByInterviewer(String data){
		List<InterviewDetails> interviewDetailsList=interviewIndexRepository.findByInterviewerEmailStartingWith(data);
		return interviewDetailsList;
	}
	
	public InterviewDetails addInterviewDetailsIndex(InterviewDetails interviewDetails) throws Exception {
		InterviewDetails interviewDetailsData = interviewIndexRepository.save(interviewDetails);
		return interviewDetailsData;
	}
	
	public InterviewDetails updateInterviewDetailsIndex(InterviewDetails interviewDetails) throws Exception {
		InterviewDetails interviewDetailsData;
		if(interviewIndexRepository.exists(interviewDetails.getInterviewerId())){
			interviewIndexRepository.delete(interviewDetails.getInterviewerId());
			interviewDetailsData=addInterviewDetailsIndex(interviewDetails);
			}else{
				interviewDetailsData=addInterviewDetailsIndex(interviewDetails);
			}
		return interviewDetailsData;
	}
	
}
