CREATE TABLE staff(
    id VARCHAR(50) PRIMARY KEY,
    fullname_first_name VARCHAR(50)  NOT NULL,
    fullname_surname VARCHAR(50)  NOT NULL,
    logindetails_username VARCHAR(50)  NOT NULL,
    logindetails_password VARCHAR(50)  NOT NULL,
    job_role VARCHAR(50)  NOT NULL,
    address_house_name_number VARCHAR(50)  NOT NULL,
    address_street VARCHAR(50)  NOT NULL,
    address_town VARCHAR(50)  NOT NULL,
    address_postcode VARCHAR(50)  NOT NULL
);

CREATE TABLE staff_skills(
    id int AUTO_INCREMENT PRIMARY KEY,
    staff_id VARCHAR(50)  NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    skill_id VARCHAR(50)  NOT NULL,
    strength_of_skill VARCHAR(50)  NOT NULL,
    expiry_date DATE
);

CREATE TABLE team(
    id int AUTO_INCREMENT PRIMARY KEY,
    staff_id VARCHAR(50)  NOT NULL,
    manager_id VARCHAR(50)  NOT NULL,
    fullname_first_name VARCHAR(50)  NOT NULL,
    fullname_surname VARCHAR(50)  NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (manager_id) REFERENCES staff(id)
);

