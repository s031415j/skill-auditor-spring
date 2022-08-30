INSERT INTO staff (id, fullname_first_name, fullname_surname, logindetails_username, logindetails_password, job_role, manager, address_house_name_number, address_street, address_town, address_postcode)
VALUES('6e29166c-247d-11ed-861d-0242ac120002', 'Katherine', 'Shields', 'katherineshieldss', 'password', 'Software Engineer', 'David', '31', 'Belfast Road', 'Belfast', 'BT42 3NR'),
      ('6e291838-247d-11ed-861d-0242ac120002', 'Sophie', 'Shields', 'sophie', 'password', 'SCRUM Master', 'Hannah', '31', 'Steep', 'Ballymena', 'BT41 1BQ');

-- INSERT INTO skill(id, skill_name, category_id)
-- VALUES('6e291932-247d-11ed-861d-0242ac120002', 'Java', '6e291af4-247d-11ed-861d-0242ac120002'),
--       ('6e291a18-247d-11ed-861d-0242ac120002', 'CPR', '6e291bd0-247d-11ed-861d-0242ac120002');
--
-- INSERT INTO category(id, category_name)
-- VALUES('6e291af4-247d-11ed-861d-0242ac120002', 'Programming'),
--       ('6e291bd0-247d-11ed-861d-0242ac120002', 'First Aid');

INSERT INTO staff_skill(id, staff_id, skill_id, strength_of_skill, expiry_date)
VALUES ('1','6e29166c-247d-11ed-861d-0242ac120002', '6e291932-247d-11ed-861d-0242ac120002', 1, '01-12-25'),
       ('2','6e29166c-247d-11ed-861d-0242ac120002', '6e291a18-247d-11ed-861d-0242ac120002', 2, '07-03-24'),
       ('3','6e291838-247d-11ed-861d-0242ac120002', '6e291932-247d-11ed-861d-0242ac120002', 0, '15-06-24');
create sequence staff_skill_sequence_id start with (select max(id) + 1 from staff_skill);

-- create sequence skills_sequence_id start with (select max(id) + 1 from staff_skills);