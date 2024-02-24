INSERT INTO role(name)
VALUES ('OWNER'),
       ('ADMIN'),
       ('USER'),
       ('ACTIVITI_USER'),
       ('ACTIVITI_ADMIN');

INSERT INTO ho_group(name)
VALUES ('ADMIN'),
       ('TEAM');

INSERT INTO organization(id, name, description, owner, admin, pending_approval, is_default)
VALUES (1, 'DEFAULT', 'DEFAULT ORGANIZATION', null, null, false, true);

INSERT INTO org_unit(id, key, name, description, organization)
VALUES (1, 'root', 'ROOT', 'ROOT UNIT', 1), (2, 'admin', 'ADMIN', 'ADMIN UNIT', 1);

INSERT INTO administrative_unit(id)
VALUES (1);
INSERT INTO operational_unit(id)
VALUES (2);

INSERT INTO place_under(id, organization, subordinate, superior) VALUES (1, 1, 2, 1);

INSERT INTO vue(id, name)
VALUES (1, 'ORGANIZATIONS'),
       (2, 'UNITS'),
       (3, 'EMPLOYEES'),
       (4, 'ACTIVITY'),
       (5, 'VIEWS'),
       (6, 'PERMISSIONS'),
       (7, 'RESOURCES'),
       (8, 'ACTIONS'),
       (9, 'CONTEXTS'),
       (10, 'POLICY_DATABASE');

INSERT INTO activity(id, name)
VALUES (1, 'CREATE'),
       (2, 'UPDATE'),
       (3, 'DELETE'),
       (4, 'VIEW'),
       (5, 'ADMINISTER');

INSERT INTO operational_permission (id, organization, name, activity, vue, unit, required_approval, approval_level,
                                    approval_type)
VALUES (1, 1, 'CREATE ORGANIZATION', 1, 1, 1, false, 0, null),
       (2, 1, 'UPDATE ORGANIZATION', 2, 1, 1, false, 0, null),
       (3, 1, 'DELETE ORGANIZATION', 3, 1, 1, false, 0, null),
       (4, 1, 'VIEW ORGANIZATION', 4, 1, 1, false, 0, null),
       (5, 1, 'ADMINISTER ORGANIZATION', 5, 1, 1, false, 0, null), --administer org by assigning/changing admins

       (6, 1, 'CREATE UNIT', 1, 2, 1, false, 0, null),
       (7, 1, 'UPDATE UNIT', 2, 2, 1, false, 0, null),
       (8, 1, 'DELETE UNIT', 3, 2, 1, false, 0, null),
       (9, 1, 'VIEW UNIT', 4, 2, 1, false, 0, null),
       (10, 1, 'ADMINISTER UNIT', 5, 2, 1, false, 0,
        null),                                                     --administer units by defining/removing unit hierarchy, association between units

       (11, 1, 'CREATE EMPLOYEE', 1, 3, 1, false, 0, null),
       (12, 1, 'UPDATE EMPLOYEE', 2, 3, 1, false, 0, null),
       (13, 1, 'DELETE EMPLOYEE', 3, 3, 1, false, 0, null),
       (14, 1, 'VIEW EMPLOYEE', 4, 3, 1, false, 0, null),
       (15, 1, 'ADMINISTER EMPLOYEE', 5, 3, 1, false, 0,
        null),                                                     --administer employees means assigning/removing them to units

       (16, 1, 'CREATE ACTIVITY', 1, 4, 1, false, 0, null),
       (17, 1, 'UPDATE ACTIVITY', 2, 4, 1, false, 0, null),
       (18, 1, 'DELETE ACTIVITY', 3, 4, 1, false, 0, null),
       (19, 1, 'VIEW ACTIVITY', 4, 4, 1, false, 0, null),
       (20, 1, 'ADMINISTER ACTIVITY', 5, 4, 1, false, 0, null),       --assigning activities and assigning/removing operations

       (21, 1, 'CREATE VIEW', 1, 5, 1, false, 0, null),
       (22, 1, 'UPDATE VIEW', 2, 5, 1, false, 0, null),
       (23, 1, 'DELETE VIEW', 3, 5, 1, false, 0, null),
       (24, 1, 'VIEW VIEWS', 4, 5, 1, false, 0, null),
       (25, 1, 'ADMINISTER VIEW', 5, 5, 1, false, 0, null),           --assigning/removing resources/subviews

       (26, 1, 'CREATE PERMISSION', 1, 6, 1, false, 0, null),
       (27, 1, 'UPDATE PERMISSION', 2, 6, 1, false, 0, null),
       (28, 1, 'DELETE PERMISSION', 3, 6, 1, false, 0, null),
       (29, 1, 'VIEW PERMISSION', 4, 6, 1, false, 0, null),

       (30, 1, 'CREATE RESOURCE', 1, 7, 1, false, 0, null),
       (31, 1, 'UPDATE RESOURCE', 2, 7, 1, false, 0, null),
       (32, 1, 'DELETE RESOURCE', 3, 7, 1, false, 0, null),
       (33, 1, 'VIEW RESOURCE', 4, 7, 1, false, 0, null),

       (34, 1, 'CREATE ACTION', 1, 8, 1, false, 0, null),
       (35, 1, 'UPDATE ACTION', 2, 8, 1, false, 0, null),
       (36, 1, 'DELETE ACTION', 3, 8, 1, false, 0, null),
       (37, 1, 'VIEW ACTION', 4, 8, 1, false, 0, null),

       (38, 1, 'CREATE CONTEXT', 1, 9, 1, false, 0, null),
       (39, 1, 'UPDATE CONTEXT', 2, 9, 1, false, 0, null),
       (40, 1, 'DELETE CONTEXT', 3, 9, 1, false, 0, null),
       (41, 1, 'VIEW CONTEXT', 4, 9, 1, false, 0, null),
       (42, 1, 'ADMINISTER CONTEXT', 5, 9, 1, false, 0,
        null),                                                     --administer means be able to assign/remove context to employees and actions

       (43, 1, 'ADMINISTER POLICY STORE', 4, 10, 1, false, 0,
        null); --administer policy store means allowing/restricting access to database operations where the policy is stored, including granting access to other users