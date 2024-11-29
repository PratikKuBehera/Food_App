package com.tap.manager;

import java.util.HashMap;
import java.util.Map;

import com.tap.classes.CartItems;
import com.tap.interfaces.CartDao;

public class CartImp implements CartDao {

	private Map<Integer , CartItems> items;
	
	
	
	public CartImp() {
		this.items = new HashMap<>();
	}



	@Override
	public Map<Integer, CartItems> addItems(CartItems item) {
		
         int itemId= item.getMenuId();
         
         if(items.containsKey(itemId)) {
        	 CartItems existingItems =items.get(itemId);
        	 existingItems.setQuantity(existingItems.getQuantity() + item.getQuantity());
         }
         else {
        	 items.put(itemId,item);
         }
         return items;		
	}
	
	@Override
	public void update(int itemId , int Quantity) {
		
		if(items.containsKey(itemId)) {
			
			if(Quantity <=0) {
				items.remove(itemId);
			}
			else {
				items.get(itemId).setQuantity(Quantity);
			}
		}
	}
	
	
	@Override
	public  Map<Integer, CartItems> getItems(){
		
		return this.items;
	}



	@Override
	public void remove(int itemsId) {
		
		items.remove(itemsId);
		
	}

	
	
	

	
	
	
	
	
	

}
