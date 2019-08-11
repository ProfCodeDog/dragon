CREATE DATABASE dragon_job CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
CREATE USER dragon_job IDENTIFIED WITH caching_sha2_password BY 'dragon_job';
grant all privileges on dragon_job.* to 'dragon_job'@'%';
flush privileges;
