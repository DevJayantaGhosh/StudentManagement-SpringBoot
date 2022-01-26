package com.student.management.repository;

import org.springframework.stereotype.Repository;

import com.student.management.entity.Employee;

@Repository
public class EmployeeRepositoryImpl extends GenericRepositoryImpl implements EmployeeRepository {
	
	@Override
	public boolean exists(int employeeId) {
		return (Long)
				entityManager
				.createQuery("select count(e.id) from Employee e where e.employeeId = :employeeId")
				.setParameter("employeeId", employeeId)
				.getSingleResult() == 1 ?true : false;
	}
	@Override
	public Employee fetchByIdAndPassword(int employeeId, String pwd) {
		return (Employee) entityManager.createQuery("select e from Employee e where e.employeeId = :employeeId and e.password = :pwd")
				.setParameter("employeeId", employeeId).setParameter("pwd", pwd).getSingleResult();
	}

}
