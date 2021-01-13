package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemID;
	private String title;
	private Float price;

	public Item(String title, String surname) {
		this.title = title;
		this.price = price;
	}

	public Item(Long id, String title, Float price) {
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

	public String getTile() {
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
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Customer other = (Customer) obj;
//		if (firstName == null) {
//			if (other.firstName != null)
//				return false;
//		} else if (!firstName.equals(other.firstName))
//			return false;
//		if (id == null) {
//			if (other.id != null)
//				return false;
//		} else if (!id.equals(other.id))
//			return false;
//		if (surname == null) {
//			if (other.surname != null)
//				return false;
//		} else if (!surname.equals(other.surname))
//			return false;
//		return true;
	}

//}
