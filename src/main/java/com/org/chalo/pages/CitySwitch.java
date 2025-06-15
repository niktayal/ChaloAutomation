package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class CitySwitch extends TestBase {

    public CitySwitch() {
        log = LogManager.getLogger(CitySwitch.class);
    }

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void clickSwitch() {

        wait.until(ExpectedConditions.elementToBeClickable(getElement(properties.getProperty("btnSwitch"))));
        log.info("Switch Clicked");
        getElement(properties.getProperty("btnSwitch")).click();
        log.info("Clicked switch city");
    }

    public void clickSelectCity() {
        wait.until(ExpectedConditions.visibilityOf(getElement(properties.getProperty("btnSwitchCity"))));
        getElement(properties.getProperty("btnSwitchCity")).click();
    }

    public void enterCity(String city) throws AWTException {
        getElement(properties.getProperty("btnSwitchCity")).clear();
        getElement(properties.getProperty("btnSwitchCity")).sendKeys(city + Keys.ENTER);
    }

    public void enterAgency(String agency) throws AWTException, InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(getElement(properties.getProperty("btnEnterAgency"))));

        WebElement fieldAgency = getElement(properties.getProperty("btnEnterAgency"));

        if(fieldAgency.isDisplayed()) {
            getElement(properties.getProperty("btnEnterAgency")).clear();
            Thread.sleep(1000);
            getElement(properties.getProperty("btnEnterAgency")).sendKeys(agency + Keys.ENTER);
        }

        else {
            log.info("The Agency field is not required for this city");
        }
    }

    public void enterAccount(String account) throws AWTException, InterruptedException {
        //wait.until(ExpectedConditions.elementToBeSelected(getElement(properties.getProperty("btnEnterAccount"))));
        getElement(properties.getProperty("btnEnterAccount")).clear();
        Thread.sleep(1000);
        getElement(properties.getProperty("btnEnterAccount")).sendKeys(account);
        getElement(properties.getProperty("btnEnterAccount")).sendKeys(Keys.ENTER);
    }

    public void clickConfirmButton() throws InterruptedException {
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.elementToBeSelected(getElement(properties.getProperty("btnSwitchConfirm"))));
        getElement(properties.getProperty("btnSwitchConfirm")).click();
    }

}
