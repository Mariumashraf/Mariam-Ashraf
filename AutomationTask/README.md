# Mariam-Ashraf

## Test Automation Framework
#### Test Automation Framework to perform UI and API Tests with a Data Driven Framework and Page Object Model design pattern using Java, Selenium Webdriver, RestAssured, TestNG, POM, and Maven.
## Features:
* Reading data from Properties, Excel and Json files.
* Running on multiple browsers besides headless running.
* Taking screenshots and logger.
* Logging.
* Generating Extent report.

## Setup:
#### 1. Download Intellij or Eclipse
#### 2. Download java jdk
#### 3. Clone this project and open it

# Third Part:
## Automated test cases for facebook  registration and login scenarios

### 1. Registration scenarios:
#### A. Register with 3 users' valid data stored in an Excel file, check that the user is registered successfully, and the home page is displayed.
#### B. Register with 8 users' invalid data stored in JSON file, and check that an error message appears.
 - Register with a blank first name and validate on error message.
 - Register with a blank last name and validate on error message.
 - Register with a blank email and validate on error message.
 - Register with a blank confirm email and validate on error message. 
 - Register with a blank password and validate on error message.
 - Register with a blank birth date and validate on error message.
 - Register with a blank gender and validate on error message.

### 2. Login scenarios:
#### A. Login with 1 user valid data stored in an JSON file, check that the user is logged in successfully, and the home page is displayed.
#### B. Login with 4 users' invalid data stored in JSON file, and check that an error message appears.
 - Login with a blank email, blank password and validate on error message.
 - Login with a invalid email, invalid password and validate on error message.
 - Login with a valid email, invalid password and validate on error message.
 - Login with a invalid email, valid password and validate on error message.

#### 3. Execution: 
  - #### Run facebookRunner.xml 
   - #### Check Extent generated report 'BestBuyTestResult.html' at 'TestReport' folder
# Fourth Part
## Automated tests for Best Buy APIs

#### 1. List of test cases Proposed For Automation:

| EndPoint       | Request Type          |Scenario |Script Name|
| ------------- |:-------------:|:-------------:||:-------------:||
|Products|Post|Verify that I can't add a new product with an empty body|addNewProductWithEmptyBody()|
|Products|Post|Verify that i can add a new product successfully|addNewProduct()|
|Products|Get|Verify that I can get a product successfully by valid id|getProductByValidId()|
|Products|Get|Verify that I can't get a product by invalid id and get an error message|getProductByInvalidId()|
|Products|Patch|Verify that I can update product's name successfully by valid id|updateProductName()|
|Products|Delete|Verify that I can delete a product successfully by valid id|deleteProductById()|
|Products|Delete|Verify that I can delete a product successfully by invalid id|deleteProductByInvalidId()|
|Stores|Post|Verify that i can add a new store successfully|addNewStore()|
|Stores|Get|Verify that I can get a store successfully by valid id|getStoreByValidId()|
|Stores|Get|Verify that I can get stores by state name|getStoresByState()|
|Services|Post|Verify that i can add a new service successfully|addNewService()|
|Services|Get|Verify that I can get a service successfully by valid id|getServiceByValidId()|
|Services|Post|Verify that i can't add a new service with an empty name and get an error message|ValidateNameField()|
|Services|Post|Verify that i can't add a new service with a name longer than 100 characters and get an error message|ValidateNameField()|
|Categories|Post|Verify that i can add a new category successfully|addNewCategory()|
|Version|Get|Verify that I can get app version successfully|getVersion() |
|HealthCheck|Get|Verify that I can get system information 'number of products, stores and categories'|getSystemInfo()|
|HealthCheck,Categories|Post, Get|Verify that categories number increases by 1 after adding a new category|addCategoryAndCheckSystemInfo()|

#### 2. Execution:
 - #### Run  bestBuyRunner.xml
 - #### Check Extent generated report 'FacebookTestResult.html' at 'TestReport' folder


