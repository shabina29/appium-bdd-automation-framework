package com.framework.utils;

import org.testng.*;
import com.aventstack.extentreports.*;

public class ExtentListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest t = extent.createTest(result.getMethod().getMethodName());
        test.set(t);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());

        // attach screenshot
        String path = ScreenshotUtils.capture(result.getMethod().getMethodName());
        test.get().addScreenCaptureFromPath(path);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}