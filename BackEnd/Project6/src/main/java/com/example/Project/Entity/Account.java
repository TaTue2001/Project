package com.example.Project.Entity;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Entity
@Table(name = "Account")
public class Account {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID AccountId;
	private String UserName;
	private String PassWord;	
//	private String GroupRole;
	private String Email;
	private String FullName;
	private Date DateOfBirth;
	private int Gender=0;
	private String PhoneNumber;
	private String IdentifyNumber;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	private int isEmailVarified=0;
	@ManyToMany
	@JoinTable(name="users_role", 
	joinColumns=@JoinColumn(name="AccountId"), 
	inverseJoinColumns=@JoinColumn	(name="RoleId"))
	private Set<Role> Roles=new HashSet<>();
	
	public Account() {
	}
//String groupRole
	public Account(UUID accountId, String userName, String passWord , String email, String fullName,
			Date dateOfBirth, int gender, String phoneNumber, String identifyNumber, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy, int isEmailVarified,Set<Role> roles) {
		super();
		AccountId = accountId;
		UserName = userName;
		PassWord = passWord;
//		GroupRole = groupRole;
		Email = email;
		FullName = fullName;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		PhoneNumber = phoneNumber;	
		IdentifyNumber = identifyNumber;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		this.isEmailVarified = isEmailVarified;
		Roles=roles;
	}
	
	public Set<Role> getRoles() {
		return Roles;
	}
	public void setRoles(Set<Role> roles) {
		Roles = roles;
	}
	public UUID getAccountId() {
		return AccountId;
	}

	public void setAccountId(UUID accountId) {
		AccountId = accountId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassWord() {
		return PassWord;
	}

	public void setPassWord(String passWord) {
		PassWord = passWord;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
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

	public int getIsEmailVarified() {
		return isEmailVarified;
	}

	public void setIsEmailVarified(int isEmailVarified) {
		this.isEmailVarified = isEmailVarified;
	}

}
