package com.study.andersen.gof.structural.adapter.youth;

public class YoungParty {
    private final Integer ageUnder;

    public YoungParty(Integer ageTo) {
        this.ageUnder = ageTo;
    }

    public Integer getAgeUnder() {
        return ageUnder;
    }

    public boolean fits(YoungPerson person) {
        boolean result;
        result = (person.getAge() <= this.getAgeUnder());
        return result;
    }
}
