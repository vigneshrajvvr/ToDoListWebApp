-- User table
CREATE TABLE users(
    id INT AUTO_INCREMENT PRIMARY KEY,
    mail_id VARCHAR(50)
);

-- Task table
CREATE TABLE tasks(
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_header VARCHAR(100),
    task_description VARCHAR(500),
    date_added DATE DEFAULT NOW(),
    user_task_id INT,
    FOREIGN KEY (user_task_id) REFERENCES users(id)
);
