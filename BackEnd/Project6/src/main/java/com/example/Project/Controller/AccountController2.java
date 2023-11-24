package com.example.Project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController2 {
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/listAC")
	public ResponseEntity<UserDetails> getAc(@RequestParam String username){
		UserDetails us=userDetailsService.loadUserByUsername(username);
		String rp="hello";
		return ResponseEntity.ok(us);
	}
}
