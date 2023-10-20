package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Person {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	protected UUID PsId;
	protected String PsCode;
	protected String PsFullName;
	protected Date PsDateOfBirth;
	protected int PsGender;
	protected String PsPhoneNumber;
	protected String PsAddress;

	public Person() {
	}

	public Person(UUID psId, String psCode, String psFullName, Date psDateOfBirth, int psGender, String psPhoneNumber,
			String psAddress) {
		super();
		PsId = psId;
		PsCode = psCode;
		PsFullName = psFullName;
		PsDateOfBirth = psDateOfBirth;
		PsGender = psGender;
		PsPhoneNumber = psPhoneNumber;
		PsAddress = psAddress;
	}

	public UUID getPsId() {
		return PsId;
	}

	public void setPsId(UUID psId) {
		PsId = psId;
	}

	public String getPsCode() {
		return PsCode;
	}

	public void setPsCode(String psCode) {
		PsCode = psCode;
	}

	public String getPsFullName() {
		return PsFullName;
	}

	public void setPsFullName(String psFullName) {
		PsFullName = psFullName;
	}

	public Date getPsDateOfBirth() {
		return PsDateOfBirth;
	}

	public void setPsDateOfBirth(Date psDateOfBirth) {
		PsDateOfBirth = psDateOfBirth;
	}

	public int getPsGender() {
		return PsGender;
	}

	public void setPsGender(int psGender) {
		PsGender = psGender;
	}

	public String getPsPhoneNumber() {
		return PsPhoneNumber;
	}

	public void setPsPhoneNumber(String psPhoneNumber) {
		PsPhoneNumber = psPhoneNumber;
	}

	public String getPsAddress() {
		return PsAddress;
	}

	public void setPsAddress(String psAddress) {
		PsAddress = psAddress;
	}

	@Override
	public String toString() {
		return "Person [PsId=" + PsId + ", PsCode=" + PsCode + ", PsFullName=" + PsFullName + ", PsDateOfBirth="
				+ PsDateOfBirth + ", PsGender=" + PsGender + ", PsPhoneNumber=" + PsPhoneNumber + ", PsAddress="
				+ PsAddress + "]";
	}
	
}
