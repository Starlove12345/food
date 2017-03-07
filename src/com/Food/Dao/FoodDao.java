package com.Food.Dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Food.model.Customer;
import com.Food.model.Food;

@Service @Transactional
public class FoodDao {
	//spring注释,实现Beans的功能，获取数据源，连接数据，使用数据，关闭数据
	@Resource SessionFactory factory;

	/* 添加Food信息 */
	//注意导入相应的包，import com.Food.model.Food
	public void addFood(Food food) throws Exception {
		Session s = factory.getCurrentSession();
		s.save(food);
	}

	/* 删除Food信息 */
	public void deleteFood(int foodId) throws Exception {
		Session s = factory.getCurrentSession();
		Object food = s.load(Food.class, foodId);
		s.delete(food);
	}

	/* 更新Food信息 */
	public void UpdateFood(Food food) throws Exception {
		Session s = factory.getCurrentSession();
		s.update(food);
	}

	/* 查询所有Food信息 */
	public ArrayList<Food> queryAllFood() {
		Session s = factory.getCurrentSession();
		String hql = "From Food";
		Query q = s.createQuery(hql);
		List foodList = q.list();
		return (ArrayList<Food>) foodList;
	}

	/* 根据主键获取对象 */
	public Food getFoodById(Integer foodid) {
		Session s = factory.getCurrentSession();
		Food food = (Food) s.get(Food.class, foodid);
		return food;
	}

	/* 根据查询条件查询 */
	public ArrayList<Food> queryFoodInfo(String foodname) {//只根据foodname查询
		Session s = factory.getCurrentSession();
		String hql = "From Food food where 1=1";//保证数据没有找到时候报错。
		if (!foodname.equals(""))
			hql = hql + " and food.foodname like '%" + foodname + "%'";
		Query q = s.createQuery(hql);
		List foodList = q.list();
		return (ArrayList<Food>) foodList;
	}

}
