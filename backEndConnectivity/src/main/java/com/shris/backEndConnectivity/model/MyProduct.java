package com.shris.backEndConnectivity.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;


@Entity

public class MyProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	@Column(nullable=false,unique=false)
	@NotEmpty(message="Product Name cannot be Empty")
	private String productName;
	
	@Column(columnDefinition="longtext")
	private String productDescription;
	
	
	
	@Column(precision=10, scale=2)
	private float productPrice;
	
	private int prouctQuantity;
	
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private MyCategory mycategory;
	
	
	@ManyToOne
	@OnDelete(action=OnDeleteAction.CASCADE)
	private MySeller myseller;
	
	@Transient
	private MultipartFile image;
	
	
	public MyCategory getMycategory() {
		return mycategory;
	}
	public void setMycategory(MyCategory mycategory) {
		this.mycategory = mycategory;
	}
	public MySeller getMyseller() {
		return myseller;
	}
	public void setMyseller(MySeller myseller) {
		this.myseller = myseller;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	public Float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public int getProuctQuantity() {
		return prouctQuantity;
	}
	public void setProuctQuantity(int prouctQuantity) {
		this.prouctQuantity = prouctQuantity;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	
	

}
