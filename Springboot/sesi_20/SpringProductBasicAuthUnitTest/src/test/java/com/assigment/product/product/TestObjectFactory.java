package com.assigment.product.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import com.assigment.product.model.Barang;

public class TestObjectFactory {
	public static Barang createProduct() {
		  final Barang product = new Barang();
		  product.setId(new Random().nextInt());
		  product.setNama(RandomStringUtils.randomAlphabetic(10));
		  product.setHargaBeli(new Random().nextInt());
		  product.setHargaJual(new Random().nextInt());

		  return product;
		}

		public static List<Barang> createProductList(final int size){
		  final List<Barang> result = new ArrayList<>();
		  for(int i=0; i<size; i++) {
		    result.add(createProduct());
		  }
		  return result;
		}
	@Test
	public void testCreateProduct() {
		createProductList(5);
	}
}
