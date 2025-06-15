package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SpotTicketReportPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public SpotTicketReportPage() {
        log = LogManager.getLogger(SpotTicketReportPage.class);
    }

    public void checkRedirectionOfSpotTicketReportPage() {

        log.info("The user is on Home Page and clicking on Spot Ticket Report Page option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnReports = getElement(properties.getProperty("btnReports"));

// STEP 1: Hover on "Reports"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnReports));
        actions.moveToElement(btnReports).perform();

// STEP 2: Wait for Spot Ticket Report link to become visible/clickable
        WebElement btnSpotTicketReport = getElement(properties.getProperty("btnSpotTicketReport"));
        WebElement spotTicketReport = wait.until(ExpectedConditions.elementToBeClickable(btnSpotTicketReport));
        if (spotTicketReport.isDisplayed()) {
            spotTicketReport.click();
            expectedHeading = "Spot Ticket Sales";
            actualHeading = getElement(properties.getProperty("textSpotTicketReport")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Spot Ticket Report page is not loading");
        }

        else {
            log.info("The Spot Ticket Report option is not available for this user");
        }

    }

}
