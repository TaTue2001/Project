package com.example.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Entity.Account;
import com.example.Project.Interface.Service.IAccountService;
import com.example.Project.Interface.Service.IEmailService;
import com.example.Project.Interface.Service.IOtpService;
import com.example.Project.Service.EmailService;
//import com.example.Project.Service.FirebaseService;

@RestController
@RequestMapping("/mail")
public class SendEmailController {
	@Autowired
    private IEmailService iEmailService;
	@Autowired
	private IOtpService iOtpService;
	@Autowired
	private IAccountService iAccountService;

    @PostMapping("/send-otp")
    public String sendEmail(@RequestParam String email) {
        iEmailService.sendEmail(email, "this is email sended by TXT", iOtpService.generateOtp(email));
        return "Otp sent successfully!";
    }
    @PostMapping("/verify-otp")
    public String verifyOtp(@RequestParam String email, @RequestParam String otp) {
        if (iOtpService.isValidOtp(email, otp)) {
        	iAccountService.updateEmailVerificationStatus(email);
            return "OTP verified successfully";
        } else {
            return "Invalid OTP";
        }
    }
    @PostMapping("/forgot-password")
    public String forgotPassword(@RequestParam String email) {
    	Account account=iAccountService.getAccountByEmail(email);
    	if(account!=null) {
    		if(account.getIsEmailVarified()==1) {
    			iEmailService.sendEmail(email, "OTP for recorver password", iOtpService.generateOtp(email));
    			return "Otp sent successfully!";
    		}
    		return "no account corresponding to the email";
    	}
        return "not exist Account with this email";
    }
    @PostMapping("/recover-password")
    public String recoverPassword(@RequestParam String email, @RequestParam String otp, @RequestParam String newPassword) {
        if (iOtpService.isValidOtp(email, otp)) {
        	String rs=iAccountService.updatePassword(email, newPassword);
            return rs;
        } else {
            return "Invalid OTP";
        }
    }
    
}
