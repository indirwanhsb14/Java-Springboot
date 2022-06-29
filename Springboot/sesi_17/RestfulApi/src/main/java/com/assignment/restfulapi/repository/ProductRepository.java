package com.assignment.restfulapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.assignment.restfulapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
