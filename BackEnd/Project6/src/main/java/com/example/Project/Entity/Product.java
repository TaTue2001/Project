package com.example.Project.Entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

	@Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Type(type = "org.hibernate.type.UUIDCharType")
	private UUID ProductId;
	private String ProductCode;
	private String ProductName;
	private String Trademake;
	@ManyToOne()
	@JoinColumn(name="CategoryId")
	private Category category;
	@Transient
	private String CategoryName;
	private String Describle;
	private String Color;
	private String Specifications;
	private String Origin;
	private String Version;
	private String ConditionOfProduct;
	private String Size;
	private String Guarantee;
	private Long Price;
	private Long PriceSale;
	private Date CreateDate;
	private String CreateBy;
	private Date ModifiedDate;
	private String ModifiedBy;
	private int Inventory;
	public Product() {
	}
	public Product(UUID productId, String productCode, String productName, String trademake, Category category,
			String categoryName, String describle, String color, String specifications, String origin, String version,
			String conditionOfProduct, String size, String guarantee, Long price, Long priceSale, Date createDate,
			String createBy, Date modifiedDate, String modifiedBy, int inventory) {
		super();
		ProductId = productId;
		ProductCode = productCode;
		ProductName = productName;
		Trademake = trademake;
		this.category = category;
		CategoryName = categoryName;
		Describle = describle;
		Color = color;
		Specifications = specifications;
		Origin = origin;
		Version = version;
		ConditionOfProduct = conditionOfProduct;
		Size = size;
		Guarantee = guarantee;
		Price = price;
		PriceSale = priceSale;
		CreateDate = createDate;
		CreateBy = createBy;
		ModifiedDate = modifiedDate;
		ModifiedBy = modifiedBy;
		Inventory=inventory;
	}
	public UUID getProductId() {
		return ProductId;
	}
	public void setProductId(UUID productId) {
		ProductId = productId;
	}
	public String getProductCode() {
		return ProductCode;
	}
	public void setProductCode(String productCode) {
		ProductCode = productCode;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getTrademake() {
		return Trademake;
	}
	public void setTrademake(String trademake) {
		Trademake = trademake;
	}
	public String getCategoryName() {
		return (category != null) ? category.getCategoryName() : CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getDescrible() {
		return Describle;
	}
	public void setDescrible(String describle) {
		Describle = describle;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getSpecifications() {
		return Specifications;
	}
	public void setSpecifications(String specifications) {
		Specifications = specifications;
	}
	public String getOrigin() {
		return Origin;
	}
	public void setOrigin(String origin) {
		Origin = origin;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getConditionOfProduct() {
		return ConditionOfProduct;
	}
	public void setConditionOfProduct(String conditionOfProduct) {
		ConditionOfProduct = conditionOfProduct;
	}
	public String getSize() {
		return Size;
	}
	public void setSize(String size) {
		Size = size;
	}
	public String getGuarantee() {
		return Guarantee;
	}
	public void setGuarantee(String guarantee) {
		Guarantee = guarantee;
	}
	public Long getPrice() {
		return Price;
	}
	public void setPrice(Long price) {
		Price = price;
	}
	public Long getPriceSale() {
		return PriceSale;
	}
	public void setPriceSale(Long priceSale) {
		PriceSale = priceSale;
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
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getInventory() {
		return Inventory;
	}
	public void setInventory(int inventory) {
		Inventory = inventory;
	}
	
}
