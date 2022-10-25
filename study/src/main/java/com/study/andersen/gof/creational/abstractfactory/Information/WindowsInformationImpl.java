package com.study.andersen.gof.creational.abstractfactory.Information;

import com.study.andersen.gof.creational.abstractfactory.Information.api.Information;

public class WindowsInformationImpl implements Information {
    @Override
    public void showInformation() {
        String name = System.getProperty("os.name").toLowerCase();
        String version = System.getProperty("os.version").toLowerCase();
        System.out.println(
                "Getting Information on Windows\n" + "name: " + name + " version: " + version);

    }
}
