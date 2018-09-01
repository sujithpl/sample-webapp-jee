package com.sujithpaul.jeepetsupplystore.client;

import javax.enterprise.inject.Alternative;

import com.sujithpaul.jeepetsupplystore.model.Product;

@Alternative
public class InventoryAPIClientStub implements InventoryAPIClient {

	@Override
	public Product getProductDetails(String id) {
		Product product = new Product();
		product.setId(id);
		product.setCategory("category");
		product.setName("Name");
		product.setPrice(12.34);
		return product;
	}
}
