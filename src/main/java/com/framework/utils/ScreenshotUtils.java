package com.framework.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import com.framework.driver.DriverManager;

public class ScreenshotUtils {

    public static String capture(String testName) {

        // 👉 Screenshot file path
        String path = System.getProperty("user.dir") + "/test-output/screenshots/" + testName + ".png";

        try {
            File src = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            File dest = new File(path);

            FileUtils.copyFile(src, dest);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}