package com.tap.interfaces;

import com.tap.classes.Orders;
import com.tap.classes.Restaurant;

public interface OrdersDao {
	
	void insertOrder(int userId, int restaurentId, int totalamount, boolean status, String paymentoption);
	Orders fetchOnOrderId(int orderId);
	void updateOrder(int orderId , boolean status);
	public int getOrderId();

	


}
