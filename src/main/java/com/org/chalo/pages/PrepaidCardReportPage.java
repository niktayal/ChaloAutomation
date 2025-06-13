package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PrepaidCardReportPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public PrepaidCardReportPage() {
        log = LogManager.getLogger(PrepaidCardReportPage.class);
    }

    public void checkRedirectionOfPrepaidCardReportPage() {

        log.info("The user is on Home Page and clicking on Prepaid Card Report Page option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnReports = getElement(properties.getProperty("btnReports"));

// STEP 1: Hover on "Reports"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnReports));
        actions.moveToElement(btnReports).perform();

// STEP 2: Wait for Prepaid Card Report link to become visible/clickable
        WebElement btnPrepaidCardReport = getElement(properties.getProperty("btnPrepaidCardReport"));
        WebElement prepaidCardReport = wait.until(ExpectedConditions.elementToBeClickable(btnPrepaidCardReport));
        if (prepaidCardReport.isDisplayed()) {
            prepaidCardReport.click();
            expectedHeading = "Card Issue Report";
            actualHeading = getElement(properties.getProperty("textPrepaidCardReport")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Prepaid Card Report page is loading correctly");
        }

        else {
            log.info("The Prepaid Card Report option is not available for this user");
        }

    }
}
