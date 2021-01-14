package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemID;
	private String title;
	private Double price;

	public Item(String title, Double price) {
		this.title = title;
		this.price = price;
	}

	public Item(Long id,String title, Double price) {
		this.itemID = id;
		this.title = title;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

	public String toString() {
		return "id:" + itemID + " name of item:" + title + " amount:" + price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		return true;
	}

}
