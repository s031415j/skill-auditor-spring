INSERT INTO staff (id, fullname_first_name, fullname_surname, logindetails_username, logindetails_password, job_role, address_house_name_number, address_street, address_town, address_postcode)
VALUES('6e29166c-247d-11ed-861d-0242ac120002', 'Katherine', 'Shields', 'kate', 'password', 'MANAGER', '31', 'Belfast Road', 'Belfast', 'BT42 3NR'),
      ('6e291838-247d-11ed-861d-0242ac120002', 'Sophie', 'Shields', 'soph', 'password', 'STAFF', '31', 'Steep', 'Ballymena', 'BT41 1BQ'),
      ('96720fa0-2ed4-11ed-a261-0242ac120002', 'Kellie', 'Shields', 'kell', 'password', 'STAFF', '6', 'Teapot Lane', 'Larne', 'BT49 5RD'),
      ('96721086-2ed4-11ed-a261-0242ac120002', 'Alan', 'Shields', 'alan', 'password', 'STAFF', '81', 'Garden Road', 'Antrim', 'BT41 1BP');


INSERT INTO staff_skills( staff_id, skill_id, strength_of_skill, expiry_date)
VALUES ('6e29166c-247d-11ed-861d-0242ac120002', '6e291932-247d-11ed-861d-0242ac120002', 'BEGINNER', '01-12-25'),
       ('6e29166c-247d-11ed-861d-0242ac120002', '6e291a18-247d-11ed-861d-0242ac120002', 'INTERMEDIATE', '07-03-24'),
       ('6e291838-247d-11ed-861d-0242ac120002', '6e291932-247d-11ed-861d-0242ac120002', 'PROFESSIONAL', '15-06-24');
create sequence skills_sequence_id start with (select max(id) + 1 from staff_skills);


INSERT INTO team(staff_id, manager_id, fullname_first_name, fullname_surname)
VALUES ('96720fa0-2ed4-11ed-a261-0242ac120002', '6e29166c-247d-11ed-861d-0242ac120002','Kellie', 'Shields'),
       ('96721086-2ed4-11ed-a261-0242ac120002', '6e29166c-247d-11ed-861d-0242ac120002', 'Alan', 'Shields');
create sequence team_sequence_id start with (select max(id) + 1 from team);