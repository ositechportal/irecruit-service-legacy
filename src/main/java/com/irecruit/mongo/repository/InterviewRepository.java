package com.irecruit.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.irecruit.pojo.InterviewDetails;

@Repository
public interface InterviewRepository  extends MongoRepository<InterviewDetails, String>{
/*
	@Autowired
	private MongoOperations mongoOperation;

	public void save(InterviewDetails interview) {
		mongoOperation.save(interview);
	}

	public List<InterviewDetails> getAllInterviewDetails() {
		List<InterviewDetails> interviewDetails = mongoOperation.findAll(InterviewDetails.class);
		return interviewDetails;
	}*/
}
