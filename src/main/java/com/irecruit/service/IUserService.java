package com.irecruit.service;

import java.util.List;

import com.irecruit.pojo.UserInfo;

public interface IUserService {
	UserInfo registerUserByEmailId(UserInfo userInfo);

	List<UserInfo> retrieveUser();

	List<UserInfo> retrieveUserById(String userId);

	List<UserInfo> retrieveUserByName(String name);

	UserInfo createUserInfo(String userName);

	void updateUser(UserInfo user);

	List<UserInfo> retrieveUserByClient(String clientName);

	List<UserInfo> retrieveUserByRole(String role);

	boolean isUserAlradyExist(String emailId);
}
