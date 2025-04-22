package com.olx.resale.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "product")
public class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Product Name is mandatory")
	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private Double productPrice;

	@NotBlank(message = "Product Location is mandatory")
	@Column(name = "product_location")
	private String productLocation;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "status")
	private String status;
	
	@Column(name = "mfg_date")
	private Date mfgDate;
	
	@Column(name = "expiry_date")
	private Date expiryDate;
	
	@Column(name = "posting_date")
	private Date postingDate;

	@NotBlank(message = "Owner is mandatory")
	@Column(name = "owner")
	private String owner;

	@NotBlank(message = "Description is mandatory")
	@Column(name = "description")
	private String description;

	@Column(name = "color")
	private String color;

	@NotBlank(message = "Category is mandatory")
	@Column(name = "category")
	private String category;

	@NotBlank(message = "Sub Category is mandatory")
	@Column(name = "subcategory")
	private String subcategory;

	@Column(name = "discount_price")
	private Double discountPrice;

	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@Column(name = "customer_type")
	private String customerType;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "units")
	private String units;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, @NotBlank(message = "Product Name is mandatory") String productName, Double productPrice,
			@NotBlank(message = "Product Location is mandatory") String productLocation, Double latitude,
			Double longitude, String status, Date mfgDate, Date expiryDate, Date postingDate,
			@NotBlank(message = "Owner is mandatory") String owner,
			@NotBlank(message = "Description is mandatory") String description, String color,
			@NotBlank(message = "Category is mandatory") String category,
			@NotBlank(message = "Sub Category is mandatory") String subcategory, Double discountPrice, Long customerId,
			String customerName, String customerType, Long quantity, String units) {
		super();
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productLocation = productLocation;
		this.latitude = latitude;
		this.longitude = longitude;
		this.status = status;
		this.mfgDate = mfgDate;
		this.expiryDate = expiryDate;
		this.postingDate = postingDate;
		this.owner = owner;
		this.description = description;
		this.color = color;
		this.category = category;
		this.subcategory = subcategory;
		this.discountPrice = discountPrice;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerType = customerType;
		this.quantity = quantity;
		this.units = units;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductLocation() {
		return productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getMfgDate() {
		return mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Date getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(Date postingDate) {
		this.postingDate = postingDate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productLocation=" + productLocation + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", status=" + status + ", mfgDate=" + mfgDate + ", expiryDate=" + expiryDate + ", postingDate="
				+ postingDate + ", owner=" + owner + ", description=" + description + ", color=" + color + ", category="
				+ category + ", subcategory=" + subcategory + ", discountPrice=" + discountPrice + ", customerId="
				+ customerId + ", customerName=" + customerName + ", customerType=" + customerType + ", quantity="
				+ quantity + ", units=" + units + "]";
	}

	

	
	
}
