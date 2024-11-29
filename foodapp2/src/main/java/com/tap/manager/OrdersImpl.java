package com.tap.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.classes.OrderHistory;
import com.tap.classes.OrderItems;
import com.tap.classes.Orders;
import com.tap.classes.User;
import com.tap.interfaces.OrderHistoryDao;
import com.tap.interfaces.OrderItemsDao;
import com.tap.interfaces.OrdersDao;

public class OrdersImpl implements OrdersDao , OrderItemsDao, OrderHistoryDao {

	
private Session session;
private Transaction t;

private static final String DB_URL = "jdbc:mysql://localhost:3306/food_app";
private static final String DB_USER = "root";
private static final String DB_PASSWORD = "pratik123";





public void connection() {
		
		session = new Configuration().configure().addAnnotatedClass(Orders.class).
				addAnnotatedClass(OrderItems.class).addAnnotatedClass(OrderHistory.class)
				.addAnnotatedClass(User.class).
				buildSessionFactory().openSession();
		
		
	}

//Orders---------------

	@Override
	public void insertOrder(int userId, int restaurentId, int totalamount, boolean status, String paymentoption) {
		
        connection();
		
		t= session.beginTransaction();
		
		Orders order = new Orders(userId, restaurentId,  totalamount, status, paymentoption);
		
		session.persist(order);
		
		t.commit();
		
		
	}
	
	@Override
	public Orders fetchOnOrderId(int orderId) {
		
        connection();
		
		Orders o =session.get(Orders.class,orderId);		
		
		return o;
	}
	
	@Override
	public void updateOrder(int orderId, boolean status) {
		
        connection();
		
		t= session.beginTransaction();
		Orders o =session.get(Orders.class,orderId);
		
		o.setStatus(status);
		
		session.persist(o);

		session.getTransaction().commit();
		
		
	}

	@Override
	public int getOrderId() {

	    try
	    {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/food_app","root","pratik123");
	    	Statement stmt = con.createStatement();
	    	ResultSet res = stmt.executeQuery("SELECT MAX(orderId) FROM orders");
	    	 int maxOrderId = 0;
	    	    if (res.next()) { // Move the cursor to the first row
	    	        maxOrderId = res.getInt(1); // Retrieve the first column value
	    	    }
	    	    
	    	    // Print the maxOrderId
	    	    System.out.println("Max Order ID: " + maxOrderId);
	    	 return maxOrderId;
	    	
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    }
	 return 0;
	}
	
	
	
	// order history

	@Override
	public OrderHistory insertOrderHistory(int userId, Orders orderId, int totalamount, String status) {
		
        connection();
		
		t =session.beginTransaction();
		
		OrderHistory oh = new OrderHistory(userId, orderId, totalamount,status);
		
		session.persist(oh);
		
		t.commit();
		
		return oh;
		
		
	}

	@Override
	public void fetchOrderHistory(int orderHistoryId) {
		
        connection();
		
		OrderHistory oh = session.get(OrderHistory.class,orderHistoryId );
		
		System.out.println(oh);

		
	}
	
//	@Override
//	public List<OrderHistory> fetchHistoryUserId(int userId) {
//		
//        connection();
//		
//        List<OrderHistory> orderHistory = session.createQuery(
//                "FROM OrderHistory WHERE UserId = :userId", OrderHistory.class)
//                .setParameter("userId", userId) 
//                .getResultList();
//        System.out.println("OrdersImp "+orderHistory);
//        return orderHistory;            
//	}

	
	
	private Orders fetchOrderById(int orderId) {
	    Orders order = null;
	    String query = "SELECT * FROM Orders WHERE orderId = ?";

	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        preparedStatement.setInt(1, orderId);

	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            if (resultSet.next()) {
	                order = new Orders();
	                order.setOrderId(resultSet.getInt("orderId"));
	                
	                // Populate other fields as necessary
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return order;
	}
	
	
	
	@Override
	public List<OrderHistory> fetchOrderHistoryByUserId(int userId) {
	    List<OrderHistory> orderHistories = new ArrayList<>();
	    String query = "SELECT * FROM OrderHistory WHERE UserId = ?";

	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set the parameter for the userId
	        preparedStatement.setInt(1, userId);

	        // Execute the query and process the result set
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                // Create an OrderHistory object and populate its fields
	                OrderHistory orderHistory = new OrderHistory();

	                orderHistory.setOrderHistoryId(resultSet.getInt("orderHistoryId"));
	                orderHistory.setDate(resultSet.getDate("date"));
	                orderHistory.setTotalamount(resultSet.getInt("totalamount"));
	                orderHistory.setStatus(resultSet.getString("status"));
	                orderHistory.setTotalamount(resultSet.getInt("totalamount"));

	                // Fetch the Orders object manually (you'll need a separate method for this)
	                int orderId = resultSet.getInt("orderId");
	                Orders order = fetchOrderById(orderId); // Fetch the Orders object
	                orderHistory.setOrderId(order);

	                
	                // Add the object to the list
	                orderHistories.add(orderHistory);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return orderHistories;
	}
	
            
         		
	
	
	

	@Override
	public void updateorderHistory(int orderHistoryId, String status) {
		
		    t =session.beginTransaction();
			
	        OrderHistory oh =session.get(OrderHistory.class, orderHistoryId);
		    oh.setStatus(status);
		    session.persist(oh);
			session.getTransaction().commit();
			
			
	}
	
	//order items

	@Override
	public OrderItems insertOrderItems(int menuId, int quantity, int subtotal, Orders order) {
		
        connection();
		
		t= session.beginTransaction();
		
		OrderItems or =new OrderItems(menuId, quantity, subtotal,order);
		session.persist(or);
		
		
		t.commit();
		
		
		return or;
		
		
	}

	
//	@Override
//	public List<OrderItems> fetchOrderItems(int orderId) {
//		
//        connection();
//        List<OrderItems> orderItemsList = session.createQuery(
//                "FROM OrderItems WHERE orderIdJoin.orderItemsId = :orderId", OrderItems.class)
//                .setParameter("orderId", orderId)
//                .getResultList();
//            
//            return orderItemsList;	
//            
//	}
	
	
	@Override
	public List<OrderItems> fetchOrderItems(int orderId) {
	    List<OrderItems> orderItemsList = new ArrayList<>();

	    // SQL query to fetch OrderItems for the given orderId
	    String query = "SELECT * FROM OrderItems WHERE orderId = ?";

	    try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {

	        // Set the parameter for the query
	        preparedStatement.setInt(1, orderId);

	        // Execute the query
	        try (ResultSet resultSet = preparedStatement.executeQuery()) {
	            while (resultSet.next()) {
	                // Create a new OrderItems object
	                OrderItems orderItem = new OrderItems();

	                // Map the columns to the OrderItems object
	                orderItem.setOrderItemsId(resultSet.getInt("orderItemsId"));
	                orderItem.setMenuId(resultSet.getInt("menuId"));
	                orderItem.setQuantity(resultSet.getInt("quantity"));
	                orderItem.setSubtotal(resultSet.getInt("subtotal"));

	                // Assuming you have a method to fetch the Orders object from the database
	                Orders order = new Orders();
	                order.setOrderId(resultSet.getInt("orderid")); // Map the foreign key to the Orders object
	                orderItem.setOrderIdJoin(order);

	                // Add the OrderItems object to the list
	                orderItemsList.add(orderItem);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return orderItemsList;
	}

}
