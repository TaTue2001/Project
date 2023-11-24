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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString
public class Customer {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID CustomerId;
	private String CustomerCode;
	private String FullName;
	private Date DateOfBirth;
	private int Gender=0;
	private String PhoneNumber;
	private String IdentifyNumber;
	@JoinColumn(name = "RankId", referencedColumnName = "RankId")
	private UUID RankId;
	@OneToOne
	@JoinColumn(name = "AccountId")
	private Account account;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Customer() {
		super();
	}
	public Customer(UUID customerId, String customerCode, String fullName, Date dateOfBirth, int gender,
			String phoneNumber, String identifyNumber, UUID rankId, Account account, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy) {
		super();
		CustomerId = customerId;
		CustomerCode = customerCode;
		FullName = fullName;
		DateOfBirth = dateOfBirth;
		Gender = gender;
		PhoneNumber = phoneNumber;
		IdentifyNumber = identifyNumber;
		RankId = rankId;
		this.account = account;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(UUID customerId) {
		CustomerId = customerId;
	}
	public String getCustomerCode() {
		return CustomerCode;
	}
	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
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
	public UUID getRankId() {
		return RankId;
	}
	public void setRankId(UUID rankId) {
		RankId = rankId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
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
		return "Customer [CustomerId=" + CustomerId + ", CustomerCode=" + CustomerCode + ", FullName=" + FullName
				+ ", DateOfBirth=" + DateOfBirth + ", Gender=" + Gender + ", PhoneNumber=" + PhoneNumber
				+ ", IdentifyNumber=" + IdentifyNumber + ", RankId=" + RankId + ", account=" + account + ", CreateDate="
				+ CreateDate + ", CreateBy=" + CreateBy + ", ModifiedDate=" + ModifiedDate + ", ModifiedBy="
				+ ModifiedBy + "]";
	}
	
}
