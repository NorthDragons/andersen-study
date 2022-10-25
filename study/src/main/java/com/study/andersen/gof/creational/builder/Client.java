package com.study.andersen.gof.creational.builder;

import com.study.andersen.gof.creational.builder.builder.DogBuilder;
import com.study.andersen.gof.creational.builder.builder.DogManualBuilder;

public class Client {
    public static void main(String[] args) {
        DogBuilder dogBuilder = new DogBuilder();
        Breeder breeder = new Breeder();
        breeder.createHusky(dogBuilder);
        System.out.println(dogBuilder.getResult().toString());
        DogManualBuilder dogManualBuilder = new DogManualBuilder();
        breeder.createHusky(dogManualBuilder);
        System.out.println(dogManualBuilder.getResult().getDescription());
    }
}
