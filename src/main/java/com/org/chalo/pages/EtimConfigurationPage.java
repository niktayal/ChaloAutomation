package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class EtimConfigurationPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public EtimConfigurationPage() {
        log = LogManager.getLogger(EtimConfigurationPage.class);
    }

    public void checkRedirectionOfEtimConfigurationPage() {

        log.info("The user is on Home Page and clicking on ETIM Configuration option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for ETIM Configuration link to become visible/clickable
        WebElement btnETIMConfiguration = getElement(properties.getProperty("btnEtimConfig"));
        WebElement etimConfig = wait.until(ExpectedConditions.elementToBeClickable(btnETIMConfiguration));
        if(etimConfig.isDisplayed()) {
            etimConfig.click();
            expectedHeading = "ETIM Configuration";
            actualHeading = getElement(properties.getProperty("textEtimConfig")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The ETIM Configuration page is not loading");
        }

        else {
            log.info("The ETIM config option is not available for this user");
        }

    }
}
