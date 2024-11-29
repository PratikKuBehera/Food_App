package com.tap.interfaces;

import java.util.Map;

import com.tap.classes.CartItems;

public interface CartDao {
	

	public Map<Integer, CartItems> addItems(CartItems item);
	
	public void update(int itemId , int Quantity);
	
	public  Map<Integer, CartItems> getItems();
	
	public void remove(int itemsId);
	
	
}
