package com.student.management.dto;

import java.util.List;

import com.student.management.entity.Student;

public class StudentsListDto extends Status{

	private List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	
}
