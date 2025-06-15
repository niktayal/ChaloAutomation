package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ScheduleMasterPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public ScheduleMasterPage() {
        log = LogManager.getLogger(ScheduleMasterPage.class);
    }

    public void checkRedirectionOfScheduleMasterPage() {

        log.info("The user is on Home Page and clicking on Schedule Master option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Schedule Master link to become visible/clickable
        WebElement btnScheduleMaster = getElement(properties.getProperty("btnScheduleMaster"));
        WebElement scheduleMaster = wait.until(ExpectedConditions.elementToBeClickable(btnScheduleMaster));
        if (scheduleMaster.isDisplayed()) {
            scheduleMaster.click();
            expectedHeading = "Schedule Master";
            actualHeading = getElement(properties.getProperty("textScheduleMaster")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Schedule Master page is not loading");
        }

        else {
            log.info("The Schedule Master option is not available for this user");
        }

    }
}
