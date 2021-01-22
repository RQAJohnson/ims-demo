Coverage: 32%
# Project Title: Inventory Management System

**Project Description:** A management system which tracks items, customers and orders. Allowing users to manager their inventory with ease.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
See Admin folder for ERD and UML diagrams. 

### Prerequisites

Technologies you need to download.


Eclipse: https://www.eclipse.org/downloads/
Java SE: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
Maven: : https://maven.apache.org/download.cgi
Mysql Workbench: https://dev.mysql.com/downloads/workbench/
Git: https://git-scm.com/


### Installing

* To **COMPLETE** the installation process follow the links below, some contain visual aids.


Eclipse: https://www.tutorialspoint.com/eclipse/eclipse_installation.htm``` When eclipse starts up for the first time it prompts you for the location of the workspace folder. 
All your data will be stored in the workspace folder. You can accept the default or choose a new location.

Java SE: https://www.javatpoint.com/javafx-how-to-install-java

Maven (as a build tool for Java): https://mkyong.com/maven/how-to-install-maven-in-windows/

Mysql Workbench:https://www.guru99.com/introduction-to-mysql-workbench.html``` 

Git: https://phoenixnap.com/kb/how-to-install-git-windows``` Once the installation is complete, tick the boxes to view the Release Notes or Launch Git Bash, 
then click Finish. For further instructions.





## Running the tests

Automated testing is the process of performing software testing with little human interaction it is used to achieve greater speed and efficiency 

For this application JUnit was used. Please see the **Unit Tests** description below.

### Unit Tests 
Unit testing, tests each unit of code in an application. For this application '**Junit**' was the framework used.

To run the test ensure that you have the right maven dependencies,
 
The proceed to **SELECT** the test class. **RIGHT CLICK** and there should be a promt **run as** and select Junit Test.
Running this test helps to detect and protect bugs inn the furture.


### Integration Tests 
Intergration testing, tests whether each individual module operate together.

To run the test create a dummy function copying the input values and what you expect to be returned. 
This is because we might have created unit tests for each class but we have not proven that they can communicate together.

The idea is to prove that each 'integration' of the application is functioning as expected.



## Deployment

In order to deploy this application onto a live site (GCP) you want to replace the "localhost" part of the URL and add in your local IP address.

EXAMPLE (Numbers given are example)

jdbc:mysql://localhost:3306/ims **>** jdbc:mysql://56.21.44.447:3306/ims



## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

* We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Rianna Johnson**, **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

* For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
