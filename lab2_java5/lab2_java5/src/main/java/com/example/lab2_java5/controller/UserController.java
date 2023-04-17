package com.example.lab2_java5.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.lab2_java5.bean.UserMap;
import com.example.lab2_java5.dao.UserDAO;
import com.example.lab2_java5.model.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping("/user/index")
	public String index(Model model) {
		User user = new User("","",0.0,true,"VN");
		model.addAttribute("form", user);
		UserMap map = userDAO.findAll();
		model.addAttribute("items", map);
		return "user/index";
	}
	
	@RequestMapping("/user/edit/{key}")
	public String edit(Model model, @PathVariable("key") String key) {
		model.addAttribute("key", key);
		System.out.println("KEY: "+key);
		User user = userDAO.findByKey(key);
		System.out.println("name:"+user.getFullName());
		model.addAttribute("form", user);
		UserMap map = userDAO.findAll();
		model.addAttribute("items", map);
		return "user/index";
	}
	
	@RequestMapping("/user/create")
	public String create(User user) {
		userDAO.create(user);
		return "redirect:/user/index";
	}
	
	@RequestMapping("/user/update/{key}")
	public String update(@PathVariable("key") String key, User user) {
		userDAO.update(key, user);
		return "redirect:/user/edit/"+key;
	}
	
	@RequestMapping("/user/delete/{key}")
	public String delete(@PathVariable("key") String key) {
		userDAO.delete(key);
		return "redirect:/user/index";
	}
}
