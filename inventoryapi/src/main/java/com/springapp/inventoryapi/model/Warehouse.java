package com.springapp.inventoryapi.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Warehouse {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private Address address;

	// Create relationship table warehouse_product
	@ManyToMany
	@JoinTable(name = "warehouse_product", joinColumns = @JoinColumn(name = "warehouse_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
	private List<Product> products;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getLocation() {
		return address;
	}

	public void setAddress(Address location) {
		this.address = location;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
