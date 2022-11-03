package com.study.andersen.shop.dao.api;

import com.study.andersen.shop.model.Product;
import java.util.Map;

public interface ProductDao {

    Map<Integer, Product> getAll();

    Map<Integer, Product> putProductIntoBucket(Product products);

    Map<Integer, Product> getBucket();

    boolean deleteProduct(Integer product);

    boolean cleanBucket();
}
