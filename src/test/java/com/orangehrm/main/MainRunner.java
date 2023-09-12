package com.orangehrm.main;

import org.testng.TestNG;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainRunner {

    static TestNG testNg;
    public static void main(String[] args) {

        testNg = new TestNG();
        String path = System.getProperty("user.dir") + File.separator + "testng.xml";
        List<String>xmlList = new ArrayList<>();
        xmlList.add(path);
        testNg.setTestSuites(xmlList);
        testNg.run();

    }
}
