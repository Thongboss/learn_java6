package com.example.lab2_java5.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student2 {
	private String name;
	private Boolean gender;
	private double mark;
	private Contact contact;
	private List<String> subjects;
}
