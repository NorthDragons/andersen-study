package com.study.andersen.gof.structural.adapter;

import com.study.andersen.gof.structural.adapter.pensioners.OldParty;
import com.study.andersen.gof.structural.adapter.pensioners.OldPerson;
import com.study.andersen.gof.structural.adapter.youth.YoungPerson;

public class Client {
    public static void main(String[] args) {
        OldPerson oldPerson = new OldPerson(66);
        OldParty oldParty = new OldParty(40);
        System.out.println(oldParty.fits(oldPerson));

        YoungPerson youngPerson = new YoungPerson(20);
        YoungPerson youngPerson2 = new YoungPerson(36);

        PensionerAdapter pensionerAdapter = new PensionerAdapter(youngPerson);
        PensionerAdapter pensionerAdapter2 = new PensionerAdapter(youngPerson2);

        System.out.println(oldParty.fits(pensionerAdapter));
        System.out.println(oldParty.fits(pensionerAdapter2));
    }
}
