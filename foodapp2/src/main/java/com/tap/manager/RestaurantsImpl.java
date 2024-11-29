package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.classes.Menu;
import com.tap.classes.Restaurant;
import com.tap.interfaces.RestaurantsDao;

public class RestaurantsImpl implements RestaurantsDao {
	
	private static  Session session;
	private Transaction t;
	//private Restaurant r;
	static List<Restaurant> restaurant;
	
	public void connection() {
		
		session = new Configuration().configure().addAnnotatedClass(Restaurant.class).addAnnotatedClass(Menu.class).
				buildSessionFactory().openSession();
		
	}

	

	@Override
	public void insertRestaurant(String name, String cuisine, int deleveryTime, boolean isActive, int rating,
			String imagePath) {

		connection();
		t =session.beginTransaction();
		Restaurant res = new Restaurant(name,cuisine, deleveryTime, isActive, rating,imagePath);
		System.out.println(res);
		System.out.println("executing-----------------------------------");
		session.persist(res);
		System.out.println("executing-----------------------------------");

		t.commit();
		
		System.out.println("Data Executed-----------------------------------");

		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Restaurant> fetchAllRestaurant() {
		
		connection();
		restaurant =session.createQuery("from Restaurant").list();
		System.out.println("rdoi "+""+restaurant);
		return restaurant;
		
	}

	@Override
	public Restaurant fetchByRestId(int Id) {
		
		connection();

		Restaurant r = session.get(Restaurant.class, Id);
		
		System.out.println(r);
		return r;
		
		 
			
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteByRestId(int Id) {
		
		connection();
		
	      t = session.beginTransaction();
			
	      Restaurant e =session.get(Restaurant.class, Id);
			
			if(e != null) {
				
				session.delete(e);
				
				t =session.getTransaction();
				
				t.commit();
				
				System.out.println("Row Deleted");
			}
			else {
				System.out.println("Data Not Available");
			}
		
		
	}

	@Override
	public void updateRestAvaliStatus(boolean b, int Id) {
		
        t =session.beginTransaction();
		
	    Restaurant e =session.get(Restaurant.class, Id);
	    e.setIsActive(b);
	    session.persist(e);
		session.getTransaction().commit();
		
		
	}

}
