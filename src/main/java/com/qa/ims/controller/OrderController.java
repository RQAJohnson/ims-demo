package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {
	
//	inherit CustomerID and ItemID??? 
//	Garage task!?!?! having an arraylist that adds customer and item to it

public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	
	private CrudServices<Order> orderService;
	
	public OrderController(CrudServices<Order> orderService) {
		this.orderService = orderService;
	}
	
	String getInput() {
		return Utils.getInput();
	}
	
	Long getinpuT() {
		return Utils.getinpuT();
	}

	@Override
	public List<Order> readAll() {
		List<Order> orders = orderService.readAll();
		for(Order order: orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}

	@Override
	public Order create() {
		LOGGER.info("Please Enter Your Customer ID: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please Enter the item ID: ");
		Long itemID = getinpuT();
		LOGGER.info("Please enter the name of the item you wish to order: ");
		String title = getInput();
		Order order = orderService.create(new Order(id, itemID, title));
		LOGGER.info("Order Placed");
		return order;
//		FOR LOOP HERE!!! > 
	}
	
	@Override
	public void delete() {
		LOGGER.info("Please Enter the OrderID you would like to delete: ");
		Long orderID = getinpuT();
		orderService.delete(orderID);
		
	}

	@Override
	public Order update() {
		return null;
	}	
	
}
