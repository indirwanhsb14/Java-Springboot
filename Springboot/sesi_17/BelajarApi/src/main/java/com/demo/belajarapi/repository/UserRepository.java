package com.demo.belajarapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.belajarapi.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
}
