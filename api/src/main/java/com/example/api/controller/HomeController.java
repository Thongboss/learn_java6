package com.example.api.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/home/index")
	public String home(Model model) {
		model.addAttribute("message","This is home page");
		return "home/index";
	}
	@RequestMapping("/home/about")
	public String about(Model model) {
		model.addAttribute("message","This is introduction page");
		return "home/index";
	}
	
	@RequestMapping("/home/delete")
	public String delete(Model model){
		return "redirect:/home/index";
	}
	
//	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping("/home/admins")
	public String admins(Model model) {
//		if(!request.isUserInRole("ADMIN")) {
//			return "redirect:/auth/access/denied";
//		}
		model.addAttribute("message","Hello adminstrator");
		return "home/index";
	}
	
//	@PreAuthorize("hasAnyRole('ADMIN','USER')")
	@RequestMapping("/home/users")
	public String users(Model model) {
//		if(!(request.isUserInRole("ADMIN") || request.isUserInRole("USER"))) {
//			return "redirect:/auth/access/denied";
//		}
		model.addAttribute("message","Hello staff");
		return "home/index";
	}
	
//	@PreAuthorize("isAuthenticated()")
	@RequestMapping("/home/authenticated")
	public String authenticated(Model model) {
//		if(request.getRemoteUser() == null) {
//			return "redirect:/auth/login/form";
//		}
		model.addAttribute("message","Hello authenticated user");
		return "home/index";
	}
	
	@RequestMapping("/home/thymleaf1")
	public String thymleaf1(Model model) {
		model.addAttribute("message","Thymleaf - With Extras");
		return "home/thymleaf1";
	}
	
	@RequestMapping("/home/thymleaf2")
	public String thymleaf2(Model model) {
		model.addAttribute("message","Thymleaf - With Extras");
		return "home/thymleaf2";
	}
}
