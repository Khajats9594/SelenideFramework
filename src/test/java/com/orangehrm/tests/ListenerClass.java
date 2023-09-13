package com.orangehrm.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.orangehrm.annotation.FrameworkAnnotation;
import com.orangehrm.utils.DynamicLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.ThreadContext;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListenerClass implements ITestListener, ISuiteListener {

   DynamicLogger logger = DynamicLogger.getLogger(getClass());
    @Override
    public void onStart(ISuite suite) {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        // or for fine-tuning:
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @Override
    public void onFinish(ISuite suite) {

    }
    @Override
    public void onTestStart(ITestResult result) {

        ThreadContext.put("testName", result.getMethod().getMethodName());
        ThreadContext.put("authorName", result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class)
                .author());

        logger.info(" Test started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ThreadContext.put("testResult", "Passed");
        logger.info("test case");
        ThreadContext.clearMap();
    }
    @Override
    public void onTestFailure(ITestResult result) {
        ThreadContext.put("testResult", "Failed");
        logger.error("test case");
        ThreadContext.clearMap();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ThreadContext.put("testResult", "Skipped");
        logger.warn("test case on Skipped");
        ThreadContext.clearMap();
    }

}
