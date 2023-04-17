package com.example.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class Customer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String photo;
	private Boolean activated;
	
	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	List<Orders> orders;
}
