package com.example.lab2_java5.streamAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.lab2_java5.model.Student;

public class StreamAPI {
	
	static List<Student> listS = Arrays.asList(
			new Student("Nguyễn Văn Tèo", true, 7.5),
			new Student("Trần Thị Thu Phương", false, 5.5),
			new Student("Phạm Đức Cường", true, 9.5),
			new Student("Lê Thị Mỹ Hồng", false, 6.0),
			new Student("Đoàn Thị Kim Ty", false, 8.0)
			);

	public static void main(String[] args) {
//		demo1();
//		demo2();
//		demo3();
		demo4();
	}

	private static void demo4() {
		double average = listS.stream()
				.mapToDouble(sv -> sv.getMark())
				.average().getAsDouble();
		System.out.println(">>Average: "+ average);
		
		double sum = listS.stream()
				.mapToDouble(sv -> sv.getMark())
				.sum();
		System.out.println(">>Sum: "+sum);
		
		double min_Mark = listS.stream()
				.mapToDouble(sv -> sv.getMark())
				.min().getAsDouble();
		System.out.println(">>min: "+min_Mark);
		
		boolean all_passed = listS.stream()
				.allMatch(sv -> sv.getMark() >= 5);
		System.out.println(">>All_Passed: "+all_passed);	
		
		Student min_sv = listS.stream()
				.reduce(listS.get(0), (min,sv) ->sv.getMark() < min.getMark() ? sv : min);
		System.out.println(">>Min_SV: "+min_sv.getName());	
				
	}

	private static void demo3() {
		List<Student> result = listS.stream()
				.filter(sv -> sv.getMark() >= 7)
				.peek(sv -> sv.setName(sv.getName().toUpperCase()))
				.collect(Collectors.toList());
		
		result.forEach(sv ->{
	        System.out.println(">>Name: "+ sv.getName());
	        System.out.println(">>Mark: "+sv.getMark());
	        System.out.println();
		});
	}

	private static void demo2() {
		List<Integer> list = Arrays.asList(1,9,4,7,5,2);
		List<Double> result = list.stream()
				.filter(n -> n%2 ==0)
				.map(Math::sqrt)
				.peek(System.out::println)
				.collect(Collectors.toList());
	}

	private static void demo1() {
		Stream<Integer> stream1 = Stream.of(1,9,4,7,5,2);
		stream1.forEach(System.out::println);
		System.out.println("//AAA///");
		List<Integer> list = Arrays.asList(1,9,4,7,5,2);
		list.stream().forEach(System.out::println);
	}

}
