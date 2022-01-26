package com.student.management.repository;

import com.student.management.entity.Admission;

public interface AdmissionRepository extends GenericRepository{
	boolean isRollNoPresent(int rollNo);
	Admission getAdmissionWithReferenceNo(int referenceNo);
	void deleteAdmission(Admission admission);
	boolean isReferenceNoPresent(int referenceNo);
	long classCount(String classs);
}
