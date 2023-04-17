 package com.example.api.entity;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="students")
public class Student {
	@Id
	@Column(name="email")
	private String email;
	@Column(name="fullname")
	private String fullname;
	@Column(name="mark")
	private Double mark;
	@Column(name="gender")
	private Boolean gender;
	@Column(name="country")
	private String country;
	
}
