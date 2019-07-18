package com.shris.backEndConnectivity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class MySeller {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sellerid;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Name cannot be blank")
	private String sellername;
	
	@Column(nullable=false)
	@NotEmpty(message="City caanot be blank")
	private String sellercity;
	
	@Column(nullable=false, unique=true)
	@NotEmpty(message="Please enter valid Phone number")
	@Pattern(regexp="[9876][0-9]{9}", message="Please enter valid phone no")
	private String sellerphoneno;
	
	@Column(nullable=false, unique=true)
	@NotEmpty(message="Please enter valid email")
	@Email(regexp="^\\w+@[0-9a-zA-Z_]+?\\.[a-zA-Z]{2,3}$",message="Please Enter a valid Email id")
	private String selleremail;
	
	@Transient
	@NotEmpty(message="Password cannot be blank")
	//@Pattern(regexp="[0-9A-Za-z] {6,7}",message="Please enter 6 digit password") 
	private String sellerpassword;
	
	public int getSellerid() {
		return sellerid;
	}

	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getSellercity() {
		return sellercity;
	}

	public void setSellercity(String sellercity) {
		this.sellercity = sellercity;
	}

	public String getSellerphoneno() {
		return sellerphoneno;
	}

	public void setSellerphoneno(String sellerphoneno) {
		this.sellerphoneno = sellerphoneno;
	}

	public String getSelleremail() {
		return selleremail;
	}

	public void setSelleremail(String selleremail) {
		this.selleremail = selleremail;
	}

	public String getSellerpassword() {
		return sellerpassword;
	}

	public void setSellerpassword(String sellerpassword) {
		this.sellerpassword = sellerpassword;
	}

	

}
