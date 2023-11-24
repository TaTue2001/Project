package com.example.Project.Auth;

import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
public class AuthenticationResponse {
	private String accessToken;
	private String refreshToken;
	private UserDetails userDetails;
	
	public AuthenticationResponse() {
	}

	public AuthenticationResponse(String accessToken, String refreshToken, UserDetails userDetails) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
		this.userDetails = userDetails;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "AuthenticationResponse [accessToken=" + accessToken + ", refreshToken=" + refreshToken
				+ ", userDetails=" + userDetails + "]";
	}

}
