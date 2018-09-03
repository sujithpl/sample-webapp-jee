package com.sujithpaul.jeepetsupplystore.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.sujithpaul.jeepetsupplystore.client.InventoryAPIClient;
import com.sujithpaul.jeepetsupplystore.model.Item;
import com.sujithpaul.jeepetsupplystore.model.ItemInput;
import com.sujithpaul.jeepetsupplystore.model.Order;
import com.sujithpaul.jeepetsupplystore.model.OrderEntity;
import com.sujithpaul.jeepetsupplystore.model.OrderInput;
import com.sujithpaul.jeepetsupplystore.model.Product;
import com.sujithpaul.jeepetsupplystore.repository.OrderRepository;

public class OrderService {
	@Inject
	private OrderRepository orderRepository;

	@Inject
	private InventoryAPIClient client;

	public Order getOrder(long orderNumber) {
		try {
			OrderEntity orderEntity = orderRepository.findOrder(orderNumber);
			return convertToOrder(orderEntity);
		} catch (Exception e) {
			throw e;
		}
	}

	public Order saveOrder(OrderInput orderInput) {
		OrderEntity orderEntity = convertToOrderEntity(orderInput);
		orderRepository.saveOrder(orderEntity);
		return convertToOrder(orderEntity);
	}

	private OrderEntity convertToOrderEntity(OrderInput orderInput) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomerId(orderInput.getCustomerId());
		List<Item> orderItems = new ArrayList<Item>();
		for (ItemInput item : orderInput.getItems()) {
			Item orderItem = new Item();
			orderItem.setProductId(item.getProductId());
			orderItem.setQuantity(item.getQuantity());
			Product product = client.getProductDetails(item.getProductId());
			orderItem.setProductName(product.getName());
			orderItem.setPrice(product.getPrice());
			orderItems.add(orderItem);
		}
		orderEntity.setItems(orderItems);
		return orderEntity;
	}

	private Order convertToOrder(OrderEntity orderEntity) {
		Order order = new Order();
		order.setOrderNumber(orderEntity.getOrderNumber());
		order.setCustomerId(orderEntity.getCustomerId());
		order.setItems(orderEntity.getItems());
		order.setTotal(computeTotal(order.getItems()));
		return order;
	}

	private double computeTotal(List<Item> items) {
		double total = 0.0;
		for (Item item : items) {
			total += item.getQuantity() * item.getPrice();
		}
		return total;
	}
}
