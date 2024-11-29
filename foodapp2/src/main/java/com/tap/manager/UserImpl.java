package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.classes.OrderHistory;
import com.tap.classes.OrderItems;
import com.tap.classes.Orders;
import com.tap.classes.User;
import com.tap.decode.Decode;
import com.tap.interfaces.UserDao;

public class UserImpl implements UserDao {
	
	
	Session session;
	private Transaction t;
	private User user;
	private List<User> userlist;
	
	public void connection() {
		
		session = (Session) new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(OrderHistory.class).
				addAnnotatedClass(Orders.class).addAnnotatedClass(OrderItems.class).buildSessionFactory().openSession();
		
		
		
	}

	@Override
	public void insertUser(String name, String email, int mobileNo, String password, String address) {
		
		connection();
        t = session.beginTransaction();
		user = new User(name,email, mobileNo,password, address);
		session.persist(user);
		t.commit();
		
	}
	

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public void fetchAllUser() {
		
        connection();
		
		userlist = session.createQuery("from User").list(); 

        for (User e : userlist) {
        	
            System.out.println(e); 
            
            
        }
	}

	@Override
	public User fetchUserId(int Id) {
		
		connection();

        User e =session.get(User.class,Id);
		
        System.out.println("user:::::::::::::::::::::::::" + e);
        
		System.out.println(e);
		
		return e;
		
	}

	@Override
	public void updateUserName(int Id, String Name) {
		
		connection();
		
		t = session.beginTransaction();
		 
		 User e =session.get(User.class, Id);
		 
		 
		 if(e != null ) {
			 
			 e.setName(Name);
			 
			 session.persist(e);
			 
			 t.commit();
			 
			 System.out.println("Updated");
			 
		 }
		 else {
			 System.out.println("Data Not found-----");
		 }
		
	}

	@Override
	public User userLogin(String email, String password) {
		
		
		User u = session.createQuery("FROM User WHERE Email = :email ", User.class)
                .setParameter("email", email)
                .uniqueResult();
		
//		System.out.println("User Pwd "+u.getPassword());
//		System.out.println("User decode pwd "+Decode.decrypt(u.getPassword()));
		
		if(password.equals(Decode.decrypt(u.getPassword()))) {
			return u;
	
		}
		return null;
		
		
	}

}
