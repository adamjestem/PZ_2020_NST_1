insert into users (id, full_name, password, role, username)
values (10, 'Marian Cebula', '72122ce96bfec66e2396d2e25225d70a', 'OWNER', 'owner');
insert into users (id, full_name, password, role, username)
values (1, 'Andrzej Strzelba', 'c240642ddef994358c96da82c0361a58', 'MANAGER', 'manager1');
insert into users (id, full_name, password, role, username)
values (2, 'Janusz Januszowski', '8df5127cd164b5bc2d2b78410a7eea0c', 'MANAGER', 'manager2');
insert into users (id, full_name, password, role, username)
values (3, 'Janusz Głowica', 'ebad64149cc767ba26ef069819279fd5', 'WORKER', 'worker1');
insert into users (id, full_name, password, role, username)
values (4, 'Adam Mysz', '01925b7892e2ca194993afdd20a7c761', 'WORKER', 'worker2');
insert into users (id, full_name, password, role, username)
values (5, 'Adam Nowak', 'b504f5a746deafd3e78b9c85c20ca653', 'WORKER', 'worker3');
insert into users (id, full_name, password, role, username)
values (6, 'Jan Kowalski', '221393135bcf2a755b8ac9da40365c67', 'WORKER', 'worker4');
insert into users (id, full_name, password, role, username)
values (7, 'Mariusz Betoniara', '6a21db8adb7572cb5d1b15dfaa4469e4', 'WORKER', 'worker5');
insert into users (id, full_name, password, role, username)
values (8, 'Zdzisław Ceglarz', '16b7e21c964d2e0b98a5a4712a0df241', 'WORKER', 'worker6');
insert into users (id, full_name, password, role, username)
values (9, 'Józef Zaprawa', 'e2954e1abf0b7138d9dd7a3c13f5aaec', 'WORKER', 'worker7');

insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (10, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        1, 'Budowa u Staszka', 'TODO', 'HIGH', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 1', 'Staszek Łopata');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (1, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        2, 'Wiata u Marcina', 'FOUNDATIONS', 'HIGH', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 2', 'Marcin Szpadel');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (2, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        1, 'Garaż u Józefa', 'FOUNDATIONS', 'MEDIUM', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2022', '%d-%m-%Y'), 'some nota sd asd asd asd es', 'Zgłobień 3', 'Józef Cement');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (3, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        2, 'Dom u Ambrożego', 'WALLS', 'LOW', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes adadad asd asd as', 'Zgłobień 4', 'Ambroży Cegła');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (4, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        1, 'Dom u Andrzeja', 'WALLS', 'HIGH', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 5', 'Andrzej Piasek');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (5, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        2, 'Dom u Mariusza', 'CEILING', 'MEDIUM', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some noteadasdasdadas das', 'Zgłobień 6', 'Mariusz Betoniara');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (6, NOW(), 'description', 2, 'Garaż na plebanii', 'CEILING', 'LOW', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 7', 'Marian Cebula');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (7, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        null, 'Dom u Myszów', 'ROOF', 'HIGH', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 8', 'Adam Mysz');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (8, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        1, 'Dom Tadeusza', 'ROOF', 'LOW', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 9', 'Tadeusz Wajcha');
insert into buildings (id, created_at, description, manager_id, name, status, priority, end_date, start_date,
                       additional_notes, address, customer)
values (9, NOW(),
        'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.',
        1, 'Hala Sklepu GS', 'DONE', 'HIGH', STR_TO_DATE('1-01-2020', '%d-%m-%Y'),
        STR_TO_DATE('1-01-2021', '%d-%m-%Y'), 'some notes', 'Zgłobień 10', 'Delikatesy GS');

insert into attachments (id, building_id, created_at, path, user_id)
values (10, 10, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 10);
insert into attachments (id, building_id, created_at, path, user_id)
values (1, 1, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 2);
insert into attachments (id, building_id, created_at, path, user_id)
values (2, 10, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 4);
insert into attachments (id, building_id, created_at, path, user_id)
values (3, 3, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 10);
insert into attachments (id, building_id, created_at, path, user_id)
values (4, 4, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 5);
insert into attachments (id, building_id, created_at, path, user_id)
values (5, 4, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 10);
insert into attachments (id, building_id, created_at, path, user_id)
values (6, 5, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 5);
insert into attachments (id, building_id, created_at, path, user_id)
values (7, 6, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 7);
insert into attachments (id, building_id, created_at, path, user_id)
values (8, 9, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 8);
insert into attachments (id, building_id, created_at, path, user_id)
values (9, 9, NOW(), 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 9);

insert into buildings_attachments (Building_id, attachments_id)
values (10, 10);
insert into buildings_attachments (Building_id, attachments_id)
values (1, 1);
insert into buildings_attachments (Building_id, attachments_id)
values (2, 2);
insert into buildings_attachments (Building_id, attachments_id)
values (3, 3);
insert into buildings_attachments (Building_id, attachments_id)
values (4, 4);
insert into buildings_attachments (Building_id, attachments_id)
values (5, 5);
insert into buildings_attachments (Building_id, attachments_id)
values (6, 6);
insert into buildings_attachments (Building_id, attachments_id)
values (7, 7);
insert into buildings_attachments (Building_id, attachments_id)
values (8, 8);
insert into buildings_attachments (Building_id, attachments_id)
values (8, 9);

insert into users_attachments (User_id, attachments_id)
values (10, 10);
insert into users_attachments (User_id, attachments_id)
values (10, 1);
insert into users_attachments (User_id, attachments_id)
values (2, 2);
insert into users_attachments (User_id, attachments_id)
values (2, 3);
insert into users_attachments (User_id, attachments_id)
values (4, 4);
insert into users_attachments (User_id, attachments_id)
values (5, 5);
insert into users_attachments (User_id, attachments_id)
values (6, 6);
insert into users_attachments (User_id, attachments_id)
values (7, 7);
insert into users_attachments (User_id, attachments_id)
values (8, 8);
insert into users_attachments (User_id, attachments_id)
values (8, 9);

insert into workers_buildings(User_id, building_id) value (3, 1);
insert into workers_buildings(User_id, building_id) value (3, 5);
insert into workers_buildings(User_id, building_id) value (4, 2);
insert into workers_buildings(User_id, building_id) value (5, 3);
insert into workers_buildings(User_id, building_id) value (6, 4);
insert into workers_buildings(User_id, building_id) value (7, 1);
insert into workers_buildings(User_id, building_id) value (8, 6);
insert into workers_buildings(User_id, building_id) value (9, 7);
insert into workers_buildings(User_id, building_id) value (9, 1);
insert into workers_buildings(User_id, building_id) value (6, 2);
