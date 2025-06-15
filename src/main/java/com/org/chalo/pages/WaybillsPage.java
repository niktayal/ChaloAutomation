package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaybillsPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public WaybillsPage() {
        log = LogManager.getLogger(WaybillsPage.class);
    }

    public void checkRedirectionOfWaybillsPage() {

        log.info("The user is on Home Page and clicking on Waybills option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnDailyOps = getElement(properties.getProperty("btnDailyOps"));

// STEP 1: Hover on "Daily Ops Data"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnDailyOps));
        actions.moveToElement(btnDailyOps).perform();

// STEP 2: Wait for Waybills link to become visible/clickable
        WebElement btnWaybills = getElement(properties.getProperty("btnWaybills"));
        WebElement waybills = wait.until(ExpectedConditions.elementToBeClickable(btnWaybills));
        if (waybills.isDisplayed()) {
            waybills.click();
            expectedHeading = "Waybills";
            actualHeading = getElement(properties.getProperty("textWaybills")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Waybills page is not loading");
        }

        else {
            log.info("The Waybills option is not available for this user");
        }

    }
}
