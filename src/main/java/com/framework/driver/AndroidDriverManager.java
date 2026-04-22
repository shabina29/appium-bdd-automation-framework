package com.framework.driver;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverManager {


public static void createDriver(String deviceName, String systemPort) {

    try {

        String appPath = System.getProperty("user.dir")
                + "/src/test/resources/apps/ApiDemos-debug.apk";

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:deviceName", deviceName);
        caps.setCapability("appium:udid", deviceName);
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability("appium:systemPort", Integer.parseInt(systemPort));

        // App
        caps.setCapability("appium:app", appPath);
        caps.setCapability("appium:appPackage", "io.appium.android.apis");
        caps.setCapability("appium:appActivity", ".ApiDemos");

        // Stability
        caps.setCapability("appium:noReset", false);
        caps.setCapability("appium:autoGrantPermissions", true);

        URL url = new URL("http://127.0.0.1:4723/");

        AndroidDriver driver = new AndroidDriver(url, caps);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        DriverManager.setDriver(driver);

        System.out.println("✅ Driver initialized for device: " + deviceName);

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("❌ Failed to initialize Android Driver", e);
    }
}


}
