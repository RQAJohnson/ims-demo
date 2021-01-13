package com.qa.ims.controller;

import java.util.List; 

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
public static final Logger LOGGER = Logger.getLogger(ItemController.class);
	
	private CrudServices<Item> itemService;
	

	String getInput() {
		return Utils.getInput();
	}
	
	Float getinput() {
		return Utils.getinput();
	}
	
	Integer getinpuT() {
		return Utils.getinpuT();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> item = itemService.readAll();
		for(Item items: item) {
			LOGGER.info(items.toString());
		}
		return item;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please Enter a Title of game");
		String title = getInput();
		LOGGER.info("Please enter a Price");
		Float price = getinput();
		LOGGER.info("Please enter the Quantity");
		Integer quantity = getinpuT();
		Item item = itemService.create(new Item(title, price, quantity));
		LOGGER.info("Item Added");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the ID of the item you want to update");
		Long itemID = Long.valueOf(getInput());
		LOGGER.info("Please enter a Title");
		String title = getInput();
		LOGGER.info("Please enter a Price");
		Float price = getinput();
		LOGGER.info("Please Enter Your new Quantity");
		Integer quantity = getinpuT();
		Item item = itemService.update(new Item(itemID, title, price, quantity));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you wish to delete");
		Long id = Long.valueOf(getInput());
		itemService.delete(id);
	}

}
