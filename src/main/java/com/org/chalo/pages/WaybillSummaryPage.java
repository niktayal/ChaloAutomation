package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaybillSummaryPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public WaybillSummaryPage() {
        log = LogManager.getLogger(WaybillSummaryPage.class);
    }

    public void checkRedirectionOfWaybillSummaryPage() {

        log.info("The user is on Home Page and clicking on Waybill Summary Page option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnReports = getElement(properties.getProperty("btnReports"));

// STEP 1: Hover on "Reports"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnReports));
        actions.moveToElement(btnReports).perform();

// STEP 2: Wait for Waybill Summary link to become visible/clickable
        WebElement btnWaybillSummary = getElement(properties.getProperty("btnWaybillSummary"));
        WebElement waybillSummary = wait.until(ExpectedConditions.elementToBeClickable(btnWaybillSummary));
        if (waybillSummary.isDisplayed()) {
            waybillSummary.click();
            expectedHeading = "Waybill Summary";
            actualHeading = getElement(properties.getProperty("textWaybillSummary")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Waybill Summary page is loading correctly");
        }

        else {
            log.info("The Waybill Summary option is not available for this user");
        }

    }
}
