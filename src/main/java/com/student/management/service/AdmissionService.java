package com.student.management.service;

import com.student.management.dto.AdmissionDto;
import com.student.management.dto.IdDto;
import com.student.management.entity.Admission;
import com.student.management.entity.Student;

public interface AdmissionService {
	 int admit(AdmissionDto admission);
	 int update(AdmissionDto admission);
	 void deleteAdmission(int rollNo);
	 AdmissionDto getAdmission(int rollNo);
	Student getStudent(int rollNo);
	long classCount(String classs);
	IdDto idCard(int rollNo);
}
