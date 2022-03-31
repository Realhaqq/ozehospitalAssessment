# OzeHospital

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![Coverage Status](https://coveralls.io/repos/github/codecentric/springboot-sample-app/badge.svg?branch=master)](https://coveralls.io/github/codecentric/springboot-sample-app?branch=master)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

OzeHospital [Spring Boot](http://projects.spring.io/spring-boot/) app.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.oze.ozehospital.OzehospitalApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Change the Databse Configuration
OzeHostpital uses a relational database. You can change the database configuration by editing the `application.properties` file and `liquibase.properties`.


## PostMan Collection
Use postman to test all the api request and response.

https://www.postman.com/lively-satellite-572983/workspace/samiu/collection/8155479-e7a64694-2173-4b2d-a0a1-e9ad8402e3e2?ctx=documentation
