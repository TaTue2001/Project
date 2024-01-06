package com.example.Project.Entity;

import com.google.cloud.storage.Acl.User;

public class RequestSignUp {
	public Account account;
	public Customer customer;
	public Employee employee;
	public RequestSignUp() {
	}
	public RequestSignUp(Account account, Customer customer) {
		super();
		this.account = account;
		this.customer = customer;
	}
	public RequestSignUp(Account account, Employee employee) {
		super();
		this.account = account;
		this.employee = employee;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
