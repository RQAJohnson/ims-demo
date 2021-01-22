package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;


public class ItemServices implements CrudServices<Item>{
	
private Dao<Item> itemDao;
	
	public ItemServices(Dao<Item> itemDao) {
		this.itemDao = itemDao;
	}
	
	public List<Item> readAll() {  
		return itemDao.readAll();
	}

	public Item create(Item item) {
		return itemDao.create(item);
	}

	public Item update(Item item) {
		return itemDao.update(item);
	}

	public void delete(Long id) {
		itemDao.delete(id);
	}

	@Override
	public Order orderline(Order order) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
