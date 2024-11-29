package com.tap.classes;

public class CartItems {
	
    private int menuId;
    private String name;
    private int quantity;
    private float price;
    private Restaurant restaurantId;
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Restaurant getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Restaurant restaurantId) {
		this.restaurantId = restaurantId;
	}
	public CartItems(int menuId, String name, int quantity, float f, Restaurant restaurant) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.quantity = quantity;
		this.price = f;
		this.restaurantId = restaurant;
	}
	public CartItems(String name, int quantity, int price, Restaurant restaurantId) {
		super();
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.restaurantId = restaurantId;
	}
	public CartItems() {
		super();
	}
	@Override
	public String toString() {
		return "CartItems [menuId=" + menuId + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", restaurantId=" + restaurantId + "]";
	}
    
    

}
