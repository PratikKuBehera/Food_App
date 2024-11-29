package com.tap.hibernatemanager;

import com.tap.manager.MenuImp;

public class HibernateManager {
	
	public static void main(String[] args) {
		
		MenuImp m =new MenuImp();
		
		m.insertMenu("Dosa", 120, true, null, null);
		
	}

}
