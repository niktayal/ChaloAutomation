package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CollectionPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public CollectionPage() {
        log = LogManager.getLogger(CollectionPage.class);
    }

    public void checkRedirectionOfCollectionPage() {

        log.info("The user is on Home Page and clicking on Collection option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnDailyOps = getElement(properties.getProperty("btnDailyOps"));

// STEP 1: Hover on "Daily Ops Data"
        WebElement dailyOps = wait.until(ExpectedConditions.visibilityOf(btnDailyOps));
        actions.moveToElement(btnDailyOps).perform();

// STEP 2: Wait for Collection link to become visible/clickable
        WebElement btnCollection = getElement(properties.getProperty("btnCollection"));
        WebElement collection = wait.until(ExpectedConditions.elementToBeClickable(btnCollection));
        if (collection.isDisplayed()) {
            collection.click();
            expectedHeading = "Collection";
            actualHeading = getElement(properties.getProperty("textCollection")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Collection page is not loading");
        }

        else {
            log.info("The Collection option is not available for this user");
        }

    }
}
