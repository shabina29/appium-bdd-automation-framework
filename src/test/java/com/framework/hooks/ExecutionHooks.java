package com.framework.hooks;

import com.framework.driver.AndroidDriverManager;
import com.framework.driver.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ExecutionHooks {

@Before
public void setUp() {

    System.out.println("🚀 Starting Appium Driver...");

    // Device name & system port
    AndroidDriverManager.createDriver("emulator-5554", "8200");
}

@After
public void tearDown() {

    System.out.println("🛑 Closing Driver...");

    if (DriverManager.getDriver() != null) {
        DriverManager.getDriver().quit();
    }
}


}
