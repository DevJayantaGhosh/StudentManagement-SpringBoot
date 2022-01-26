package com.student.management.repository;

import org.springframework.stereotype.Repository;

import com.student.management.entity.Admission;

@Repository
public class AdmissionRepositoryImpl extends GenericRepositoryImpl implements AdmissionRepository {
	
	@Override
	public boolean isRollNoPresent(int rollNo) {
		return (Long)
				entityManager
				.createQuery("select count(a.rollNo) from Admission a where a.rollNo = :rollNo")
				.setParameter("rollNo", rollNo)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public long classCount(String classs) {
		return (Long)
				entityManager
				.createQuery("select count(a.rollNo) from Admission a where a.classs = :classs")
				.setParameter("classs", classs)
				.getSingleResult();
	}
	
	@Override
	public Admission getAdmissionWithReferenceNo(int referenceNo) {
		return (Admission)
				entityManager
				.createQuery("select a from Admission a where a.student.referenceNo = :referenceNo")
				.setParameter("referenceNo", referenceNo)
				.getSingleResult();
	}
	
	@Override
	public boolean isReferenceNoPresent(int referenceNo) {
		return (Long)
				entityManager
				.createQuery("select count(a.rollNo) from Admission a where a.student.referenceNo = :referenceNo")
				.setParameter("referenceNo", referenceNo)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public void deleteAdmission(Admission admission) {
		entityManager.remove(admission);
	}

}
