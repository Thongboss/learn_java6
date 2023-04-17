package com.example.lab2_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomelController {
	@GetMapping("homel/index")
	public String index(Model model) {
		return "layout/home";
	}
	@GetMapping("homel/about")
	public String about(Model model) {
		return "layout/about";
	}
}
