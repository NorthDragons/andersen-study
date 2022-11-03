package com.study.andersen.shop;

import com.study.andersen.shop.service.ProductServiceImpl;
import com.study.andersen.shop.service.api.ProductService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {

    private static boolean status;
    private static final ProductService productService = new ProductServiceImpl();

    private static final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    Please select an action
                    1)Open Catalog
                    2)Open bucket
                    3)close shop""");
            makeTheAction();
        }
    }

    private static void makeTheAction() {
        int action = Integer.parseInt(inputStream());
        switch (action) {
            case 1 -> {
                productService.showAll();
            }
            case 2 -> {
                productService.showBucket();
            }
            case 3 -> System.exit(0);
        }
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
