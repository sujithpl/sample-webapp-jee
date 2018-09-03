package com.sujithpaul.jeepetsupplystore.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.sujithpaul.jeepetsupplystore.model.Item;
import com.sujithpaul.jeepetsupplystore.model.Order;
import com.sujithpaul.jeepetsupplystore.model.OrderEntity;
import com.sujithpaul.jeepetsupplystore.repository.OrderRepository;

public class OrderServiceTest {

	@Mock
	private OrderRepository orderRepository;

	@InjectMocks
	private OrderService orderService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetOrder() {
		List<Item> items = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setItemId(100);
		item1.setProductId("id1");
		item1.setQuantity(10);
		item1.setProductName("Some product");
		item1.setPrice(5.01);
		items.add(item1);

		Item item2 = new Item();
		item2.setItemId(200);
		item2.setProductId("id2");
		item2.setQuantity(2);
		item2.setProductName("Some other product");
		item2.setPrice(23.33);
		items.add(item2);

		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomerId("customer1");
		orderEntity.setOrderNumber(1001L);
		orderEntity.setItems(items);

		when(orderRepository.findOrder(Mockito.anyLong())).thenReturn(orderEntity);
		Order order = orderService.getOrder(1001L);
		assertEquals(order.getTotal(), 96.76, 0.001);
	}

}
