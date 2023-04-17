package com.example.lab2_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
public class OkController {
	@RequestMapping("")
	public String ok() {
		return "bai1/ok";
	}
	@GetMapping("ok1")
	public String ok1(Model model) {
//		System.out.println("đã đến đây 1");
		model.addAttribute("message", "Bạn chọn ok 1");
		return "bai1/ok";
	}
	@GetMapping("ok2")
	public String ok2(Model model) {
//		System.out.println("đã đến đây 2");
		model.addAttribute("message", "Bạn chọn ok 2");
		return "bai1/ok";
	}
	@GetMapping("ok3")
	public String ok3(Model model) {
//		System.out.println("đã đến đây 3");
		model.addAttribute("message", "Bạn chọn ok 3");
		return "bai1/ok";
	}
}
