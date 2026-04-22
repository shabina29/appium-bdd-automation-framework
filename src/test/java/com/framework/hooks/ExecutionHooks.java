package com.framework.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.framework.driver.DriverManager;
import com.framework.driver.AndroidDriverManager;

public class ExecutionHooks {

    @Before
    public void setUp() {
        System.out.println("🚀 Starting Appium Driver...");
        AndroidDriverManager.createDriver("emulator-5554", "8200");
    }

    @After
    public void tearDown(Scenario scenario) {

        // 👉 Capture screenshot only on failure
        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        System.out.println("🛑 Closing Driver...");
        DriverManager.quitDriver();
    }
}