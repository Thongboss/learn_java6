package com.example.lab2_java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("result")
public class ResultController {
	@RequestMapping("")
	public String a() {
		return "bai5/a";
	}
	@GetMapping("b")
	public String b(Model model) {
		model.addAttribute("message", "I come from B");
		return "forward:/result";
	}
	@GetMapping("c")
	public String c(RedirectAttributes params) {
		params.addAttribute("message", "Icome from C");
		return "redirect:/result";
	}
	@ResponseBody
	@GetMapping("/d")
	public String d() {
		return "I come from D";
	}
}
