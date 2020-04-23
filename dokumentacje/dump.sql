-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Apr 22, 2020 at 11:57 PM
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
  `created_at` datetime(6) NOT NULL,
  `description` varchar(1000) NOT NULL,
  `manager_id` int DEFAULT NULL,
  `name` varchar(45) NOT NULL,
  `priority` varchar(45) NOT NULL,
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
  ADD KEY `FKda0ct5u4uby0eqq9k9qhc50jl` (`building_id`),
  ADD KEY `FKrap79tymgdjf1c5x4dla3rekl` (`user_id`);

--
-- Indexes for table `buildings`
--
ALTER TABLE `buildings`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKs0en8l3jvg2tn2eji1pur17p6` (`manager_id`);

--
-- Indexes for table `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD UNIQUE KEY `UK_nya4wdxhfset631qr7skcn1t0` (`attachments_id`),
  ADD KEY `FKsv21y9m2jwxuy8k0b5ny868j1` (`Building_id`);

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
  ADD KEY `FKpkpssvt5shyx2y3ei3ib2if5a` (`User_id`);

--
-- Indexes for table `workers_buildings`
--
ALTER TABLE `workers_buildings`
  ADD KEY `FK92y6r9q70alkhxek229f66nrj` (`user_id`),
  ADD KEY `FKfn62q1tkg78kmgmg5tddpaxvw` (`building_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attachments`
--
ALTER TABLE `attachments`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `buildings`
--
ALTER TABLE `buildings`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attachments`
--
ALTER TABLE `attachments`
  ADD CONSTRAINT `FKda0ct5u4uby0eqq9k9qhc50jl` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`),
  ADD CONSTRAINT `FKrap79tymgdjf1c5x4dla3rekl` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `buildings`
--
ALTER TABLE `buildings`
  ADD CONSTRAINT `FKs0en8l3jvg2tn2eji1pur17p6` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `buildings_attachments`
--
ALTER TABLE `buildings_attachments`
  ADD CONSTRAINT `FK98vdrdbep580nayrsriw3e30a` FOREIGN KEY (`attachments_id`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `FKsv21y9m2jwxuy8k0b5ny868j1` FOREIGN KEY (`Building_id`) REFERENCES `buildings` (`id`);

--
-- Constraints for table `users_attachments`
--
ALTER TABLE `users_attachments`
  ADD CONSTRAINT `FKmgwg87nvm4rhervmma0qtwesq` FOREIGN KEY (`attachments_id`) REFERENCES `attachments` (`id`),
  ADD CONSTRAINT `FKpkpssvt5shyx2y3ei3ib2if5a` FOREIGN KEY (`User_id`) REFERENCES `users` (`id`);

--
-- Constraints for table `workers_buildings`
--
ALTER TABLE `workers_buildings`
  ADD CONSTRAINT `FK92y6r9q70alkhxek229f66nrj` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `FKfn62q1tkg78kmgmg5tddpaxvw` FOREIGN KEY (`building_id`) REFERENCES `buildings` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
