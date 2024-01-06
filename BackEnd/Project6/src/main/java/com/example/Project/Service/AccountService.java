package com.example.Project.Service;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Account;
import com.example.Project.Entity.Customer;
import com.example.Project.Entity.Employee;
import com.example.Project.Entity.Line;
import com.example.Project.Entity.RequestSignUp;
import com.example.Project.Interface.Repository.IAccountRepository;
import com.example.Project.Interface.Repository.IBaseRepository;
import com.example.Project.Interface.Repository.ICustomerRepository;
import com.example.Project.Interface.Repository.IEmployeeRepository;
import com.example.Project.Interface.Service.IAccountService;
import com.example.Project.Security.AccountUserDetail;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Service
@Slf4j
public class AccountService implements UserDetailsService, IAccountService {
	@Autowired
	private IBaseRepository<Account> repo;
	@Autowired
	private IAccountRepository iAccountRepository;
	@Autowired
	private ICustomerRepository iCustomerRepository;
	@Autowired
	private IEmployeeRepository iEmployeeRepository;


	@Bean
	public PasswordEncoder passwordEncodern() {
		return new BCryptPasswordEncoder();
	}

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public UserDetails loadUserByUsername(String username) {
		try {
			Account account = repo.FindByField(Account.class, "UserName", username);
			return new AccountUserDetail(account);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void updateEmailVerificationStatus(String email) {
		try {
			Account account = getAccountByEmail(email);
			String accountId = account.getAccountId().toString();
			if (account != null) {
				account.setIsEmailVarified(1);
				iAccountRepository.save(account);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveAccount(Account account) {
		String encodedPassword = passwordEncodern().encode(account.getPassWord());
		account.setPassWord(encodedPassword);
		iAccountRepository.save(account);
	}

	@Override
	public String updatePassword(String email, String password) {
		try {
			Account account = getAccountByEmail(email);
			String encodePassword = passwordEncodern().encode(password);
			if (account != null) {
				account.setPassWord(encodePassword);
				iAccountRepository.save(account);
				return "recover-Password success";
			}
			return "not exist Account with this email";
		} catch (Exception e) {
			e.printStackTrace();
			return "Exist Error";
		}
	}

	@Override
	public Account getAccountByEmail(String email) {
		return repo.FindByField(Account.class, "Email", email);
	}
	
	public Account getAccountn(String accountid) {
		Account account=iAccountRepository.findById(UUID.fromString(accountid)).get();
		return account;
	}

//	public String SignUpCustomer(RequestSignUp requestSignUp) {
//		try {
//			Account account=requestSignUp.getAccount();
//			Customer customer=requestSignUp.getCustomer();
//			account.setGroupRole("CUSTOMER");
//			entityManager.persist(account);
//			entityManager.flush();
//			customer.setAccount(account);
//			iCustomerRepository.save(customer);
//			return "Sign Up User success";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//	public String SignUpEmployee(RequestSignUp requestSignUp){
//		try {
//			Account account=requestSignUp.getAccount();
//			Employee employee=requestSignUp.getEmployee();
//			account.setGroupRole("EMPLOYEE");
//			entityManager.persist(account);
//			entityManager.flush();
//			employee.setAccount(account);
//			iEmployeeRepository.save(employee);
//			return "Sign Up Employee success";
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
}
