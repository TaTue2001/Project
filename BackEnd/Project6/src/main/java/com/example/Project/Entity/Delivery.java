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
@Table(name="delivery")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Delivery {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID DeliveryId;
	private String DeliveryCode;
	private String DeliveryName;
	private String Describle;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Delivery() {
	}
	public Delivery(UUID deliveryId, String deliveryCode, String deliveryName, String describle, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy) {
		super();
		DeliveryId = deliveryId;
		DeliveryCode = deliveryCode;
		DeliveryName = deliveryName;
		Describle = describle;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getDeliveryId() {
		return DeliveryId;
	}
	public void setDeliveryId(UUID deliveryId) {
		DeliveryId = deliveryId;
	}
	public String getDeliveryCode() {
		return DeliveryCode;
	}
	public void setDeliveryCode(String deliveryCode) {
		DeliveryCode = deliveryCode;
	}
	public String getDeliveryName() {
		return DeliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		DeliveryName = deliveryName;
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
