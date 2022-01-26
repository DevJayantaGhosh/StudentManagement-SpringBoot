package com.student.management.repository;

import java.util.List;

import com.student.management.entity.Result;

public interface ResultRepository extends GenericRepository{
	List<Result> getResultsByRollNo(int rollNo);
	List<Result> getResultsByTestCode(String testCode);
}
