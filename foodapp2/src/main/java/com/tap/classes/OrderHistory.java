package com.tap.classes;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="OrderHistory")
public class OrderHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="orderHistoryId")
	private int orderHistoryId;
	
	@Column(name="UserId")
	private int UserId;

	@OneToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId" )
    private Orders orderId;
	
	@Column(name = "date")
    private Date date; 

	
	@Column(name="totalamount")
	private int totalamount;
	
	@Column(name="status")
	private String status;
	
	

	public int getOrderHistoryId() {
		return orderHistoryId;
	}

	public void setOrderHistoryId(int orderHistoryId) {
		this.orderHistoryId = orderHistoryId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

	public int getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(int totalamount) {
		this.totalamount = totalamount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	

	
	public Orders getOrderId() {
		return orderId;
	}

	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}

	
//
//	public int getOrderid() {
//		return orderid;
//	}
//
//	public void setOrderid(int orderid) {
//		this.orderid = orderid;
//	}

	

	public OrderHistory(int orderHistoryId, int userId, Orders orderId, Date date, int totalamount, String status) {
		super();
		this.orderHistoryId = orderHistoryId;
		UserId = userId;
		this.orderId = orderId;
		this.date = date;
		this.totalamount = totalamount;
		this.status = status;
	}
	

	public OrderHistory(int userId, Orders orderId, int totalamount, String status) {
		super();
		UserId = userId;
		this.orderId = orderId;
		this.totalamount = totalamount;
		this.status = status;
	}
	
	
	

	public OrderHistory() {
		super();
	}
	
	

}
