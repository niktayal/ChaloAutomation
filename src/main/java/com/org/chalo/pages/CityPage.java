package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CityPage extends TestBase {
    private String expectedHeading;
    private String actualHeading;


    public CityPage() {
        log = LogManager.getLogger(CityPage.class);
    }

    public void checkRedirectionOfCityPage() throws InterruptedException {

        log.info("The user is on Home Page and clicking on City Page option");

        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(getElement(properties.getProperty("btnCityManagement"))));
        Actions actions = new Actions(driver);

        WebElement btnCityManagement = getElement(properties.getProperty("btnCityManagement"));

// STEP 1: Hover on "City Management"
        WebElement cityManagement = wait.until(ExpectedConditions.visibilityOf(btnCityManagement));
        actions.moveToElement(btnCityManagement).perform();

// STEP 2: Wait for City link to become visible/clickable
        WebElement btnCity = getElement(properties.getProperty("btnCity"));
        btnCity.click();
        WebElement city = wait.until(ExpectedConditions.elementToBeClickable(btnCity));
        if (city.isDisplayed()) {
            city.click();
            expectedHeading = "City";
            actualHeading = getElement(properties.getProperty("textCity")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The City page is not loading");
        }

        else {
            log.info("The City option is not available for this user");
        }

    }
}
