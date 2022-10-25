package com.study.andersen.gof.structural.adapter.pensioners;

public class OldPerson {
    private Integer age;

    public OldPerson(Integer age) {
        this.age = age;
    }

    public OldPerson() {
    }

    public Integer getAge() {
        return age;
    }
}
