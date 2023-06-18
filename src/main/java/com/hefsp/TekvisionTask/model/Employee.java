package com.hefsp.TekvisionTask.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//This code is Java Class defines a simple Employee class that can be used to create employee
//objects, set their attributes, and retrieve or modify their data
// I have Annotations to create class, This class also create database table of Employees name with @Entity annotation

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private long contactno;
	private String address;
	
	//Here we create constructor from Super Class
	
	public Employee() {
		super();
	}

	public Employee(int id, String firstname, String lastname, long contactno, String address) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.contactno = contactno;
		this.address = address;
	}
	
	//This is toString method it displaying the values of all the member variables.

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", contactno=" + contactno
				+ ", address=" + address + "]";
	}
	
	// This code for Getter and Setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getContactno() {
		return contactno;
	}

	public void setContactno(long contactno) {
		this.contactno = contactno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
