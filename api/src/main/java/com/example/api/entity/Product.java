package com.example.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="products")
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String image;
	private Double price;
	@Temporal(TemporalType.DATE)
	Date createDate = new Date();
	private Boolean available;
	
	@ManyToOne
	@JoinColumn(name="categoryId")
	Category category; 
	
	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetails> orderDetails;
}
