package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class CitySwitch extends TestBase {

    public CitySwitch() {
        log = LogManager.getLogger(CitySwitch.class);
    }

    public void clickSwitch() {

        log.info("Switch Clicked");
        getElement(properties.getProperty("btnSwitch")).click();
        log.info("Clicked switch city");
    }

    public void clickSelectCity() {
        getElement(properties.getProperty("btnSelectCity")).click();
    }

    public void enterCity(String city) throws AWTException {
        getElement(properties.getProperty("btnEnterCity")).clear();
        getElement(properties.getProperty("btnEnterCity")).sendKeys(city + Keys.ENTER);
    }

    public void enterAgency(String agency) throws AWTException {

        WebElement fieldAgency = getElement(properties.getProperty("btnEnterAgency"));

        if(fieldAgency.isDisplayed()) {
            getElement(properties.getProperty("btnEnterAgency")).clear();
            getElement(properties.getProperty("btnEnterAgency")).sendKeys(agency + Keys.ENTER);
        }

        else {
            log.info("The Agency field is not required for this city");
        }
    }

    public void enterAccount(String account) throws AWTException {
        getElement(properties.getProperty("btnEnterAccount")).clear();
        getElement(properties.getProperty("btnEnterAccount")).sendKeys(account+ Keys.ENTER);
    }

    public void clickConfirmButton() {
        getElement(properties.getProperty("btnSwitchConfirm")).click();
    }

}
