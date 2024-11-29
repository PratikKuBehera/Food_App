package com.tap.interfaces;

import java.util.List;

import com.tap.classes.Restaurant;

public interface RestaurantsDao {
	
	    public void insertRestaurant(String name, String cuisine, int deleveryTime, boolean isActive, int rating, String imagePath);
		
		public List<Restaurant>  fetchAllRestaurant();

		public Restaurant fetchByRestId(int Id);

		public void deleteByRestId(int Id);

		public void updateRestAvaliStatus(boolean b , int Id);



}
