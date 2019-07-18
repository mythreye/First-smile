package com.shris.backEndConnectivity.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Orders {

	@Id
	String orderId;
	
	@ManyToOne
	MyProduct product;
	
	@ManyToOne
	MyCustomer customer;
	
	@ManyToOne
	Address address;
	
	@Temporal(TemporalType.DATE)
	Date date;
	
	int qty;
	
	double price;
	
	String orderState;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public MyProduct getProduct() {
		return product;
	}

	public void setProduct(MyProduct product) {
		this.product = product;
	}

	public MyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MyCustomer customer) {
		this.customer = customer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}
	
	
	
}
