package com.inventory.search.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 8513022721736610456L;
	@Id
	@Column(name = "product_id")
	private int productId;
	@Column(name = "product_category")
	private String productCategory;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_quantity")
	private long productQuantity;
	@Column(name = "product_price")
	private double productPrice;
	@Column(name = "product_brand")
	private String productBrand;
	@Column(name = "product_type")
	private String productType;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductBrand() {
		return productBrand;
	}
	public void setProductBrand(String productBrand) {
		this.productBrand = productBrand;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productCategory=" + productCategory + ", productName="
				+ productName + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice
				+ ", productBrand=" + productBrand + ", productType=" + productType + "]";
	}
}
