package com.study.andersen.shop.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product implements Serializable {
    private ProductType productType;
    private String name;
    private Double price;
}
