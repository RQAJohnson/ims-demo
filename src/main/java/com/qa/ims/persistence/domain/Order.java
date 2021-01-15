package com.qa.ims.persistence.domain;

public class Order {
	private Long orderID;
	private Long itemID;
	private Long customerID;
	private String title;
	
	//Need our own attributes
	//Getters and Setters > customer and item class. 
	
	public Order(Long orderID, Long itemID, String title) {
		super();
		this.orderID = orderID;
		this.itemID = itemID;
		this.customerID = customerID;
		this.title = title;
	}

	public Long getOrderID() {
		return orderID;
	}

	public void setOrderID(Long orderID) {
		this.orderID = orderID;
	}

	public Long getItemID() {
		return itemID;
	}

	public void setItemID(Long itemID) {
		this.itemID = itemID;
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}
	
	

}


 