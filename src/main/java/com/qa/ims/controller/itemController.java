package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class itemController implements CrudController<Item> {
public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Item> customerService;
	
	public ItemController(CrudServices<Item> itemService) {
		this.itemService = itemService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemService.readAll();
		for(Item items: items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Item item = itemService.create(new Item(firstName, surname));
		LOGGER.info("Customer created");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the customer you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a first name");
		String firstName = getInput();
		LOGGER.info("Please enter a surname");
		String surname = getInput();
		Item item = itemService.update(new Item(id, firstName, surname));
		LOGGER.info("Customer Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the customer you would like to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
	}

}
