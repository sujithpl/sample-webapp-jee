package com.sujithpaul.jeepetsupplystore.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.sujithpaul.jeepetsupplystore.model.Order;
import com.sujithpaul.jeepetsupplystore.model.OrderInput;
import com.sujithpaul.jeepetsupplystore.service.OrderService;

@Path("/order")
public class OrderProcessor {

	@Inject
	private OrderService orderService;

	@GET
	@Path("{orderNumber}")
	@Produces(MediaType.APPLICATION_JSON)
	public Order getOrder(@PathParam("orderNumber") long orderNumber) {
		return orderService.getOrder(orderNumber);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response fileOrder(OrderInput orderInput) {
		Order order = orderService.saveOrder(orderInput);
		return Response.ok(order).build();
	}
}
