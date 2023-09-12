package com.orangehrm.pages;

import com.codeborne.selenide.SelenideElement;
import com.orangehrm.entity.LoginDetails;
import io.qameta.allure.Step;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private LoginPage(){}

    public static LoginPage getInstance(){
        return new LoginPage();
    }

    private static final SelenideElement USERNAME = element(byName("username"));
    private static final SelenideElement PASSWORD = element(byName("password"));
    private static final SelenideElement LOGIN_BUTTON = element("[type='submit']");

    @Step("Login with username and password")
    public HomePage loginToApplication(LoginDetails loginDetails){
        USERNAME.shouldBe(visible).setValue(loginDetails.getUserName());
        PASSWORD.shouldBe(visible).setValue(loginDetails.getPassword());
        LOGIN_BUTTON.shouldBe(enabled).click();
        return new HomePage();

    }
}
