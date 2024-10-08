# API Cucumber Allure Test Automation Framework

## Overview
This is a test automation framework for API testing using Java, Cucumber, RestAssured and Allure.
Linking that components together makes it in easy way provide fast automated test implementation with clear reports generation.
That is not full version of framework, but it is a good start point for your own implementation.

## Features
1. **Cucumber** - BDD framework
2. **RestAssured** - Java library for RESTful API testing
3. **Allure** - Framework for generating test reports
4. Test running possible from command line & IDE

## Prerequisites
1. **Java** - should be installed and configured
2. **Maven** - should be installed and configured

## How to run tests
1. Clone the repository
2. Open terminal and navigate to the project directory
3. Run the following command:
```mvn clean test```
4. To generate Allure report run:
```mvn allure:serve```

## Notes
Tests implemented as example with one failed to show how Allure report looks like in that case. 