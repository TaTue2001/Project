package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="conditions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Condition {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID ConditionId;
	private String ConditionCode;
	private String ConditionName;
	private String Describle;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Condition() {
	}
	public Condition(UUID conditionId, String conditionCode, String conditionName, String describle, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy) {
		super();
		ConditionId = conditionId;
		ConditionCode = conditionCode;
		ConditionName = conditionName;
		Describle = describle;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getConditionId() {
		return ConditionId;
	}
	public void setConditionId(UUID conditionId) {
		ConditionId = conditionId;
	}
	public String getConditionCode() {
		return ConditionCode;
	}
	public void setConditionCode(String conditionCode) {
		ConditionCode = conditionCode;
	}
	public String getConditionName() {
		return ConditionName;
	}
	public void setConditionName(String conditionName) {
		ConditionName = conditionName;
	}
	public String getDescrible() {
		return Describle;
	}
	public void setDescrible(String describle) {
		Describle = describle;
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
		return "Condition [ConditionId=" + ConditionId + ", ConditionCode=" + ConditionCode + ", ConditionName="
				+ ConditionName + ", Describle=" + Describle + ", CreateDate=" + CreateDate + ", CreateBy=" + CreateBy
				+ ", ModifiedDate=" + ModifiedDate + ", ModifiedBy=" + ModifiedBy + "]";
	}
	
}
