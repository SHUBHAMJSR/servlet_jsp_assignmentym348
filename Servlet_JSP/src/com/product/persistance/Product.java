package com.product.persistance;

import java.sql.Date;

public class Product {
	private int id;
	private String productName;
	private Double productPrice;
	private int productQty; 
	private Date manufacturedDate, inspectedDate;
	
	
	public Product() {
	}


	public Product(int id, String productName, Double productPrice, int productQty, Date manufacturedDate,
			Date inspectedDate) {
		this.id = id;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.manufacturedDate = manufacturedDate;
		this.inspectedDate = inspectedDate;
	}


	public Product(String productName, Double productPrice, int productQty, Date manufacturedDate, Date inspectedDate) {
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQty = productQty;
		this.manufacturedDate = manufacturedDate;
		this.inspectedDate = inspectedDate;
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", productPrice=");
		builder.append(productPrice);
		builder.append(", productQty=");
		builder.append(productQty);
		builder.append(", manufacturedDate=");
		builder.append(manufacturedDate);
		builder.append(", inspectedDate=");
		builder.append(inspectedDate);
		builder.append("]");
		return builder.toString();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	public int getProductQty() {
		return productQty;
	}


	public void setProductQty(int productQty) {
		this.productQty = productQty;
	}


	public Date getManufacturedDate() {
		return manufacturedDate;
	}


	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}


	public Date getInspectedDate() {
		return inspectedDate;
	}


	public void setInspectedDate(Date inspectedDate) {
		this.inspectedDate = inspectedDate;
	}
	
	
	
	
}
