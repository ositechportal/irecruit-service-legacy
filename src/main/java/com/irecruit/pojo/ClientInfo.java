package com.irecruit.pojo;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClientInfo{
	@Id
	String clientId;
	String clientName;
	String locations;
	Interviewer interviewers;
	
	/*

	public ClientInfo() {
	}

	public ClientInfo(String clientId, String clientName, String locations, Interviewer interviewers) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.locations = locations;
		this.interviewers = interviewers;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getLocations() {
		return locations;
	}

	public void setLocations(String locations) {
		this.locations = locations;
	}

	public Interviewer getInterviewers() {
		return interviewers;
	}

	public void setInterviewers(Interviewer interviewers) {
		this.interviewers = interviewers;
	}
*/
}
