-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Czas generowania: 01 Maj 2020, 10:20
-- Wersja serwera: 8.0.19
-- Wersja PHP: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `budowa`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `attachments`
--

CREATE TABLE `attachments` (
  `id` int NOT NULL,
  `building_id` int NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `path` varchar(500) NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `attachments`
--

INSERT INTO `attachments` (`id`, `building_id`, `created_at`, `path`, `user_id`) VALUES
(1, 1, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 2),
(2, 10, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 4),
(3, 3, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 10),
(4, 4, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 5),
(5, 4, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 10),
(6, 5, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 5),
(7, 6, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 7),
(8, 9, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 8),
(9, 9, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 9),
(10, 10, '2020-05-01 09:48:35.000000', 'https://media.giphy.com/media/bjfv14wZU7PiM/giphy.gif', 10);

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `buildings`
--

CREATE TABLE `buildings` (
  `id` int NOT NULL,
  `additional_notes` varchar(1000) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `customer` varchar(1000) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `end_date` varchar(1000) NOT NULL,
  `manager_id` int DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `priority` varchar(45) NOT NULL,
  `start_date` varchar(1000) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `buildings`
--

INSERT INTO `buildings` (`id`, `additional_notes`, `address`, `created_at`, `customer`, `description`, `end_date`, `manager_id`, `name`, `priority`, `start_date`, `status`) VALUES
(1, 'some notes', 'Zgłobień 2', '2020-05-01 09:48:35.000000', 'Marcin Szpadel', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 2, 'Wiata u Marcina', 'HIGH', '2021-01-01', 'FOUNDATIONS'),
(3, 'some notes adadad asd asd as', 'Zgłobień 4', '2020-05-01 09:48:35.000000', 'Ambroży Cegła', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 2, 'Dom u Ambrożego', 'LOW', '2021-01-01', 'WALLS'),
(4, 'some notes', 'Zgłobień 5', '2020-05-01 09:48:35.000000', 'Andrzej Piasek', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 1, 'Dom u Andrzeja', 'HIGH', '2021-01-01', 'WALLS'),
(5, 'some noteadasdasdadas das', 'Zgłobień 6', '2020-05-01 09:48:35.000000', 'Mariusz Betoniara', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 2, 'Dom u Mariusza', 'MEDIUM', '2021-01-01', 'CEILING'),
(6, 'some notes', 'Zgłobień 7', '2020-05-01 09:48:35.000000', 'Marian Cebula', 'description', '2020-01-01', 2, 'Garaż na plebanii', 'LOW', '2021-01-01', 'CEILING'),
(7, 'some notes', 'Zgłobień 8', '2020-05-01 09:48:35.000000', 'Adam Mysz', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', NULL, 'Dom u Myszów', 'HIGH', '2021-01-01', 'ROOF'),
(8, 'some notes', 'Zgłobień 9', '2020-05-01 09:48:35.000000', 'Tadeusz Wajcha', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 1, 'Dom Tadeusza', 'LOW', '2021-01-01', 'ROOF'),
(9, 'some notes', 'Zgłobień 10', '2020-05-01 09:48:35.000000', 'Delikatesy GS', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 1, 'Hala Sklepu GS', 'HIGH', '2021-01-01', 'DONE'),
(10, 'some notes', 'Zgłobień 1', '2020-05-01 09:48:35.000000', 'Staszek Łopata', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer magna ligula, dictum posuere tincidunt ut, interdum id orci. Proin sit amet vulputate ante, vitae sollicitudin elit. Proin id nisi finibus, pretium libero vitae, viverra lectus. Vivamus porttitor velit et sem gravida, in mollis nisi malesuada. Maecenas luctus, eros sit amet porta sagittis, tellus felis mollis ante, eu accumsan massa justo vitae arcu. Donec rhoncus quam vel nulla suscipit, a maximus nisl egestas. Maecenas ante purus, viverra vitae est nec, dignissim ornare mi. Donec eget aliquet eros. Maecenas euismod mollis enim non tempus. Quisque nulla nunc, blandit nec aliquet vel, maximus a nunc. Morbi eget lectus sodales, commodo magna ac, varius sapien. Vivamus mi nisl, scelerisque at lacus at, dignissim fringilla nisi. Cras ut est blandit, imperdiet massa ut, tincidunt nisi. Mauris varius lectus eget tortor tempus facilisis. Fusce vel eleifend lorem. Quisque mollis nec lectus eu semper. Pellentesque vitae ipsum ex.', '2020-01-01', 1, 'Budowa u Staszka', 'HIGH', '2021-01-01', 'TODO');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `buildings_attachments`
--

CREATE TABLE `buildings_attachments` (
  `Building_id` int NOT NULL,
  `attachments_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users`
--

CREATE TABLE `users` (
  `id` int NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `users`
--

INSERT INTO `users` (`id`, `full_name`, `password`, `role`, `username`) VALUES
(1, 'Andrzej Strzelba', 'manager1', 'MANAGER', 'manager1'),
(2, 'Janusz Januszowski', 'manager2', 'MANAGER', 'manager2'),
(3, 'Janusz Głowica', 'worker1', 'WORKER', 'worker1'),
(4, 'Adam Mysz', 'worker2', 'WORKER', 'worker2'),
(5, 'Adam Nowak', 'worker3', 'WORKER', 'worker3'),
(6, 'Jan Kowalski', 'worker4', 'WORKER', 'worker4'),
(7, 'Mariusz Betoniara', 'worker5', 'WORKER', 'worker5'),
(8, 'Zdzisław Ceglarz', 'worker6', 'WORKER', 'worker6'),
(9, 'Józef Zaprawa', 'worker7', 'WORKER', 'worker7'),
(10, 'Marian Cebula', 'owner', 'OWNER', 'owner');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users_attachments`
--

CREATE TABLE `users_attachments` (
  `User_id` int NOT NULL,
  `attachments_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `workers_buildings`
--

CREATE TABLE `workers_buildings` (
  `building_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `attachments`
--
ALTER TABLE `attachments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtd53u8djavlqe229ly9j9djxn` (`building_id`),
  ADD KEY `FKnuvi0v2f8fd3ly3b2lq4a0tsn` (`user_id`);

--
-- Indeksy dla tabeli `buildings`
--
ALTER TABLE `buildings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmlcjadm62gho6w2thinlwpa2m` (`manager_id`);

--
-- Indeksy dla tabeli `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD UNIQUE KEY `UK_nya4wdxhfset631qr7skcn1t0` (`attachments_id`),
  ADD KEY `FK2a9f6p2xav6t3sogaokv7et8n` (`Building_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD UNIQUE KEY `UK_h4kyodw0vev8aepklxui45mw0` (`attachments_id`),
  ADD KEY `FK1f5crjcf0dd2i4qbd8joocymu` (`User_id`);

--
-- Indeksy dla tabeli `workers_buildings`
--
ALTER TABLE `workers_buildings`
  ADD KEY `FKj3wj30jeijpkvq1gg9mushpan` (`user_id`),
  ADD KEY `FK3s00k1c26namr89cyyky53sfr` (`building_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `attachments`
--
ALTER TABLE `attachments`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `buildings`
--
ALTER TABLE `buildings`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT dla tabeli `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `attachments`
--
ALTER TABLE `attachments`
  ADD CONSTRAINT `FKnuvi0v2f8fd3ly3b2lq4a0tsn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKtd53u8djavlqe229ly9j9djxn` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`);

--
-- Ograniczenia dla tabeli `buildings`
--
ALTER TABLE `buildings`
  ADD CONSTRAINT `FKmlcjadm62gho6w2thinlwpa2m` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`);

--
-- Ograniczenia dla tabeli `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD CONSTRAINT `FK2a9f6p2xav6t3sogaokv7et8n` FOREIGN KEY (`Building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKiyij07njsoic18qkumqtgef48` FOREIGN KEY (`attachments_id`) REFERENCES `attachments` (`id`);

--
-- Ograniczenia dla tabeli `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD CONSTRAINT `FK1f5crjcf0dd2i4qbd8joocymu` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK3yainvq3cqnvyd9hpt1v02ucg` FOREIGN KEY (`attachments_id`) REFERENCES `attachments` (`id`);

--
-- Ograniczenia dla tabeli `workers_buildings`
--
ALTER TABLE `workers_buildings`
  ADD CONSTRAINT `FK3s00k1c26namr89cyyky53sfr` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKj3wj30jeijpkvq1gg9mushpan` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
