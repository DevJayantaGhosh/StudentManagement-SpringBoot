package com.student.management.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.dto.Status;
import com.student.management.dto.Status.StatusCode;
import com.student.management.entity.Employee;
import com.student.management.exception.ServiceException;
import com.student.management.service.EmailService;
import com.student.management.service.EmailTemplate;
import com.student.management.service.EmployeeService;
import com.student.management.service.OtpService;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin
public class OtpController {

	@Autowired
	public OtpService otpService;

	@Autowired
	public EmployeeService employeeService;

	@Autowired
	public EmailService emailService;

	@GetMapping("/generateOtp")
	public Status generateOtp(@RequestParam("employeeId") int employeeId) {
		try {
			Status status = new Status();
			int otp = otpService.generateOTP(employeeId);
			// Employee requestedEmployee = employeeService.fetchById(employeeId);
			EmailTemplate template = new EmailTemplate("SendOtp.html");
			Map<String, String> replacements = new HashMap<String, String>();
			replacements.put("name", "Sai");
			replacements.put("otpnum", String.valueOf(otp));
			// replacements.put("employeeName", requestedEmployee.getFirstName());
			// replacements.put("employeeId", Integer.toString(employeeId));
			replacements.put("employeeName", "Krishna");
			replacements.put("employeeId", Integer.toString(employeeId));
			String message = template.getTemplate(replacements);
			emailService.sendOtpMessage("gdsaikrishna@gmail.com", "OTP for Students list", message);
			status.setStatusCode(StatusCode.SUCCESS);
			status.setStatusMessage("Otp sent Successfully");
			return status;
		} catch (ServiceException | MessagingException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Failed to send OTP");
			return status;
		}
	}

	@GetMapping("/validateOtp")
	public Status validateOtp(@RequestParam("employeeId") int employeeId, @RequestParam("otpnum") int otpnum) {
		try {
			Status status = new Status();
			if (otpnum >= 0) {
				int serverOtp = otpService.getOtp(employeeId);
				if (serverOtp == otpnum) {
					status.setStatusCode(StatusCode.SUCCESS);
					status.setStatusMessage("Valid OTP");
					otpService.clearOTP(employeeId);
				} else {
					status.setStatusCode(StatusCode.FAILURE);
					status.setStatusMessage("Invalid OTP, try again");
				}
			} else {
				status.setStatusCode(StatusCode.FAILURE);
				status.setStatusMessage("Invalid OTP, try again");
			}
			return status;
		} catch (ServiceException e) {
			Status status = new Status();
			status.setStatusCode(StatusCode.FAILURE);
			status.setStatusMessage("Wrong OTP, try again");
			return status;
		}
	}

}
