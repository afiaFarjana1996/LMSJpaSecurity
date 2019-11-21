# LMS Librarian Part
This project has the functionalities of a Librarian of LMS project.

# Technologies-Used
This is a Java8 project built in Spring-boot framework

1. embedded servlet-container- apache tomcat

2. build tool- maven

3. relational database-mysql

4. JPA Jibernate- map database table elements to objects in class

4. API testing tool-postman

# Package-Description
1.Entity package: This package has all the classes of plain old java objects. Each class has private fields that correspond to relative table column and getter setter methods for setting value of the fields and getter method for getting that value.

2.Dao package: This package has all the classes of data access objects. JPA Hibernate was used to map relational database informations to objects in class.

3.Service package: This package has all the classes for service layer classes where we define the business logic. Methods in these classes uses methods from dao classes.

4.Controller package: This package has all the controller classes. These classes contain all the definition for the api endpoints.
