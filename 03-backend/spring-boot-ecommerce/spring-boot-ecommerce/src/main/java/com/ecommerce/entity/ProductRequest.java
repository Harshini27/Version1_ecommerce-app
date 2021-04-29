package com.ecommerce.entity;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data

public class ProductRequest {

    private String sku;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private String imageUrl;
    private int unitsInStock;
    private String categoryName;

}
