package com.hibernate.mapping.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.hibernate.mapping.dao.UserDAO;

public class Main {

	public static void main(String[] args) {
		 UserDAO userDAO = new UserDAO();
	        
	        User user = new User();
	        user.setName("John Doe");
	        user.setEmail("john.doe@example.com");
	        
	        Address address = new Address();
	        address.setStreet("123 Main St");
	        address.setCity("Anytown");
	        address.setState("CA");
	        address.setZip("12345");
	        user.setAddress(address);
	        address.setUser(user);
	        
	        Phone phone = new Phone();
	        phone.setPhoneNumber("123-456-7890");
	        user.getPhones().add(phone);
	        phone.setUser(user);
	        
	        Order order = new Order();
	        order.setOrderDate(new Date());
	        order.setTotal(new BigDecimal("100.00"));
	        user.getOrders().add(order);
	        order.setUser(user);
	        
	        Product product1 = new Product();
	        product1.setName("Product 1");
	        product1.setPrice(new BigDecimal("50.00"));
	        
	        Product product2 = new Product();
	        product2.setName("Product 2");
	        product2.setPrice(new BigDecimal("50.00"));
	        
	        order.getProducts().add(product1);
	        order.getProducts().add(product2);
	        product1.getOrders().add(order);
	        product2.getOrders().add(order);
	        
	        userDAO.saveUser(user);
	    }

	
}
