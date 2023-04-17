package com.example.lab2_java5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	String email;
	String fullName;
	Double mark;
	Boolean gender;
	String country;
}
