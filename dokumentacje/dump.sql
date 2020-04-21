-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Czas generowania: 21 Kwi 2020, 15:11
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
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `buildings`
--

CREATE TABLE `buildings` (
  `id` int NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `description` varchar(255) NOT NULL,
  `manager_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `buildings_attachments`
--

CREATE TABLE `buildings_attachments` (
  `Building_id` int NOT NULL,
  `attachmentById_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Zrzut danych tabeli `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1),
(1);

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

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users_attachments`
--

CREATE TABLE `users_attachments` (
  `User_id` int NOT NULL,
  `attachmentById_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `users_buildings`
--

CREATE TABLE `users_buildings` (
  `User_id` int NOT NULL,
  `buildingById_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indeksy dla zrzutów tabel
--

--
-- Indeksy dla tabeli `attachments`
--
ALTER TABLE `attachments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKda0ct5u4uby0eqq9k9qhc50jl` (`building_id`),
  ADD KEY `FKrap79tymgdjf1c5x4dla3rekl` (`user_id`);

--
-- Indeksy dla tabeli `buildings`
--
ALTER TABLE `buildings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs0en8l3jvg2tn2eji1pur17p6` (`manager_id`);

--
-- Indeksy dla tabeli `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD UNIQUE KEY `UK_12101iqsyt0496nmio6kdwbrv` (`attachmentById_id`),
  ADD KEY `FKsv21y9m2jwxuy8k0b5ny868j1` (`Building_id`);

--
-- Indeksy dla tabeli `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indeksy dla tabeli `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD UNIQUE KEY `UK_ao7rckouejv941kawqtigp9iq` (`attachmentById_id`),
  ADD KEY `FKpkpssvt5shyx2y3ei3ib2if5a` (`User_id`);

--
-- Indeksy dla tabeli `users_buildings`
--
ALTER TABLE `users_buildings`
  ADD UNIQUE KEY `UK_mkegps66a510j71p5vmgjor78` (`buildingById_id`),
  ADD KEY `FKnjrkawhfcf0xpsqelg01f8ed8` (`User_id`);

--
-- Ograniczenia dla zrzutów tabel
--

--
-- Ograniczenia dla tabeli `attachments`
--
ALTER TABLE `attachments`
  ADD CONSTRAINT `FKda0ct5u4uby0eqq9k9qhc50jl` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKrap79tymgdjf1c5x4dla3rekl` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Ograniczenia dla tabeli `buildings`
--
ALTER TABLE `buildings`
  ADD CONSTRAINT `FKs0en8l3jvg2tn2eji1pur17p6` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`);

--
-- Ograniczenia dla tabeli `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD CONSTRAINT `FKsv21y9m2jwxuy8k0b5ny868j1` FOREIGN KEY (`Building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKsxc8iuwi9sj4mimiejtlcfkww` FOREIGN KEY (`attachmentById_id`) REFERENCES `attachments` (`id`);

--
-- Ograniczenia dla tabeli `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD CONSTRAINT `FK7p4tt2feycva9fhw7ch5d6o0b` FOREIGN KEY (`attachmentById_id`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `FKpkpssvt5shyx2y3ei3ib2if5a` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);

--
-- Ograniczenia dla tabeli `users_buildings`
--
ALTER TABLE `users_buildings`
  ADD CONSTRAINT `FKd4uhjt6mtrjkn9sr4t4jyh4be` FOREIGN KEY (`buildingById_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKnjrkawhfcf0xpsqelg01f8ed8` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
