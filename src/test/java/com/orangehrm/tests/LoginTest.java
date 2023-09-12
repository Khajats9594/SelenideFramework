package com.orangehrm.tests;

import com.orangehrm.annotation.FrameworkAnnotation;
import com.orangehrm.entity.EmployeeDetails;
import com.orangehrm.entity.LoginDetails;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.testdata.LoginTestData;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    @Test(description = "Login Scenario with valid username and password")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with valid username and password")
    @Story("Valid username and password login test")
    @FrameworkAnnotation(author = "Tom")
    public void validLoginTest(){

        // Arrange
        logger.info("LoginTestData:getValidLoginDetails execution started.");
        LoginDetails validLoginDetails = LoginTestData.getValidLoginDetails();

        // Act and Assert
        logger.debug("LoginTestData:getValidLoginDetails request parameters {}",validLoginDetails);
        LoginPage.getInstance()
                .loginToApplication(validLoginDetails);

    }
}
