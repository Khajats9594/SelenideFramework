package com.orangehrm.pages;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.orangehrm.entity.EmployeeDetails;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.element;

public class EmployeeInformationPage {

    private static final SelenideElement ADD_EMPLOYEE_BUTTON = element(byTagAndText("a","Add Employee"));
    private static final SelenideElement FIRST_NAME = element(Selectors.byName("firstName"));
    private static final SelenideElement LAST_NAME = element(byName("lastName"));
    private static final SelenideElement MIDDLE_NAME = element(byName("middleName"));
    private static final SelenideElement IMAGE = element(byXpath("//input[@type='file']"));
    private static final SelenideElement SAVE_BUTTON = element(byText("Save"));
    private static final SelenideElement SUCCESS_MESSAGE = element(byText("Success"));

    @Step("Entering the valid employee credentials ")
    public EmployeeInformationPage addNewEmployee(EmployeeDetails employee){
        ADD_EMPLOYEE_BUTTON.shouldBe(visible).click();
        FIRST_NAME.shouldBe(visible).setValue(employee.getFirstName());
        LAST_NAME.shouldBe(visible).setValue(employee.getLastName());
        MIDDLE_NAME.shouldBe(visible).setValue(employee.getMiddleName());
        IMAGE.shouldBe(enabled).uploadFromClasspath(employee.getProfilePicturePath());
        SAVE_BUTTON.shouldBe(visible).click();
        return this;
    }

    @Step("Checking that the employee is added successfully")
    public void checkWhetherEmployeeCreatedSuccessfully(){
        SUCCESS_MESSAGE.shouldHave(visible,text("Success"));
    }
}
