package com.irecruit.service;

import java.util.List;

import com.irecruit.pojo.InterviewDetails;

public interface IInterviewService {
	void prepareInterview(InterviewDetails interview);
	List<InterviewDetails> interviewCheck(String candidateId);
	
}
