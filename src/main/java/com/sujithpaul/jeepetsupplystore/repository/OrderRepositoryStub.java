package com.sujithpaul.jeepetsupplystore.repository;

import java.util.ArrayList;
import java.util.List;

import com.sujithpaul.jeepetsupplystore.model.Item;
import com.sujithpaul.jeepetsupplystore.model.OrderEntity;

public class OrderRepositoryStub implements OrderRepository {

	private List<OrderEntity> orderList = new ArrayList<OrderEntity>();

	public OrderRepositoryStub() {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomerId("customer0");
		orderEntity.setOrderNumber(999L);
		Item item = new Item();
		item.setProductId("pppp");
		item.setProductName("Chew Toy");
		item.setPrice(5.55);
		item.setQuantity(2);
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		orderEntity.setItems(items);
		orderList.add(orderEntity);
	}

	@Override
	public OrderEntity findOrder(long orderNumber) {
		return orderList.get(0);
	}

	@Override
	public void saveOrder(OrderEntity orderEntity) {
		orderList.add(orderEntity);
		System.out.println("@@@@@ Size: " + orderList.size());
	}
}
