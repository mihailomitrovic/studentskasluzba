-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 24, 2024 at 05:01 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projekat`
--

-- --------------------------------------------------------

--
-- Table structure for table `ispit`
--

CREATE TABLE `ispit` (
  `IspitID` int(11) NOT NULL,
  `NazivIspita` varchar(255) NOT NULL,
  `GodinaStudija` varchar(4) NOT NULL,
  `BrojESPB` int(11) NOT NULL,
  `Cena` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ispit`
--

INSERT INTO `ispit` (`IspitID`, `NazivIspita`, `GodinaStudija`, `BrojESPB`, `Cena`) VALUES
(1, 'Programiranje 1', 'I', 4, 1600),
(2, 'Marketing', 'II', 5, 2000),
(3, 'Baze podataka', 'III', 6, 2400),
(4, 'Projektovanje softvera', 'IV', 6, 2400);

-- --------------------------------------------------------

--
-- Table structure for table `ispitnirok`
--

CREATE TABLE `ispitnirok` (
  `IspitniRokID` int(11) NOT NULL,
  `NazivIspitnogRoka` varchar(255) NOT NULL,
  `PridevIspitnogRoka` varchar(255) NOT NULL,
  `DatumOd` date NOT NULL,
  `DatumDo` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ispitnirok`
--

INSERT INTO `ispitnirok` (`IspitniRokID`, `NazivIspitnogRoka`, `PridevIspitnogRoka`, `DatumOd`, `DatumDo`) VALUES
(1, 'Januar', 'januarski', '2024-01-01', '2024-01-31'),
(2, 'Februar', 'februarski', '2024-02-01', '2024-02-29'),
(3, 'Jun', 'junski', '2024-06-01', '2024-06-30'),
(4, 'Jul', 'julski', '2024-07-01', '2024-07-31'),
(5, 'Septembar', 'septembarski', '2024-09-01', '2024-09-20'),
(6, 'Oktobar', 'oktobarski', '2024-09-21', '2024-09-30');

-- --------------------------------------------------------

--
-- Table structure for table `mesto`
--

CREATE TABLE `mesto` (
  `MestoID` int(11) NOT NULL,
  `NazivMesta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mesto`
--

INSERT INTO `mesto` (`MestoID`, `NazivMesta`) VALUES
(1, 'Beograd'),
(2, 'Novi Sad'),
(3, 'Niš'),
(4, 'Subotica'),
(5, 'Kragujevac'),
(6, 'Kraljevo'),
(7, 'Kruševac'),
(8, 'Čačak'),
(9, 'Užice'),
(10, 'Leskovac');

-- --------------------------------------------------------

--
-- Table structure for table `prijavaispita`
--

CREATE TABLE `prijavaispita` (
  `PrijavaID` int(11) NOT NULL,
  `DatumPrijave` date NOT NULL,
  `IspitniRokID` int(11) NOT NULL,
  `IspitID` int(11) NOT NULL,
  `StudentID` int(11) NOT NULL,
  `SluzbenikID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `prijavaispita`
--

INSERT INTO `prijavaispita` (`PrijavaID`, `DatumPrijave`, `IspitniRokID`, `IspitID`, `StudentID`, `SluzbenikID`) VALUES
(47, '2023-11-17', 1, 4, 15, 1);

-- --------------------------------------------------------

--
-- Table structure for table `racunprijaveispita`
--

CREATE TABLE `racunprijaveispita` (
  `RacunID` int(11) NOT NULL,
  `DatumIzdavanja` date NOT NULL,
  `PrijavaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sluzbenik`
--

CREATE TABLE `sluzbenik` (
  `SluzbenikID` int(11) NOT NULL,
  `KorisnickoIme` varchar(255) NOT NULL,
  `Lozinka` varchar(255) NOT NULL,
  `ImePrezimeSluzbenika` varchar(255) NOT NULL,
  `imeVokativ` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sluzbenik`
--

INSERT INTO `sluzbenik` (`SluzbenikID`, `KorisnickoIme`, `Lozinka`, `ImePrezimeSluzbenika`, `imeVokativ`) VALUES
(1, 'admin', 'admin', 'Petar Petrović', 'Petre');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL,
  `ImePrezime` varchar(255) NOT NULL,
  `DatumRodjenja` date NOT NULL,
  `Kontakt` varchar(255) NOT NULL,
  `MestoID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`StudentID`, `ImePrezime`, `DatumRodjenja`, `Kontakt`, `MestoID`) VALUES
(9, 'Mihailo Mitrović', '1999-10-14', '062326123', 7),
(10, 'Ana Ivanović', '2000-09-02', '065348431', 8),
(13, 'Jovan Jovanović', '2012-04-03', '062123123', 3),
(15, 'Marko Marković', '2004-04-04', '063028324', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ispit`
--
ALTER TABLE `ispit`
  ADD PRIMARY KEY (`IspitID`);

--
-- Indexes for table `ispitnirok`
--
ALTER TABLE `ispitnirok`
  ADD PRIMARY KEY (`IspitniRokID`);

--
-- Indexes for table `mesto`
--
ALTER TABLE `mesto`
  ADD PRIMARY KEY (`MestoID`);

--
-- Indexes for table `prijavaispita`
--
ALTER TABLE `prijavaispita`
  ADD PRIMARY KEY (`PrijavaID`),
  ADD KEY `FK_ISPIT` (`IspitID`),
  ADD KEY `FK_ROK` (`IspitniRokID`),
  ADD KEY `FK_STUDENT` (`StudentID`),
  ADD KEY `FK_SLUZBENIK` (`SluzbenikID`);

--
-- Indexes for table `racunprijaveispita`
--
ALTER TABLE `racunprijaveispita`
  ADD PRIMARY KEY (`RacunID`),
  ADD KEY `FK_PRIJAVA` (`PrijavaID`);

--
-- Indexes for table `sluzbenik`
--
ALTER TABLE `sluzbenik`
  ADD PRIMARY KEY (`SluzbenikID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`StudentID`),
  ADD KEY `FK_MESTO` (`MestoID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ispit`
--
ALTER TABLE `ispit`
  MODIFY `IspitID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `ispitnirok`
--
ALTER TABLE `ispitnirok`
  MODIFY `IspitniRokID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `mesto`
--
ALTER TABLE `mesto`
  MODIFY `MestoID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `prijavaispita`
--
ALTER TABLE `prijavaispita`
  MODIFY `PrijavaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `racunprijaveispita`
--
ALTER TABLE `racunprijaveispita`
  MODIFY `RacunID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1019;

--
-- AUTO_INCREMENT for table `sluzbenik`
--
ALTER TABLE `sluzbenik`
  MODIFY `SluzbenikID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `StudentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `prijavaispita`
--
ALTER TABLE `prijavaispita`
  ADD CONSTRAINT `FK_ISPIT` FOREIGN KEY (`IspitID`) REFERENCES `ispit` (`IspitID`),
  ADD CONSTRAINT `FK_ROK` FOREIGN KEY (`IspitniRokID`) REFERENCES `ispitnirok` (`IspitniRokID`),
  ADD CONSTRAINT `FK_SLUZBENIK` FOREIGN KEY (`SluzbenikID`) REFERENCES `sluzbenik` (`SluzbenikID`),
  ADD CONSTRAINT `FK_STUDENT` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`);

--
-- Constraints for table `racunprijaveispita`
--
ALTER TABLE `racunprijaveispita`
  ADD CONSTRAINT `FK_PRIJAVA` FOREIGN KEY (`PrijavaID`) REFERENCES `prijavaispita` (`PrijavaID`),
  ADD CONSTRAINT `racunprijaveispita_ibfk_1` FOREIGN KEY (`PrijavaID`) REFERENCES `prijavaispita` (`PrijavaID`);

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `FK_MESTO` FOREIGN KEY (`MestoID`) REFERENCES `mesto` (`MestoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
