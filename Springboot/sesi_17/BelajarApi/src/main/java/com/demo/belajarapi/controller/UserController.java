package com.demo.belajarapi.controller;

import java.util.List;
import java.util.NoSuchElementException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.belajarapi.model.User;
import com.demo.belajarapi.service.UserService;

@RestController
@RequestMapping("/api/v1")
public class UserController {

	@Autowired
	UserService userService;

	@CrossOrigin
	@GetMapping("/users")
	public List<User> list() {
		return userService.listAllUser();
	}

	@CrossOrigin
	@GetMapping("/users/{id}")
	public ResponseEntity<User> users(@PathVariable Integer id) {
		try {
			User user = userService.getUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@PostMapping("/users")
	public ResponseEntity<?>users(@RequestBody User user) {
		userService.saveUser(user);
		return new ResponseEntity<>("Berhasil simpan Data Users", HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/users/{id}")
	public ResponseEntity<?> update(@RequestBody User user, @PathVariable Integer id) {
		try {
			User existUser = userService.getUser(id);
			if (existUser.getId() != id) {
				return new ResponseEntity<>("ID Tidak Ada !!",HttpStatus.OK);
			}
			user.setId(id);
			userService.saveUser(user);
			return new ResponseEntity<>("Berhasil Edit Data Users ", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/users/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("Berhasil Hapus Data Users ID "+id , HttpStatus.OK);
	}

}
