package com.olx.resale.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transaction")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "customer_id")
	private Long customerId;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_type")
	private String customerType;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_price")
	private Double productPrice;

	@Column(name = "delivery_price")
	private Double deliveryPrice;

	@Column(name = "gst_tax_slab")
	private Double gstTaxSlab;

	@Column(name = "gst_price")
	private Double gstPrice;

	@Column(name = "taxable_amount")
	private Double taxableAmount;

	@Column(name = "total_price")
	private Double totalPrice;          //  totalPrice = ( taxable amount +gst price ) for every product

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "reference_number")
	private Double referenceNumber;

	@Column(name = "payment_date")
	private String paymentDate;

	@Column(name = "payment_time")
	private String paymentTime;

	@Column(name = "status")
	private String status;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "units")
	private String units;

	@Column(name = "discount_price")
	private Double discountPrice;

	@Column(name = "grand_total_amount")
	private Double grandTotalAmount;     // grandTotal = sum of all totalPrice of every product + delivery charge

	public TransactionEntity() {
		super();
	}

	public TransactionEntity(Long id, Long customerId, String customerName, String customerType, Long productId,
							 String productName, Double productPrice, Double deliveryPrice, Double gstTaxSlab, Double gstPrice,
							 Double taxableAmount, Double totalPrice, String paymentMode, Double referenceNumber, String paymentDate,
							 String paymentTime, String status, String deliveryAddress, Long quantity, String units,
							 Double discountPrice, Double grandTotalAmount) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerType = customerType;
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.deliveryPrice = deliveryPrice;
		this.gstTaxSlab = gstTaxSlab;
		this.gstPrice = gstPrice;
		this.taxableAmount = taxableAmount;
		this.totalPrice = totalPrice;
		this.paymentMode = paymentMode;
		this.referenceNumber = referenceNumber;
		this.paymentDate = paymentDate;
		this.paymentTime = paymentTime;
		this.status = status;
		this.deliveryAddress = deliveryAddress;
		this.quantity = quantity;
		this.units = units;
		this.discountPrice = discountPrice;
		this.grandTotalAmount = grandTotalAmount;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
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

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Double getGstTaxSlab() {
		return gstTaxSlab;
	}

	public void setGstTaxSlab(Double gstTaxSlab) {
		this.gstTaxSlab = gstTaxSlab;
	}

	public Double getGstPrice() {
		return gstPrice;
	}

	public void setGstPrice(Double gstPrice) {
		this.gstPrice = gstPrice;
	}

	public Double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(Double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Double referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(String paymentTime) {
		this.paymentTime = paymentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
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

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getGrandTotalAmount() {
		return grandTotalAmount;
	}

	public void setGrandTotalAmount(Double grandTotalAmount) {
		this.grandTotalAmount = grandTotalAmount;
	}

	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerType=" + customerType + ", productId=" + productId + ", productName=" + productName
				+ ", productPrice=" + productPrice + ", deliveryPrice=" + deliveryPrice + ", gstTaxSlab=" + gstTaxSlab
				+ ", gstPrice=" + gstPrice + ", taxableAmount=" + taxableAmount + ", totalPrice=" + totalPrice
				+ ", paymentMode=" + paymentMode + ", referenceNumber=" + referenceNumber + ", paymentDate="
				+ paymentDate + ", paymentTime=" + paymentTime + ", status=" + status + ", deliveryAddress="
				+ deliveryAddress + ", quantity=" + quantity + ", units=" + units + ", discountPrice=" + discountPrice
				+ ", grandTotalAmount=" + grandTotalAmount + "]";
	}



}
