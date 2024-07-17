# Teladoc Automation Framework

## Overview

This UI Testing Framework automates the testing of web applications. It is built using Java, Selenium, Cucumber, JUnit, and Maven.

## Table of Contents

- Prerequisites
- Installation
- Project Structure
- Running Tests
- Configuration
- Reporting


## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- Java JDK 8 or higher
- Apache Maven
- Google Chrome (for ChromeDriver)
- ChromeDriver supplied by newer version of Selenium

## Installation

1. **Clone the repository**:


    git clone https://github.com/akyn-git/TeladocAutomation.git
    cd TeladocAutomation


2. **Install the project dependencies**:

   mvn clean install

## Project Structure

TeladocAutomation
- pom.xml`: Maven configuration file.
- configuration.properties`: Configuration file for browser settings and other properties.
- src/main/java`: Contains the framework's core classes.
- src/test/java`: Contains the test runner and step definitions.
- src/test/resources`: Contains the feature files.


### Feature Files

Feature files are written in Gherkin syntax and stored in the `src/test/resources/teladoc` directory.

### Step Definitions

Step definitions are Java methods that correspond to the steps in your feature files. They are located in the `src/test/java/com/teladoc/step_definitions` directory.

### Runner Class

The Runner class is used to run the Cucumber tests and is located in the `src/test/java/com/teladoc/runners` directory.

## Running Tests

To run the tests, use the following Maven command:


mvn clean verify

This command will run the test and generate html reports


This command will execute the tests defined in the feature files using the step definitions and configuration provided.

## Configuration

The `configuration.properties` file contains configuration settings such as browser type and base URL.

Example `configuration.properties`:
browser=chrome
url=https://www.way2automation.com/angularjs-protractor/webtables/

## Reporting

Test results are generated in the `reports/html-reports` directory. The reports are in HTML format and can be opened in a web browser for detailed test execution results.






