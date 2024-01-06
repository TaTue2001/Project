package com.example.Project.Service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Project.Interface.Repository.IOtpRepository;
import com.example.Project.Interface.Service.IOtpService;
import com.example.Project.Entity.OtpEntity;

@Service
public class OtpService implements IOtpService {
	@Autowired
	private IOtpRepository iOtpRepository;

	@Override
	public String generateOtp(String email) {
		String otp = generateRandomOtp();
        OtpEntity otpEntity = new OtpEntity();
        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpEntity.setExpirationTime(new Date(System.currentTimeMillis() + 5* 60 * 1000)); // Hết hạn sau 30s
        iOtpRepository.save(otpEntity);

        return otp;		
	}

	@Override
	public boolean isValidOtp(String email, String otp) {
        Optional<OtpEntity> otpEntityOptional = iOtpRepository.findById(email);

        if (otpEntityOptional.isPresent()) {
            OtpEntity otpEntity = otpEntityOptional.get();

            return otpEntity.getOtp().equals(otp) && new Date().before(otpEntity.getExpirationTime());
        }

        return false;
	}

	@Override
	public String generateRandomOtp() {
		return String.format("%06d", (int) (Math.random() * 1000000));
	}
	
}
