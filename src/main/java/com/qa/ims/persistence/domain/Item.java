package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemID;
	private String title;
	private Float price;
	private Integer quantity;

	public Item(String title, Float price, Integer quantity) {
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public Item(Long id,String title, Float price, Integer quantity) {
		this.itemID = id;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public Long getId() {
		return itemID;
	}

	public void setId(Long id) {
		this.itemID = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	

	public String toString() {
		return "id:" + itemID + " name of item:" + title + " amount:" + price + "quantity" + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

//	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (itemID == null) {
			if (other.itemID != null)
				return false;
		} else if (!itemID.equals(other.itemID))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if(other.quantity != null)
				return false;
		}else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

}
