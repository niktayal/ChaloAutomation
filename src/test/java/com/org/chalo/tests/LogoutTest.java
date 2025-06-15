package com.org.chalo.tests;

import com.org.chalo.base.TestBase;
import com.org.chalo.pages.HomePage;
import com.org.chalo.pages.Logout;
import com.org.chalo.util.Constants;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;
import java.time.Duration;

public class LogoutTest extends TestBase{

    private HomePage homePage;
    LoginPageTest login = new LoginPageTest();
    Logout logout = new Logout();

    @BeforeMethod
    public void setUp(Method method) throws InterruptedException, AWTException {
        initialization();
        homePage = new HomePage();
        log.info(Constants.LINE);

        if(!driver.getCurrentUrl().contains("home")){

            log.info("The user is not logged in into the website");
            login.testMethod();
        }

        else {
            log.info("The user is already logged in into the website");
        }
    }

    @Test(priority = 1, description = "This method is testing the logout scenario")
    void logout() throws AWTException, InterruptedException {
        try {
            log.info("The logout check is been started");

            Thread.sleep(2000);
            logout.clicklogoutBtn();

            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //wait.until(ExpectedConditions.elementToBeClickable(getElement(properties.getProperty("btnSingIn"))));

            Assert.assertTrue(logout.isLoggedOut(), "Logout failed: Login not visible");

            log.info("The logout check is been stopped");

            Assert.assertTrue(true);
        } catch (Exception e) {
            log.error("-->Deliberately Failed Menu Options Enable Method: {}", e.getMessage());
            Assert.fail();
        }
    }

    @AfterMethod
    public void tearDown() {
        log.info(Constants.LINE);
        driver.close();
    }
}
