package com.org.chalo.tests;

import com.org.chalo.base.TestBase;
import com.org.chalo.pages.LoginPage;
import com.org.chalo.util.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;
import java.time.Duration;

public class LoginPageTest extends TestBase {
    private LoginPage loginPage = new LoginPage();
    //loginPage = new LoginPage();
    @BeforeMethod
    public void setUp(Method method) {
        initialization();
        //loginPage = new LoginPage();
        log.info(Constants.LINE);
    }

    @Test(description = "Test Method")
    void testMethod() throws AWTException, InterruptedException {
        try {
        loginPage.enterUserName(properties.getProperty("username"));

        loginPage.enterPassword(properties.getProperty("password"));

        loginPage.clickSignInButton();

        loginPage.enterCity(properties.getProperty("city"));

        loginPage.enterAgency(properties.getProperty("agency"), properties.getProperty("city"));

        loginPage.enterDepot(properties.getProperty("depot"));

            //By etimRegisterButton = By.xpath("//div[contains(@class,'align-horizonal menu-accordian logo')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(getElement(properties.getProperty("logo"))));

            Assert.assertTrue(loginPage.isLoggedIn(), "Login failed: Dashboard not visible");


        } catch (Exception e) {
            log.error("-->Deliberately Failed Test Method: {}", e.getMessage());
            Assert.fail("Test failed due to exception: " + e.getMessage());
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info(Constants.LINE);
        driver.close();
    }
}
