[MySQL Docker Image](https://hub.docker.com/_/mysql/)

- Create MySQL DB in Docker container:

```shell
cd ./docker && ^
docker build -t my-sql-jdbc-img . && ^
docker run -d -p 3306:3306 --name db-flyway-2 my-sql-jdbc-img --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
