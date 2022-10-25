package com.study.andersen.gof.creational.builder.builder;

import com.study.andersen.gof.creational.builder.builder.api.Builder;
import com.study.andersen.gof.creational.builder.dog.Dog;
import com.study.andersen.gof.creational.builder.dog.api.Behavior;
import com.study.andersen.gof.creational.builder.dog.api.Breed;

public class DogBuilder implements Builder {
    private String color;
    private String name;
    private Double weight;
    private Breed breed;
    private Behavior behavior;

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public void setBreed(Breed breed) {
        this.breed = breed;
    }

    @Override
    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
    }

    public Dog getResult() {
        return new Dog(color, name, weight, breed, behavior);
    }
}
