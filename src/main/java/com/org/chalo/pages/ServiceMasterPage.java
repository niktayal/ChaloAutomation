package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ServiceMasterPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public ServiceMasterPage() {
        log = LogManager.getLogger(ServiceMasterPage.class);
    }

    public void checkRedirectionOfServiceMasterPage() {

        log.info("The user is on Home Page and clicking on Service Master option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Service Master link to become visible/clickable
        WebElement btnServiceMaster = getElement(properties.getProperty("btnServiceMaster"));
        WebElement serviceMaster = wait.until(ExpectedConditions.elementToBeClickable(btnServiceMaster));
        if (serviceMaster.isDisplayed()) {
            serviceMaster.click();
            expectedHeading = "Service Master";
            actualHeading = getElement(properties.getProperty("textServiceMaster")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Service Master page is not loading");
        }

        else {
            log.info("The Service Master option is not available for this user");
        }

    }
}
