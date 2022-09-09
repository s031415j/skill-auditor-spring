CREATE TABLE staff(
    id VARCHAR PRIMARY KEY,
    fullname_first_name VARCHAR NOT NULL,
    fullname_surname VARCHAR NOT NULL,
    logindetails_username VARCHAR NOT NULL,
    logindetails_password VARCHAR NOT NULL,
    job_role VARCHAR NOT NULL,
    address_house_name_number VARCHAR NOT NULL,
    address_street VARCHAR NOT NULL,
    address_town VARCHAR NOT NULL,
    address_postcode VARCHAR NOT NULL
);

CREATE TABLE staff_skill(
    id int AUTO_INCREMENT PRIMARY KEY,
    staff_id VARCHAR NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    skill_id VARCHAR NOT NULL,
    strength_of_skill VARCHAR NOT NULL,
    expiry_date DATE
);

CREATE TABLE team(
    id int AUTO_INCREMENT PRIMARY KEY,
    staff_id VARCHAR NOT NULL,
    manager_id VARCHAR NOT NULL,
    fullname_first_name VARCHAR NOT NULL,
    fullname_surname VARCHAR NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES staff(id),
    FOREIGN KEY (manager_id) REFERENCES staff(id)
);

