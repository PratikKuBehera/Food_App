package com.tap.classes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="userId")
	private int userId;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Email")
	private String Email;
	
	@Column(name="MobileNo")
	private int MobileNo;
	
	@Column(name="Password")
	private String Password;
	
	@Column(name="Address")
	private String Address;
	
	


	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getMobileNo() {
		return MobileNo;
	}

	public void setMobileNo(int mobileNo) {
		MobileNo = mobileNo;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public User(int userId, String name, String email, int mobileNo, String password, String address) {
		super();
		this.userId = userId;
		Name = name;
		Email = email;
		MobileNo = mobileNo;
		Password = password;
		Address = address;
	}

	public User(String name, String email, int mobileNo, String password, String address) {
		super();
		Name = name;
		Email = email;
		MobileNo = mobileNo;
		Password = password;
		Address = address;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", Name=" + Name + ", Email=" + Email + ", MobileNo=" + MobileNo
				+ ", Password=" + Password + ", Address=" + Address + "]";
	}
	
	
}
