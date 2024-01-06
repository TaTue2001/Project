package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "Customer")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID CustomerId;
	private String CustomerCode;
	@JoinColumn(name = "RankId", referencedColumnName = "RankId")
	private UUID RankId;
	@OneToOne
	@JoinColumn(name = "AccountId")
	private Account account;
	@Transient
	private String UserName;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Customer() {
		super();
	}
	public Customer(UUID customerId, String customerCode, UUID rankId, Account account, String userName,
			Date createDate, String createBy, Date modifiedDate, String modifiedBy) {
		super();
		CustomerId = customerId;
		CustomerCode = customerCode;
		RankId = rankId;
		this.account = account;
		UserName = userName;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
//	public UUID getCustomerId() {
//		return CustomerId;
//	}
	public void setCustomerId(UUID customerId) {
		CustomerId = customerId;
	}
	public String getCustomerCode() {
		return CustomerCode;
	}
	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}
	public UUID getRankId() {
		return RankId;
	}
	public void setRankId(UUID rankId) {
		RankId = rankId;
	}
//	public Account getAccount() {
//		return account;
//	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getUserName() {
		return (account!= null) ? account.getUserName() : UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
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
	

}
