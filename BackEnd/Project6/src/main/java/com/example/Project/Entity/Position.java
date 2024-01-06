package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="positions")
public class Position {
	@Id
	@GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID PositionId;
	private String PositionCode;
	private String PositionName;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Position() {
	}
	public Position(UUID positionId, String positionCode, String positionName, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy) {
		super();
		PositionId = positionId;
		PositionCode = positionCode;
		PositionName = positionName;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getPositionId() {
		return PositionId;
	}
	public void setPositionId(UUID positionId) {
		PositionId = positionId;
	}
	public String getPositionCode() {
		return PositionCode;
	}
	public void setPositionCode(String positionCode) {
		PositionCode = positionCode;
	}
	public String getPositionName() {
		return PositionName;
	}
	public void setPositionName(String positionName) {
		PositionName = positionName;
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
		return "Position [PositionId=" + PositionId + ", PositionCode=" + PositionCode + ", PositionName="
				+ PositionName + ", CreateDate=" + CreateDate + ", CreateBy=" + CreateBy + ", ModifiedDate="
				+ ModifiedDate + ", ModifiedBy=" + ModifiedBy + "]";
	}
	
	
	
}
