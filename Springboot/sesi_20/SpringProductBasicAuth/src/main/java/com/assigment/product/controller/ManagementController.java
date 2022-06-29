package com.assigment.product.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assigment.product.model.User;
import com.assigment.product.repository.UserRepository;

@RestController
@RequestMapping("api/management")
public class ManagementController {
	
	private UserRepository userRepository;

    public ManagementController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "API Test 2";
    }
    
    @GetMapping("")
    public List<User> users(){
        return this.userRepository.findAll();
    }
}
