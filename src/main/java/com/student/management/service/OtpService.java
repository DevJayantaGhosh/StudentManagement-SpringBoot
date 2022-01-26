package com.student.management.service;

public interface OtpService {

	int generateOTP(int employeeId);

	int getOtp(int employeeId);

	void clearOTP(int employeeId);

}