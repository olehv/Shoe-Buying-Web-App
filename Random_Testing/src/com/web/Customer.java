package com.web;

import java.io.Serializable;

public class Customer implements Serializable {
private int customerID;
private String userName, password, firstName, lastName, address, city, postalCode;

public int getCustomerID() {
	return customerID;
}
public void setCustomerID(int customerID) {

	this.customerID = customerID;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
@Override
public String toString() {
	return "<br> userName: " + userName + "<br> firstName: "
			+ firstName + "<br> lastName: " + lastName + "<br> address: " + address + "<br> city: " + city + "<br> postalCode: "
			+ postalCode;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPostalCode() {
	return postalCode;
}
public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
}
}
