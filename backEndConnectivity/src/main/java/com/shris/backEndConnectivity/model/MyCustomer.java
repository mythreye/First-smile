package com.shris.backEndConnectivity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
/*
import javax.validation.constraints.Email;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
*/
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class MyCustomer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerid;
	
	@Column(nullable=false)
	@NotEmpty(message="Customer name cannot be blank")
	private String customername;
	
	@Column(nullable=false, unique=true)
	@NotEmpty(message="Customer email cannot be blank")
	@Email(regexp="^\\w+@[0-9a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message="Please Enter a valid Email id")
	private String customeremail;
	
	@Column(nullable=false, unique=true)
	@NotEmpty(message="Customer phone  cannot be blank")
	@Pattern(regexp="[9876][0-9]{9}" , message="Valid number")
	private String customerphone;
	
	@Transient
	@NotEmpty(message="Password cannot be blank")
	//@Pattern(regexp="[0-9A-Za-z] {6,10}",message="Please enter 6 digit password")   
	private String customerpassword;
	
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeremail() {
		return customeremail;
	}
	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}
	
	public String getCustomerpassword() {
		return customerpassword;
	}
	public void setCustomerpassword(String customerpassword) {
		this.customerpassword = customerpassword;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	
	
	
}
