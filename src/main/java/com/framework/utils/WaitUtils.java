package com.framework.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.driver.DriverManager;

public class WaitUtils {


private static final int TIMEOUT = 15;

private static WebDriverWait getWait() {
    return new WebDriverWait(
            DriverManager.getDriver(),
            Duration.ofSeconds(TIMEOUT)
    );
}

public static WebElement waitForVisibility(By locator) {
    return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static WebElement waitForClickability(By locator) {
    return getWait().until(ExpectedConditions.elementToBeClickable(locator));
}


}
