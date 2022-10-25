package com.study.andersen.gof.creational.abstractfactory;

import com.study.andersen.gof.creational.abstractfactory.Information.api.Information;
import com.study.andersen.gof.creational.abstractfactory.factory.api.AbstractFactory;
import com.study.andersen.gof.creational.abstractfactory.parameters.api.Parameters;

public class Application {
    private final Information information;
    private final Parameters parameters;

    public Application(AbstractFactory factory) {
        information = factory.createInformation();
        parameters = factory.createParameters();
    }

    public void paint() {
        information.showInformation();
        parameters.showParameters();
    }
}