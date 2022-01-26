package com.student.management.repository;

import com.student.management.entity.Employee;

public interface EmployeeRepository extends GenericRepository{
	Employee fetchByIdAndPassword(int employeeId, String pwd);
	boolean exists(int employeeId);

}
