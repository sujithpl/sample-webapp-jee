package com.sujithpaul.jeepetsupplystore.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
	@JsonProperty("Id")
	private String id;

	@JsonProperty("Category")
	private String category;

	@JsonProperty("Name")
	private String name;

	@JsonProperty("Price")
	private double price;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
