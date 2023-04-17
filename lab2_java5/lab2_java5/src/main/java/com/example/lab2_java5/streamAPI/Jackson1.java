package com.example.lab2_java5.streamAPI;

import java.io.File;
import java.io.IOException;

import com.example.lab2_java5.model.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jackson1 {

	public static void main(String[] args) throws Exception {
//		demo1();
		demo2();
	}

	private static void demo2() throws Exception {
		String path = "D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\students.json";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode students = mapper.readTree(new File(path));
		students.iterator().forEachRemaining(stu -> {
			System.out.println(">>Name: "+stu.get("name").asText());
		});
	}

	private static void demo1() throws Exception {
//		String json ="{\r\n"+
//	         "         \"name\": \"Nguyễn Văn Tèo\",\r\n"+
//	         "         \"gender\": true,\r\n"+
//	         "         \"mark\": 7.5,\r\n"+
//	         "         \"contact\": {\r\n"+
//	         "            \"email\": \"Teonv@gmail.com\",\r\n"+
//	         "            \"phone\": \"0527152152\"\r\n"+
//	         "         },\r\n"+
//	         "         \"subjects\": [\"WEB205\",\"COM108\"]\r\n"+
//	         "         }";
//		
//		ObjectMapper mapper = new ObjectMapper();
//		JsonNode student = mapper.readTree(json);
		
		String path ="D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\student.json";
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode student = mapper.readTree(new File(path));
		
		System.out.println(">>Name: "+student.get("name").asText());
		System.out.println(">>Mark: "+student.get("mark").asDouble());
		System.out.println(">>Gender: "+student.get("gender").asBoolean());
		System.out.println(">>Email: "+student.get("contact").get("email").asText());
		System.out.println(">>Phone: "+student.findValue("phone").asText());
		
		student.get("subjects").iterator().forEachRemaining(sub -> {
			System.out.println(">>Subject: "+sub.asText());
		});
	}

}
