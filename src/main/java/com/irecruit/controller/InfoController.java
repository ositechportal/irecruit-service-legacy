package com.irecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irecruit.mongo.repository.InfoRepository;
import com.irecruit.pojo.InfoEntity;

@RestController
@RequestMapping("/appInfo")
public class InfoController {

	@Autowired
	private InfoRepository infoService;

	@GetMapping
	public List<InfoEntity> retrieveInfo() {
		return infoService.findAll();
	}

	@PutMapping
	//(value = "/info", consumes = "application/JSON")
	public ResponseEntity<?> updateInfo(@RequestBody InfoEntity info) throws Exception {
		infoService.insert(info);
		String jsonObj = "{\"msg\":\"Updated\"}";
		return new ResponseEntity<String>(jsonObj, HttpStatus.OK);
	}

	@DeleteMapping
	//(value = "/info", consumes = "application/JSON")
	public ResponseEntity<?> deleteInfo(@RequestBody InfoEntity info) throws Exception {
		infoService.insert(info);
		String jsonObj = "{\"msg\":\"Updated\"}";
		return new ResponseEntity<String>(jsonObj, HttpStatus.OK);
	}
}
