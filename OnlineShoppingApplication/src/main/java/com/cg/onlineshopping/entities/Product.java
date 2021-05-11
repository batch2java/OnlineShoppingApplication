package com.cg.onlineshopping.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Product {
@Id	
@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
@SequenceGenerator(sequenceName = "product_seq", allocationSize = 1, name = "product_seq")
private Integer productId;
private String productName;

private double price;
private String color;
private String dimension;
private String specification;
private String manufacturer;
private int quantity;
@ManyToOne(cascade = CascadeType.ALL)
private Category category;
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getDimension() {
	return dimension;
}
public void setDimension(String dimension) {
	this.dimension = dimension;
}
public String getSpecification() {
	return specification;
}
public void setSpecification(String specification) {
	this.specification = specification;
}
public String getManufacturer() {
	return manufacturer;
}
public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Category getCategory() {
	return category;
}
public void setCategory(Category category) {
	this.category = category;
}


}
