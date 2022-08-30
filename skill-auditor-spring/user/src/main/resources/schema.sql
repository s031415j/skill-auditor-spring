CREATE TABLE staff(
    id VARCHAR PRIMARY KEY,
    fullname_first_name VARCHAR NOT NULL,
    fullname_surname VARCHAR NOT NULL,
    logindetails_username VARCHAR NOT NULL,
    logindetails_password VARCHAR NOT NULL,
    job_role VARCHAR NOT NULL,
    manager VARCHAR NOT NULL,
    address_house_name_number VARCHAR NOT NULL,
    address_street VARCHAR NOT NULL,
    address_town VARCHAR NOT NULL,
    address_postcode VARCHAR NOT NULL
);

-- CREATE TABLE category(
--     id VARCHAR PRIMARY KEY,
--     category_name VARCHAR NOT NULL
-- );
--
-- CREATE TABLE skill(
--     id VARCHAR PRIMARY KEY,
--     skill_name VARCHAR NOT NULL,
--     category_id VARCHAR NOT NULL,
--     FOREIGN KEY (category_id) REFERENCES category(id)
-- );

CREATE TABLE staff_skill(
    id int AUTO_INCREMENT PRIMARY KEY,
    staff_id VARCHAR NOT NULL,
    skill_id VARCHAR NOT NULL,
    FOREIGN KEY (staff_id) REFERENCES staff(id),
--     FOREIGN KEY (skill_id) REFERENCES skill(id),
    strength_of_skill VARCHAR NOT NULL,
    expiry_date DATE
);

