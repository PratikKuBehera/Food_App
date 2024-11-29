package com.tap.interfaces;

import java.util.List;

import com.tap.classes.OrderHistory;
import com.tap.classes.Orders;
import com.tap.classes.User;

public interface OrderHistoryDao {
	
	public OrderHistory insertOrderHistory(int userId, Orders orderId, int totalamount, String status);
	void fetchOrderHistory(int orderHistoryId);
	void updateorderHistory(int orderHistoryId,String status);
	public List<OrderHistory> fetchOrderHistoryByUserId(int userId);


}