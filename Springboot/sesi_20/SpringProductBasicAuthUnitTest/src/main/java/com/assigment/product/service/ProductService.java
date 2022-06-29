package com.assigment.product.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assigment.product.model.Barang;
import com.assigment.product.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Barang> listAllProduct() {
		return productRepository.findAll();
	}

	public void saveProduct(Barang barang) {
		productRepository.save(barang);
	}

	public Barang getProduct(Integer id) {
		return productRepository.findById(id).get();
	}

	public void deleteProduct(Integer id) {
		Barang product = productRepository.findById(id).orElse(new Barang());
		productRepository.delete(product);
	}

	public Barang saveorUpdateProduct(Barang product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	public Barang findProductById(int id) {
		// TODO Auto-generated method stub
		Barang product = productRepository.findById(id).orElse(new Barang());
		return product;
	}
}
