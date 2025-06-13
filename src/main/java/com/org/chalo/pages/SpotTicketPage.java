package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SpotTicketPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public SpotTicketPage() {
        log = LogManager.getLogger(SpotTicketPage.class);
    }

    public void checkRedirectionOfSpotTicketPage() {

        log.info("The user is on Home Page and clicking on Spot Ticket option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnDailyOps = getElement(properties.getProperty("btnDailyOps"));

// STEP 1: Hover on "Daily Ops Data"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnDailyOps));
        actions.moveToElement(btnDailyOps).perform();

// STEP 2: Wait for Spot Ticket link to become visible/clickable
        WebElement btnSpotTicket = getElement(properties.getProperty("btnSpotTicket"));
        WebElement spotTicket = wait.until(ExpectedConditions.elementToBeClickable(btnSpotTicket));
        if (spotTicket.isDisplayed()) {
            spotTicket.click();
            expectedHeading = "Spot Ticket Waybills";
            actualHeading = getElement(properties.getProperty("textSpotTicket")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Spot Ticket page is loading correctly");
        }

        else {
            log.info("The Spot Ticket option is not available for this user");
        }

    }
}
