package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AccountPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public AccountPage() {
        log = LogManager.getLogger(AccountPage.class);
    }

    public void checkRedirectionOfAccountPage() {

        log.info("The user is on Home Page and clicking on Account Page option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnCityManagement = getElement(properties.getProperty("btnCityManagement"));

// STEP 1: Hover on "City Management"
        WebElement cityManagement = wait.until(ExpectedConditions.visibilityOf(btnCityManagement));
        actions.moveToElement(btnCityManagement).perform();

// STEP 2: Wait for Account link to become visible/clickable
        WebElement btnAccount = getElement(properties.getProperty("btnAccount"));
        WebElement account = wait.until(ExpectedConditions.elementToBeClickable(btnAccount));
        if (account.isDisplayed()) {
            account.click();
            expectedHeading = "Account";
            actualHeading = getElement(properties.getProperty("textAccount")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Account page is loading correctly");
        }

        else {
            log.info("The Account option is not available for this user");
        }

    }
}
