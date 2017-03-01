package com.irecruit.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.irecruit.pojo.ClientInfo;

public interface ClientInfoRepository extends MongoRepository<ClientInfo, String> {
	public List<ClientInfo> findByClientName(String clientName);
}
