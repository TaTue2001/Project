package com.example.Project.Entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Otp")
public class OtpEntity {
	@Id
	private String email;
	private String otp;
	private Date expirationTime;
	public OtpEntity() {
	}
	public OtpEntity(String email, String otp, Date expirationTime) {
		super();
		this.email = email;
		this.otp = otp;
		this.expirationTime = expirationTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Date getExpirationTime() {
		return expirationTime;
	}
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	
}
