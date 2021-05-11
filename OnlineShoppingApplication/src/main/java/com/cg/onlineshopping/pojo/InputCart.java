package com.cg.onlineshopping.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class InputCart {
	@NotNull(message =" quantity should not be empty")
	@Min(value=1,message="Quantity should be greater than zero")
	private int quantity;
	 private Integer customerId;
	 private Integer cartId;
	 private Integer productId;
	
	 public Integer getCartId() {
		return cartId;
	}
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	 public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
