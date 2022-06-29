package com.assigment.product.controller;

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
import com.assigment.product.model.Product;
import com.assigment.product.service.ProductService;


@RestController
@RequestMapping("/api")
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
			Product barang = productService.getProduct(id);
			return new ResponseEntity<Product>(barang, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@PostMapping("/products")
	public ResponseEntity<?> products(@RequestBody Product barang) {
		productService.saveProduct(barang);
		return new ResponseEntity<>("Berhasil Simpan Data Product", HttpStatus.OK);
	}

	@CrossOrigin
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product barang, @PathVariable Integer id) {
		try {
			Product existProduct = productService.getProduct(id);
			if (existProduct.getId() != id) {
				return new ResponseEntity<>("ID Tidak Ada !!",HttpStatus.OK);
			}
			barang.setId(id);
			productService.saveProduct(barang);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?>  delete(@PathVariable Integer id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>("Berhasil Hapus Data Product Dengan ID "+id, HttpStatus.OK);
	}
}
