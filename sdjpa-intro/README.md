[MySQL Docker Image](https://hub.docker.com/_/mysql/)  

Create MySQL in Docker container:
```shell
docker run -d -p 3306:3306 --name test-mysql -e MYSQL_DATABASE=bookdb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_USER=bookadmin -e MYSQL_PASSWORD=password mysql:8
```

Use `local` profile

---
Problem: cannot connect to MySQL from Docker using DBeaver, error: _Public Key Retrieval is not allowed_

Solution: [Connection Java - MySQL : Public Key Retrieval is not allowed](https://stackoverflow.com/questions/50379839/connection-java-mysql-public-key-retrieval-is-not-allowed)
> **For DBeaver users:**  
> Right click your connection, choose "Edit Connection"  
> On the "Connection settings" screen (main screen) click on "Edit Driver Settings"  
> Click on "Connection properties", (In recent versions it named "Driver properties")  
> Right click the "user properties" area and choose "Add new property"  
> Add two properties: "**useSSL**" and "**allowPublicKeyRetrieval**"  
> Set their values to "**false**" and "**true**" by double clicking on the "value" column  

---
Liquibase:  
[Getting Started with Liquibase and Gradle](https://docs.liquibase.com/tools-integrations/gradle/getting-started-liquibase-gradle.html)  
[Liquibase Gradle Plugin](https://github.com/liquibase/liquibase-gradle-plugin)  

---
Course: [Hibernate and Spring Data JPA: Beginner to Guru](https://www.udemy.com/course/hibernate-and-spring-data-jpa-beginner-to-guru/)  
Original repo: [Spring Data JPA - Introduction to Spring Data JPA](https://github.com/springframeworkguru/sdjpa-intro)  
