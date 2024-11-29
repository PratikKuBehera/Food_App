package com.tap.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tap.classes.Menu;
import com.tap.classes.Restaurant;
import com.tap.interfaces.MenuDao;


public class MenuImp implements MenuDao {
	
	private Session session;
	private Transaction t;
	private Menu menu;
	
	public void connection() {
		
		session = (Session) new Configuration().configure().addAnnotatedClass(Menu.class).addAnnotatedClass(Restaurant.class).
				buildSessionFactory().openSession();
		
	}

	@Override
	public void insertMenu(String itemsName, float price, boolean isAvalablie, String description, String imagePath) {
		
		 connection();
		 t= session.beginTransaction();
		 menu = new Menu(itemsName,price,isAvalablie,description,imagePath);
		 session.persist(menu);
		 
		 System.out.println("data inserted --------------------------------");
		 t.commit();
		
	}

	@Override
	public Menu fetchByMenuId(int menuId) {
		
		connection();
		Menu e=session.get(Menu.class, menuId);
		
		return e;
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteByMenuId(int menuId) {
		
        connection();
		
		t=session.beginTransaction();
		
		Menu e=session.get(Menu.class, menuId);
						
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
	public void updateMenuAvailStatus(boolean isAvalablie, int menuId) {
        connection();

        t =session.beginTransaction();
		
	    Menu e =session.get(Menu.class, menuId);
	    e.setIsAvalablie(isAvalablie);
	    session.persist(e);
		session.getTransaction().commit();

		
	}

	@Override
	public List<Menu> fetchByRestId(int restaurantId) {
		
        connection();
        List<Menu> menuList = session.createQuery("FROM Menu WHERE restaurant.restaurantId = :restaurantId", Menu.class)
                .setParameter("restaurantId", restaurantId)
                .getResultList();
        		
		return menuList;
		
		
	}
	
	
	

}
