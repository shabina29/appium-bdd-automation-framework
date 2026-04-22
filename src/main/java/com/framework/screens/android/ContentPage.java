package com.framework.screens.android;

import io.appium.java_client.AppiumBy;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.framework.driver.DriverManager;

public class ContentPage {

    // ================= LOCATORS =================

    private final String CONTENT = "Content";

    // ================= ACTIONS =================

    public void clickContent() {

        // 👉 Scroll to element first (important for mobile apps)
        DriverManager.getDriver().findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true))"
                                + ".scrollIntoView(new UiSelector().description(\"Content\"))"
                )
        );

        // 👉 Explicit wait (fix for flakiness)
        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10)
        );

        WebElement contentElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId(CONTENT)
                )
        );

        contentElement.click();
    }

    public void clickMenu(String menu) {

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10)
        );

        WebElement menuElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId(menu)
                )
        );

        menuElement.click();
    }

    public void clickMultipleTimes(String menu) {

        clickContent(); // navigate first

        for (int i = 0; i < 3; i++) {

            clickMenu(menu);

            DriverManager.getDriver().navigate().back();
        }
    }

    public void pressBack() {
        DriverManager.getDriver().navigate().back();
    }

    // ================= VALIDATIONS =================

    public boolean isContentDisplayed() {

        try {
            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(10)
            );

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.accessibilityId("Assets")
                    )
            );

            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isMenuVisible(String menu) {

        try {
            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(10)
            );

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.accessibilityId(menu)
                    )
            );

            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHomeScreenDisplayed() {

        try {
            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(10)
            );

            WebElement element = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.accessibilityId("API Demos")
                    )
            );

            return element.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void scrollScreen() {
        System.out.println("Scrolling screen...");
    }

    public boolean validateAccessibility(String element) {

        try {
            WebDriverWait wait = new WebDriverWait(
                    DriverManager.getDriver(),
                    Duration.ofSeconds(10)
            );

            WebElement el = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.accessibilityId(element)
                    )
            );

            return el.isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    public void invalidElementCheck() {

        // Negative scenario
        DriverManager.getDriver()
                .findElement(AppiumBy.id("invalid_id"));
    }

    public long measureLoadTime(String element) {

        long start = System.currentTimeMillis();

        WebDriverWait wait = new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(10)
        );

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        AppiumBy.accessibilityId(element)
                )
        );

        long end = System.currentTimeMillis();

        return end - start;
    }
}