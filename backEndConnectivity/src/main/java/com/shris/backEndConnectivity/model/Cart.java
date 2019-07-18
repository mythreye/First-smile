package com.shris.backEndConnectivity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
public class Cart {

	@ManyToOne
	private MyCustomer customer;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private MyProduct product;
	private int quantity;
	private double totalprice;

	public MyCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(MyCustomer customer) {
		this.customer = customer;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public MyProduct getProduct() {
		return product;
	}

	public void setProduct(MyProduct product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

}