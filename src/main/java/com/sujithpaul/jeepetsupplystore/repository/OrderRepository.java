package com.sujithpaul.jeepetsupplystore.repository;

import com.sujithpaul.jeepetsupplystore.model.OrderEntity;

public interface OrderRepository {
	public OrderEntity findOrder(long orderNumber);
	public void saveOrder(OrderEntity orderEntity);
}
