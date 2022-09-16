INSERT INTO category(id, category_name)
VALUES ('1f3fe396-2e19-11ed-a261-0242ac120002', 'Programming'),
       ('1f3fe59e-2e19-11ed-a261-0242ac120002', 'First Aid'),
       ('1f3fe6de-2e19-11ed-a261-0242ac120002', 'Testing'),
       ('1f3fe7ec-2e19-11ed-a261-0242ac120002', 'Version Control'),
       ('b9f4a73e-35d8-11ed-a261-0242ac120002', 'Test');

INSERT INTO skill(id, skill_name, category_id)
VALUES ('1f3feac6-2e19-11ed-a261-0242ac120002', 'Java', '1f3fe396-2e19-11ed-a261-0242ac120002'),
       ('1f3febd4-2e19-11ed-a261-0242ac120002', 'Python', '1f3fe396-2e19-11ed-a261-0242ac120002'),
       ('1f3feee0-2e19-11ed-a261-0242ac120002', 'CPR', '1f3fe59e-2e19-11ed-a261-0242ac120002'),
       ('1f3fecd8-2e19-11ed-a261-0242ac120002', 'Git', '1f3fe7ec-2e19-11ed-a261-0242ac120002'),
       ('1f3feddc-2e19-11ed-a261-0242ac120002', 'Cucumber', '1f3fe7ec-2e19-11ed-a261-0242ac120002');