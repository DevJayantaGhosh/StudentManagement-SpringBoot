package com.student.management.service;

import javax.transaction.Transactional;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.student.management.entity.Student;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private MailSender mailSender;

	@Override
	public void marksEmail() {
	}

	@Override
	public void registerEmail(Student student) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("do-not-reply@aayaam.com");
		message.setTo(student.getEmailId());
		message.setSubject("Student Registration Successful");
		message.setText("Greetings , " + student.getName() + " has been successfully registered for the class " + ".");
		mailSender.send(message);
	}

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOtpMessage(String to, String subject, String message) throws MessagingException {

		MimeMessage msg = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(message, true);
		javaMailSender.send(msg);
	}

}
