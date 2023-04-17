package com.example.lab2_java5.dao;

import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.lab2_java5.bean.UserMap;
import com.example.lab2_java5.model.User;
import com.fasterxml.jackson.databind.JsonNode;

@Repository
public class UserDAO {
	RestTemplate rest = new RestTemplate();
	
	String url = "https://poly-java6-db492-default-rtdb.asia-southeast1.firebasedatabase.app/students.json";
	
	private String getUrl(String key) {
		return url.replace(".json", "/"+key+".json");
	}
	
	public UserMap findAll() {
		return rest.getForObject(url, UserMap.class);
	}
	
	public User findByKey(String key) {
		return rest.getForObject(getUrl(key), User.class);
	}
	
	public String create(User data) {
		HttpEntity<User> entity = new HttpEntity<>(data);
		JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
		return resp.get("name").asText();
	}
	
	public User update(String key, User data) {
		HttpEntity<User> entity = new HttpEntity<>(data);
		rest.put(getUrl(key), entity);
		return data;
	}
	
	public void delete(String key) {
		rest.delete(getUrl(key));
	}
}
