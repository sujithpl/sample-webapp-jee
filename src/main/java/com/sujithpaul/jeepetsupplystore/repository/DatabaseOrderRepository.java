package com.sujithpaul.jeepetsupplystore.repository;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import com.sujithpaul.jeepetsupplystore.model.OrderEntity;

@Default
public class DatabaseOrderRepository implements OrderRepository {
	private static final String PERSISTENCE_UNIT_NAME = "test";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	private static final EntityManager em = factory.createEntityManager();

	@Override
	public OrderEntity findOrder(long orderNumber) {
		OrderEntity orderEntity;
		try {
			orderEntity = em.find(OrderEntity.class, orderNumber);
		} catch (EntityNotFoundException e) {
			throw e;
		}
		return orderEntity;
	}

	@Override
	public void saveOrder(OrderEntity orderEntity) {
		em.getTransaction().begin();
		em.persist(orderEntity);
		em.getTransaction().commit();
	}
}
