package com.sujithpaul.jeepetsupplystore.client;

import javax.enterprise.inject.Default;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.sujithpaul.jeepetsupplystore.model.Product;

@Default
public class RestInventoryAPIClient implements InventoryAPIClient {
	private static final String INVENTORY_API_URI = "https://petstoreapp.azurewebsites.net/api/products/";

	private Client client = ClientBuilder.newClient();

	@Override
	public Product getProductDetails(String id) {
		return client.target(INVENTORY_API_URI).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON)
				.get(Product.class);
	}

}
