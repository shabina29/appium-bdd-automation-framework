package com.framework.utils;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.framework.driver.DriverManager;

import io.appium.java_client.android.AndroidDriver;

public class GestureUtils {

private static AndroidDriver getDriver() {
    return (AndroidDriver) DriverManager.getDriver();
}

// ✅ Swipe (W3C / Appium 2)
public static void swipeUp() {
    getDriver().executeScript("mobile: swipeGesture", Map.of(
            "direction", "up",
            "percent", 0.75
    ));
}

public static void swipeDown() {
    getDriver().executeScript("mobile: swipeGesture", Map.of(
            "direction", "down",
            "percent", 0.75
    ));
}

// ✅ Scroll
public static void scrollDown() {
    getDriver().executeScript("mobile: scrollGesture", Map.of(
            "direction", "down",
            "percent", 0.8
    ));
}

public static void scrollUp() {
    getDriver().executeScript("mobile: scrollGesture", Map.of(
            "direction", "up",
            "percent", 0.8
    ));
}

// ✅ Tap using mobile command (simple & recommended)
public static void tap(int x, int y) {
    getDriver().executeScript("mobile: clickGesture", Map.of(
            "x", x,
            "y", y
    ));
}

// ✅ Tap using W3C (advanced)
public static void tapUsingW3C(int x, int y) {

    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    Sequence tap = new Sequence(finger, 1);

    tap.addAction(finger.createPointerMove(Duration.ZERO,
            PointerInput.Origin.viewport(), x, y));
    tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
    tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

    getDriver().perform(java.util.List.of(tap));
}


}


