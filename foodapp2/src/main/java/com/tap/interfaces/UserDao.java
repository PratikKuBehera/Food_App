package com.tap.interfaces;

import com.tap.classes.User;

public interface UserDao {
	
	 public void insertUser(String name, String email, int mobileNo, String password, String address);
		
	 public void fetchAllUser();
		
	 public User fetchUserId(int Id);
		
	 public void updateUserName(int Id , String Name);
		
	 public User userLogin(String email , String password);
	 



}
