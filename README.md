# SpringMVCAppFix

Simple CRUD application implementing Internet Recruitment System.

Application is driven by embedded Tomcat server and HSQL database.

## Quick start

1. Download and unpack *.zip 
2. Inside unzipped directory run 
```mvn package```
3. ```java -jar target/standalone.jar```
4. Point your browser to http://localhost:8080/standalone

## Requirements

1. JRE (JDK) >= 7
2. Apache Maven 3

## Tools:

- Spring MVC
- Hibernate
- Spring Data JPA
- Spring Security
- Hibernate Validation
- Tomcat
- HSQL DB


View is rendered by simple *.jsp files with bootstrap support.



Application gives a simple API to check registered users.

```
http://localhost:8080/standalone/product/${id}/api/users
```
where ```${id}``` is the auto generated id.

To do:

1. Implement services and DAO to meet Model-View-Controller requirements.
2. Take care about unsupported error view after trying to add two identical job offers.
3. Add CV file uploader.
4. Change JSP to modern JS frontend.
5. Implement categories while posting a new job offers.
