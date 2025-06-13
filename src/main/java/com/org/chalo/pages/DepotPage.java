package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DepotPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public DepotPage() {
        log = LogManager.getLogger(DepotPage.class);
    }

    public void checkRedirectionOfDepotPage() {

        log.info("The user is on Home Page and clicking on Depot Page option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnCityManagement = getElement(properties.getProperty("btnCityManagement"));

// STEP 1: Hover on "City Management"
        WebElement cityManagement = wait.until(ExpectedConditions.visibilityOf(btnCityManagement));
        actions.moveToElement(btnCityManagement).perform();

// STEP 2: Wait for Depot link to become visible/clickable
        WebElement btnDepot = getElement(properties.getProperty("btnDepot"));
        WebElement depot = wait.until(ExpectedConditions.elementToBeClickable(btnDepot));
        if (depot.isDisplayed()) {
            depot.click();
            expectedHeading = "Depot";
            actualHeading = getElement(properties.getProperty("textDepot")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Depot page is loading correctly");
        }

        else {
            log.info("The Depot option is not available for this user");
        }

    }
}
