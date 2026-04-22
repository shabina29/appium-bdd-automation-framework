package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = "src/test/resources/features",
glue = {"com.framework.stepdefinitions","com.framework.hooks"},
plugin = {"pretty"},
monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
