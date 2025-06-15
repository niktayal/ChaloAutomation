package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import object_repository.LoginPageOR;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LoginPage extends TestBase {

    public LoginPage() {
        log = LogManager.getLogger(LoginPage.class);
    }

    public void enterUserName(String userName) {

        log.info("Entering Username");
        //getElement(LoginPageOR.INP_USER_NAME_XP.getLocator())
                //.sendKeys(userName);
        getElement(properties.getProperty("inputUserName")).sendKeys(userName);
        log.info("Entered username: {}", userName);
    }

    public void enterPassword(String password) {
        getElement(properties.getProperty("inputPassword")).sendKeys(password);
    }

    public void clickSignInButton() {

        getElement(properties.getProperty("btnSingIn")).click();
    }

    public void clickSelectCity() {
        getElement(properties.getProperty("btnSelectCity")).click();
    }

    public void enterCity(String city) throws AWTException, InterruptedException {
        getElement(properties.getProperty("btnSelectCity")).clear();
        getElement(properties.getProperty("btnSelectCity")).sendKeys(city + Keys.ENTER);
        Thread.sleep(1000);
    }

    public void enterAgency(String agency, String city) throws AWTException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // Disable implicit wait temporarily

            By agencyFieldLocator = By.xpath(properties.getProperty("btnSelectAgencyField"));
            List<WebElement> elements = driver.findElements(agencyFieldLocator);

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                WebElement fieldAgencyLogin = elements.get(0);
                fieldAgencyLogin.clear();
                fieldAgencyLogin.sendKeys(agency + Keys.ENTER);
            } else {
                System.out.println("Agency field not present or not visible for city: " + city);
            }

        } catch (Exception e) {
            System.out.println("Exception in enterAgency: " + e.getMessage());
        } finally {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Reset your global wait
        }
    }


    public void enterDepot(String depot) throws AWTException, InterruptedException {
        getElement(properties.getProperty("btnSelectDepo")).clear();
        getElement(properties.getProperty("btnSelectDepo")).sendKeys(depot+ Keys.ENTER);

    }

    public boolean isLoggedIn() throws InterruptedException {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("home");
    }
}
