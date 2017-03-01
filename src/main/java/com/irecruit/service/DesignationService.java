package com.irecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.DesignationRepository;
import com.irecruit.pojo.Designation;;

@Service
public class DesignationService implements IDesignationService {

	@Autowired
	DesignationRepository designationRepository;

	public List<Designation> retrieveDesignations() {
		return designationRepository.findAll();
	}

	public void prepareDesignation(Designation designation) {
		designationRepository.insert(designation);
	}

	public void updateDesignation(Designation designation) {
		designationRepository.insert(designation);
	}

	public void deleteDesignation(String designation) {
		designationRepository.delete(designation);
	}
}
