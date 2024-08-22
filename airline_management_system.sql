-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 21, 2024 at 03:58 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `airline_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `ID` int(100) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `User_Name` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Contact_No` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`ID`, `Name`, `User_Name`, `Password`, `Address`, `Contact_No`) VALUES
(1, 'Mohammadh Rimaz', 'MRimaz2', '1234@Rmz', 'Welamboda', 773397333);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Cus_ID` varchar(100) NOT NULL,
  `Customer_Name` varchar(255) NOT NULL,
  `Gender` text NOT NULL,
  `Age` int(3) NOT NULL,
  `Nationality` text NOT NULL,
  `Passport_No` varchar(15) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Contact_NO` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cus_ID`, `Customer_Name`, `Gender`, `Age`, `Nationality`, `Passport_No`, `Email`, `Address`, `Contact_NO`) VALUES
('C0001', 'Anjali N', 'Female', 31, 'Sri Lanka', '4987392231A', 'anjali@gmail.com', '21, Kandy Road, Gelioya.', 773232982),
('C0002', 'Micheal', 'Male', 32, 'Sri Lanka', '729852929A', 'micheal123@gmail.com', '81, Colombo Road, Jaffna.', 778289229),
('C0003', 'Mohamed Faris', 'Male', 40, 'Pakistan', '9739742922A', 'mfarisss@gmail.com', '62/2, Lahore City, Pakistan ', 777292992),
('C0004', 'Nivetha Swamy', 'Female', 25, 'India', '8593202020A', 'nivethaswamy@gmail.com', '1200/52, Vellore, Chennai.', 1128383737),
('C0005', 'Anjana Madhav', 'Male', 39, 'Sri Lanka', '9642799623A', 'madhav76@gmail.com', '33, Wellawatte, Colombo.', 714382992),
('C0006', 'Zaky', 'Female', 42, 'Sri Lanka', '4978252603', 'zaky342@gmail.com', '10/2, Matale rd, Kandy', 793279412);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `NO` int(100) NOT NULL,
  `Customer_ID` varchar(100) NOT NULL,
  `Customer_Name` varchar(100) NOT NULL,
  `Feedback` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`NO`, `Customer_ID`, `Customer_Name`, `Feedback`) VALUES
(1, 'C0003', 'Mohamed Faris', 'Thank you for giving me the cheap rate of ticket. Please consider online features for customer needs... ');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE `flight` (
  `No` int(100) NOT NULL,
  `Airline` varchar(255) NOT NULL,
  `Flight_No` varchar(20) NOT NULL,
  `No_of_Seats` int(100) NOT NULL,
  `Booked_Seats` int(100) NOT NULL DEFAULT 0,
  `Available_Seats` int(100) DEFAULT NULL,
  `Seat_Type` varchar(100) NOT NULL,
  `Source` varchar(100) NOT NULL,
  `Departure_Date` varchar(30) NOT NULL,
  `Departure_Time` varchar(30) NOT NULL,
  `Destination` varchar(100) NOT NULL,
  `Arrival_Date` varchar(30) NOT NULL,
  `Arrival_Time` varchar(30) NOT NULL,
  `Ticket_Price` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`No`, `Airline`, `Flight_No`, `No_of_Seats`, `Booked_Seats`, `Available_Seats`, `Seat_Type`, `Source`, `Departure_Date`, `Departure_Time`, `Destination`, `Arrival_Date`, `Arrival_Time`, `Ticket_Price`) VALUES
(12, 'Sri Lankan Airlines', 'S1', 400, 0, 400, 'Economy Class, Business Class', 'Colombo - Sri Lanka', '2023/09/30', '9.00 am', 'Delhi - India', '2023/09/30', '10.55 am', '60000, 100000'),
(13, 'Qatar Airways', 'QA1', 600, 2, 598, 'Economy Class, Business Class, First Class', 'Doha - Qatar', '2023/10/05', '7.00 pm', 'Colombo - Sri Lanka', '2023/10/06', '2.00 am', '120000, 200000, 350000'),
(14, 'Dubai Emirates', 'DE1', 450, -1, 451, 'Economy Class, Business Class', 'Dubai - UAE', '2023/10/10', '2.00 am', 'Melbourne - Australia', '2023/10/11', '5.00 pm', '400000, 500000'),
(15, 'Sri Lankan Airlines', 'S2', 250, 1, 249, 'Economy Class, Business Class', 'Colombo - Sri Lanka', '2023/09/28', '8.35 pm', 'Chennai - India', '2023/09/28', '9.40 pm', '40000, 95000');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `ID` int(100) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Gender` text NOT NULL,
  `NIC` varchar(15) NOT NULL,
  `User_Name` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Contact_No` int(12) NOT NULL,
  `Payment` decimal(20,2) NOT NULL,
  `Shift` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`ID`, `Name`, `Gender`, `NIC`, `User_Name`, `Password`, `Email`, `Address`, `Contact_No`, `Payment`, `Shift`) VALUES
(1, 'L Kumar', 'Male', '9738486582v', 'Kumar1', '123kumar', 'kumar1@gmail.com', '64, Colombo rd, Kandy.', 711687384, '40000.00', 'Day'),
(3, 'Julia A', 'Female', '2001454343', 'Juli#1', '4567', 'julia2@gmail.com', '34/2, Gampola.', 773423429, '30000.00', 'Day'),
(4, 'T Perera', 'Male', '54285394710', 'Perera1', 'Pera32', 'per12@gmail.com', '65/1, Galle', 738947936, '30000.00', 'Night');

-- --------------------------------------------------------

--
-- Table structure for table `ticket_booking`
--

CREATE TABLE `ticket_booking` (
  `Tic_ID` varchar(255) NOT NULL,
  `Booking_Date` varchar(30) NOT NULL,
  `Cus_ID` varchar(255) NOT NULL,
  `Customer_Name` varchar(255) NOT NULL,
  `Nationality` varchar(255) NOT NULL,
  `Passport_No` varchar(15) NOT NULL,
  `Flight_No` varchar(10) NOT NULL,
  `Source` varchar(255) NOT NULL,
  `Departure_Date` varchar(100) NOT NULL,
  `Departure_Time` varchar(100) NOT NULL,
  `Destination` varchar(255) NOT NULL,
  `Arrival_Date` varchar(100) NOT NULL,
  `Arrival_Time` varchar(100) NOT NULL,
  `Seat_Type` varchar(100) NOT NULL,
  `Ticket_Price` varchar(100) NOT NULL,
  `Discount` varchar(10) NOT NULL,
  `Discount_Price` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket_booking`
--

INSERT INTO `ticket_booking` (`Tic_ID`, `Booking_Date`, `Cus_ID`, `Customer_Name`, `Nationality`, `Passport_No`, `Flight_No`, `Source`, `Departure_Date`, `Departure_Time`, `Destination`, `Arrival_Date`, `Arrival_Time`, `Seat_Type`, `Ticket_Price`, `Discount`, `Discount_Price`) VALUES
('T0001', '2023/09/27', 'C0001', 'Anjali N', 'Sri Lanka', '4987392231A', 'QA1', 'Doha - Qatar', '2023/10/05', '7.00 pm', 'Colombo - Sri Lanka', '2023/10/06', '2.00 am', 'Economy Class', '120000', '11', '106800.00'),
('T0002', '2023/09/20', 'C0002', 'Micheal', 'Sri Lanka', '729852929A', 'QA1', 'Doha - Qatar', '2023/10/05', '7.00 pm', 'Colombo - Sri Lanka', '2023/10/06', '2.00 am', 'Economy Class', '120000', '12', '105600.00'),
('T0003', '2023/09/27', 'C0003', 'Mohamed Faris', 'Pakistan', '9739742922A', 'S1', 'Colombo - Sri Lanka', '2023/09/30', '9.00 am', 'Delhi - India', '2023/09/30', '10.55 am', 'Economy Class', '60000', '15', '51000.00'),
('T0004', '2023/09/27', 'C0004', 'Nivetha Swamy', 'India', '8593202020A', 'S2', 'Colombo - Sri Lanka', '2023/09/28', '8.35 pm', 'Chennai - India', '2023/09/28', '9.40 pm', 'Business Class', '95000', '15', '80750.00');

-- --------------------------------------------------------

--
-- Table structure for table `ticket_cancellation`
--

CREATE TABLE `ticket_cancellation` (
  `No` int(100) NOT NULL,
  `Tic_ID` varchar(255) NOT NULL,
  `Customer_ID` varchar(255) NOT NULL,
  `Customer_Name` varchar(255) NOT NULL,
  `Passport_No` varchar(15) NOT NULL,
  `Flight_No` varchar(10) NOT NULL,
  `Booked_Date` varchar(255) NOT NULL,
  `Cancelled_Date` varchar(255) NOT NULL,
  `Seat_Type` varchar(100) NOT NULL,
  `Source` varchar(100) NOT NULL,
  `Destination` varchar(100) NOT NULL,
  `Fine` varchar(100) NOT NULL,
  `Refund` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ticket_cancellation`
--

INSERT INTO `ticket_cancellation` (`No`, `Tic_ID`, `Customer_ID`, `Customer_Name`, `Passport_No`, `Flight_No`, `Booked_Date`, `Cancelled_Date`, `Seat_Type`, `Source`, `Destination`, `Fine`, `Refund`) VALUES
(4, 'T0005', 'C0005', 'Anjana Madhav', '9642799623A', 'QA1', '2023/09/30', '2024/08/06', 'First Class', 'Doha - Qatar', 'Colombo - Sri Lanka', '10000', '340000.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `pswrd` (`Password`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Cus_ID`),
  ADD UNIQUE KEY `psprtno` (`Passport_No`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`NO`);

--
-- Indexes for table `flight`
--
ALTER TABLE `flight`
  ADD PRIMARY KEY (`No`),
  ADD UNIQUE KEY `Flight_No` (`Flight_No`) USING BTREE;

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `nic` (`NIC`);

--
-- Indexes for table `ticket_booking`
--
ALTER TABLE `ticket_booking`
  ADD PRIMARY KEY (`Tic_ID`);

--
-- Indexes for table `ticket_cancellation`
--
ALTER TABLE `ticket_cancellation`
  ADD PRIMARY KEY (`No`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `NO` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `flight`
--
ALTER TABLE `flight`
  MODIFY `No` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `ID` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `ticket_cancellation`
--
ALTER TABLE `ticket_cancellation`
  MODIFY `No` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
