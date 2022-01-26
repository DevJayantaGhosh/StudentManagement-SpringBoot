package com.student.management.service;

import com.student.management.entity.Employee;

public interface EmployeeService {
	Employee login(int employeeId, String password);
	Employee fetchById(int employeeId);
	void changePassword(int employeeId, String password);

}
