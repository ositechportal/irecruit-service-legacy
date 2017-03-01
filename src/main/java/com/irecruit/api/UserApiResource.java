package com.irecruit.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irecruit.mongo.repository.UserRepository;
import com.irecruit.pojo.User;

@RestController
@RequestMapping(value = "/api/users")
public class UserApiResource {
	
	@Autowired
    private UserRepository userRepository;

    @GetMapping(produces = "application/JSON")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/JSON")
    public User findById(@PathVariable("id") String userID) {
        return userRepository.findOne(userID);
    }
}