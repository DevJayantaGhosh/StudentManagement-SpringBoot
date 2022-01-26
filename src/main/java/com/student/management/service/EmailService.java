package com.student.management.service;

import javax.mail.MessagingException;

import com.student.management.entity.Student;

public interface EmailService {
	void marksEmail();
	void registerEmail(Student student);
	void sendOtpMessage(String to, String subject, String message) throws MessagingException;

}
