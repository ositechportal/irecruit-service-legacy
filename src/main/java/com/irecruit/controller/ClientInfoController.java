package com.irecruit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irecruit.pojo.ClientInfo;
import com.irecruit.pojo.ResponseVO;
import com.irecruit.service.ClientInfoService;

@RestController
@RequestMapping("/api/clientInfo")
public class ClientInfoController {

	@Autowired
	ClientInfoService clientInfoService;

	@GetMapping(value = "/clientNames", produces = "application/JSON")
	public List<String> getClients() {
		return clientInfoService.getClientNames();
	}
	
	@GetMapping
	public ResponseEntity<?> getClientInfo(@RequestParam(value = "clientName", required = false) String clientName) {
		List<ClientInfo> clients = null;
		if (clientName != null && !clientName.isEmpty()) {
		 clients = clientInfoService.getClientDetailsByClient(clientName);
		}else{
		 clients = clientInfoService.getClientDetails();
		}
		return !clients.isEmpty() ? new ResponseEntity<List<ClientInfo>>(clients, HttpStatus.OK) : new ResponseEntity<String>("Client not found", HttpStatus.NOT_FOUND) ;
	}
	
	@GetMapping(value = "/interviewerNames")
	public List<String> getInterviewerNames() {
		List<String> interviewerNames = clientInfoService.getInterviewerNames();
		return interviewerNames;
	}
	
	@GetMapping(value = "/getClientById")
	public ClientInfo getClientById(@RequestParam(value = "clientId", required = true) String clientId) {
		ClientInfo client = clientInfoService.getClientById(clientId);
		return client;
	}
	
//	@PostMapping(value = "/clientInfo")
	@PostMapping
	public ResponseVO<String> deleteClient(@RequestBody ClientInfo clientInfo) {
		clientInfoService.createClient(clientInfo);
		ResponseVO<String>  resononse = new ResponseVO<String>();
				resononse.setMessage(clientInfo.getClientName() + " Client has been created successfully.");
		return resononse;
	}
	
	@DeleteMapping
	//(value = "/clientInfo")
	public ResponseVO<String> deleteClient(@RequestParam(value = "clientId", required = true) String clientId) {
		clientInfoService.deleteClient(clientId);
		ResponseVO<String>  resononse = new ResponseVO<String>();
				resononse.setMessage(clientId + " Id Client has been removed successfully.");
		return resononse;
	}
}
