package com.study.andersen.gof.creational.prototype;

import com.study.andersen.gof.creational.prototype.api.Car;
import java.util.Objects;

public class SportCar extends Car implements Cloneable {
    private final Boolean nitro;

    public SportCar(String color, String type, Double maxSpeed, Boolean nitro) {
        super(color, type, maxSpeed);
        this.nitro = nitro;
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public Double getMaxSpeed() {
        return super.getMaxSpeed();
    }

    @Override
    public void setMaxSpeed(Double maxSpeed) {
        super.setMaxSpeed(maxSpeed);
    }

    @Override
    public SportCar clone() {
        try {
            return (SportCar) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SportCar sportCar = (SportCar) o;
        return Objects.equals(nitro, sportCar.nitro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nitro);
    }
}
