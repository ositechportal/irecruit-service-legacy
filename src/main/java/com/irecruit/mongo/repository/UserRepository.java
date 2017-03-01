package com.irecruit.mongo.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.irecruit.pojo.User;

public interface UserRepository extends PagingAndSortingRepository<User, String> {
}