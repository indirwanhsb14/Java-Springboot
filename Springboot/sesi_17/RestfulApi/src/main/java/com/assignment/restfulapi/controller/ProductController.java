package com.assignment.restfulapi.controller;

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

import com.assignment.restfulapi.model.Product;
import com.assignment.restfulapi.service.ProductService;


@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@CrossOrigin
	@GetMapping("/products")
	public List<Product> list() {
		return productService.listAllProduct();
	}
	
	@CrossOrigin
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> products(@PathVariable Integer id) {
		try {
			Product product = productService.getProduct(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin
	@PostMapping("/products")
	public ResponseEntity<?>products(@RequestBody Product product) {
		productService.saveProduct(product);
		return new ResponseEntity<>("Berhasil simpan Data Product", HttpStatus.OK);	
	}
	
	@CrossOrigin
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
		try {
			Product existProduct = productService.getProduct(id);
			if (existProduct.getId() != id) {
				return new ResponseEntity<>("ID Tidak Ada !!",HttpStatus.OK);
			}
			product.setId(id);
			productService.saveProduct(product);
			return new ResponseEntity<>("Berhasil Edit Data Product ", HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@CrossOrigin
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Berhasil Hapus Data Product dengan ID "+id , HttpStatus.OK);
	}
}
