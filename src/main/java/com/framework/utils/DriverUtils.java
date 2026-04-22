package com.framework.utils;

import com.framework.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public class DriverUtils {


private static AndroidDriver getDriver() {
    return (AndroidDriver) DriverManager.getDriver();
}

public static void launchApp() {
    getDriver().activateApp("io.appium.android.apis");
}

public static void closeApp() {
    getDriver().terminateApp("io.appium.android.apis");
}

public static void backgroundApp(int seconds) {
    getDriver().runAppInBackground(java.time.Duration.ofSeconds(seconds));
}


}

