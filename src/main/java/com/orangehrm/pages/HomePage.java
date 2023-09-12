package com.orangehrm.pages;

import com.orangehrm.enums.LeftMenuComponentType;
import com.orangehrm.pages.pagecomponents.LeftMenuComponent;
import io.qameta.allure.Step;


public class HomePage {

    private final LeftMenuComponent leftMenuComponent;

    public HomePage() {
        this.leftMenuComponent = new LeftMenuComponent();
    }
    public LeftMenuComponent getLeftMenuComponent(){
        return leftMenuComponent;
    }

    @Step("Navigating to the Add Employee Page")
    public EmployeeInformationPage navigateToEmployeeInformationPage(){
        this.leftMenuComponent.selectAManuFromLeftMenuBar(LeftMenuComponentType.PIM);
        return new EmployeeInformationPage();
    }
}

