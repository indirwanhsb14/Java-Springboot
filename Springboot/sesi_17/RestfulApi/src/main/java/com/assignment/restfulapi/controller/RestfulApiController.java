package com.assignment.restfulapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restful-api/v1")
public class RestfulApiController {
	
	@GetMapping(value = "/get")
	public String restfulApi() {
		return "Mari Belajar API Java Spring Boot";
	}
}
