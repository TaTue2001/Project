package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID OrderId;
	private String OrderCode;
	private Date OrderDate;
	@ManyToOne
	@JoinColumn(name="ConditionId")
	private Condition condition;
	@Transient
	private String ConditrionName;
	@ManyToOne
	@JoinColumn(name="PaymentId")
	private Payment payment;
	@Transient
	private String PaymentName;
	@OneToOne
	@JoinColumn(name="AddressId")
	private Address address;
	@Transient
	private UUID AddressId;
	@Transient
	private String AddressParticular;
	@OneToOne
	@JoinColumn(name="DeliveryId")
	private Delivery delivery;
	@Transient 
	private String DeliveryName;
	private Long TotalOfOrder;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	public Order() {
	}
	public Order(UUID orderId, String orderCode, Date orderDate, Condition condition, String conditrionName,
			Payment payment, String paymentName, Address address, UUID addressId, String addressParticular,
			Delivery delivery, String deliveryName, Long totalOfOrder, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy) {
		super();
		OrderId = orderId;
		OrderCode = orderCode;
		OrderDate = orderDate;
		this.condition = condition;
		ConditrionName = conditrionName;
		this.payment = payment;
		PaymentName = paymentName;
		this.address = address;
		AddressId = addressId;
		AddressParticular = addressParticular;
		this.delivery = delivery;
		DeliveryName = deliveryName;
		TotalOfOrder = totalOfOrder;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
	}
	public UUID getOrderId() {
		return OrderId;
	}
	public void setOrderId(UUID orderId) {
		OrderId = orderId;
	}
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public Date getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(Date orderDate) {
		OrderDate = orderDate;
	}
	public String getConditrionName() {
		return (condition != null)? condition.getConditionName() :ConditrionName; 
	}
	public void setConditrionName(String conditrionName) {
		ConditrionName = conditrionName;
	}
	public String getPaymentName() {
		return (payment!= null)? payment.getPaymentName() :PaymentName;
	}
	public void setPaymentName(String paymentName) {
		PaymentName = paymentName;
	}
	public UUID getAddressId() {
		return (address!=null)?address.getAddressId():AddressId;
	}
	public void setAddressId(UUID addressId) {
		AddressId = addressId;
	}
	public String getAddressParticular() {
		return (address!= null)? (address.getParticular()+", "+address.getWards()+", "+address.getDistrict()+", "+address.getProvince()):null;
	}
	public void setAddressParticular(String addressParticular) {
		AddressParticular = addressParticular;
	}
	public String getDeliveryName() {
		return (delivery!= null)? delivery.getDeliveryName() :DeliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		DeliveryName = deliveryName;
	}
	public Long getTotalOfOrder() {
		return TotalOfOrder;
	}
	public void setTotalOfOrder(Long totalOfOrder) {
		TotalOfOrder = totalOfOrder;
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
	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

}
