package com.tap.classes;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="restaurantId")
	private int restaurantId;
	
	@Column(name="Name")
	private String Name;
	
	@Column(name="Cuisine")
	private String Cuisine;
	
	@Column(name="DeleveryTime")
	private int  DeleveryTime;
	
	@Column(name="IsActive")
	private boolean IsActive;
	
	@Column(name="Rating")
	private int Rating;
	
	@Column(name="ImagePath")
	private String ImagePath;
	
	
	
	
	 @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
	 private List<Menu> menus;

	    // Getters and setters, constructors, and toString() method

	 public List<Menu> getMenus() {
	        return menus;
	 }

	 public void setMenus(List<Menu> menus) {
	        this.menus = menus;
	  }
	    
	    

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCuisine() {
		return Cuisine;
	}

	public void setCuisine(String cuisine) {
		Cuisine = cuisine;
	}

	public int getDeleveryTime() {
		return DeleveryTime;
	}

	public void setDeleveryTime(int deleveryTime) {
		DeleveryTime = deleveryTime;
	}

	public boolean isIsActive() {
		return IsActive;
	}

	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}

	public int getRating() {
		return Rating;
	}

	public void setRating(int rating) {
		Rating = rating;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public Restaurant(int restaurantId, String name, String cuisine, int deleveryTime, boolean isActive, int rating,
			String imagePath) {
		super();
		this.restaurantId = restaurantId;
		Name = name;
		Cuisine = cuisine;
		DeleveryTime = deleveryTime;
		IsActive = isActive;
		Rating = rating;
		ImagePath = imagePath;
	}

	public Restaurant(String name, String cuisine, int deleveryTime, boolean isActive, int rating, String imagePath) {
		super();
		Name = name;
		Cuisine = cuisine;
		DeleveryTime = deleveryTime;
		IsActive = isActive;
		Rating = rating;
		ImagePath = imagePath;
	}

	public Restaurant() {
		super();
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", Name=" + Name + ", Cuisine=" + Cuisine
				+ ", DeleveryTime=" + DeleveryTime + ", IsActive=" + IsActive + ", Rating=" + Rating + ", ImagePath="
				+ ImagePath + "]";
	}
	
	
	
	

}
