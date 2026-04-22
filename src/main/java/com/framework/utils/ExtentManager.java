package com.framework.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String reportPath = System.getProperty("user.dir")
                    + "/test-output/ExtentReport.html";

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
            spark.config().setReportName("Mobile Automation Report");
            spark.config().setDocumentTitle("Execution Results");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Environment", System.getProperty("env", "QA"));
            extent.setSystemInfo("Device", System.getProperty("device", "ANDROID"));
        }
        return extent;
    }
}