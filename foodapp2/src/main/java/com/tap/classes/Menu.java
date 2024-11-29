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
@Table(name="Menu")
public class Menu {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="menuId")
	private int menuId;
	
	@Column(name="ItemsName")
	private String ItemsName;
	
	@Column(name="Price")
	private float Price;
	
	@Column(name="IsAvalablie")
	private boolean IsAvalablie;
	
	@Column(name="Description")
	private String Description;
	
	@Column(name="ImagePath")
	private String ImagePath;
	
	@ManyToOne
    @JoinColumn(name = "restaurantId", nullable = false)
    private Restaurant restaurant;

    // Getters and setters, constructors

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public String getItemsName() {
		return ItemsName;
	}

	public void setItemsName(String itemsName) {
		ItemsName = itemsName;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public boolean isIsAvalablie() {
		return IsAvalablie;
	}

	public void setIsAvalablie(boolean isAvalablie) {
		IsAvalablie = isAvalablie;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public Menu(int menuId, String itemsName, float price, boolean isAvalablie, String description, String imagePath) {
		super();
		this.menuId = menuId;
		ItemsName = itemsName;
		Price = price;
		IsAvalablie = isAvalablie;
		Description = description;
		ImagePath = imagePath;
	}

	
	public Menu(String itemsName, float price, boolean isAvalablie, String description, String imagePath) {
		super();
		ItemsName = itemsName;
		Price = price;
		IsAvalablie = isAvalablie;
		Description = description;
		ImagePath = imagePath;
	}

	public Menu() {
		super();
	}
	
}
