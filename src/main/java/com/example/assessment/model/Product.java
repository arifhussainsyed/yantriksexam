package com.example.assessment.model;

public class Product {
    String productId;
    String productName;
    String unitOfMeasure;
    String Status;
    String launchDate;

    public Product() {
    }

    public Product(String productId, String productName, String unitOfMeasure) {
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Product(String productId, String productName, String unitOfMeasure, String launchDate) {
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
    }

    public Product(String productId, String productName, String unitOfMeasure, String status, String launchDate) {
        this.productId = productId;
        this.productName = productName;
        this.unitOfMeasure = unitOfMeasure;
        Status = status;
    }


    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
}
