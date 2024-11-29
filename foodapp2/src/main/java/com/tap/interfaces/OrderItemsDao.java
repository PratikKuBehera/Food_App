package com.tap.interfaces;

import java.util.List;

import com.tap.classes.OrderItems;
import com.tap.classes.Orders;

public interface OrderItemsDao {
	

	public OrderItems insertOrderItems(int menuId, int quantity, int subtotal, Orders order);
	public List<OrderItems> fetchOrderItems(int orderItemsId);


}
