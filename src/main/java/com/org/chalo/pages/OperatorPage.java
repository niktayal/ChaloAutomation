package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class OperatorPage extends TestBase {

    private String expectedHeading;
    private String actualHeading;


    public OperatorPage() {
        log = LogManager.getLogger(OperatorPage.class);
    }

    public void checkRedirectionOfOperatorPage() {

        log.info("The user is on Home Page and clicking on Operator option");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        WebElement btnMasterData = getElement(properties.getProperty("btnMasterData"));

// STEP 1: Hover on "Master Data"
        WebElement masterData = wait.until(ExpectedConditions.visibilityOf(btnMasterData));
        actions.moveToElement(btnMasterData).perform();

// STEP 2: Wait for Operator link to become visible/clickable
        WebElement btnOperator = getElement(properties.getProperty("btnOperator"));
        WebElement operator = wait.until(ExpectedConditions.elementToBeClickable(btnOperator));
        if(operator.isDisplayed()) {
            operator.click();
            expectedHeading = "Operator";
            actualHeading = getElement(properties.getProperty("textOperator")).getText();

            Assert.assertEquals(expectedHeading.toLowerCase(), actualHeading.toLowerCase(), "The Operator page is not loading");
        }

        else {
            log.info("The Operator option is not available for this user");
        }

    }
}
