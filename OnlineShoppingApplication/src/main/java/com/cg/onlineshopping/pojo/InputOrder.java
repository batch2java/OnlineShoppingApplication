package com.cg.onlineshopping.pojo;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class InputOrder {
	private Integer orderId;
	@NotEmpty(message= "orderStatus can not be null")
	private String orderStatus;
	//@ApiModelProperty(required = true, dataType="date")  
	//@JsonFormat(pattern = DATE_FORMAT)   
	@JsonFormat(pattern = "yyyy-MM-dd")
	//@NotEmpty(message= "orderDate can not be null")
	private LocalDate orderDate;
	private Integer addressId;
	private Integer customerId;
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
}
	