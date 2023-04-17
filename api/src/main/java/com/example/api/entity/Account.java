package com.example.api.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name="accounts")
@Data
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="user_name",length=50)
	private String userName;
	
	private String password;
	
	@Column(length = 50)
	private String fullName;
	
	@Column(length = 50, unique = true)
	private String email;
	
	private String photo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	List<Authorities> authorities;

}
