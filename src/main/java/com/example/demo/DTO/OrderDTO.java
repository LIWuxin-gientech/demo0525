package com.example.demo.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderDTO {

    private Long orderId;
    private String orderNo;
    private LocalDate orderDate;
    private String status;
    private String customerName;
    private String customerType;
    private String productName;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal amount;

    public OrderDTO() {
    }

    public OrderDTO(Long orderId, String orderNo, LocalDate orderDate, String status,
                    String customerName, String customerType, String productName,
                    Integer quantity, BigDecimal unitPrice, BigDecimal amount) {
        this.orderId = orderId;
        this.orderNo = orderNo;
        this.orderDate = orderDate;
        this.status = status;
        this.customerName = customerName;
        this.customerType = customerType;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.amount = amount;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
