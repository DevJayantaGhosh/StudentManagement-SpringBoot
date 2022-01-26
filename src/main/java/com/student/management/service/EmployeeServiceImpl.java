package com.student.management.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.student.management.entity.Employee;
import com.student.management.exception.ServiceException;
import com.student.management.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee login(int employeeId, String password) {
		try {
			if(employeeRepository.fetchByIdAndPassword(employeeId, password)!= null) {
				return employeeRepository.fetchByIdAndPassword(employeeId, password);
			}
			else {
				throw new ServiceException("Invalid Employee Id/password");
			}
			
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid Employee Id/password");
		}
	}

	@Override
	public Employee fetchById(int employeeId) {
		if(employeeRepository.exists(employeeId)) {
			Employee emp = employeeRepository.fetchById(Employee.class, employeeId);
			return emp;
		}
		else {
			throw new ServiceException("Invalid Employee Id");
		}	
		
	} 
	
	@Override
	public void changePassword(int employeeId, String password) {
		try {
			if(employeeRepository.exists(employeeId)) {
				Employee emp = employeeRepository.fetchById(Employee.class, employeeId);
				emp.setPassword(password);
				employeeRepository.save(emp);
			}
			else {
				throw new ServiceException("Invalid Employee Id");
			}
			
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceException("Invalid Employee Id");
		}
	} 
	

}
