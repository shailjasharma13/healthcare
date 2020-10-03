Project title
Microservice/webservice for tracking status of enrollees in a health care program.

Build status
Spring Boot and Maven to build the project

Tech/framework used
The code is written in JAVA and uses Spring Web, Spring Data dependency of Spring Boot listed in pom.xml

Installation
Install MySQL and change application.properties file to update database url ,username and password

 Create Tables :

 Create table enrollee(
   enrollee_id INT NOT NULL AUTO_INCREMENT,
   name_en VARCHAR(100) NOT NULL,
   activation_status BIT NOT NULL,
   phone_number INT,
   birth_date DATE,
   PRIMARY KEY ( enrollee_id )
);

Create table dependents(
   dependent_id INT NOT NULL AUTO_INCREMENT,
   dependent_name VARCHAR(100) NOT NULL,
   birth_date DATE,
   enrollee_id INT REFERENCES enrollee(enrollee_id),
   PRIMARY KEY ( dependent_id )
);

Insert Enrollee:

INSERT INTO enrollee
   (name_en, activation_status, phone_number,birth_date)
   VALUES
   ('Mark', 1, 813234543, '1989-03-03');

Insert Dependents:

INSERT INTO dependents
(dependent_name, birth_date, enrollee_id)
VALUES
('Maria', '2018-05-03', 1);

INSERT INTO dependents
(dependent_name, birth_date, enrollee_id)
VALUES
('Mia', '1991-07-02', 1);

How to use?
Use Postman or use web browser

GET Enrollee:
http://localhost:8080/enrollees

POST Enrollee:
http://localhost:8080/enrollees
{
    "name": "Ryan",
    "activationStatus": "False",
    "phoneNumber": 123456324,
    "birthDate": "1991-10-03"
}

PUT Enrollee:
http://localhost:8080/enrollees/2
{
    "name": "Ryan",
    "activationStatus": "True",
    "phoneNumber": 123456324,
    "birthDate": "2012-10-03"
}

DELETE Enrollee:
http://localhost:8080/enrollees/2

GET Dependents:
http://localhost:8080/enrollees/1/dependents

CREATE Dependents:
http://localhost:8080/enrollees/2/dependents
{
    "dependentName": "Ada",
    "birthDate": "2019-05-05"
}

PUT Dependents:
http://localhost:8080/enrollees/2/dependents/3
{
    "dependentName": "Ada",
    "birthDate": "2001-06-05"
}

DELETE All Dependents:
http://localhost:8080/enrollees/1/dependents
