package com.irecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.ProfileRepository;
import com.irecruit.pojo.InterviewDetails;
import com.irecruit.pojo.Profile;
import com.irecruit.pojo.ReportsVO;

@Service
public class ReportsService {
	
	ReportsVO reportsVO = new ReportsVO();
	
	@Autowired
	ProfileRepository profileRepository;
	@Autowired
	InterviewDetailsService interviewDetailsService;
	
	public ReportsVO getDataByJobCode(String jobcodeProfile) {
		List<Profile> profiles = profileRepository.retrieveProfileByJobCode(jobcodeProfile);
		List<InterviewDetails> interviewDetails = interviewDetailsService.getInterviewByJobCode(jobcodeProfile);
		reportsVO.setProfiles(profiles);
		reportsVO.setInterviewDetails(interviewDetails);
		return reportsVO;
	}
}
