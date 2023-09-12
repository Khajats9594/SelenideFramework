package com.orangehrm.pages.pagecomponents;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.orangehrm.enums.LeftMenuComponentType;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.element;

public class LeftMenuComponent {

    public void selectAManuFromLeftMenuBar(LeftMenuComponentType menuName){
        element(byText(menuName.getMenuName())).shouldBe(enabled).click();
    }


}
