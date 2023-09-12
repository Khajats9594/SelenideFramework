package com.orangehrm.tests;

import com.orangehrm.annotation.FrameworkAnnotation;
import com.orangehrm.entity.EmployeeDetails;
import com.orangehrm.entity.LoginDetails;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.testdata.EmployeeTestData;
import com.orangehrm.testdata.LoginTestData;
import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

@Epic("Regression Tests")
@Feature("Add Employee Tests")
public class AddEmployeeTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(AddEmployeeTest.class);

    @Test(description = "Add Employee Scenario with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Add Employee Test with valid credentials")
    @Story("Valid employee and login credentials for Add Employee Test")
    @FrameworkAnnotation(author = "Jerry")
    public void testAddEmployee1() throws InterruptedException {

        // Arrange
        LoginDetails loginDetails = LoginTestData.getValidLoginDetails();
        logger.info("LoginTestData:getValidLoginDetails execution started.");
        EmployeeDetails employee = EmployeeTestData.getRandomEmployeeDetails();
        logger.info("EmployeeTestData:getRandomEmployeeDetails execution started.");

        // Act and Assert
        logger.debug("LoginTestData:getValidLoginDetails request parameters {}",loginDetails);
        logger.debug("EmployeeTestData:getRandomEmployeeDetails request parameters {}",employee);
        LoginPage.getInstance()
                .loginToApplication(loginDetails)
                .navigateToEmployeeInformationPage()
                .addNewEmployee(employee)
                .checkWhetherEmployeeCreatedSuccessfully();

        Thread.sleep(5000);
    }
}
