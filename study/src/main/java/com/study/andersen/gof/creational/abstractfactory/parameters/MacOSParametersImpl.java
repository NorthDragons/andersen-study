package com.study.andersen.gof.creational.abstractfactory.parameters;

import com.study.andersen.gof.creational.abstractfactory.parameters.api.Parameters;

public class MacOSParametersImpl implements Parameters {
    @Override
    public void showParameters() {
        System.out.println("CPU: Apple M1, RAM:12gb");
    }
}
