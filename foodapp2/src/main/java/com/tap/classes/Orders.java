package com.tap.classes;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderId")
	private int orderId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="restaurentId")
	private int restaurentId;
	
	@Column(name="totalamount")
	private int totalamount;
	
	@Column(name="status")
	private boolean status;
	

    @Column(name = "date")
    private LocalDateTime date; // Changed to LocalDateTime

	@Column(name="paymentoption")
	private String paymentoption;

	
	
	@OneToMany(mappedBy = "orderIdJoin", cascade = CascadeType.ALL)
	private List<OrderItems> orderItems;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "orderId", optional = true)
	private OrderHistory orderHistory;



	public OrderHistory getOrderHistory() {
		return orderHistory;
	}

	public void setOrderHistory(OrderHistory orderHistory) {
		this.orderHistory = orderHistory;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getPaymentoption() {
		return paymentoption;
	}

	public void setPaymentoption(String paymentoption) {
		this.paymentoption = paymentoption;
	}
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurentId() {
		return restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}
	

	public Orders(int orderId, int userId, int restaurentId, int totalamount, boolean status, LocalDateTime date,
			String paymentoption) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurentId = restaurentId;
		this.totalamount = totalamount;
		this.status = status;
		this.date = date;
		this.paymentoption = paymentoption;
	}
	
	

	public Orders(int userId, int restaurentId, int totalamount, boolean status, LocalDateTime date, String paymentoption) {
		super();
		this.userId = userId;
		this.restaurentId = restaurentId;
		this.totalamount = totalamount;
		this.status = status;
		this.date = date;
		this.paymentoption = paymentoption;
	}
	

	public Orders(int userId, int restaurentId, int totalamount, boolean status, String paymentoption) {
		this.userId = userId;
		this.restaurentId = restaurentId;
		this.totalamount = totalamount;
		this.status = status;
		this.paymentoption = paymentoption;
	}


	public Orders() {
		super();
	}

	
	
	
	

}
