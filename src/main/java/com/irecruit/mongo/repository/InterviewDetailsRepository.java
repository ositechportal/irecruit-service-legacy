package com.irecruit.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.irecruit.pojo.InterviewDetails;

//@Repository
public interface InterviewDetailsRepository extends MongoRepository<InterviewDetails, String>{
	InterviewDetails findByCandidateEmail(String candidateId);
	
	/*@Autowired
	private MongoOperations mongoOperation;
	
	public InterviewDetails getInterviewDetailsById(String CandidateId) {
		Query query = new Query();
		query.addCriteria(Criteria.where("candidateEmail").is(CandidateId));
		InterviewDetails intDetails = mongoOperation.findOne(query, InterviewDetails.class);
		return intDetails;
	}
	
	public void scheduleInterview(InterviewDetails interviewDetails) {
		mongoOperation.save(interviewDetails);
	}
	
	public void saveFeedback(InterviewFeedback interviewFeedback){
		mongoOperation.save(interviewFeedback);
	}
	
	public void updateinterviewDetails(InterviewDetails interviewDetails) {
		Query query = new Query();
		query.addCriteria(Criteria.where("candidateEmail").is(interviewDetails.getCandidateEmail()));
		InterviewDetails interview = mongoOperation.findOne(query, InterviewDetails.class);
		query.fields().include("candidateEmail");
		Update update = new Update();
		
		update.set("candidateName",interviewDetails.getCandidateName());
		update.set("currentPositionId",interview.getCurrentPositionId());
		update.set("positionId", interviewDetails.getPositionId());
		update.set("candidateSkills",interviewDetails.getCandidateSkills());
		update.set("clientName",interview.getClientName());
		update.set("designation",interviewDetails.getDesignation());
		update.set("hrAssigned",interviewDetails.getHrAssigned());
		update.set("interviewerEmail", interviewDetails.getInterviewerEmail());
		mongoOperation.updateFirst(query, update, InterviewDetails.class);
	}*/
}
