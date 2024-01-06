package com.example.Project.Interface.Service;

import org.springframework.stereotype.Repository;

@Repository
public interface IOtpService {
	String generateOtp(String email);
	boolean isValidOtp(String email, String otp);
	String generateRandomOtp();
}
