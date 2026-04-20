package com.framework.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.framework.driver.DriverManager;

public class ScreenshotUtils {


public static String takeScreenshot(String testName) {
    File src = ((TakesScreenshot) DriverManager.getDriver())
            .getScreenshotAs(OutputType.FILE);

    String path = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

    try {
        Files.copy(src.toPath(), Paths.get(path));
    } catch (IOException e) {
        e.printStackTrace();
    }

    return path;
}

}
