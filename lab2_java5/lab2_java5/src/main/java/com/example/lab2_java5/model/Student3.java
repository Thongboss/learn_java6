package com.example.lab2_java5.model;



import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student3 {
	@NotBlank(message = "Không để trống email.")
	@Email(message = "Email phải đúng định dạng.")
	String email;
	@NotBlank(message = "không để trống họ tên.")
	String fullName;
	@NotNull(message = "Không để trống điểm.")
	@PositiveOrZero(message = "Điểm phải lớn hơn 0")
	@Max(message = "Điểm phải nhỏ hơn 10", value = 10)
	Double mark;
	@NotNull(message = "Chọn giới tính!")
	Boolean gender;
	@NotBlank(message = "Chọn quốc tịch!")
	String country;
}
