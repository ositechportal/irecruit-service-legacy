package com.irecruit.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.irecruit.pojo.Designation;

//@Repository
public interface DesignationRepository extends MongoRepository<Designation, String> {

	/*@Autowired
	private MongoOperations mongoOperations;
	
	public ArrayList<Designation> retrieveDesignations() {
		  ArrayList<Designation> designation = (ArrayList<Designation>) mongoOperations.findAll(Designation.class);
		  return designation;
	}
	
	public void prepareDesignations(Designation designation) {
		mongoOperations.save(designation);
	}
	
	public void updateDesignations(Designation designation) {
			Query updateQuery = new Query();
			updateQuery.addCriteria(Criteria.where("designation").is(designation.getDesignation()));
			Designation designation1 = mongoOperations.findOne(updateQuery, Designation.class);
			designation1.equals(designation) ;
			Update update = new Update();
			update.set("skills", designation.getSkills());
			update.set("minExpYear", designation.getMinExpYear());
			update.set("maxExpYear", designation.getMaxExpYear());
			
			mongoOperations.updateFirst(updateQuery, update,  Designation.class);		
	}
	public void removeDesignations(String designation) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").regex(designation));
		Designation designationDetail = mongoOperations.findOne(query, Designation.class);
		mongoOperations.remove(designationDetail);
	}
*/
}
