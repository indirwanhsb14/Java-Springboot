package com.assignment.restfulapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.restfulapi.model.Product;
import com.assignment.restfulapi.repository.ProductRepository;



@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> listAllProduct() {
		return productRepository.findAll();
	}

	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	public Product getProduct(Integer id) {
		return productRepository.findById(id).get();
	}

	public void deleteProduct(Integer id) {
		productRepository.deleteById(id);
	}
}
