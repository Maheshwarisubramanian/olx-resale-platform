package com.olx.resale.app.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "bill")
public class BillEntity {


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

	@Column(name = "company_gst_no")
	private String companyGstNo;

	@Column(name = "delivery_address")
	private String deliveryAddress;

	@Column(name = "order_date")
	private String orderDate;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "quantity")
	private Long quantity;

	@Column(name = "units")
	private String units;

	@Column(name = "product_price")
	private Double productPrice;

	@Column(name = "discount_price")
	private Double discountPrice;

	@Column(name = "delivery_price")
	private Double deliveryPrice;

	@Column(name = "taxable_amount")
	private Double taxableAmount;

	@Column(name = "gst_tax_slab")
	private Double gstTaxSlab;

	@Column(name = "gst_price")
	private Double gstPrice;

	@Column(name = "cgst")
	private Double cgst;

	@Column(name = "sgst")
	private Double sgst;

	@Column(name = "igst")
	private Double igst;

	@Column(name = "total_price")
	private Double totalPrice;     // totalPrice = ( taxable amount +gst price ) for every product

	@Column(name = "grand_total_amount")
	private Double grandTotalAmount;     // grandTotal = sum of all totalPrice of every product + delivery charge

	@Column(name = "status")
	private String status;

	public BillEntity() {
		super();

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

	public String getCompanyGstNo() {
		return companyGstNo;
	}

	public void setCompanyGstNo(String companyGstNo) {
		this.companyGstNo = companyGstNo;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public Double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(Double taxableAmount) {
		this.taxableAmount = taxableAmount;
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

	public Double getCgst() {
		return cgst;
	}

	public void setCgst(Double cgst) {
		this.cgst = cgst;
	}

	public Double getSgst() {
		return sgst;
	}

	public void setSgst(Double sgst) {
		this.sgst = sgst;
	}

	public Double getIgst() {
		return igst;
	}

	public void setIgst(Double igst) {
		this.igst = igst;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getGrandTotalAmount() {
		return grandTotalAmount;
	}

	public void setGrandTotalAmount(Double grandTotalAmount) {
		this.grandTotalAmount = grandTotalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BillEntity [id=" + id + ", customerId=" + customerId + ", customerName=" + customerName
				+ ", customerType=" + customerType + ", companyGstNo=" + companyGstNo + ", deliveryAddress=" + deliveryAddress
				+ ", orderDate=" + orderDate + ", companyName=" + companyName + ", productId=" + productId
				+ ", productName=" + productName + ", quantity=" + quantity + ", units=" + units + ", productPrice="
				+ productPrice + ", discountPrice=" + discountPrice + ", deliveryPrice=" + deliveryPrice
				+ ", taxableAmount=" + taxableAmount + ", gstTaxSlab=" + gstTaxSlab + ", gstPrice=" + gstPrice
				+ ", cgst=" + cgst + ", sgst=" + sgst + ", igst=" + igst + ", totalPrice=" + totalPrice
				+ ", grandTotalAmount=" + grandTotalAmount + ", status=" + status + "]";
	}











}
