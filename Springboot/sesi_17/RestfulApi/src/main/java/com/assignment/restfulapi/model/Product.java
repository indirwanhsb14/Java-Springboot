package com.assignment.restfulapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float proBuy;
	private float proSell;
	private String proName;
	
	
	public Product() {
		
	}
	
	public Product(int id, float proBuy, float proSell, String proName) {
		this.id = id;
		this.proName = proName;
		this.proBuy = proBuy;
		this.proSell = proSell;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getProBuy() {
		return proBuy;
	}

	public void setProBuy(float proBuy) {
		this.proBuy = proBuy;
	}

	public float getProSell() {
		return proSell;
	}

	public void setProSell(float proSell) {
		this.proSell = proSell;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}
	
	
}
