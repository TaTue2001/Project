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
@Table(name="payment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Payment {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID PaymentId;
	private String PaymentCode;
	private String PaymentName;
	private String Describle;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Payment() {
	}
	public Payment(UUID paymentId, String paymentCode, String paymentName, String describle, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy) {
		super();
		PaymentId = paymentId;
		PaymentCode = paymentCode;
		PaymentName = paymentName;
		Describle = describle;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getPaymentId() {
		return PaymentId;
	}
	public void setPaymentId(UUID paymentId) {
		PaymentId = paymentId;
	}
	public String getPaymentCode() {
		return PaymentCode;
	}
	public void setPaymentCode(String paymentCode) {
		PaymentCode = paymentCode;
	}
	public String getPaymentName() {
		return PaymentName;
	}
	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
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

}
