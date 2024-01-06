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
import lombok.ToString;

@Entity
@Table(name="rate")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Rate {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID RateId;
	private String RateCode;
	private int Scores;
	private String Describle;
	@OneToOne
	@JoinColumn(name="LineId")
	private Line line;
	@Transient
	private UUID LineId;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Rate() {
	}
	public Rate(UUID rateId, String rateCode, int scores, String describle, Line line,UUID lineId, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy) {
		super();
		RateId = rateId;
		RateCode = rateCode;
		Scores = scores;
		Describle = describle;
		this.line = line;
		LineId=lineId;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getRateId() {
		return RateId;
	}
	public void setRateId(UUID rateId) {
		RateId = rateId;
	}
	public String getRateCode() {
		return RateCode;
	}
	public void setRateCode(String rateCode) {
		RateCode = rateCode;
	}
	public int getScores() {
		return Scores;
	}
	public void setScores(int scores) {
		Scores = scores;
	}
	public String getDescrible() {
		return Describle;
	}
	public void setDescrible(String describle) {
		Describle = describle;
	}
	public void setLine(Line line) {
		this.line = line;
	}
	public UUID getLineId() {
		return (line!=null)? line.getLineId():LineId;
	}
	public void setLineId(UUID lineId) {
		LineId = lineId;
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
