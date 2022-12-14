package com.study.andersen.gof.creational.abstractfactory;

import com.study.andersen.gof.creational.abstractfactory.factory.api.AbstractFactory;
import com.study.andersen.gof.creational.abstractfactory.factory.MacOCAbstractFactoryImpl;
import com.study.andersen.gof.creational.abstractfactory.factory.WindowsAbstractFactoryImpl;

public class Client {

    /**
     * The application selects the type and creates specific factories dynamically based on
     * from configuration or environment.
     */
    private static Application configureApplication() {
        Application app;
        AbstractFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("mac")) {
            factory = new MacOCAbstractFactoryImpl();
        } else {
            factory = new WindowsAbstractFactoryImpl();
        }
        app = new Application(factory);
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }
}