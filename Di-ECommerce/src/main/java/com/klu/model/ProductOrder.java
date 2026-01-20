package com.klu.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductOrder {

	private int orderId;
	private String customerName;
	private String productName;
	private int quantity;

	public ProductOrder(
			@Value("102") int orderId,
			@Value("Anjan") String customerName) {
		this.orderId = orderId;
		this.customerName = customerName;
	}

	@Value("Mouse")
	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Value("5")
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void display() {
		System.out.println("Following is the Order Details");
		System.out.println("OrderId: " + orderId);
		System.out.println("CustomerName: " + customerName);
		System.out.println("ProductName: " + productName);
		System.out.println("Quantity ordered: " + quantity);
	}
}
