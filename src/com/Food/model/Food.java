package com.Food.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Food entity. @author MyEclipse Persistence Tools
 */

public class Food implements java.io.Serializable {

	// Fields

	private Integer foodid;
	private String foodname;
	private Double uintprice;
	private Set orders = new HashSet(0);

	// Constructors

	/** default constructor */
	public Food() {
	}

	/** minimal constructor */
	public Food(String foodname) {
		this.foodname = foodname;
	}

	/** full constructor */
	public Food(String foodname, Double uintprice, Set orders) {
		this.foodname = foodname;
		this.uintprice = uintprice;
		this.orders = orders;
	}

	// Property accessors

	public Integer getFoodid() {
		return this.foodid;
	}

	public void setFoodid(Integer foodid) {
		this.foodid = foodid;
	}

	public String getFoodname() {
		return this.foodname;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public Double getUintprice() {
		return this.uintprice;
	}

	public void setUintprice(Double uintprice) {
		this.uintprice = uintprice;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}