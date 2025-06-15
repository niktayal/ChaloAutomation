package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PrepaidCardMasterPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public PrepaidCardMasterPage() {
        log = LogManager.getLogger(PrepaidCardMasterPage.class);
    }

    public void checkRedirectionOfPrepaidCardMasterPage() {

        log.info("The user is on Home Page and clicking on Prepaid Card Master option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Prepaid Cards link to become visible/clickable
        WebElement btnPrepaidCardMaster = getElement(properties.getProperty("btnPrepaidCardMaster"));
        WebElement cardMaster = wait.until(ExpectedConditions.elementToBeClickable(btnPrepaidCardMaster));
        if (cardMaster.isDisplayed()) {
            cardMaster.click();
            expectedHeading = "Prepaid Card Master";
            actualHeading = getElement(properties.getProperty("textPrepaidCardMaster")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Prepaid Card Master page is not loading");
        }

        else {
            log.info("The Prepaid card master option is not available for this user");
        }
    }
}
