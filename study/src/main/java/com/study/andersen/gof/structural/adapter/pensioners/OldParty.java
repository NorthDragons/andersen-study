package com.study.andersen.gof.structural.adapter.pensioners;

public class OldParty {
    private final Integer ageUp;

    public OldParty(Integer ageFrom) {
        this.ageUp = ageFrom;
    }

    public Integer getAgeUp() {
        return ageUp;
    }

    public boolean fits(OldPerson person) {
        boolean result;
        result = (person.getAge() >= this.getAgeUp());
        return result;
    }

}
