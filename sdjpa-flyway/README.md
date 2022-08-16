[MySQL Docker Image](https://hub.docker.com/_/mysql/)

- Create MySQL in Docker container:

```shell
docker run -d -p 3306:3306 --name db-flyway -e MYSQL_DATABASE=bookdb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_USER=bookadmin -e MYSQL_PASSWORD=password mysql:8 --character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci
```
