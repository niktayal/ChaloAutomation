package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CrewMasterPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public CrewMasterPage() {
        log = LogManager.getLogger(CrewMasterPage.class);
    }

    public void checkRedirectionOfCrewMasterPage() {

        log.info("The user is on Home Page and clicking on Prepaid Card Master option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Crew Master link to become visible/clickable
        WebElement btnCrewMaster = getElement(properties.getProperty("btnCrewMaster"));
        WebElement crewMaster = wait.until(ExpectedConditions.elementToBeClickable(btnCrewMaster));
        if(crewMaster.isDisplayed()) {
            crewMaster.click();

            expectedHeading = "Crew Master";
            actualHeading = getElement(properties.getProperty("textCrewMaster")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Crew Master page is loading correctly");
        }

        else {
            log.info("The crew master option is not available for this user");
        }
    }
}
