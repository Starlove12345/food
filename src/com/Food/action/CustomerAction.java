package com.Food.action;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.Food.Dao.CustomerDao;
import com.Food.model.Customer;
import com.opensymphony.xwork2.ActionSupport;

//@Scope("prototype")表示将Action的范围声明为原型，可以利用容器的scope="prototype"
//来保证每一个请求有一个单独的Action来处理，避免struts中Action的线程安全问题。
//scope="prototype" 可以保证当有请求的时候都创建一个Action对象
@Controller @Scope("prototype")
public class CustomerAction extends ActionSupport{
	@Resource CustomerDao customerDao;//注入customerDao
	 private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String reg() throws Exception{
		customerDao.AddCustomer(customer);
		return "show_view";
		
	}
	
	private String errMessage;//用來登錄錯誤信息
	
	public String getErrMessage() {
		return errMessage;
	}

	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}
    
	/* 验证用户登录 */
	public String login() {
		Customer db_customer = (Customer)customerDao.QueryCustomerInfo(customer.getName()).get(0);
		if(db_customer == null) { 
			this.errMessage = " 账号不存在 ";
			System.out.print(this.errMessage);
			return "input";
		} else if( !db_customer.getPassword().equals(customer.getPassword())) {
			this.errMessage = " 密码不正确! ";
			System.out.print(this.errMessage);
			return "input";
		}
		return "show_view";
	}
	
}