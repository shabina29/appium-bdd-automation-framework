package com.framework.driver;

import io.appium.java_client.android.AndroidDriver;

public class DriverManager {    // ThreadLocal driver for parallel execution
    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

    // Private constructor to prevent object creation
    private DriverManager() {}

    // Set driver
    public static void setDriver(AndroidDriver androidDriver) {
        driver.set(androidDriver);
    }

    // Get driver
    public static AndroidDriver getDriver() {
        return driver.get();
    }

    // Quit driver
    public static void quitDriver() {

        AndroidDriver androidDriver = driver.get();

        if (androidDriver != null) {
            androidDriver.quit();
            driver.remove();
        }
    }

}
