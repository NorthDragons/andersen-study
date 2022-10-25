package com.study.andersen.gof.creational.abstractfactory.parameters;

import com.study.andersen.gof.creational.abstractfactory.parameters.api.Parameters;

public class WindowsParametersImpl implements Parameters {

    @Override
    public void showParameters() {
        System.out.println("CPU : Intel(R) Core(TM) i7, RAM:32gb");
    }
}
