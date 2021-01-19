package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List; 
import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrderController implements CrudController<Order> {

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
		List<Order> order = orderService.readAll();
		for(Order orders: order) {
			LOGGER.info(orders.toString());
		}
		return order;
	}

	@Override
	public Order create() {
		LOGGER.info("Please Enter Your Customer ID: ");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Enter the item ID :");
//		Long itemID = getinpuT();
		Long orderID = getinpuT();
		Order order = orderService.create(new Order(id));
		LOGGER.info("Order Placed!");
		return order;
	}
	
//	
	public Order orderline() {
		LOGGER.info("Enter the ID of the order you wish to update: ");
		Long orderID = getinpuT();
		LOGGER.info("Enter your customer ID: ");
		Long itemID = Long.valueOf(getInput());
		Order order = orderService.update(new Order(itemID, orderID));
		return order;
//		look up orderID in orders table
//		
	}
	
	@Override
	public Order update() {
		LOGGER.info("Enter the ID of the order you wish to update: ");
		Long orderID = getinpuT();
		LOGGER.info("Enter your customer ID: ");
		Long customerID = Long.valueOf(getInput());
		Order order = orderService.update(new Order(customerID, orderID));
		LOGGER.info("Order Successfully Updated");
		return order;
	}
//		<!-------------ADD/DELETE item--------------!>		
//		List<Order> odr= orderService.update();
//		Order itemID;
//		odr.add(itemID);
//		odr.remove(itemID);		
////		if order = new order, sysout "do enter Item ID you wish to add.
////		else "order updated"
////		else if sysout "enter item ID you wish to remove".
////		sysout "order updated
////		return order;
////		

	
	@Override
	public void delete() {
		LOGGER.info("Please Enter the OrderID you would like to delete: ");
		Long orderID = getinpuT();
		orderService.delete(orderID);
		
	}
	
}
