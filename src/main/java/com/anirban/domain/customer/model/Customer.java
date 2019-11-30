package com.anirban.domain.customer.model;

import java.util.Date;

import javax.validation.constraints.Size;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "customer")
public class Customer {

	
	
	
	@Id
	public ObjectId id;
	
	@Field("cust_id")
	@Size(max = 14, message = "Customer Ide can not be more than 14 characters.")
	private String custId;

	@Field("first_name")

	@Size(max = 100, message = "first_name can not be more than 100 characters.")

	private String firstName;

	@Field("last_name")

	@Size(max = 100, message = "last_name can not be more than 100 characters.")

	private String lastName;

	@Field("phone")

	@Size(max = 14, message = "email can not be more than 14 characters.")

	private String phone;

	@Field("email")

	@Size(max = 100, message = "email can not be more than 100 characters.")

	private String email;

	@Field("created")

	private Date created = new Date();

	@Field("modified")

	private Date modified = new Date();

	public ObjectId getId() {

		return id;

	}

	public void setId(ObjectId id) {

		this.id = id;

	}
	
	public String getCustId() {

		return custId;

	}

	public void setCusttId(String custId) {

		this.custId = custId;

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

	public String getPhone() {

		return phone;

	}

	public void setPhone(String phone) {

		this.phone = phone;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

	public Date getCreated() {

		return created;

	}

	public void setCreated(Date created) {

		this.created = created;

	}

	public Date getModified() {

		return modified;

	}

	public void setModified(Date modified) {

		this.modified = modified;

	}
}
