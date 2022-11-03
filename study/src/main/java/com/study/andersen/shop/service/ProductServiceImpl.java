package com.study.andersen.shop.service;

import com.study.andersen.shop.dao.ProductDaoImpl;
import com.study.andersen.shop.dao.api.ProductDao;
import com.study.andersen.shop.model.Product;
import com.study.andersen.shop.service.api.ProductService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Set;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private Map<Integer, Product> products;
    private static final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));


    public ProductServiceImpl() {
        this.productDao = new ProductDaoImpl();
    }

    @Override
    public void showAll() {
        products = productDao.getAll();
        Set<Integer> integers = products.keySet();
        for (Integer integer : integers) {
            System.out.println(integer + ")" + products.get(integer));
        }
        while (true) {
            System.out.println("""
                                    
                    Please select an action
                    1)Add to bucket
                    2)Go to menu""");

            Integer action = Integer.valueOf(inputStream());
            if (action.equals(1)) {
                System.out.println("Please choose the number of product");
                putProductIntoBucket(products.get(Integer.valueOf(inputStream())));
            } else {
                return;
            }
        }
    }

    @Override
    public Map<Integer, Product> putProductIntoBucket(Product product) {
        return productDao.putProductIntoBucket(product);
    }


    @Override
    public void showBucket() {
        Map<Integer, Product> bucket = productDao.getBucket();
        Set<Integer> integers = bucket.keySet();
        if (integers.size() == 0) {
            System.out.println("Your bucket is empty");
            return;
        }
        for (Integer integer : integers) {
            System.out.println(integer + ")" + bucket.get(integer));
        }
        while (true) {
            System.out.println("""
                                    
                    Please select an action
                    1)Remove product
                    2)Clean bucket
                    3)Go to menu""");
            Integer action = Integer.valueOf(inputStream());
            if (action.equals(1)) {
                System.out.println("Please choose the number of product");
                deleteProductFromBucket(Integer.valueOf(inputStream()));
            } else if (action.equals(2)) {
                productDao.cleanBucket();
            } else {
                return;
            }
        }
    }

    @Override
    public boolean deleteProductFromBucket(Integer product) {
        return productDao.deleteProduct(product);
    }

    @Override
    public boolean clearTheBucket() {
        return productDao.cleanBucket();
    }

    private static String inputStream() {
        String text = "";
        try {
            text = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Data entry error");
        }
        return text;
    }
}
