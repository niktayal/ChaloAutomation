package com.org.chalo.pages;

import com.org.chalo.base.TestBase;
import com.org.chalo.util.Constants;
import org.apache.commons.lang3.time.DurationUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class Logout extends TestBase {

    public Logout() {
        log = LogManager.getLogger(Logout.class);
    }

    public void clicklogoutBtn(){
        log.info("Clicking on the logout button");

        getElement(properties.getProperty("btnLogout")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(getElement(properties.getProperty("confLogout"))));

        getElement(properties.getProperty("confLogout")).click();

        wait.until(ExpectedConditions.visibilityOf(getElement(properties.getProperty("btnSingIn"))));

    }

    public boolean isLoggedOut() throws InterruptedException {
        return Objects.requireNonNull(driver.getCurrentUrl()).contains("login");

        }
}
