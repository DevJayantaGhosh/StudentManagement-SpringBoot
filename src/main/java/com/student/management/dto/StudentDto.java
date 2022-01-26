package com.student.management.dto;

import java.sql.Blob;
import java.time.LocalDate;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import com.student.management.entity.Student;
//object for registering student 
public class StudentDto extends Status {
	private Student student;
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	
}
