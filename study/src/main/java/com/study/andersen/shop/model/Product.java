package com.study.andersen.shop.model;

import java.io.Serializable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product implements Serializable {
    private ProductType productType;
    private String name;
    private Double price;

    @Override
    public String toString() {
        return name + '\'' + ", price=" + price;
    }
}
