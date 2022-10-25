package com.study.andersen.gof.creational.builder.builder.api;

import com.study.andersen.gof.creational.builder.dog.api.Behavior;
import com.study.andersen.gof.creational.builder.dog.api.Breed;

public interface Builder {
    void setColor(String color);
    void setName(String name);
    void setWeight(Double weight);
    void setBreed(Breed breed);
    void setBehavior(Behavior behavior);
}
