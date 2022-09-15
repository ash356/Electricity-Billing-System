-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2021 at 07:36 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ashour`
--

-- --------------------------------------------------------

--
-- Table structure for table `adminstate`
--

CREATE TABLE `adminstate` (
  `district` varchar(50) NOT NULL,
  `cons_rate` int(11) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `adminstate`
--

INSERT INTO `adminstate` (`district`, `cons_rate`, `price`) VALUES
('Helwan', 1350, 1975),
('Naser city', 11100, 1595);

-- --------------------------------------------------------

--
-- Table structure for table `bills`
--

CREATE TABLE `bills` (
  `meter_no` int(11) NOT NULL,
  `month` varchar(50) NOT NULL DEFAULT '0',
  `status` varchar(50) NOT NULL DEFAULT 'Not Paid',
  `first_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bills`
--

INSERT INTO `bills` (`meter_no`, `month`, `status`, `first_date`) VALUES
(2020, 'April', 'Paid', '2021-03-10'),
(29264, '0', 'Not Paid', '2021-03-19'),
(101454, 'January', 'Paid', '2021-03-11'),
(279236, 'July', 'Paid', '2021-03-12'),
(412054, 'April', 'Paid', '2021-03-13'),
(469464, '0', 'Not Paid', '2021-03-14'),
(494567, 'February', 'Paid', '2021-03-15'),
(851143, '0', 'Not Paid', '2021-03-16'),
(958552, '0', 'Not Paid', '2021-03-17');

-- --------------------------------------------------------

--
-- Table structure for table `complains`
--

CREATE TABLE `complains` (
  `meter_no` int(11) NOT NULL,
  `complain` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `complains`
--

INSERT INTO `complains` (`meter_no`, `complain`) VALUES
(2020, '123745618');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `meter_no` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `national_id` int(11) NOT NULL,
  `phone_no` int(11) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `attach` varchar(10000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`meter_no`, `user_name`, `password`, `national_id`, `phone_no`, `address`, `email`, `city`, `attach`) VALUES
(2020, 'Ali', '1234', 10, 20, 'Tanta', 'rnze', 'Tanta', 'C:\\Users\\Ashour\\Desktop\\Pictures\\4.JPG'),
(29264, 'zezo', '1234', 25, 7896454, 'Giza', '@zezo', 'Giza', 'C:\\Users\\Ashour\\Desktop\\333.JPG'),
(101454, 'ehab', '1234', 15, 2316, 'elmarg', '@ehab', 'elmarg', 'E:\\Study\\Computer Science\\3rd Term\\PL2\\My Projects\\My_Electricity_Billing_System\\build.xml'),
(198163, 'Mona', '1234', 11, 10, 'Naser City', 'all', 'Naser City', 'C:\\Users\\Ashour\\Desktop\\00.JPG'),
(279236, 'Wafaa', '1234', 12, 651531, 'Helwan', 'vhgdtrd', 'Helwan', 'E:\\Study\\Computer Science\\3rd Term\\PL2\\My Projects\\My_Electricity_Billing_System\\dist\\run.cmd.txt'),
(412054, 'Ahmed', '1234', 13, 12, 'Alex', '@kkk', 'Alex', 'C:\\Users\\Ashour\\Desktop\\My_Electricity_Billing_System2222.zip'),
(430998, 'Heba', '1234', 20, 12, 'Tanta', 'heba@yahoo', 'Tanta', 'C:\\Users\\Ashour\\Desktop\\00.JPG'),
(469464, 'ola', '1234', 21, 1234, 'new cairo', '@ola', 'new cairo', 'E:\\Study\\Computer Science\\3rd Term\\PL2\\My Projects\\My_Electricity_Billing_System\\manifest.mf'),
(494567, 'hamdy', '1234', 454648, 138132, 'Naser City', '@hamdy', 'Naser City', 'C:\\Users\\Ashour\\Desktop\\00.JPG'),
(661524, 'Omnia', '1234', 14, 15, 'Elharm', '@omnia', 'Elharm', 'C:\\Users\\Ashour\\Desktop\\00.JPG'),
(688764, 'yousef', '1234', 20208298, 13216845, 'Elzagazeg', '@yousef', 'Elzagazeg', 'C:\\Users\\Public\\Desktop\\Apache NetBeans IDE 12.1.lnk'),
(842054, 'Alaa', '1234', 17, 12, 'Helwan', '@alaa', 'Helwan', 'C:\\Users\\Ashour\\Desktop\\GameLoop.lnk'),
(851143, 'elhacker', '1234', 16, 214864, 'Naser city', '@@@@ads', 'Naser city', 'E:\\Study\\Computer Science\\3rd Term\\PL2\\My Projects\\My_Electricity_Billing_System\\manifest.mf'),
(958552, 'mo', '1234', 19, 131, '151', '32132', '515', 'E:\\Study\\Computer Science\\3rd Term\\PL2\\My Projects\\My_Electricity_Billing_System\\manifest.mf');

-- --------------------------------------------------------

--
-- Table structure for table `customer_pay`
--

CREATE TABLE `customer_pay` (
  `meter_no` int(11) NOT NULL,
  `payment` int(11) NOT NULL,
  `tariff` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer_pay`
--

INSERT INTO `customer_pay` (`meter_no`, `payment`, `tariff`) VALUES
(2020, 400, 'Fifth'),
(279236, 5000, 'first');

-- --------------------------------------------------------

--
-- Table structure for table `monthly_reading`
--

CREATE TABLE `monthly_reading` (
  `meter_no` int(11) NOT NULL,
  `old_reading` int(100) DEFAULT 0,
  `month` varchar(50) NOT NULL DEFAULT '0',
  `new_reading` int(100) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `monthly_reading`
--

INSERT INTO `monthly_reading` (`meter_no`, `old_reading`, `month`, `new_reading`) VALUES
(2020, 100, 'March', 150),
(29264, 0, '0', 0),
(101454, 200, 'January', 0),
(198163, 0, 'March', 0),
(279236, 100, 'March', 150),
(412054, 2000, 'January', 2100),
(494567, 80, 'February', 0),
(661524, 500, 'January', 0),
(688764, 150, 'January', 0),
(851143, 0, '0', 0),
(958552, 100, 'February', 0);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `password`, `role_status`) VALUES
(54684, '1', '1234', 'Operator'),
(2000, '1234', '1234', 'Admin'),
(2001, '888', '1234', 'Admin'),
(13, 'Ahmed', '1234', 'Customer'),
(17, 'Alaa', '1234', 'Customer'),
(10, 'Ali', '1234', 'Customer'),
(15, 'ehab', '1234', 'Customer'),
(16, 'elhacker', '1234', 'Customer'),
(454648, 'hamdy', '1234', 'Customer'),
(20, 'Heba', '1234', 'Customer'),
(3030, 'michael', '1234', 'Operator'),
(19, 'mo', '1234', 'Customer'),
(11, 'Mona', '1234', 'Customer'),
(21, 'ola', '1234', 'Customer'),
(2002, 'omar', '1234', 'Admin'),
(14, 'Omnia', '1234', 'Customer'),
(12, 'Wafaa', '1234', 'Customer'),
(20208298, 'yousef', '1234', 'Customer'),
(25, 'zezo', '1234', 'Customer');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adminstate`
--
ALTER TABLE `adminstate`
  ADD PRIMARY KEY (`district`);

--
-- Indexes for table `bills`
--
ALTER TABLE `bills`
  ADD PRIMARY KEY (`meter_no`);

--
-- Indexes for table `complains`
--
ALTER TABLE `complains`
  ADD PRIMARY KEY (`meter_no`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`meter_no`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD UNIQUE KEY `national_id` (`national_id`);

--
-- Indexes for table `customer_pay`
--
ALTER TABLE `customer_pay`
  ADD PRIMARY KEY (`meter_no`);

--
-- Indexes for table `monthly_reading`
--
ALTER TABLE `monthly_reading`
  ADD PRIMARY KEY (`meter_no`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_name`),
  ADD UNIQUE KEY `user_id` (`user_id`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bills`
--
ALTER TABLE `bills`
  ADD CONSTRAINT `bills_ibfk_1` FOREIGN KEY (`meter_no`) REFERENCES `customers` (`meter_no`);

--
-- Constraints for table `complains`
--
ALTER TABLE `complains`
  ADD CONSTRAINT `complains_ibfk_1` FOREIGN KEY (`meter_no`) REFERENCES `customers` (`meter_no`);

--
-- Constraints for table `customer_pay`
--
ALTER TABLE `customer_pay`
  ADD CONSTRAINT `customer_pay_ibfk_1` FOREIGN KEY (`meter_no`) REFERENCES `customers` (`meter_no`);

--
-- Constraints for table `monthly_reading`
--
ALTER TABLE `monthly_reading`
  ADD CONSTRAINT `monthly_reading_ibfk_1` FOREIGN KEY (`meter_no`) REFERENCES `customers` (`meter_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
