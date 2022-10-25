package com.study.andersen.gof.creational.prototype.api;

public abstract class Car  {
    private String color;
    private String type;
    private Double maxSpeed;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Car(String color, String type, Double maxSpeed) {
        this.color = color;
        this.type = type;
        this.maxSpeed = maxSpeed;
    }
}
