package com.study.andersen.gof.creational.abstractfactory.factory.api;

import com.study.andersen.gof.creational.abstractfactory.Information.api.Information;
import com.study.andersen.gof.creational.abstractfactory.parameters.api.Parameters;

public interface AbstractFactory {
    Information createInformation();

    Parameters createParameters();
}
