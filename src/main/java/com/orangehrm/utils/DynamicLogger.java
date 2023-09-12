package com.orangehrm.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.message.SimpleMessageFactory;

public class DynamicLogger {

    private final Logger logger;

    private DynamicLogger(Class<?> clazz) {
       this.logger = LogManager.getLogger(clazz.getName(), new SimpleMessageFactory());
    }

    public static DynamicLogger getLogger(Class<?> clazz) {
        return new DynamicLogger(clazz);
    }

    public void info(String message, Object... params) {
       logger.info(createDynamicMessage(message), params);
    }

    public void error(String message, Object... params) {
       logger.error(createDynamicMessage(message), params);
    }

    public void warn(String message, Object... params) {
       logger.error(createDynamicMessage(message), params);
    }

    private String createDynamicMessage(String message) {
        String dynamicSection = "";

        String testName = ThreadContext.get("testName");
        String authorName = ThreadContext.get("authorName");
        String testResult = ThreadContext.get("testResult");

        if (testName != null) {
            dynamicSection += "Test: " + testName + ", ";
        }
        if (authorName != null) {
            dynamicSection += "Author: " + authorName + ", ";
        }
        if (testResult != null) {
            dynamicSection += "Result: " + testResult + " - ";
        }

        // Remove trailing comma and space
        if (!dynamicSection.isEmpty()) {
            dynamicSection = dynamicSection.substring(0, dynamicSection.length() - 2);
        }

        return dynamicSection + message;
    }
}
