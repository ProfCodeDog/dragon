--docker pull mysql:8.0

--docker run -p 3308:3306 --name mysql_8.0_3308 -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0 --character-set-server=utf8mb4 --collation-server=utf8mb4_general_ci

--docker start mysql_8.0_3308

--docker exec -it mysql_8.0_3308 /bin/bash


--mysql -uroot -proot


CREATE DATABASE dragon CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
CREATE USER dragon IDENTIFIED WITH caching_sha2_password BY 'dragon';
grant all privileges on dragon.* to 'dragon'@'%';
flush privileges;


--mysql -h127.0.0.1 -P3308 -uroot -proot -D dragon
