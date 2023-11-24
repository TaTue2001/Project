package com.example.Project.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Project.Entity.Account;
import com.example.Project.Interface.Repository.IBaseRepository;
import com.example.Project.Interface.Service.IAccountService;
import com.example.Project.Security.AccountUserDetail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Service
@Slf4j
public class AccountService implements UserDetailsService{
	@Autowired
	private IBaseRepository<Account> Repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<Account> listAccount = Repo.Active(Account.class, "UserName", username, 1, 1);
//		UUID id = UUID.fromString("de41fce6-de91-446f-b6c8-adca79190a02");
//		Date date = null;
//		Account account1 = new Account(id, "taxuantue", "tue123", "customer",date, null,date, null);
//		Account account2 = new Account(id, "IndexOutLength", "IndexOutLength", "IndexOutLength", date, null, date, null);
		Account account=null;
		if (listAccount == null) {
			throw new UsernameNotFoundException(username);
		} else {
			account = listAccount.get(0);
			return new AccountUserDetail(account);
		}	
	}

}
