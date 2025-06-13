package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaybillSignOffPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public WaybillSignOffPage() {
        log = LogManager.getLogger(WaybillSummaryPage.class);
    }

    public void checkRedirectionOfWaybillSignOffPage() {

        log.info("The user is on Home Page and clicking on Waybill Sign Off option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnReports = getElement(properties.getProperty("btnReports"));

// STEP 1: Hover on "Reports"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnReports));
        actions.moveToElement(btnReports).perform();

// STEP 2: Wait for Waybills Sign off link to become visible/clickable
        WebElement btnWaybillSignOff = getElement(properties.getProperty("btnWaybillSignOff"));
        WebElement waybillSignOff = wait.until(ExpectedConditions.elementToBeClickable(btnWaybillSignOff));
        if (waybillSignOff.isDisplayed()) {
            waybillSignOff.click();
            expectedHeading = "Waybill SignOff";
            actualHeading = getElement(properties.getProperty("textWaybillSignOff")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Waybill Sign Off page is loading correctly");
        }

        else {
            log.info("The Waybill Sign Off option is not available for this user");
        }

    }
}
