### How to test

1. Create MySQL DB container
    ```shell
    docker run -d -p 3306:3306 --name multi-db -e MYSQL_ROOT_PASSWORD=password mysql:8 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
    ```

2. Connect to DB container and run [mysql-setup.sql](src/main/resources/scripts/mysql-setup.sql) script

3. Run [JpaMultiDbApplicationTests](src/test/java/random/jpamultidb/JpaMultiDbApplicationTests.java)

---
Original: [Spring Data JPA Multiple Database Project](https://github.com/springframeworkguru/sdjpa-multi-db)