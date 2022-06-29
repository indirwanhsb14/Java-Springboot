package com.assigment.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/belajar-api/v1")
public class UiController {

	@GetMapping(value = "/get")
	public String UiController() {
		return "Welcome to our product";
	}
}
