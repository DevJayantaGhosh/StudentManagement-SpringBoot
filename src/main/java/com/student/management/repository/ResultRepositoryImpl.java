package com.student.management.repository;

import org.springframework.stereotype.Repository;

import com.student.management.entity.Result;

import java.util.List;


@Repository
public class ResultRepositoryImpl extends GenericRepositoryImpl implements ResultRepository {
	
	@Override
	public List<Result> getResultsByRollNo(int rollNo){
		return (List<Result>)
				entityManager
				.createQuery("select r from Result r where r.rollNo = :rollNo")
				.setParameter("rollNo", rollNo)
				.getResultList();
		
	}
	
	@Override
	public List<Result> getResultsByTestCode(String testCode){
		return (List<Result>)
				entityManager
				.createQuery("select r from Result r where r.testCode = :testCode")
				.setParameter("testCode", testCode)
				.getResultList();
		
	}

}
