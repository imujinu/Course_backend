-- Active: 1732688612707@@127.0.0.1@3306@ssac
CREATE DATABASE ssac DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_general_ci;

#계정명 및 비밀번호 설정
CREATE USER 'jinwoo'@'%' IDENTIFIED BY '1234';

ALTER USER 'ssac'@'%' IDENTIFIED WITH mysql_native_password BY '1234';
FLUSH PRIVILEGES;
FLUSH PRIVILEGES;
#계정 사용하기//////
USE jinwoo@'%';

#계정에게 권한 부여
GRANT ALL PRIVILEGES ON *.* TO 'jinwoo'@'%' WITH GRANT OPTION;

#계정이 제대로 생성되었는지 확인
SHOW DATABASES;

SELECT user, host FROM mysql.user;

SELECT , @@3306, DATABASE();