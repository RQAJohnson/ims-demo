package com.qa.ims.persistence.dao;

import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Order;

public interface Dao<T> {

    List<T> readAll();
     
    T create(T t);
     
    T update(T t);
     
    void delete(long id);
    
    public Order orderline(Order order);

	Customer update();
    

}
	