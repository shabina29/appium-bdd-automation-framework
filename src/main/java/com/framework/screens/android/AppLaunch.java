package com.framework.screens.android;

import org.openqa.selenium.By;

import com.framework.utils.ElementActions;

public class AppLaunch {


// Create object of actions class
ElementActions actions = new ElementActions();

// Locator for "API Demos" title on home screen
private By homeTitle = By.xpath("//android.widget.TextView[@text='API Demos']");

// Method to verify app launch
public boolean isHomeScreenDisplayed() {
    return actions.isVisible(homeTitle);
}


}

