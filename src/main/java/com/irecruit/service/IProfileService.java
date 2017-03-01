package com.irecruit.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.irecruit.pojo.Profile;
import com.mongodb.gridfs.GridFSDBFile;

public interface IProfileService {
	Profile prepareCandidate(Profile candidate) throws Exception;

	void updateCandidate(Profile candidate);
	
	void updateCandidateStatus(String email,String status);

	List<Profile> getProfileByEmailId(String emailId);

	List<Profile> retrieveProfileByJobCode(String jobcodeProfile);

	List<Profile> getProfileByProfileCreatedId(String profilecreatedBy);

	List<Profile> retrieveAllProfiles();

	Profile deleteProfileBasedOnEmailId(String emailId);

	void saveResume(MultipartFile multipartFile, String candidateId);

	String[] getResume(String emailId) throws Exception;
	
	List<GridFSDBFile> getFileData(String emailId) throws Exception;
	
	
}
