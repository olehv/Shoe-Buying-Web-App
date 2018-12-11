package com.web;

import java.io.Serializable;

public class Shoe implements Serializable {

	@Override
	public String toString() {
		return "Shoe [itemId=" + itemId + ", shoeSize=" + shoeSize + ", itemName=" + itemName + ", category=" + category
				+ ", price=" + price + "]";
	}
	private int itemId, shoeSize;
	private String itemName, category;
	private double price;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(int shoeSize) {
		this.shoeSize = shoeSize;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
