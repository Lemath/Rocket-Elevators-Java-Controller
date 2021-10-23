# Rocket-Elevators-Java-Controller
### Description

This project simulate the selection and movement logic for elevators in a commercial building and is written in Java.

When someone want to call an elevator from the lobby, he will first select his destination. The controller will then decide which column of the battery to use and select the best elevator available to fill the request and carry the user to his selected floor. When someone call an elevator from a floor, the corresponding column will select his best available elevator to pick up the user and bring him back to the lobby.

### Installation

You will need Java JDK installed on your computer first

https://java.com/en/download/help/download_options.html

### Running the tests

Tests are run using maven

https://maven.apache.org/install.html

To run the tests, access the root directory of the project in your command line and enter :

`mvn clean test`

You should get the following result :

![Java-test](https://user-images.githubusercontent.com/56204810/138535714-be54c7b0-1c70-4c1d-9015-48d9ad0d3b57.jpg)
