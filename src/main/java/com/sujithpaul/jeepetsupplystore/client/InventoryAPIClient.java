package com.sujithpaul.jeepetsupplystore.client;

import com.sujithpaul.jeepetsupplystore.model.Product;

public interface InventoryAPIClient {
	public Product getProductDetails(String id);
}
