package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import object_repository.LoginPageOR;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

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

    public void enterCity(String city) throws AWTException {
        getElement(properties.getProperty("btnSelectCity")).clear();
        getElement(properties.getProperty("btnSelectCity")).sendKeys(city + Keys.ENTER);
    }

    public void enterAgency(String agency, String city) throws AWTException {

        WebElement fieldAgencyLogin = getElement(properties.getProperty("btnSelectAgencyField"));

        //if(city.equalsIgnoreCase("Mumbai")) {
        if(fieldAgencyLogin.isDisplayed()) {
            getElement(properties.getProperty("btnSelectAgencyField")).clear();
            getElement(properties.getProperty("btnSelectAgencyField")).sendKeys(agency + Keys.ENTER);
        }

        else {
            //log.info("The Agency field is not required for this city");
        }
    }

    public void enterDepot(String depot) throws AWTException {
        getElement(properties.getProperty("btnSelectDepo")).clear();
        getElement(properties.getProperty("btnSelectDepo")).sendKeys(depot+ Keys.ENTER);
    }
}
