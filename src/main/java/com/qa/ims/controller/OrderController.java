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
		Order order = orderService.create(new Order(id));
		LOGGER.info("Order Placed!");
		return order;
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
	
	public Order orderline() {
		LOGGER.info("Enter your order ID: ");
		Long orderID = getinpuT();
		LOGGER.info("Enter Item ID: ");
		Long itemID = Long.valueOf(getInput());
		Order order = orderService.orderline(new Order(itemID, orderID));
		return order;
	}
	
//	<!-------------ADD/DELETE item--------------!>
//	List<Order> listA = new ArrayList<>();
//	system.out.println("Add an item to your order");
//	
//	listA.add(orderID);
//	listA.add(orderID);
//	listA.add(orderID);
	
//	system.out.println("Delete an item from your order");
//	listA.remove(itemID);
//  listA.remove(itemID);
//----------------------------------------------------
	
//	List<Order> odr= orderService.create();
//	Order itemID;
//	odr.add(itemID);
	
//	odr.remove(itemID);
//	-----------------------------------------------
	

	@Override
	public void delete() {
		LOGGER.info("Please Enter the OrderID you would like to delete: ");
		Long orderID = getinpuT();
		orderService.delete(orderID);
		
	}
	
}
