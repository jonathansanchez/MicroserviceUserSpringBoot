# Microservice using Spring Boot on Docker
Microservice example to manipulate users on Docker 🐳

Create package:

```
$ mvn clean package
```
If you have Maven Plugin:
```
$ ./mvnw clean package
```
If you only want to run as a Spring Boot application:
```
$ mvn spring-boot:run
```
or 
```
$ ./mvnw spring-boot:run
```
Example table in MySQL:
```
create table user
(
  id        int          not null primary key,
  name      varchar(128) not null,
  last_name varchar(128) not null,
  email     varchar(128) not null,
  password  varchar(255) not null
);
```
