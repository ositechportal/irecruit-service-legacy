package com.irecruit.elastic.repository;

import  com.google.common.collect.Lists;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.pojo.Profile;


@Service
public class ProfileSearchService {
	

	@Autowired
	private ProfileIndexRepository profileIndexRepository;
	
	@Autowired
	private ProfileIndexQueryRepository profileIndexQueryRepository;
	
	public List<Profile> getAllProfiles() throws Exception {
		Iterable<Profile> profile = profileIndexRepository.findAll();
		List<Profile> porofileList = Lists.newArrayList(profile);
		return porofileList;
	}
	
	public List<Profile> getProfilesByEmailIdOrByNameOrByDesignation(String data) throws Exception {
		List<Profile> profilesList;
		if(data.contains("@")){
			profilesList = profileIndexRepository.findProfilesByEmailIdContainsAllIgnoreCase(data);
		}else{
			profilesList = profileIndexQueryRepository.findProfilesByEmailIdStartingWithOrCandidateNameStartingWithOrDesignationStartingWithAllIgnoreCase(data);
		}
		
		return profilesList;
	}
	
	public Profile addProfileIndex(Profile profile) throws Exception {
		Profile profileData = profileIndexRepository.save(profile);
		return profileData;
	}

	public void updateProfileIndex(Profile profile) throws Exception {
		if(profileIndexRepository.exists(profile.getEmailId())){
		profileIndexRepository.delete(profile.getEmailId());
		addProfileIndex(profile);
		}else{
			addProfileIndex(profile);
		}
	}

	public List<Profile> getProfilesByJobcodeProfile(String jobcodeProfile) {
		List<Profile> profilesList = profileIndexRepository.findProfilesByJobcodeProfileStartingWithAllIgnoreCase(jobcodeProfile);
		return profilesList;
	}
	
	
	public List<Profile> getProfilesByProfilecreated(String profilecreatedBy){
		List<Profile> profilesList = profileIndexRepository.findProfilesByCreatedByStartingWithAllIgnoreCase(profilecreatedBy);
		return profilesList;
	}
	
	public List<Profile> getProfilesByRefreedBy(String profilecreatedBy){
		List<Profile> profilesList = profileIndexRepository.findProfilesByReferredBy(profilecreatedBy);
		return profilesList;
	}
}
