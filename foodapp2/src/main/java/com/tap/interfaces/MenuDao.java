package com.tap.interfaces;

import java.util.List;

import com.tap.classes.Menu;

public interface MenuDao {

	public void insertMenu(String itemsName, float price, boolean isAvalablie, String description, String imagePath);

	public Menu fetchByMenuId(int menuId);

	public void deleteByMenuId(int menuId);

	public void updateMenuAvailStatus(boolean isAvalablie , int menuId);

	public  List<Menu>  fetchByRestId(int restaurantId);

}
