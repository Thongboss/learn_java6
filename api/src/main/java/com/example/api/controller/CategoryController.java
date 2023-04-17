package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.entity.Category;
import com.example.api.repository.CategoryRepository;

@CrossOrigin("*")
@RestController
public class CategoryController {
	@Autowired
	CategoryRepository categoryRepository;
	
	@GetMapping("/rest/categories")
	public ResponseEntity<List<Category>> getAll(Model model){
		return ResponseEntity.ok(categoryRepository.findAll());
	}
	
	@GetMapping("/rest/categories/{id}")
	public ResponseEntity<Category> getById(@PathVariable("id") Long id){
		if(!categoryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(categoryRepository.findById(id).get());
	}
	
	@PostMapping("/rest/categories")
	public ResponseEntity<Category> post(@RequestBody Category cate){
		if(categoryRepository.existsById(cate.getId())) {
			return ResponseEntity.badRequest().build();
		}
		categoryRepository.save(cate);
		return ResponseEntity.ok(cate);
	}
	
	@PutMapping("/rest/categories/{id}")
	public ResponseEntity<Category> put(@PathVariable("id") Long id, @RequestBody Category cate){
		if(!categoryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categoryRepository.save(cate);
		return ResponseEntity.ok(cate);
	}
	
	@DeleteMapping("/rest/categories/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id){
		if(!categoryRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		categoryRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}



