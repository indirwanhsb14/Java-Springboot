package com.assigment.product.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "barang")
public class Product {
	private int id;
	private String nama;
	private double hargaBeli;
	private double hargaJual;
	
	public Product() {
		
	}
	
	public Product(int id, String nama, double hargaBeli, double hargaJual) {
		this.id = id;
		this.nama = nama;
		this.hargaBeli = hargaBeli;
		this.hargaJual = hargaJual;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public double getHargaBeli() {
		return hargaBeli;
	}

	public void setHargaBeli(double hargaBeli) {
		this.hargaBeli = hargaBeli;
	}

	public double getHargaJual() {
		return hargaJual;
	}

	public void setHargaJual(double hargaJual) {
		this.hargaJual = hargaJual;
	}
	
	
	
}
