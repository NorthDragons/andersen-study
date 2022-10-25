package com.study.andersen.gof.creational.abstractfactory.factory;

import com.study.andersen.gof.creational.abstractfactory.Information.WindowsInformationImpl;
import com.study.andersen.gof.creational.abstractfactory.Information.api.Information;
import com.study.andersen.gof.creational.abstractfactory.factory.api.AbstractFactory;
import com.study.andersen.gof.creational.abstractfactory.parameters.WindowsParametersImpl;
import com.study.andersen.gof.creational.abstractfactory.parameters.api.Parameters;

public class WindowsAbstractFactoryImpl implements AbstractFactory {
    @Override
    public Information createInformation() {
        return new WindowsInformationImpl();
    }

    @Override
    public Parameters createParameters() {
        return new WindowsParametersImpl();
    }
}
