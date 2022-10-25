package com.study.andersen.gof.structural.adapter;

import com.study.andersen.gof.structural.adapter.pensioners.OldPerson;
import com.study.andersen.gof.structural.adapter.youth.YoungPerson;

public class PensionerAdapter extends OldPerson {
    private final Integer youngPersonAge;

    public PensionerAdapter(YoungPerson youngPerson) {
        this.youngPersonAge = youngPerson.getAge();
    }

    @Override
    public Integer getAge() {
        int result = youngPersonAge;
        return result = youngPersonAge + 5;
    }
}
