package com.study.andersen.gof.creational.abstractfactory.factory;

import com.study.andersen.gof.creational.abstractfactory.Information.MacOSInformationImpl;
import com.study.andersen.gof.creational.abstractfactory.Information.api.Information;
import com.study.andersen.gof.creational.abstractfactory.factory.api.AbstractFactory;
import com.study.andersen.gof.creational.abstractfactory.parameters.MacOSParametersImpl;
import com.study.andersen.gof.creational.abstractfactory.parameters.api.Parameters;

public class MacOCAbstractFactoryImpl implements AbstractFactory {
    @Override
    public Information createInformation() {
        return new MacOSInformationImpl();
    }

    @Override
    public Parameters createParameters() {
        return new MacOSParametersImpl();
    }
}
