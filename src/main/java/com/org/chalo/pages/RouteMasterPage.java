package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class RouteMasterPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public RouteMasterPage() {
        log = LogManager.getLogger(RouteMasterPage.class);
    }

    public void checkRedirectionOfRouteMasterPage() {

        log.info("The user is on Home Page and clicking on Route Master option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Route Master link to become visible/clickable
        WebElement btnRouteMaster = getElement(properties.getProperty("btnRouteMaster"));
        WebElement routeMaster = wait.until(ExpectedConditions.elementToBeClickable(btnRouteMaster));
        if (routeMaster.isDisplayed()) {
            routeMaster.click();
            expectedHeading = "Route Master";
            actualHeading = getElement(properties.getProperty("textRouteMaster")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Route Master page is loading correctly");
        }

        else {
            log.info("The Route master option is not available for this user");
        }

    }
}
