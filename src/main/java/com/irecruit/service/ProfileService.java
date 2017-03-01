package com.irecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.irecruit.mongo.repository.ProfileRepository;
import com.irecruit.pojo.Profile;
import com.mongodb.gridfs.GridFSDBFile;

@Service
public class ProfileService implements IProfileService{

	@Autowired
	ProfileRepository profileRepository;

	@Override
	public Profile prepareCandidate(Profile candidate) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCandidate(Profile candidate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCandidateStatus(String email, String status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Profile> getProfileByEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> retrieveProfileByJobCode(String jobcodeProfile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> getProfileByProfileCreatedId(String profilecreatedBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Profile> retrieveAllProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile deleteProfileBasedOnEmailId(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveResume(MultipartFile multipartFile, String candidateId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String[] getResume(String emailId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GridFSDBFile> getFileData(String emailId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Autowired
//	ProfileSearchService profileSearchService;
	
//	@Autowired
//	InterviewSearchService interviewSearchService;
//	
//	@Autowired
//	InterviewService interviewService;
	/*
	public Profile prepareCandidate(Profile candidate) throws Exception {
		profileRepository.prepareCandidate(candidate);
		InterviewDetails interview = prepareInterviewDetails(candidate);
		interviewService.prepareInterview(interview);
		return profileSearchService.addProfileIndex(candidate);
	}

	private InterviewDetails prepareInterviewDetails(Profile candidate) {
		InterviewDetails interview = new InterviewDetails();
		interview.setCandidateName(candidate.getCandidateName());
		interview.setCandidateEmail(candidate.getEmailId());
		interview.setCandidateSkills(candidate.getPrimarySkills());
		interview.setDesignation(candidate.getDesignation());
		interview.setHrAssigned(candidate.getHrAssigned());
		interview.setProgress("Not Initialized");
		interview.setInterviewerId(candidate.getEmailId()+"_"+(int)(Math.random() * 5000 + 1));
		return interview;
	}
	
	public void updateCandidate(Profile candidate) {
		try {
			candidate.setUpdatedDate(new Date());
			profileRepository.updateCandidate(candidate);
			profileSearchService.updateProfileIndex(candidate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateCandidateStatus(String email,String status){
		profileRepository.updateCandidateStatus(email, status);
	}
	
	public List<Profile> getProfileByEmailId(String emailId) {
		return profileRepository.retrieveCandidateDetails(emailId);
	}
	
	public List<Profile> retrieveProfileByJobCode(String jobcodeProfile) {
		return profileRepository.retrieveProfileByJobCode(jobcodeProfile);
	}
	
	public List<Profile> getProfileByProfileCreatedId(String profilecreatedBy) {
		return profileRepository.retrieveProfileByProfileCreatedBy(profilecreatedBy);
	}
	
	public List<Profile> retrieveAllProfiles() {
		return profileRepository.retrieveAllProfiles();
	}
	
	public Profile deleteProfileBasedOnEmailId(String emailId) {
		return profileRepository.deleteProfileBasedOnEmailId(emailId);
	}
	
	public void saveResume(MultipartFile multipartFile, String candidateId) {
		profileRepository.saveResumeInBucket(multipartFile, candidateId);
	}
	
	public String[] getResume(String emailId) throws Exception {
		return profileRepository.getResume(emailId);
	}
	
	
	public List<GridFSDBFile> getFileData(String emailId) throws Exception {
		
		return profileRepository.getData( emailId);
	}
	*/
	
}