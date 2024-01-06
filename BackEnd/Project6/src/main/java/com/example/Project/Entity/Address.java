package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@NoArgsConstructor
public class Address {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID AddressId;
	@ManyToOne
	@JoinColumn(name = "AccountId")
	private Account account;
	@Transient
	private String Username;
	private String Particular;
	private String Wards;
	private String District;
	private String Province;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Address() {
	}
	public Address(UUID addressId, Account account,String username, String particular, String wards, String district, String province,
			Date createDate, String createBy, Date modifiedDate, String modifiedBy) {
		super();
		AddressId = addressId;
		this.account = account;
		Username=username;
		Particular = particular;
		Wards = wards;
		District = district;
		Province = province;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getAddressId() {
		return AddressId;
	}
	public void setAddressId(UUID addressId) {
		AddressId = addressId;
	}
//	public Account getAccount() {
//		return account;
//	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getUsername() {
		return (account!=null) ? account.getUserName() :Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getParticular() {
		return Particular;
	}
	public void setParticular(String particular) {
		Particular = particular;
	}
	public String getWards() {
		return Wards;
	}
	public void setWards(String wards) {
		Wards = wards;
	}
	public String getDistrict() {
		return District;
	}
	public void setDistrict(String district) {
		District = district;
	}
	public String getProvince() {
		return Province;
	}
	public void setProvince(String province) {
		Province = province;
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
