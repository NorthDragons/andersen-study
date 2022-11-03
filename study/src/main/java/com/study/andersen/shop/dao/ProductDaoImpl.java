package com.study.andersen.shop.dao;

import com.study.andersen.shop.dao.api.ProductDao;
import com.study.andersen.shop.model.Product;
import com.study.andersen.shop.model.ProductType;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDaoImpl implements ProductDao {
    private final Map<Integer, Product> bucket = new HashMap<>();

    private final Map<Integer, Product> prise;

    {
        prise = new HashMap<>();
        prise.put(1,
                Product.builder().productType(ProductType.FOOD).name("Milk").price(22.2).build());
        prise.put(2,
                Product.builder().productType(ProductType.FOOD).name("Bread").price(7.9).build());
        prise.put(3,
                Product.builder().productType(ProductType.FOOD).name("Meet").price(45.5).build());
        prise.put(4, Product.builder().productType(ProductType.NOT_FOOD).name("Towel").price(70.0)
                .build());
        prise.put(5,
                Product.builder().productType(ProductType.NOT_FOOD).name("Lego").price(11.3)
                        .build());
        prise.put(6,
                Product.builder().productType(ProductType.NOT_FOOD).name("Hammer").price(25.4)
                        .build());
    }

    @Override
    public Map<Integer, Product> getBucket() {
        return bucket;
    }

    @Override
    public boolean deleteProduct(Integer product) {
        switchElem(bucket, product);
        return true;
    }

    @Override
    public Map<Integer, Product> getAll() {
        return prise;
    }

    @Override
    public boolean cleanBucket() {
        bucket.clear();
        return true;
    }

    @Override
    public Map<Integer, Product> putProductIntoBucket(Product product) {

        bucket.put(bucket.size() + 1, product);
        return bucket;
    }

    private void switchElem(Map<Integer, Product> prise, Integer key) {
        for (int i = key; i < prise.size(); i++) {
            Product product = prise.get(i + 1);
            prise.put(i, product);
        }
        prise.remove(prise.size());
    }
}
