package com.student.management.repository;

import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

import com.student.management.entity.Admission;
import com.student.management.entity.Student;

@Repository
public class StudentRepositoryImpl extends GenericRepositoryImpl implements StudentRepository{
	
	@Transactional
	@Override
	public int save(Student student) {
		Student updatedStudent = entityManager.merge(student);
		return updatedStudent.getReferenceNo();
	}
	
	@Override
	public boolean isStudentPresent(String aadhaarNo) {
		return (Long)
				entityManager
				.createQuery("select count(s.referenceNo) from Student s where s.aadhaarNo = :aadhaarNo")
				.setParameter("aadhaarNo", aadhaarNo)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public boolean isReferenceNoPresent(int referenceNo) {
		return (Long)
				entityManager
				.createQuery("select count(s.referenceNo) from Student s where s.referenceNo = :referenceNo")
				.setParameter("referenceNo", referenceNo)
				.getSingleResult() == 1 ?true : false;
	}
	
	@Override
	public List<Student> getStudents(){
		return (List<Student>)
				entityManager
				.createQuery("select s from Student s", Student.class)
				.getResultList();
	}
	
	@Override
	public long studentCount() {
		return (long)
				entityManager
				.createQuery("select count(s.referenceNo) from Student s")
				.getSingleResult();
	}
	
	@Override
	public void deleteStudent(Student student) {
		entityManager.remove(student);
	}

}
