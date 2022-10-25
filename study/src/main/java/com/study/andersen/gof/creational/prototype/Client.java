package com.study.andersen.gof.creational.prototype;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<SportCar> cars = new ArrayList<>();
        cars.add(new SportCar("Blue", "Sport", 360.5, true));
        cars.add(cars.get(0).clone());
        System.out.println(cars.get(0) == cars.get(1));
        System.out.println(cars.get(0).equals(cars.get(1)));
    }
}
