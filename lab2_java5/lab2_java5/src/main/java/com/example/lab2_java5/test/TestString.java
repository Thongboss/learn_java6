package com.example.lab2_java5.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("Nhập vào chuỗi 1: ");
		String abc = sc.nextLine();
		System.out.println("Nhập vào chuỗi 2: ");
		String outRleData = sc.nextLine();

		// loại khoảng trắng khổng lồ
		String[] works = abc.split("            ");
		System.out.println("Array1: " + Arrays.toString(works));
		int afc = works.length;

		// loại bỏ giá trị rỗng sau cùng
		if (works[afc - 1].trim().isEmpty()) {
			afc -= 1;
		}
		List<String> adc = new ArrayList<>();
		for (int i = 0; i < afc; i++) {
			if (!(works[i].trim() == null)) {
				adc.add(works[i]);
			}
		}
		System.out.println("Array2: " + adc);

		// chuyển list sang map
		Map<String, Double> map = new HashMap();
		for (String string : adc) {
			String afk = string.trim().substring(0, 5);
			double apk = Double.parseDouble(string.trim().substring(5));
			map.put(afk, apk);
		}

		// column 2
		int a = outRleData.length();
		List<String> chuoi = new ArrayList<>();
		for (int i = 0; i < a - 20; i++) {
			chuoi.add(outRleData.substring(i, i + 20));
			i += 19;
		}
		System.out.println("Chuỗi: " + chuoi);

		int len = chuoi.size();
		Map<String, Double> mapp = new HashMap<>();
		for (int i = 0; i < len; i++) {
			mapp.put(chuoi.get(i).substring(0, 5), Double.parseDouble(chuoi.get(i).substring(5)));
		}
//		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(map);
			System.out.println("JSON: " + json);
			
			String jsonn = mapper.writeValueAsString(mapp);
			System.out.println("JSONN: " + jsonn);
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, map);
			
			mapper.writerWithDefaultPrettyPrinter().writeValue(System.out, mapp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
