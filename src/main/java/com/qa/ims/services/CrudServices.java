package com.qa.ims.services;

import java.util.List;

import com.qa.ims.persistence.domain.Order;

public interface CrudServices<T> {

    public List<T> readAll();
     
    T create(T t);
     
    T update(T t);
 
    void delete(Long id);

	Order orderline(Order order);

}
