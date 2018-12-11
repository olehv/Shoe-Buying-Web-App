package com.web;

import java.io.Serializable;
import java.sql.Date;

public class Order implements Serializable {
private int orderId, customerId, itemId, quantity;
private Date orderDate;
private String status;

public int getOrderID() {
	return orderId;
}
public void setOrderId(int orderID) {
	this.orderId = orderID;
}
@Override
public String toString() {
	return "<br> orderId: " + orderId + "<br> customerId: " + customerId + "<br> itemId: " + itemId + "<br> quantity: " + quantity
			 + "<br> status: " + status;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public int getItemId() {
	return itemId;
}
public void setItemId(int itemId) {
	this.itemId = itemId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date date) {
	this.orderDate =  date;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
}
