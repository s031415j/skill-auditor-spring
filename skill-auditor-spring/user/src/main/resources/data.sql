INSERT INTO staff (id, fullname_first_name, fullname_surname, logindetails_username, logindetails_password, job_role, address_house_name_number, address_street, address_town, address_postcode)
VALUES('6e29166c-247d-11ed-861d-0242ac120002', 'Katherine', 'Shields', 'katherineshieldss', 'password', 'Software Engineer', '31', 'Belfast Road', 'Belfast', 'BT42 3NR'),
      ('6e291838-247d-11ed-861d-0242ac120002', 'Sophie', 'Shields', 'sophie', 'password', 'SCRUM Master', '31', 'Steep', 'Ballymena', 'BT41 1BQ'),
      ('96720fa0-2ed4-11ed-a261-0242ac120002', 'Kellie', 'Shields', 'kell', 'password', 'E-Learning Creator', '6', 'Teapot Lane', 'Larne', 'BT49 5RD'),
      ('96721086-2ed4-11ed-a261-0242ac120002', 'Alan', 'Shields', 'alan', 'password', 'Electrician', '81', 'Garden Road', 'Antrim', 'BT41 1BP');


INSERT INTO staff_skill( staff_id, skill_id, strength_of_skill, expiry_date)
VALUES ('6e29166c-247d-11ed-861d-0242ac120002', '6e291932-247d-11ed-861d-0242ac120002', 'Beginner', '01-12-25'),
       ('6e29166c-247d-11ed-861d-0242ac120002', '6e291a18-247d-11ed-861d-0242ac120002', 'Intermediate', '07-03-24'),
       ('6e291838-247d-11ed-861d-0242ac120002', '6e291932-247d-11ed-861d-0242ac120002', 'Professional', '15-06-24');
create sequence staff_skill_sequence_id start with (select max(id) + 1 from staff_skill);


INSERT INTO team(staff_id, manager_id, fullname_firstname, fullname_surname)
VALUES ('96720fa0-2ed4-11ed-a261-0242ac120002', '96720cee-2ed4-11ed-a261-0242ac120002','Kellie', 'Shields'),
       ('96721086-2ed4-11ed-a261-0242ac120002', '96720eb0-2ed4-11ed-a261-0242ac120002', 'Alan', 'Shields');
create sequence team_sequence_id start with (select max(id) + 1 from team);