package com.example.lab2_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lab2_java5.model.Product;

@Controller
@RequestMapping("product")
public class ProductController {
	@RequestMapping("")
	public String form(Model model) {
		Product product = new Product("",null);
		model.addAttribute("product", product);
		return "bai3/form";
	}
	@PostMapping("save")
	public String save(@ModelAttribute("product") Product product) {
//		System.out.println(product.getName());
		return "bai3/form";
	}
}
