package com.example.lab2_java5.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lab2_java5.model.Product;

@Controller
@RequestMapping("list")
public class ListProductController {
	
	@RequestMapping("")
	public String form(Model model) {
		Product product1 = new Product();
		product1.setName("BlaBlo");
		product1.setPrice(55.3);
		model.addAttribute("product1", product1);
		Product product = new Product("",null);
		model.addAttribute("product", product);
		return "bai4/form";
	}
	@PostMapping("save")
	public String save(@ModelAttribute("product") Product product,Model model) {
		Product product1 = new Product();
		product1.setName("BlaBlo");
		product1.setPrice(55.3);
		model.addAttribute("product1", product1);
		return "bai4/form";
	}
	@ModelAttribute("list")
	public List<Product> getItem(){
		return Arrays.asList(new Product("ga",50.8),new Product("oop",23.4));
	}
}
