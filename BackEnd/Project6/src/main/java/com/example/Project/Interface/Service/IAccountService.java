package com.example.Project.Interface.Service;

import org.springframework.stereotype.Repository;

import com.example.Project.Entity.Account;
import com.example.Project.Entity.RequestSignUp;
@Repository
public interface IAccountService {
	void updateEmailVerificationStatus(String email);
	Account getAccountByEmail(String email);
	String updatePassword(String email, String password);
	void saveAccount(Account account);
//	String SignUpCustomer(RequestSignUp requestSignUp);
//	String SignUpEmployee(RequestSignUp requestSignUp);
}
