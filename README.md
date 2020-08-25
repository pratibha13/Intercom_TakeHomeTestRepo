# Intercom_TakeHomeTestRepo

# Customer Records Application

This is the application written in Spring Boot to output the customer details from the txt file within the specified distance of the organization located in Dublin. This is a take home test for Intercom


## Pre-requisites

You would need JDK 8 or above and  Apache Maven 3.5.4 or above installed in your system.
To install Maven, you can refer https://maven.apache.org/install.html


## Clone the repository

You need to clone the entire repository in order to run the code

## Building the code

First, you need to navigate to the path where you have cloned the code.
Then run the command "mvn clean install" to build the code

C:\<your repo path>\ cusRecords> mvn clean install

You should see "Build Successful"

## Running the tests

To run specifically the test, you need to run the command "mvn test" from your repo path.

## Running the code

To run the Spring boot application for the customer records, you need to run the command "mvn spring-boot:run", this will start your application at the port 8080.

## API Specifications
Open the browser and type http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
this will open the Swagger API details.
Currently there is only one end point /customersWithinGivenDistance.
This takes one argument "distance". The default value of distance is 100 km. 

## Running the application

Open browser and type [http://localhost:8080/customersWithinGivenDistance](http://localhost:8080/customersWithinGivenDistance)
You will see the list of all the customers which are within 100km distance from Dublin.

In case you want to change the distance, use the query parameter "distance"

http://localhost:8080/customersWithinGivenDistance?distance=200

This will display the list of customers within 200 Km distance from Dublin.

To get a better view, recommendation would be to use "Postman" app. You can download it from here -> https://www.postman.com/downloads/ 


