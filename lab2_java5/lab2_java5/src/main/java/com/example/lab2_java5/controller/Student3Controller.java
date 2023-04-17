package com.example.lab2_java5.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.lab2_java5.model.Student3;

@Controller
public class Student3Controller {
	@GetMapping("/student/form")
	public String form(Model model) {
		Student3 sv = new Student3();
		model.addAttribute("sv",sv);
		return "student/form";
	}
	
	@PostMapping("/student/save")
	public String save(Model model, @Validated @ModelAttribute("sv") Student3 sv1, Errors errors) {
//		System.out.println("FFF: "+errors);
		if(errors.hasErrors()) {
//			System.out.println("aaa");
			model.addAttribute("message","Vui lòng sửa các lỗi sau");
			return "student/form";
		}
		return "student/success";
	}
}
