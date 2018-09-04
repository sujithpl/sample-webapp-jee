# Purpose
To demonstrate how to build a REST API backend that integrates with an external API and persists data on a relational database. This project only uses standard JEE components and their reference implementations.

# Pre-requisites
To run the application, the environment will need to be set up with the following:
- JDK 1.8
- Maven 3.2+
- REST API client such as Postman or SOAPUI to test the end points

# Execution
*Please note that the application is currently set up to run on an embedded Jetty server with an embedded H2 database.*

To run the tests, use the following command.
`mvn test`

To run the application, use the following command.
`mvn jetty:run`

# Backlog
Potential improvements include the following:
- Use BigDecimal data type for currency.
- Include more exception handling scenarios.
- Increase unit test coverage.
- Write integration tests for the Resouce class.

