package com.student.management.service;

import com.student.management.entity.Sms;

public interface SmsService {
	void send(Sms sms);

	String sendSms(String number, String msg);
}
