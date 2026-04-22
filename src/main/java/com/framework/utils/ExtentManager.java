package com.framework.utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            // 👉 Dynamic path (works for both local + Jenkins workspace)
            String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

            System.out.println("📊 Extent Report Path: " + reportPath);
            // 👉 VERY IMPORTANT: Helps debug in Jenkins console

            ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

            spark.config().setReportName("Mobile Automation Report");
            // 👉 Report name shown in UI

            spark.config().setDocumentTitle("Execution Results");
            // 👉 Browser tab title

            extent = new ExtentReports();

            extent.attachReporter(spark);

            // 👉 System info (comes from Jenkins env variables)
            extent.setSystemInfo("Environment", System.getProperty("env", "QA"));
            extent.setSystemInfo("Device", System.getProperty("device", "ANDROID"));

            extent.setSystemInfo("Execution", "Jenkins CI");
            // 👉 Optional but strong for interview
        }

        return extent;
    }

    // ✅ IMPORTANT: Flush method (ensures report is written properly in Jenkins)
    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
/*
Test starts
   ↓
Call ExtentManager.getInstance()
   ↓
If first time 
 ↓
create report
Else 
 ↓
reuse existing report
   ↓
Tests log steps
   ↓
Report generated at end
 * 
 * ================================================================== 🎤
 * Interview Answer (Perfect)
 * 
 * “This class is used to initialize and manage the Extent Report using
 * Singleton pattern. It ensures that only one instance of the report is created
 * and reused across the framework.
 * 
 * It sets up the report path, configures the report UI using
 * ExtentSparkReporter, and adds system-level information like environment and
 * device.
 * 
 * Actual logging and screenshot attachment are handled in test classes or
 * hooks.”
 */