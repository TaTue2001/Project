package com.example.Project.Interface.Service;

import org.springframework.security.core.userdetails.UserDetails;

public interface IAccountService {
	UserDetails loadUserById(String accountId);
}
