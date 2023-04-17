package com.example.lab2_java5.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScopeController {
	
	@Autowired
	HttpServletRequest servletRequest;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	ServletContext context;
	
	@RequestMapping("scope")
	public String index(Model model) {
		model.addAttribute("a","I am in model");
		servletRequest.setAttribute("b","I am in Request scope");
		session.setAttribute("c","I am in Session scope");
		context.setAttribute("d", "I am in ServletContext");
		return "scope/index";
	}
}
