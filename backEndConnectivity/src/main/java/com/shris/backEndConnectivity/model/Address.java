package com.shris.backEndConnectivity.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Address {

	@ManyToOne
	private MyCustomer mycustomer;
	@Column(nullable=false)
	private String name;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressid;
	@Column(nullable=false)
	private String addreeline1;
	@Column(nullable=false)
	private String addressline2;
	@Column(nullable=false)
	private String city;
	@Column(nullable=false)
	private String state;
	@Column(nullable=false)
	private int pincode;
	
	
	
	public MyCustomer getMycustomer() {
		return mycustomer;
	}
	public void setMycustomer(MyCustomer mycustomer) {
		this.mycustomer = mycustomer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getAddreeline1() {
		return addreeline1;
	}
	public void setAddreeline1(String addreeline1) {
		this.addreeline1 = addreeline1;
	}
	public String getAddressline2() {
		return addressline2;
	}
	public void setAddressline2(String addressline2) {
		this.addressline2 = addressline2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
	
	
	
}
