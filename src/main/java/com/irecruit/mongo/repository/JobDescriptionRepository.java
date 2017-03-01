package com.irecruit.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.irecruit.pojo.JobDescription;

@Repository
public interface JobDescriptionRepository extends MongoRepository<JobDescription, String>{
	
	List<JobDescription> findByJobDescriptionName(String name);
	List<JobDescription> findByClient(String client);
/*
	@Autowired
	private MongoOperations mongoOperations;
	
	public ArrayList<JobDescription> retrieveJobDescriptions() {
		  ArrayList<JobDescription> jobDescription = (ArrayList<JobDescription>) mongoOperations.findAll(JobDescription.class);
		  return jobDescription;
	}
	
	public void prepareJobDescriptions(JobDescription jobDescription) {
		mongoOperations.save(jobDescription);
	}
	
	public void updateJobDescriptions(JobDescription jobDescription) {
			Query updateQuery = new Query();
			updateQuery.addCriteria(Criteria.where("jobDescriptionName").is(jobDescription.getJobDescriptionName()));
			JobDescription jobDescription1 = mongoOperations.findOne(updateQuery, JobDescription.class);
			jobDescription1.equals(jobDescription) ;
			Update update = new Update();
			update.set("skills", jobDescription.getSkills());
			update.set("jobDescriptionDetails", jobDescription.getJobDescriptionDetails());
			update.set("client", jobDescription.getClient());
			
			mongoOperations.updateFirst(updateQuery, update,  JobDescription.class);		
	}
	public void removeJobDescriptions(String jobDescription) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").regex(jobDescription));
		JobDescription jobDescriptionDetail = mongoOperations.findOne(query, JobDescription.class);
		mongoOperations.remove(jobDescriptionDetail);
	}
	
	public ArrayList<JobDescription> getJDById(String jdName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").regex(Pattern.compile(jdName, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE)));
		return (ArrayList<JobDescription>) mongoOperations.find(query, JobDescription.class);
	}
	
	public List<JobDescription> getJDByClient(String client) {
		Query query = new Query();
		query.addCriteria(Criteria.where("client").is(client));
		List<JobDescription> jobDescription = mongoOperations.find(query, JobDescription.class);
		return jobDescription;
	}*/
}