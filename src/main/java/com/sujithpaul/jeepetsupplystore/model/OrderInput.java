package com.sujithpaul.jeepetsupplystore.model;

import java.util.List;

public class OrderInput {
	String customerId;
	List<ItemInput> items;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<ItemInput> getItems() {
		return items;
	}

	public void setItems(List<ItemInput> items) {
		this.items = items;
	}
}
