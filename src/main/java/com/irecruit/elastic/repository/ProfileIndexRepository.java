package com.irecruit.elastic.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.irecruit.pojo.Profile;

public interface ProfileIndexRepository extends ElasticsearchRepository<Profile, String>{
	List<Profile> findProfilesByEmailIdStartingWithOrCandidateNameStartingWithOrDesignationStartingWithAllIgnoreCase(String emailId, String name, String designation);
	List<Profile> findProfilesByEmailIdContainsAllIgnoreCase(String emailId);
	List<Profile> findProfilesByJobcodeProfileStartingWithAllIgnoreCase(String jobcodeProfile);
	List<Profile> findProfilesByCreatedByStartingWithAllIgnoreCase(String profilecreatedBy);
	List<Profile> findProfilesByReferredBy(String referredBy);
}
