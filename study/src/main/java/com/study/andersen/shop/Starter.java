package com.study.andersen.shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {

    private static boolean status;

    private static final BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("Would you like to open a store? enter Y/N\nY - yes, N - no");
        String s = inputStream();
        while (s.equalsIgnoreCase("Y")){
            System.out.println("Please select an action\n");
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
