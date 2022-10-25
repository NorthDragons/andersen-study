package com.study.andersen.gof.creational.builder.dog;

public class DogManual {
    private String description;

    public DogManual(String descriptions) {
        this.description = descriptions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
