package com.example.assessment.model;

import java.util.Date;

public class Supply {
    String productId;
    Date updateTimeStamp;
    Double quantity;
    String status;

    public Supply() {
    }

    public Supply(String productId, Date updateTimeStamp, Double quantity) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
    }

    public Supply(String productId, Date updateTimeStamp, Double quantity, String status) {
        this.productId = productId;
        this.updateTimeStamp = updateTimeStamp;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
