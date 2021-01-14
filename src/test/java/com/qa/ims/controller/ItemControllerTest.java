package com.qa.ims.controller;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.services.ItemServices;



@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest { 
	/**
	 *  The thing I want to fake functionlity for
	 */
	@Mock
	private ItemServices itemServices;
	
	/**
	 * Spy is used because i want to mock some methods inside the item I'm testing
	 * InjectMocks uses dependency injection to insert the mock into the customer controller
	 */
	@Spy
	@InjectMocks
	private ItemController itemController;

	@Test
	public void readAllTest() { 
		ItemController itemController = new ItemController(itemServices);
		List<Item> items = new ArrayList<>(); 
		items.add(new Item("FIFA 21", 49.99));
		items.add(new Item("NBA 2K21", 41.99));
		items.add(new Item("C.O.D", 45.99));
		Mockito.when(itemServices.readAll()).thenReturn(items);
		assertEquals(items, itemController.readAll());
	}

	@Test
	public void createTest() { 
		String title = "FIFA 21";
		Mockito.doReturn(title).when(itemController).getInput();
		Double price = 49.99;
		Mockito.doReturn(price).when(itemController).getinput();
		itemController.create();
		return;
}
	/**
	 * 
	 */
	@Test
	public void updateTest() { 
		Long id = 1L;
		Mockito.doReturn(id).when(itemController).getinpuT();
		String title = "C.O.D";
		Mockito.doReturn(title).when(itemController).getInput();
		Double price = 45.99;
		Mockito.doReturn(price).when(itemController).getinput();
		itemController.update();
		return;
}

	/**
	 * Delete doesn't return anything, so we can just verify that it calls the delete method
	 */
	@Test
	public void deleteTest() {
		Long id = 1L;
		Mockito.doReturn(id).when(itemController).getinpuT();
		itemController.delete();
		Mockito.verify(itemServices, Mockito.times(1)).delete(1L);
	}
	
	}

 

