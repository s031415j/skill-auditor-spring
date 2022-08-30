CREATE TABLE app_user (
    id VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(40) NOT NULL,
    surname VARCHAR(40) NOT NULL,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(255) NOT NULL,
    job_role_id int NOT NULL
);

CREATE TABLE job_role (
    id int AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(45) NOT NULL
);