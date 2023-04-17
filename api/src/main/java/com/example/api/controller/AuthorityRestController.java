package com.example.api.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Authorities;
import com.example.api.repository.AccountRepository;
import com.example.api.repository.AuthoritiesRepository;
import com.example.api.repository.RolesRepository;

@CrossOrigin(origins="*" )
@RestController
public class AuthorityRestController {
	
	@Autowired
	private RolesRepository roles;
	
	@Autowired
	private AuthoritiesRepository authorities;
	
	@Autowired
	private AccountRepository account;
	
	@GetMapping("/rest/authorize")
	public Map<String, Object> getAuthorities(){
		Map<String, Object> data = new HashMap<>();
		data.put("authorities", authorities.findAll());
		data.put("accounts", account.findAll());
		data.put("roles", roles.findAll());
		return data;
	}
	
	@DeleteMapping("/rest/authorize/{id}")
	public void delete(@PathVariable("id") long id) {
		authorities.deleteById(id);
	}
	
	@PostMapping("/rest/authorize")
	public Authorities create(@RequestBody Authorities authority) {
		return authorities.save(authority);
	}
}
