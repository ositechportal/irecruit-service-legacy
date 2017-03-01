package com.irecruit.service;

import java.util.List;

import com.irecruit.pojo.Designation;;

public interface IDesignationService {
	List<Designation> retrieveDesignations();
	void prepareDesignation(Designation designation);
	void updateDesignation(Designation designation);
	void deleteDesignation(String designation);
}
