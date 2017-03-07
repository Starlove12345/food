package com.Food.action;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import javax.annotation.Resource;

import com.Food.Dao.*;
import com.Food.model.Food;


//@Controller(value="food") @Scope("prototype"),直接规定输入的规定为food,并且将FoodAction交给Spring管理
@Controller @Scope("prototype")//输入时格式默认foodaction默认为单列，把订单归整化
public class FoodAction extends ActionSupport {//ActionSupport为我们提供一些拦截器的功能
	 @Resource FoodDao foodDao;//将FoodDao注入
	 private Food food;//根据Struts2的特性，从页面的form表单中获取
	 private List<Food> foodList;//用于页面中显示列表
	 private String keyWords;
	 

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public java.util.List<Food> getFoodList() {
		return foodList;
	}

	public void setFoodList(java.util.List<Food> foodList) {
		this.foodList = foodList;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

		/*添加Food信息*/
	public String AddFood()throws Exception {
	    foodDao.addFood(food);
	    return "message";
	    }
	
	public String showFood()throws Exception{
	   foodList = foodDao.queryAllFood();
		return "show_view";
	}
	 
	public String showDetail()throws Exception{
		food=foodDao.getFoodById(food.getFoodid());
		return "detail_view";
	}
	
	public String showEdit()throws Exception{
		food=foodDao.getFoodById(food.getFoodid());
		return "edit_view";
	}
	
	public String editFood()throws Exception{
		foodDao.UpdateFood(food);
		return "edit_message";
	}
	
	public String deleteFood()throws Exception{
		foodDao.deleteFood(food.getFoodid());
		return "delete_message";
	}
	
	public String queryFoods()throws Exception{
	  foodList = foodDao.queryFoodInfo(keyWords);
		return "show_view";
	}
}