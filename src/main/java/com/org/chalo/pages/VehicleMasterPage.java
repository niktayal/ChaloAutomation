package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class VehicleMasterPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public VehicleMasterPage() {
        log = LogManager.getLogger(VehicleMasterPage.class);
    }

    public void checkRedirectionOfVehicleMasterPage() {

        log.info("The user is on Home Page and clicking on Vehicle Master option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Vehicle Master link to become visible/clickable
        WebElement btnVehicleMaster = getElement(properties.getProperty("btnVehicleMaster"));
        WebElement vehicleMaster = wait.until(ExpectedConditions.elementToBeClickable(btnVehicleMaster));
        if (vehicleMaster.isDisplayed()) {
            vehicleMaster.click();
            expectedHeading = "Vehicle Master";
            actualHeading = getElement(properties.getProperty("textVehicleMaster")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Vehicle Master page is loading correctly");
        }

        else {
            log.info("The Vehicle Master option is not available for this user");
        }

    }
}
