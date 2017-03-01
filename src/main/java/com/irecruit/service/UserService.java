package com.irecruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irecruit.mongo.repository.UserInfoRepository;
import com.irecruit.pojo.UserInfo;

@Service
public class UserService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	public UserInfo registerUserByEmailId(UserInfo userInfo) {
		userInfoRepository.registerUserByEmailId(userInfo);
		return userInfo;
	}
	
	public boolean isUserAlradyExist(String emailId) {
		return userInfoRepository.isUserExists(emailId);
	}
	
	public List<UserInfo> retrieveUser() {
		return userInfoRepository.retrieveUser();
	}
	
	public List<UserInfo> retrieveUserById(String userId) {
		return userInfoRepository.retrieveUserById(userId);
	}
	
	public List<UserInfo> retrieveUserByName(String name) {
		return userInfoRepository.retrieveUserByName(name);
	}
	
	public UserInfo createUserInfo(String userName) {
		return userInfoRepository.createUserInfo(userName);
	}
	
	public void updateUser(UserInfo user) {
		userInfoRepository.updateUser(user);
	}
	
	public List<UserInfo> retrieveUserByClient(String clientName) {
		return userInfoRepository.retrieveUserByClient(clientName);
	}
	
	
	public List<UserInfo> retrieveUserByRole(String role) {
		return userInfoRepository.retrieveUserByRole(role);
	}
	
}
