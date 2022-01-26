package com.student.management.service;

import org.springframework.scheduling.annotation.Scheduled;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

@Service
public class SchedulerServiceImpl {
	/*@Scheduled(cron = " 0 45,46 11 ? * *", zone = "GMT+5:30")
	public void testSchedule() {
		System.out.println("Scheduling working ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date now = new Date();
		String strDate = sdf.format(now);
		System.out.println("Java cron job expression:: " + strDate);
	}*/

}
