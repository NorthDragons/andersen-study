package com.study.andersen.gof.creational.builder;

import com.study.andersen.gof.creational.builder.builder.api.Builder;
import com.study.andersen.gof.creational.builder.dog.api.Behavior;
import com.study.andersen.gof.creational.builder.dog.api.Breed;

public class Breeder {
    public void createHusky(Builder builder) {
        builder.setBehavior(Behavior.CRAZY);
        builder.setBreed(Breed.HUSKY);
        builder.setColor("Random husky color");
        builder.setWeight(25.5);
        builder.setName("Kryacha");
    }

    public void createMalamute(Builder builder) {
        builder.setBehavior(Behavior.KIND);
        builder.setBreed(Breed.MALAMUTE);
        builder.setColor("Random malamute color");
        builder.setWeight(40.5);
        builder.setName("Asya");
    }

    public void createRetriever(Builder builder) {
        builder.setBehavior(Behavior.AGGRESSIVE);
        builder.setBreed(Breed.RETRIEVER);
        builder.setColor("Random retriever color");
        builder.setWeight(35.5);
        builder.setName("Kirill");
    }
}
