package com.example.lab2_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home/index")
	public String index(Model model) {
		model.addAttribute("message","Welcom to thymeleaf");
		return "home/index";
	}

}
