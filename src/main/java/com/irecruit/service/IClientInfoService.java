package com.irecruit.service;

import java.util.List;

import com.irecruit.pojo.ClientInfo;

public interface IClientInfoService {
List<ClientInfo> getClientDetails();
List<String> getClientNames();
List<String> getInterviewerNames();
List<ClientInfo> getClientDetailsByClient(String clientName);
}
