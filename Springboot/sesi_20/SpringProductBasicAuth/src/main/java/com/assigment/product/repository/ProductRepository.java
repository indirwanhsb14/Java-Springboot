package com.assigment.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.product.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}