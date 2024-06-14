# Apartment Block Utility Hub

This application is designed to provide a platform for apartment owners, residents, accountants, and member of the apartment block board to manage and track utility usage and important data regarding the apartment block.

## Table of contents
1. [Features](#features)
2. [Technologies Used](#technologies-used)
3. [Getting Started](#getting-started)
4. [Contributors](#contributors)

## Features
* Apartment owners can add information about the usage of water, gas, and other facilities if applicable.
* Users can view previous months' usages to track patterns and trends.
* Accountants can access the data to generate bills for each apartment.
* The member of the apartment block board can add and manage information about the apartments and other important data.

## Technologies Used
* Java
* Spring Boot
* Thymeleaf
* Database (MySQL)

## Getting Started
1. Clone the repository: 
   * git clone (repository-url)
   * cd (repository-directory)

2. Set up the application:
  2.1 Ensure you have Java and Maven installed on your machine.
  2.2 Build the project using Maven:
      * mvn clean install

3. Set up the database:
  3.1 Create a new database (MySQL, Postgres, etc.).
  3.2 Configure the database connection in the `application.properties` file located in `src/main/resources`. Update the following properties with your database information:
      * spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
      * spring.datasource.username=your-username
      * spring.datasource.password=your-password

4. Run the application:
  4.1 Start the Spring Boot application:
      * Start the Spring Boot application:

5. Access the application: 
  5.1 Open your web browser and navigate to `http://localhost:8080`

## Contributors
Liina, Indrek and Renar
