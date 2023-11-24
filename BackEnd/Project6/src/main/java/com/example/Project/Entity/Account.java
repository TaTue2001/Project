package com.example.Project.Entity;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
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
	private String GroupRole;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	
	public Account() {
	}

	public Account(UUID accountId, String userName, String passWord, String groupRole, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy) {
		super();
		AccountId = accountId;
		UserName = userName;
		PassWord = passWord;
		GroupRole = groupRole;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
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

	public String getGroupRole() {
		return GroupRole;
	}

	public void setGroupRole(String groupRole) {
		GroupRole = groupRole;
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

	@Override
	public String toString() {
		return "Account [AccountId=" + AccountId + ", UserName=" + UserName + ", PassWord=" + PassWord + ", GroupRole="
				+ GroupRole + ", CreateDate=" + CreateDate + ", CreateBy=" + CreateBy + ", ModifiedDate=" + ModifiedDate
				+ ", ModifiedBy=" + ModifiedBy + "]";
	}
	
}
