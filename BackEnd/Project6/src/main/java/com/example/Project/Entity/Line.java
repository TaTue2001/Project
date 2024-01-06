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
@Table(name="line")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Line {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "org.hibernate.type.UUIDCharType")
	private UUID LineId;
	private String LineCode;
	@OneToOne
	@JoinColumn(name = "AccountId")
	private Account account;
	@Transient
	private String Username;
	@Transient
	private UUID AccountId;
	@OneToOne
	@JoinColumn(name = "ProductId")
	private Product product;
	@Transient
	private String ProductName;
	@Transient
	private UUID ProductId;
	@ManyToOne
	@JoinColumn(name = "OrderId")
	private Order order;
	@Transient
	private UUID OrderId;
	private int Quantity;
	private long TotalPrice=0;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	private int isComplete;
	public Line() {
	}
	public Line(UUID lineId, String lineCode, Account account,UUID accountId, String username, Product product, String productName,UUID productId,
			Order order, UUID orderId, int quantity, long totalPrice, Date createDate, String createBy,
			Date modifiedDate, String modifiedBy, int isComplete) {
		super();
		LineId = lineId;
		LineCode = lineCode;
		this.account = account;
		Username = username;
		this.product = product;
		ProductName = productName;
		this.order = order;
		OrderId = orderId;
		Quantity = quantity;
		TotalPrice = totalPrice;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		this.isComplete = isComplete;
		ProductId=productId;
		AccountId=accountId;
	}
	public UUID getLineId() {
		return LineId;
	}
	public void setLineId(UUID lineId) {
		LineId = lineId;
	}
	public String getLineCode() {
		return LineCode;
	}
	public void setLineCode(String lineCode) {
		LineCode = lineCode;
	}
	public String getUsername() {
		return (account != null) ?	account.getUserName() : Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	public UUID getAccountId() {
		return (account != null) ? account.getAccountId() : AccountId;
	}
	public void setAccountId(UUID accountId) {
		AccountId = accountId;
	}
	public String getProductName() {
		return (product != null) ? product.getProductName() : ProductName;
	}
	public UUID getProductId() {
		return (product != null) ? product.getProductId() : ProductId;
	}
	public void setProductId(UUID productId) {
		ProductId = productId;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public UUID getOrderId() {
		return (order != null) ? order.getOrderId() : OrderId;
	}
	public void setOrderId(UUID orderId) {
		OrderId = orderId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public long getTotalPrice() {
		return (product.getPriceSale()*Quantity);
	}
	public void setTotalPrice(long totalPrice) {
		TotalPrice = totalPrice;
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
	public int getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

}
