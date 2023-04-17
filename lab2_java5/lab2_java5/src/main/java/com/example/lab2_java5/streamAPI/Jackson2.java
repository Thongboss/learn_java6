package com.example.lab2_java5.streamAPI;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.lab2_java5.model.Contact;
import com.example.lab2_java5.model.Student2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Jackson2 {

	public static void main(String[] args) throws Exception {
//		demo1();
//		demo2();
//		demo3();
//		demo4();
//		demo5();
//		demo6();
//		demo7();
		demo8();
	}

	private static void demo8() throws Exception {
		Contact contact = new Contact("Teohaha@gmail.com", "012345678", null);
		List<String> subjects = Arrays.asList("WEB1013","IT16308");
		Student2 student = new Student2("Nguyễn Trọng Phụng", true, 9.1, contact, subjects);
		Student2 student1 = new Student2("Lệ Chi", false, 8.6, contact, subjects);
		List<Student2> list = Arrays.asList(student,student1);
		
		ObjectMapper mapper = new ObjectMapper();
		// ghi vào string
		String json = mapper.writeValueAsString(list);
		// in ra màn hình consle
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, list);
		// ghi vào file
		mapper.writeValue(
				new File("D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\studentjson2.json"),
				list);
	}

	private static void demo7() throws Exception {
		Contact contact = new Contact("Teohaha@gmail.com", "012345678", null);
		List<String> subjects = Arrays.asList("WEB1013","IT16308");
		Student2 student = new Student2("Nguyễn Trọng Phụng", true, 9.1, contact, subjects);
		
		ObjectMapper mapper = new ObjectMapper();
		// ghi vào string
		String json = mapper.writeValueAsString(student);
		// in ra màn hình consle
		mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, student);
		// ghi vào file
		mapper.writeValue(
				new File("D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\studentjson1.json"),
				student);
	}

	private static void demo6() throws Exception {
		Map<String, Object> contact = new HashMap<>();
		contact.put("email", "Teonv@gmail.com");
		contact.put("phone", "034521324");
		List<String> subjects = Arrays.asList("WEB205", "COM108");
		Map<String, Object> student = new HashMap<>();
		student.put("name", "Nguyễn Văn Tèo");
		student.put("mark", 7.5);
		student.put("gender", true);
		student.put("subjects", subjects);
		student.put("contact", contact);

		ObjectMapper mapper = new ObjectMapper();
		// ghi vào string
		String json = mapper.writeValueAsString(student);
		// in ra màn hình consle
		mapper.writeValue(System.out, student);
		// ghi vào file
		mapper.writeValue(
				new File("D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\studentjson1.json"),
				student);
	}

	private static void demo5() throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode student = mapper.createObjectNode();
		student.put("name", "Nguyễn Văn Tèo");
		student.put("mark", 7.5);
		student.put("gender", true);
		ObjectNode contact = student.putObject("contact");
		contact.put("email", "Teonv@gmail.com");
		contact.put("phone", "0356282710");
		ArrayNode subjects = student.putArray("subjects");
		subjects.add("WEB205");
		subjects.add("COM108");
		// ghi vào string
		String json = mapper.writeValueAsString(student);
		// in ra màn hình consle
		mapper.writeValue(System.out, student);
		// ghi vào file
		mapper.writeValue(
				new File("D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\studentjson.json"),
				student);
	}

	private static void demo4() throws Exception {
		String path = "D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\students.json";

		TypeReference<List<Student2>> type = new TypeReference<List<Student2>>() {
		};
		ObjectMapper mapper = new ObjectMapper();
		List<Student2> students = mapper.readValue(new File(path), type);
		students.forEach(stu -> {
			System.out.println(">>Name: " + stu.getName());
		});
	}

	private static void demo3() throws Exception {
		String path = "D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		Student2 student = mapper.readValue(new File(path), Student2.class);
		System.out.println(">>Name: " + student.getName());
		System.out.println(">>Mark: " + student.getMark());
		System.out.println(">>Gender: " + student.getGender());
		Contact contact = student.getContact();
		System.out.println(">>Email: " + contact.getEmail());
		System.out.println(">>Phone: " + contact.getPhone());
		System.out.println(">>Address: " + contact.getAddress());
		List<String> subjects = (List<String>) student.getSubjects();
		subjects.forEach(sb -> {
			System.out.println(">>Subject: " + sb);
		});
	}

	private static void demo2() throws Exception {
		String path = "D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\students.json";

		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> students = mapper.readValue(new File(path), List.class);
		students.forEach(stu -> {
			System.out.println(">>Name: " + stu.get("name"));
		});
	}

	private static void demo1() throws Exception {
		String path = "D:\\Java5\\baitap\\UD\\lab2_java5\\lab2_java5\\src\\main\\resources\\student.json";

		ObjectMapper mapper = new ObjectMapper();
		Map<String, Object> student = mapper.readValue(new File(path), Map.class);
		System.out.println(">>Name: " + student.get("name"));
		System.out.println(">>Mark: " + student.get("mark"));
		System.out.println(">>Gender: " + student.get("gender"));
		Map<String, Object> contact = (Map<String, Object>) student.get("contact");
		System.out.println(">>Email: " + contact.get("email"));
		System.out.println(">>Phone: " + contact.get("phone"));
		List<String> subjects = (List<String>) student.get("subjects");
		subjects.forEach(sb -> {
			System.out.println(">>Subject: " + sb);
		});
	}

}
