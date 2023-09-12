package com.orangehrm.tests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.TextReport;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.open;
@Listeners({TextReport.class, ListenerClass.class})
public class BaseTest {
    protected BaseTest(){}

//    @BeforeTest
//    static void setupAllureReports() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//
//        // or for fine-tuning:
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
//                .screenshots(true)
//                .savePageSource(true)
//        );
//    }

    @BeforeMethod
    protected void setUp(){
        WebDriver driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        WebDriverRunner.getWebDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @AfterMethod
    protected void tearDown(){
        WebDriverRunner.getWebDriver().quit();
    }
}
