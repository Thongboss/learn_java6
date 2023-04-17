package com.example.lab2_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("param")
public class ParamController {
	@RequestMapping("")
	public String form() {
		return "bai2/form";
	}
	@PostMapping("save/{x}")
	public String save(@RequestParam("y") String y, @PathVariable("x") String x, Model model) {
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		return "bai2/form";
	}
}
