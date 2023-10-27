package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Department {
	@Id
//	@Column(name = "DepartmentId")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	
	private UUID DepartmentId;
	private String DepartmentCode;
	private String DepartmentName;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Department() {
	}
	public Department(UUID departmentId, String departmentCode, String departmentName, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy) {
		super();
		DepartmentId = departmentId;
		DepartmentCode = departmentCode;
		DepartmentName = departmentName;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getDepartmentId() {
		return DepartmentId;
	}
	public void setDepartmentId(UUID departmentId) {
		DepartmentId = departmentId;
	}
	public String getDepartmentCode() {
		return DepartmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		DepartmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
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
		return "Department [DepartmentId=" + DepartmentId + ", DepartmentCode=" + DepartmentCode + ", DepartmentName="
				+ DepartmentName + ", CreateDate=" + CreateDate + ", CreateBy=" + CreateBy + ", ModifiedDate="
				+ ModifiedDate + ", ModifiedBy=" + ModifiedBy + "]";
	}
	
	
}
