package com.hibernate.mapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_products")
public class OrderProduct {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	  
		@ManyToOne
	    @JoinColumn(name = "order_id")
	    private Order order;
	    @ManyToOne
	    @JoinColumn(name = "product_id")
	    private Product product;
	    public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
}
