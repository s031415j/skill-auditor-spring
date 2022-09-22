CREATE TABLE app_user (
    id VARCHAR(50) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50) NOT NULL,
    job_role_id int NOT NULL
);

CREATE TABLE job_role (
    id int AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(50) NOT NULL
);