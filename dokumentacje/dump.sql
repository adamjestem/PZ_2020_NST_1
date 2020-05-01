create database budowa;
use budowa;

-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: May 01, 2020 at 12:34 PM
-- Server version: 8.0.19
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `budowa`
--

-- --------------------------------------------------------

--
-- Table structure for table `attachments`
--

CREATE TABLE `attachments` (
  `id` int NOT NULL,
  `building_id` int NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `path` varchar(500) NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `buildings`
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

-- --------------------------------------------------------

--
-- Table structure for table `buildings_attachments`
--

CREATE TABLE `buildings_attachments` (
  `Building_id` int NOT NULL,
  `attachments_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users`
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
-- Table structure for table `users_attachments`
--

CREATE TABLE `users_attachments` (
  `User_id` int NOT NULL,
  `attachments_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `workers_buildings`
--

CREATE TABLE `workers_buildings` (
  `building_id` int NOT NULL,
  `user_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attachments`
--
ALTER TABLE `attachments`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKtd53u8djavlqe229ly9j9djxn` (`building_id`),
  ADD KEY `FKnuvi0v2f8fd3ly3b2lq4a0tsn` (`user_id`);

--
-- Indexes for table `buildings`
--
ALTER TABLE `buildings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKmlcjadm62gho6w2thinlwpa2m` (`manager_id`);

--
-- Indexes for table `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD UNIQUE KEY `UK_nya4wdxhfset631qr7skcn1t0` (`attachments_id`),
  ADD KEY `FK2a9f6p2xav6t3sogaokv7et8n` (`Building_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD UNIQUE KEY `UK_h4kyodw0vev8aepklxui45mw0` (`attachments_id`),
  ADD KEY `FK1f5crjcf0dd2i4qbd8joocymu` (`User_id`);

--
-- Indexes for table `workers_buildings`
--
ALTER TABLE `workers_buildings`
  ADD KEY `FKj3wj30jeijpkvq1gg9mushpan` (`user_id`),
  ADD KEY `FK3s00k1c26namr89cyyky53sfr` (`building_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attachments`
--
ALTER TABLE `attachments`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `buildings`
--
ALTER TABLE `buildings`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attachments`
--
ALTER TABLE `attachments`
  ADD CONSTRAINT `FKnuvi0v2f8fd3ly3b2lq4a0tsn` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKtd53u8djavlqe229ly9j9djxn` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`);

--
-- Constraints for table `buildings`
--
ALTER TABLE `buildings`
  ADD CONSTRAINT `FKmlcjadm62gho6w2thinlwpa2m` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD CONSTRAINT `FK2a9f6p2xav6t3sogaokv7et8n` FOREIGN KEY (`Building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKiyij07njsoic18qkumqtgef48` FOREIGN KEY (`attachments_id`) REFERENCES `attachments` (`id`);

--
-- Constraints for table `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD CONSTRAINT `FK1f5crjcf0dd2i4qbd8joocymu` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FK3yainvq3cqnvyd9hpt1v02ucg` FOREIGN KEY (`attachments_id`) REFERENCES `attachments` (`id`);

--
-- Constraints for table `workers_buildings`
--
ALTER TABLE `workers_buildings`
  ADD CONSTRAINT `FK3s00k1c26namr89cyyky53sfr` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKj3wj30jeijpkvq1gg9mushpan` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
