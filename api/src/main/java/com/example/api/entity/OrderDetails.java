package com.example.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="order_details")
public class OrderDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int quantity;
	private Double price;
	@ManyToOne
	@JoinColumn(name="orderId")
	Orders orders;
	@ManyToOne
	@JoinColumn(name="productId")
	Product product;
}
