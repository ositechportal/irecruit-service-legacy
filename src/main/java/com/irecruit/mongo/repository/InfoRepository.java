package com.irecruit.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.irecruit.pojo.InfoEntity;

public interface InfoRepository extends MongoRepository<InfoEntity, String>  {
}