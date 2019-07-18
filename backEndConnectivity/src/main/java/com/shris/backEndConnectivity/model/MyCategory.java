package com.shris.backEndConnectivity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;



@Entity
public class MyCategory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryid;
	
	@Column(nullable=false,unique=true)
	@NotEmpty(message="Category cannot be empty")
	private String categoryname;
	
	private String categorydescription;

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCategorydescription() {
		return categorydescription;
	}

	public void setCategorydescription(String categorydescription) {
		this.categorydescription = categorydescription;
	}
	
	
}
