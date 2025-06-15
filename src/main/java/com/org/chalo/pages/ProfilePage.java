package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProfilePage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public ProfilePage() {
        log = LogManager.getLogger(ProfilePage.class);
    }

    public void checkRedirectionOfProfilePage() {

        log.info("The user is on Home Page and clicking on Profile Page option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        //WebElement btnProfile = getElement(properties.getProperty("btnProfile"));

/*// STEP 1: Hover on "Profile"
        WebElement profile = wait.until(ExpectedConditions.visibilityOf(btnProfile));
        actions.moveToElement(btnProfile).perform();*/

// STEP 2: Wait for Profile link to become visible/clickable
        WebElement btnProfile = getElement(properties.getProperty("btnProfile"));
        WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(btnProfile));
        if (profile.isDisplayed()) {
            profile.click();
            expectedHeading = "Profile";
            actualHeading = getElement(properties.getProperty("txtProfile")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Profile page is not loading");
        }

        else {
            log.info("The Profile option is not available for this user");
        }

    }
}
