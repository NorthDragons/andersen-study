package com.study.andersen.shop.service.api;

import com.study.andersen.shop.model.Product;
import java.util.Map;

public interface ProductService {
    void showAll();

    Map<Integer, Product> putProductIntoBucket(Product product);

    void showBucket();

    boolean deleteProductFromBucket(Integer product);

    boolean clearTheBucket();

}
