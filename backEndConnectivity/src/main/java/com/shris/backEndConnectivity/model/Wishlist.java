package com.shris.backEndConnectivity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Wishlist {
	
	@ManyToOne
	private MyCustomer customerid;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wishlistid;
	
	@ManyToOne
	private MyProduct productid;
	
	public MyCustomer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(MyCustomer customerid) {
		this.customerid = customerid;
	}
	public int getWishlistid() {
		return wishlistid;
	}
	public void setWishlistid(int wishlistid) {
		this.wishlistid = wishlistid;
	}
	public MyProduct getProductid() {
		return productid;
	}
	public void setProductid(MyProduct productid) {
		this.productid = productid;
	}
	
	

}
