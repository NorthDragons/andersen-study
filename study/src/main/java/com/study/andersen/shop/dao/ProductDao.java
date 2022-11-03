package com.study.andersen.shop.dao;

import com.study.andersen.shop.model.Product;
import com.study.andersen.shop.model.ProductType;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ProductDao {
    private static final String FILE_PATH = "./prise.txt";

    public static void main(String[] args) {
        List<Product> all = getAll();
        System.out.println(all.toString());
    }

    public static List<Product> getBucket() {
        return null;
    }

    public static List<Product> getAll() {
        List<Product> products;
        try (ObjectInputStream objectIn = new ObjectInputStream(new FileInputStream(FILE_PATH))) {

            Object obj = objectIn.readObject();
            products = (obj instanceof ArrayList<?>) ? ((ArrayList<Product>) obj) :
                    createDefaultProducts();
            System.out.println("The Object has been read from the file");
        } catch (Exception ex) {
            return createDefaultProducts();
        }
        return products;
    }

    private static List<Product> createDefaultProducts() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(
                Product.builder().productType(ProductType.FOOD).name("Milk").price(22.2).build());
        products.add(
                Product.builder().productType(ProductType.FOOD).name("Bread").price(7.9).build());
        products.add(
                Product.builder().productType(ProductType.FOOD).name("Meet").price(45.5).build());
        products.add(
                Product.builder().productType(ProductType.NOT_FOOD).name("Towel").price(70.0)
                        .build());
        products.add(
                Product.builder().productType(ProductType.NOT_FOOD).name("Lego").price(11.3)
                        .build());
        products.add(
                Product.builder().productType(ProductType.NOT_FOOD).name("Hammer").price(25.4)
                        .build());
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH))) {
            objectOutputStream.writeObject(products);
            System.out.println("The Object  was successfully written to a file");
        } catch (Exception ex) {
            log.error("Error writing to file:" + ex);
        }
        return products;
    }
}
