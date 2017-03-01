package com.irecruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.ClientInfoRepository;
import com.irecruit.pojo.ClientInfo;
import com.irecruit.pojo.Interviewer;

@Service
public class ClientInfoService {
	@Autowired
	ClientInfoRepository clientInfoRepository;
	
	public List<ClientInfo> getClientDetails() {
		return clientInfoRepository.findAll();
	}
	
	public List<ClientInfo> getClientDetailsByClient(String clientName) {
		return clientInfoRepository.findByClientName(clientName);
	}

	public List<String> getClientNames() {
		List<ClientInfo> clientDetails = clientInfoRepository.findAll();
		return clientDetails.stream().map(ClientInfo::getClientName).sorted().collect(Collectors.toList());
	}
	
	public List<String> getInterviewerNames() {
		List<String> interviewerNames = new ArrayList<String>();
		List<ClientInfo> clients = (List<ClientInfo>) clientInfoRepository.findAll();
		for (ClientInfo clientInfo : clients) {
			Interviewer interviewers = clientInfo.getInterviewers();
			String interviewerName = interviewers.getTechnicalRound1().get(0).getName();
			interviewerNames.add(interviewerName);
		}
		return interviewerNames;
	}
	
	public ClientInfo getClientById(String clientId) {
		return clientInfoRepository.findOne(clientId);
	}
	
	public void deleteClient(String client) {
		 clientInfoRepository.delete(client);
	}
	
	public void createClient(ClientInfo clientInfo) {
		clientInfoRepository.save(clientInfo);
	}
	
	public void updateClient(ClientInfo clientInfo) {
		clientInfoRepository.insert(clientInfo);
	}
	
	//---Admin
	/*
	public List<UserInfo> fetchAllUsers() {
		return clientInfoRepository.fetchAllUsers();
	}
	
	public void deleteClient(String client) {
		 clientInfoRepository.deleteClient(client);
	}
	
	public void createClient(ClientInfo clientInfo) {
		clientInfoRepository.createClient(clientInfo);
	}
	
	public void updateClient(ClientInfo clientInfo) {
		clientInfoRepository.updateClient(clientInfo);
	}
	*/
}
