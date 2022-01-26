package com.student.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.dto.EmployeeLogin;
import com.student.management.dto.EmployeeLoginStatus;
import com.student.management.dto.EmployeeStatus;
import com.student.management.dto.Status;
import com.student.management.dto.Status.StatusCode;
import com.student.management.entity.Employee;
import com.student.management.exception.ServiceException;
import com.student.management.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/employee-login")
	public EmployeeLoginStatus login(@RequestBody EmployeeLogin login) {
		try {

			Employee empl = employeeService.login(login.getEmployeeId(), login.getPassword());

			EmployeeLoginStatus loginStatus = new EmployeeLoginStatus();
			loginStatus.setStatusCode(StatusCode.SUCCESS);
			loginStatus.setStatusMessage("Login Successful");
			loginStatus.setEmployeeId(empl.getEmployeeId());
			loginStatus.setName(empl.getName());
			loginStatus.setPassword(empl.getPassword());
			return loginStatus;

		} catch (ServiceException e) {
			EmployeeLoginStatus loginStatus = new EmployeeLoginStatus();
			loginStatus.setStatusCode(StatusCode.FAILURE);
			loginStatus.setStatusMessage("Invalid Id/Password");

			return loginStatus;
		}
	}

	@GetMapping(path = "/fetch-employee")
	public EmployeeStatus fetchEmployee(@RequestParam("employeeId") int employeeId) {
		try {
			Employee emp = employeeService.fetchById(employeeId);
			EmployeeStatus employeeStatus = new EmployeeStatus();
			employeeStatus.setStatusCode(StatusCode.SUCCESS);
			employeeStatus.setEmailId(emp.getEmailId());
			employeeStatus.setEmployeeId(emp.getEmployeeId());
			employeeStatus.setName(emp.getName());
			employeeStatus.setAddress(emp.getAddress());
			employeeStatus.setMobileNo(emp.getMobileNo());
			employeeStatus.setStatusMessage("Employee Fetch Successful");
			return employeeStatus;

		} catch (ServiceException e) {
			EmployeeStatus employeeStatus = new EmployeeStatus();
			employeeStatus.setStatusCode(StatusCode.FAILURE);
			employeeStatus.setStatusMessage("Invalid employeeId");

			return employeeStatus;
		}
	}

	@PostMapping(path = "/change-password")
	public Status changePassword(@RequestBody EmployeeLogin login) {
		try {
			employeeService.changePassword(login.getEmployeeId(), login.getPassword());
			Status changeStatus = new Status();
			changeStatus.setStatusCode(StatusCode.SUCCESS);
			changeStatus.setStatusMessage("Password Change Successful");
			return changeStatus;

		} catch (ServiceException e) {
			Status changeStatus = new Status();
			changeStatus.setStatusCode(StatusCode.FAILURE);
			changeStatus.setStatusMessage(e.getMessage());

			return changeStatus;
		}
	}

}
