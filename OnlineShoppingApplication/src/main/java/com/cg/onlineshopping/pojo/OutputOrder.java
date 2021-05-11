package com.cg.onlineshopping.pojo;

import java.util.HashMap;
import java.util.Map;

public class OutputOrder {
	private Integer orderId;
	private Integer addressId;
	private Integer customerId;
	private Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public Integer getAddressId() {
		return addressId;
	}
	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Map<Integer, Integer> getMap() {
		return map;
	}
	public void setMap(Map<Integer, Integer> map) {
		this.map = map;
	}


}
