package com.tap.classes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderItems")
public class OrderItems {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderItemsId")
	private int orderItemsId;
	
	
	
    @ManyToOne
	@JoinColumn(name = "orderId")  // Foreign key reference to 'Orders' table
	private Orders orderIdJoin;// The property name that maps to Orders
    
	@Column(name="menuId")
	private int menuId;


	@Column(name="quantity")
	private int quantity;
	
	@Column(name="subtotal")
	private int subtotal;


	public int getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(int subtotal) {
		this.subtotal = subtotal;
	}
	

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public OrderItems() {
		super();
	}

	public Orders getOrderIdJoin() {
		return orderIdJoin;
	}

	public void setOrderIdJoin(Orders orderIdJoin) {
		this.orderIdJoin = orderIdJoin;
	}

	public OrderItems(int menuId, int quantity, int subtotal, Orders order) {
	    this.menuId = menuId;
	    this.quantity = quantity;
	    this.subtotal = subtotal;
	    this.orderIdJoin = order;  // Directly set the Order object
	}
	
	

}
