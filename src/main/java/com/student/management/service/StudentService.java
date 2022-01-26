package com.student.management.service;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.student.management.dto.StudentDto;
import com.student.management.dto.StudentRegister;
import com.student.management.entity.Student;

public interface StudentService {
	
	void deleteStudent(int referenceNo);
	List<Student> getStudentsService();
	long studentsCount();
	Student fetchStudent(int referenceNo);
	int update(Student studentr);
	int register(StudentRegister studentr);
	byte[] writtingImage(MultipartFile image);
	byte[] writtingImage(File image);
	int updatePic(int referenceNo, MultipartFile image);
}
