package com.assigment.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assigment.product.model.Barang;
import com.assigment.product.service.ProductService;

public interface ProductRepository extends JpaRepository<Barang, Integer> {

	
}