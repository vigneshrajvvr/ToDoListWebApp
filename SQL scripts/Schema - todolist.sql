DROP DATABASE IF EXISTS todolist;
CREATE DATABASE todolist; 
USE todolist;
DROP TABLE IF EXISTS user;
CREATE TABLE user (
	user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    enabled TINYINT(1)
);

DROP TABLE IF EXISTS task;
CREATE TABLE task (
	task_id INT AUTO_INCREMENT PRIMARY KEY,
    task_title VARCHAR(50) NOT NULL,
    task_description VARCHAR(500),
    date_time_added DATETIME NOT NULL,
    task_enabled TINYINT,
    user_task_id INT NOT NULL,
    FOREIGN KEY (user_task_id) REFERENCES user(user_id)
);

DROP TABLE IF EXISTS role;
CREATE TABLE role (
	role_id INT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(50) NOT NULL
);

DROP TABLE IF EXISTS user_role;
CREATE TABLE user_role (
	user_id INT,
    role_id INT,
    FOREIGN KEY (user_id) REFERENCES user(user_id),
    FOREIGN KEY (role_id) REFERENCES role(role_id)
);