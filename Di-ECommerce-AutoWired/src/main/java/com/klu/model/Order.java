package com.klu.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order {

    private int orderId;
    private String customerName;
    private int quantity;
    private Product product;

    public Order() {
        this.orderId = 2026;
        this.customerName = "Praneeth";
        this.quantity = 4;
    }

   
    @Autowired
    public void setProduct(Product product) {
        this.product = product;
    }

    public void display() {
        System.out.println("the following are the ordered product details");
        System.out.println("OrderId:" + orderId);
        System.out.println("CustomerName:" + customerName);
        System.out.println("Quantity:" + quantity);
        System.out.println("ProductId:" + product.getProductId());
        System.out.println("ProductName:" + product.getProductName());
        System.out.println("ProductPrice:" + product.getPrice());
        System.out.println("ProductCategory:" + product.getCategory());
    }
}
