-- Adminer 4.8.1 MySQL 5.5.5-10.4.24-MariaDB dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

USE `company`;

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `DNumber` int(11) NOT NULL,
  `DName` varchar(15) NOT NULL,
  `MgrSSN` char(9) NOT NULL,
  `MgrStartDate` date DEFAULT NULL,
  PRIMARY KEY (`DNumber`),
  UNIQUE KEY `Dept_DName_Unique` (`DName`),
  KEY `Dept_MgrSSN_FK` (`MgrSSN`),
  CONSTRAINT `Dept_MgrSSN_FK` FOREIGN KEY (`MgrSSN`) REFERENCES `employee` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `department` (`DNumber`, `DName`, `MgrSSN`, `MgrStartDate`) VALUES
(1,	'HRD',	'A111',	'2004-01-20'),
(2,	'FINANCE',	'A112',	'2003-03-17'),
(3,	'HUMAS',	'A113',	'2006-05-28'),
(4,	'PRODUKSI',	'A114',	'2005-02-10');

DROP TABLE IF EXISTS `dependent`;
CREATE TABLE `dependent` (
  `ESSN` char(9) NOT NULL,
  `Dependent_Name` varchar(15) NOT NULL,
  `Sex` char(1) DEFAULT NULL,
  `BDate` date DEFAULT NULL,
  `Relationship` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ESSN`,`Dependent_Name`),
  CONSTRAINT `Dependent_ESSN_FK` FOREIGN KEY (`ESSN`) REFERENCES `employee` (`SSN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `dependent` (`ESSN`, `Dependent_Name`, `Sex`, `BDate`, `Relationship`) VALUES
('A111',	'Beni',	'M',	'2005-09-20',	'DAUGHTER'),
('A111',	'Beti',	'F',	'2007-12-01',	'SON'),
('A111',	'Dina',	'F',	'0000-00-00',	'WIFE'),
('A112',	'Amel',	'F',	'0000-00-00',	'WIFE'),
('A112',	'Roy',	'M',	'2007-11-21',	'SON'),
('A112',	'Wandi',	'M',	'1990-10-19',	'HUSBAND'),
('A113',	'Devy',	'F',	'0000-00-00',	'DAUGHTER'),
('A113',	'Roby',	'M',	'1980-08-20',	'HUSBAND'),
('A114',	'Ratih',	'F',	'0000-00-00',	'DAUGHTER'),
('A114',	'Rini',	'F',	'0000-00-00',	'WIFE'),
('A114',	'Susan',	'F',	'0000-00-00',	'WIFE'),
('A115',	'Riko',	'M',	'0000-00-00',	'SON'),
('A115',	'Tika',	'F',	'0000-00-00',	'DAUGHTER'),
('A116',	'Dito',	'M',	'0000-00-00',	'SON'),
('A117',	'Nindy',	'F',	'0000-00-00',	'WIFE');

DROP TABLE IF EXISTS `dept_locations`;
CREATE TABLE `dept_locations` (
  `DNum` int(11) NOT NULL,
  `DLocation` varchar(15) NOT NULL,
  PRIMARY KEY (`DNum`,`DLocation`),
  CONSTRAINT `DLoc_DNum_FK` FOREIGN KEY (`DNum`) REFERENCES `department` (`DNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `dept_locations` (`DNum`, `DLocation`) VALUES
(1,	'Office Tower'),
(2,	'Office Tower'),
(3,	'KCU'),
(4,	'KCP');

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `SSN` char(9) NOT NULL,
  `FName` varchar(15) NOT NULL,
  `MName` char(1) DEFAULT NULL,
  `LName` varchar(15) NOT NULL,
  `BDate` date DEFAULT NULL,
  `Address` varchar(30) DEFAULT NULL,
  `Sex` char(1) DEFAULT NULL,
  `Salary` decimal(10,2) DEFAULT NULL,
  `SuperSSN` char(9) DEFAULT NULL,
  `DNum` int(11) NOT NULL,
  PRIMARY KEY (`SSN`),
  KEY `Employee_SuperSSN_FK` (`SuperSSN`),
  CONSTRAINT `Employee_SuperSSN_FK` FOREIGN KEY (`SuperSSN`) REFERENCES `employee` (`SSN`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `employee` (`SSN`, `FName`, `MName`, `LName`, `BDate`, `Address`, `Sex`, `Salary`, `SuperSSN`, `DNum`) VALUES
('A110',	'Andi',	NULL,	'Sasmita',	'1995-02-27',	'Bali',	'M',	3750000.00,	'A112',	2),
('A111',	'Indirwan',	'I',	'Hasibuan',	'1997-10-14',	'Medan',	'M',	15000000.00,	'A111',	1),
('A112',	'Yusuf',	'R',	'Tamba',	'0000-00-00',	'Medan',	'M',	4000000.00,	NULL,	2),
('A113',	'Winda',	NULL,	'Aja',	'1998-03-19',	'Jambi',	'F',	4500000.00,	NULL,	3),
('A114',	'Kevin',	NULL,	'Pachira',	'1987-05-18',	'Kisaran',	'M',	3500000.00,	NULL,	4),
('A115',	'Pevita',	NULL,	'Pearce',	'1986-06-16',	'Tangerang',	'F',	3500000.00,	'A111',	1),
('A116',	'Raline',	NULL,	'Syah',	'1985-12-11',	'Jaksel',	'F',	3500000.00,	'A111',	1),
('A117',	'Diana',	'Y',	'Haidar',	'1990-08-03',	'Bali',	'F',	4500000.00,	'A111',	1),
('A118',	'Muhammad',	'A',	'Rojali',	'1992-06-05',	'Tangerang',	'M',	3500000.00,	'A111',	1),
('A119',	'Muhammad',	'R',	'Pratama',	'1994-01-21',	'Jambi',	'M',	3200000.00,	'A111',	2);

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `PNumber` int(11) NOT NULL,
  `PName` varchar(15) NOT NULL,
  `PLocation` varchar(15) DEFAULT NULL,
  `DNum` int(11) NOT NULL,
  PRIMARY KEY (`PNumber`),
  UNIQUE KEY `Project_PName_Unique` (`PName`),
  KEY `Project_DNum_FK` (`DNum`),
  CONSTRAINT `Project_DNum_FK` FOREIGN KEY (`DNum`) REFERENCES `department` (`DNumber`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `project` (`PNumber`, `PName`, `PLocation`, `DNum`) VALUES
(1,	'Database',	'Jakarta',	1),
(2,	'Springboot',	'Jakarta',	2),
(3,	'FrondEnd',	'Bekasi',	2),
(4,	'BackEnd',	'Tangerang',	2),
(5,	'QATest',	'Depok',	3),
(6,	'Code',	'Bali',	3),
(7,	'Break',	'Tangerang',	4),
(8,	'Deep',	'Depok',	4);

DROP TABLE IF EXISTS `works_on`;
CREATE TABLE `works_on` (
  `ESSN` char(9) NOT NULL,
  `PNum` int(11) NOT NULL,
  `Hours` decimal(3,1) NOT NULL,
  PRIMARY KEY (`ESSN`,`PNum`),
  KEY `Works_PNum_FK` (`PNum`),
  CONSTRAINT `Works_ESSN_FK` FOREIGN KEY (`ESSN`) REFERENCES `employee` (`SSN`) ON DELETE CASCADE,
  CONSTRAINT `Works_PNum_FK` FOREIGN KEY (`PNum`) REFERENCES `project` (`PNumber`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `works_on` (`ESSN`, `PNum`, `Hours`) VALUES
('A110',	2,	34.0),
('A110',	3,	78.0),
('A111',	1,	90.0),
('A111',	2,	98.0),
('A112',	2,	55.0),
('A112',	3,	78.0),
('A113',	3,	53.0),
('A113',	4,	77.0),
('A114',	4,	77.0),
('A114',	5,	98.0),
('A114',	7,	85.0),
('A114',	8,	68.0),
('A115',	5,	57.0),
('A115',	6,	87.0),
('A116',	6,	87.0),
('A116',	7,	45.0),
('A117',	7,	40.0),
('A117',	8,	88.0),
('A118',	1,	78.0),
('A118',	8,	87.0),
('A119',	1,	88.0),
('A119',	2,	65.0);

-- 2022-06-21 16:36:48
