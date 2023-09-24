SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
CREATE DATABASE `optisense`;
USE `optisense`;

CREATE TABLE `companies` (
  `CompanyCode` varchar(64) NOT NULL,
  `CompanyName` varchar(64) NOT NULL,
  `CompanyRole` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `companies` (`CompanyCode`, `CompanyName`, `CompanyRole`) VALUES
('AS01', 'AvOptics', 'Vendor'),
('BY01', 'Badimov Sensory', 'Client'),
('PL01', 'Pixart International', 'Vendor'),
('PS01', 'PACIFIX Sensors', 'Vendor'),
('PS02', 'Pandora Sensories', 'Vendor'),
('PS03', 'Pinnivara Optics', 'Vendor'),
('PT01', 'Pixart Optics', 'Vendor'),
('RG01', 'Rumafter Gaming', 'Client');

CREATE TABLE `employees` (
  `CompanyCode` varchar(64) NOT NULL,
  `EmployeeID` varchar(64) NOT NULL,
  `EmployeeFullName` varchar(64) NOT NULL,
  `EmployeePosition` varchar(64) NOT NULL,
  `EmployeePassword` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `employees` (`CompanyCode`, `EmployeeID`, `EmployeeFullName`, `EmployeePosition`, `EmployeePassword`) VALUES
('AS01', 'AS01000002', 'Adi Davis', 'Product Management Supervisor', 'sasiso'),
('AS01', 'AS01005001', 'Hardin Sutanto', 'Storage Manager', 'sutantoh'),
('PL01', 'PL01000002', 'Nikola Adder', 'Sales Management Officer', 'jason'),
('PL01', 'PL01005663', 'Fakhrul Azman', 'Nordic Export Supervisor', 'fakhrul'),
('PS03', 'PS03000001', 'Kalvin Susanto', 'Product Management Officer', 'kalvins'),
('PT01', 'PT01000016', 'Ihsan Mukimin', 'Export Supervisor', 'ihsanaaa'),
('PT01', 'PT01007532', 'Rodeyanto', 'Export Manager', 'ksa051'),
('RG01', 'RG01006323', 'Kelvin Amadeus', 'Supply Manager', 'kelvins');

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `SensorID` int(11) NOT NULL,
  `ClientCode` varchar(64) NOT NULL,
  `OrderQuantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `orders` (`OrderID`, `SensorID`, `ClientCode`, `OrderQuantity`) VALUES
(6, 4, 'RG01', 5),
(7, 15, 'RG01', 4),
(8, 9, 'RG01', 5),
(9, 1, 'RG01', 1),
(10, 2, 'RG01', 1),
(11, 3, 'RG01', 2),
(13, 11, 'RG01', 2);

CREATE TABLE `sensors` (
  `SensorID` int(11) NOT NULL,
  `VendorCode` varchar(64) NOT NULL,
  `SensorName` varchar(64) NOT NULL,
  `SensorType` varchar(64) NOT NULL,
  `SensorSpeed` int(11) NOT NULL,
  `SensorPrice` int(11) NOT NULL,
  `SensorStock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `sensors` (`SensorID`, `VendorCode`, `SensorName`, `SensorType`, `SensorSpeed`, `SensorPrice`, `SensorStock`) VALUES
(1, 'AS01', 'AJX-01', 'Optical', 10000, 250000, 100),
(2, 'AS01', 'AvLite 24K', 'Optical', 24400, 445000, 100),
(3, 'PL01', 'Luminesce L', 'Optical', 22000, 650000, 55),
(4, 'PL01', 'Luminesce LX', 'Optical', 24000, 750000, 50),
(5, 'PS03', 'Hellovara (Legacy)', 'Laser', 6000, 450000, 36),
(6, 'PS03', 'Hellovara II', 'Laser', 16000, 575000, 100),
(7, 'PS03', 'Hellovara III', 'Laser', 16000, 605000, 100),
(8, 'PS03', 'Neovara', 'Optical', 12000, 450000, 200),
(9, 'PS03', 'Neovara Plus', 'Optical', 16000, 600000, 100),
(10, 'PS03', 'Neovara Xtreme', 'Optical', 24000, 650000, 100),
(11, 'PT01', 'Luminox LM-11', 'Optical', 24000, 800000, 50),
(12, 'PT01', 'Luminox LM-5', 'Optical', 16000, 550000, 250),
(13, 'PT01', 'Luminox LM-9', 'Optical', 16000, 700000, 100),
(14, 'PT01', 'Luminox One', 'Optical', 32000, 1050000, 20),
(15, 'PT01', 'Vigilon MVT-A', 'Laser', 16000, 435000, 102);


ALTER TABLE `companies`
  ADD PRIMARY KEY (`CompanyCode`);

ALTER TABLE `employees`
  ADD PRIMARY KEY (`EmployeeID`),
  ADD KEY `FK_CompanyCode` (`CompanyCode`);

ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `FK_ClientCode` (`ClientCode`),
  ADD KEY `FK_SensorID` (`SensorID`);

ALTER TABLE `sensors`
  ADD PRIMARY KEY (`SensorID`),
  ADD KEY `FK_VendorCode` (`VendorCode`);


ALTER TABLE `orders`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

ALTER TABLE `sensors`
  MODIFY `SensorID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;


ALTER TABLE `employees`
  ADD CONSTRAINT `FK_CompanyCode` FOREIGN KEY (`CompanyCode`) REFERENCES `companies` (`CompanyCode`) ON DELETE CASCADE ON UPDATE CASCADE;
  
ALTER TABLE `sensors`
 ADD CONSTRAINT `FK_VendorCode` FOREIGN KEY (`VendorCode`) REFERENCES `companies` (`CompanyCode`) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE `orders`
  ADD CONSTRAINT `FK_ClientCode` FOREIGN KEY (`ClientCode`) REFERENCES `companies` (`CompanyCode`) ON DELETE CASCADE ON UPDATE CASCADE;
  
ALTER TABLE `orders`
  ADD CONSTRAINT `FK_SensorID` FOREIGN KEY (`SensorID`) REFERENCES `sensors` (`SensorID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
