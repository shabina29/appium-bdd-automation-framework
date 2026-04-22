package com.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.framework.utils.WaitUtils;

public class ElementActions {

public void click(By locator) {
    WaitUtils.waitForClickability(locator).click();
}

public void type(By locator, String text) {
    WebElement element = WaitUtils.waitForVisibility(locator);
    element.clear();
    element.sendKeys(text);
}

// ✅ ADD THIS METHOD
public boolean isVisible(By locator) {
    try {
        WaitUtils.waitForVisibility(locator);
        return true;
    } catch (Exception e) {
        return false;
    }
}


}
