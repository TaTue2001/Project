package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "Employee")
public class Employee {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID EmployeeId;
	private String EmployeeCode;
	private String FullName;
	private Date DateOfBirth;
	private int Gender=0;
	private String PhoneNumber;
	private String IdentifyNumber;
	private Date IdentifyDate;
	private String IdentifyPlace;
	private String Address;
	private String Email;
	private String TaxCode;
	private double Salary=0.0;
	private Date JoinDate;
	private int WorkStatus=0;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	@JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId")
	private UUID DepartmentId;
	@JoinColumn(name = "PositionId", referencedColumnName = "PositionId")
	private UUID PositionId;
	@OneToOne
	@JoinColumn(name = "AccountId")
	private Account account;
	public Employee() {
	}
	
	public Employee(UUID employeeId, String employeeCode, String fullName, Date dateOfBirth, int gender,
			String phoneNumber, String identifyNumber, Date identifyDate, String identifyPlace, String address,
			String email, String taxCode, double salary, Date joinDate, int workStatus, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy, UUID departmentId, UUID positionId,
			Account account) {
		super();
		EmployeeId = employeeId;
		EmployeeCode = employeeCode;
		FullName = fullName;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		PhoneNumber = phoneNumber;
		IdentifyNumber = identifyNumber;
		IdentifyDate = identifyDate;
		IdentifyPlace = identifyPlace;
		Address = address;
		Email = email;
		TaxCode = taxCode;
		Salary = salary;
		JoinDate = joinDate;
		WorkStatus = workStatus;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		DepartmentId = departmentId;
		PositionId = positionId;
		this.account = account;
	}
	public UUID getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(UUID employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeCode() {
		return EmployeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		EmployeeCode = employeeCode;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public Date getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public int getGender() {
		return Gender;
	}
	public void setGender(int gender) {
		Gender = gender;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getIdentifyNumber() {
		return IdentifyNumber;
	}
	public void setIdentifyNumber(String identifyNumber) {
		IdentifyNumber = identifyNumber;
	}
	public Date getIdentifyDate() {
		return IdentifyDate;
	}
	public void setIdentifyDate(Date identifyDate) {
		IdentifyDate = identifyDate;
	}
	public String getIdentifyPlace() {
		return IdentifyPlace;
	}
	public void setIdentifyPlace(String identifyPlace) {
		IdentifyPlace = identifyPlace;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getTaxCode() {
		return TaxCode;
	}
	public void setTaxCode(String taxCode) {
		TaxCode = taxCode;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	public Date getJoinDate() {
		return JoinDate;
	}
	public void setJoinDate(Date joinDate) {
		JoinDate = joinDate;
	}
	public int getWorkStatus() {
		return WorkStatus;
	}
	public void setWorkStatus(int workStatus) {
		WorkStatus = workStatus;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	public UUID getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(UUID departmentId) {
		DepartmentId = departmentId;
	}
	public UUID getPositionId() {
		return PositionId;
	}
	public void setPositionId(UUID positionId) {
		PositionId = positionId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + EmployeeId + ", EmployeeCode=" + EmployeeCode + ", FullName=" + FullName
				+ ", DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", PhoneNumber=" + PhoneNumber
				+ ", IdentifyNumber=" + IdentifyNumber + ", IdentifyDate=" + IdentifyDate + ", IdentifyPlace="
				+ IdentifyPlace + ", Address=" + Address + ", Email=" + Email + ", TaxCode=" + TaxCode + ", Salary="
				+ Salary + ", JoinDate=" + JoinDate + ", WorkStatus=" + WorkStatus + ", CreateDate=" + CreateDate
				+ ", CreateBy=" + CreateBy + ", ModifiedDate=" + ModifiedDate + ", ModifiedBy=" + ModifiedBy
				+ ", DepartmentId=" + DepartmentId + ", PositionId=" + PositionId + ", account=" + account + "]";
	}
	
}

