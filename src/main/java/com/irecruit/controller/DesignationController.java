package com.irecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irecruit.pojo.Designation;
import com.irecruit.service.IDesignationService;

@RestController
@RequestMapping("/api/design")
public class DesignationController {

	@Autowired
	private IDesignationService designationService;
	
	@GetMapping
	//(value="/design")
	public List<Designation> retrieveDesignation() {
		return designationService.retrieveDesignations();
	}
	
	@PostMapping
	//(value="/design")
	public ResponseEntity<?> saveDesignation(@RequestBody Designation designation) throws Exception {
		designationService.prepareDesignation(designation);
		String jsonObj="{\"msg\":\"Created\"}";
		return new ResponseEntity<String>(jsonObj,
				HttpStatus.OK);
	}
	
	@PutMapping
	//(value="/design")
	public ResponseEntity<?> updateDesignation(@RequestBody Designation designation) throws Exception {
		designationService.updateDesignation(designation);
		String jsonObj="{\"msg\":\"Updated\"}";
		return new ResponseEntity<String>(jsonObj,
				HttpStatus.OK);
	}
	
	@DeleteMapping
	//(value="/design/{designation}")
	public ResponseEntity<?> deleteDesignation(@PathVariable("designation") String designation) throws Exception {
		designationService.deleteDesignation(designation);
		String jsonObj="{\"msg\":\"Deleted\"}";
		return new ResponseEntity<String>(jsonObj,
				HttpStatus.OK);
	}
	
}
