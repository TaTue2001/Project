package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	private Date IdentifyDate;
	private String IdentifyPlace;
	private String Address;
	private String TaxCode;
	private double Salary=0.0;
	private Date JoinDate;
	private int WorkStatus=0;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	@ManyToOne
	@JoinColumn(name = "DepartmentId", referencedColumnName = "DepartmentId")
	private Department department;
	@ManyToOne
	@JoinColumn(name = "PositionId", referencedColumnName = "PositionId")
	private Position position;
	@OneToOne
	@JoinColumn(name = "AccountId")
	private Account account;
	@Transient
	private String UserName;
	public Employee() {
	}

	public Employee(UUID employeeId, String employeeCode, Date identifyDate, String identifyPlace, String address,
			String taxCode, double salary, Date joinDate, int workStatus, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy, Department department, Position position, Account account,
			String userName) {
		super();
		EmployeeId = employeeId;
		EmployeeCode = employeeCode;
		IdentifyDate = identifyDate;
		IdentifyPlace = identifyPlace;
		Address = address;
		TaxCode = taxCode;
		Salary = salary;
		JoinDate = joinDate;
		WorkStatus = workStatus;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		this.department = department;
		this.position = position;
		this.account = account;
		UserName = userName;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getUserName() {
		return (account!= null) ? account.getUserName() : UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
	
}

