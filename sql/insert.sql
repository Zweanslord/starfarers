insert into User (id, username, password, enabled) values (1, 'Zweanslord', '$2a$10$knG.O2IVKtO0nbSw/uiu2utevDef34hAIBqxFEbCrGOYbx9AB9eEW', true);

insert into UserRole (id, role, fk_user) values (1, 'ROLE_ADMINISTRATOR', 1);
insert into UserRole (id, role, fk_user) values (2, 'ROLE_GAME_MASTER', 1);