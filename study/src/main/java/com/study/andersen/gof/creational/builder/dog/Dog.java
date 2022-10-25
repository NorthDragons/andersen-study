package com.study.andersen.gof.creational.builder.dog;

import com.study.andersen.gof.creational.builder.dog.api.Behavior;
import com.study.andersen.gof.creational.builder.dog.api.Breed;

public class Dog {
    private String color;
    private String name;
    private Double weight;
    private Breed breed;
    private Behavior behavior;

    public Dog(String color, String name, Double weight, Breed breed, Behavior behavior) {
        this.color = color;
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.behavior = behavior;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", breed=" + breed +
                ", behavior=" + behavior +
                '}';
    }
}
