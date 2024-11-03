# Swag Labs Login Automation Test Framework

This project is a test automation framework for verifying the login functionality of
the [Swag Labs](https://www.saucedemo.com/) website. The tests are designed to validate the login form under various
scenarios and ensure robust error handling.

## Project Structure

- **Programming Language**: Java 21
- **Test Automation Tool**: Selenium WebDriver
- **Project Builder**: Maven
- **Browsers Supported**: Firefox, Edge, Chrome
- **Test Runner**: JUnit
- **Locators**: XPath
- **Assertions**: Hamcrest
- **Logging**: SLF4J
- **BDD**: Cucumber
- **Patterns**: Singleton, Page object

## Execution

There are two different implementations of tests: with Junit5 and with Cucumber. Both options support parallel
execution, logging and multiple browsers.

**1. Junit 5 tests can be executed with this command:**

   ```
   mvn clean test -Dtest=SauceDemoTest -Dbrowser=chrome
   ```
Available browsers: chrome, firefox, edge

**2. Cucumber tests can be executed with this command:**

```
mvn test -Dtest=RunCucumberTest -Dbrowser=edge
``` 
Available browsers: chrome, firefox, edge

## Test Cases

The framework includes three main use cases (UCs) for testing the login functionality:

### UC-1: Test Login with Empty Credentials

### UC-2: Test Login with Missing Password

### UC-3: Test Login with Valid Credentials

### Prerequisites

- Ensure that [Maven](https://maven.apache.org/) is installed and configured in your environment.
- Install the necessary web drivers (e.g., GeckoDriver for Firefox, EdgeDriver for Edge).

