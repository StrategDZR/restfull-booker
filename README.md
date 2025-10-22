## Description
A lightweight Java framework for API testing of https://restful-booker.herokuapp.com/ using REST-assured, JUnit 5, Lombok, and Allure reports.

## How to run tests:

```mvn clean test```   
Tests will be executed in parallel

## How to open Allure report:

```mvn allure:serve```

## How to run test on different environments:
Place new properties file near [prod.properties](src/test/resources/prod.properties) with parameters of new environment.   
Start tests with ```-Denv=``` flag with name of new file after ```=```