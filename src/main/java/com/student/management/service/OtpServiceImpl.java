package com.student.management.service;

import com.google.common.cache.LoadingCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {

	private static final Integer EXPIRE_MINS = 4;
	private LoadingCache<String, Integer> otpCache;

	public OtpServiceImpl() {
		super();
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MINS, TimeUnit.MINUTES)
				.build(new CacheLoader<String, Integer>() {
					public Integer load(String key) {
						return 0;
					}
				});
	}

	@Override
	public int generateOTP(int employeeId) {
		Random random = new Random();
		int otp = 100000 + random.nextInt(900000);
		otpCache.put(Integer.toString(employeeId), otp);
		return otp;
	}

	@Override
	public int getOtp(int employeeId) {
		try {
			return otpCache.get(Integer.toString(employeeId));
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public void clearOTP(int employeeId) {
		otpCache.invalidate(Integer.toString(employeeId));
	}

}
