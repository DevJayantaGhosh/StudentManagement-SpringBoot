package com.student.management.repository;

import java.util.List;

import com.student.management.entity.Student;

public interface StudentRepository extends GenericRepository{
	
	int save(Student student);
	boolean isStudentPresent(String aadhaarNo);
	List<Student> getStudents();
	long studentCount();
	boolean isReferenceNoPresent(int referenceNo);
	void deleteStudent(Student student);
}
