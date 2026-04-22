# 📱 Mobile Automation Framework (Appium + BDD)

## 🔹 Overview

This project is a mobile automation framework built using **Appium**, **Java**, **Cucumber (BDD)**, and **TestNG**.
It is designed to automate Android application testing with a scalable and maintainable structure.

In my current setup, I focus on automating stable modules and running regression suites efficiently using Jenkins.

---

## 🔹 Tech Stack

* Java
* Appium
* Selenium (for web if needed)
* Cucumber (BDD)
* TestNG
* Maven
* Git & GitHub
* Jenkins (CI/CD)

---

## 🔹 Project Structure

src/main/java
├── driver → Driver setup and capabilities
├── screens → Page Object classes
├── utils → Utility classes

src/test/java
├── runner → TestNG runner files

src/test/resources
├── features → Cucumber feature files
├── testdata → Test data
├── apps → APK files

---

## 🔹 Key Features

✔ BDD-based framework using Cucumber
✔ Page Object Model design pattern
✔ Supports Android automation using Appium
✔ Maven-based build management
✔ Easy integration with Jenkins
✔ Scalable and maintainable structure

---

## 🔹 How to Run Tests

### Run via Maven:

mvn clean test

---

## 🔹 Jenkins Integration

The framework is integrated with Jenkins to run regression suites automatically.
Builds are triggered using Maven goals and reports are generated after execution.

---

## 🔹 Future Enhancements

* Parallel execution support
* Allure/Extent reporting
* Cross-device execution
* Cloud execution (BrowserStack)

---

## 🔹 Author

Shabina Shahin
SDET | QA Automation Engineer
