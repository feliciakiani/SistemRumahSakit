-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:4306
-- Generation Time: Jul 05, 2022 at 05:47 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tubespbo`
--

-- --------------------------------------------------------

--
-- Table structure for table `antrian`
--

CREATE TABLE `antrian` (
  `idAntrian` int(10) NOT NULL AUTO_INCREMENT,
  `idSpesialis` int(10) NOT NULL,
  `idDokter` int(10) NOT NULL,
  `idPasien` int(10) NOT NULL,
  `tanggalPesan` date NOT NULL,
  `tanggalPeriksa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `antrian`
--

INSERT INTO `antrian` (`idAntrian`, `idSpesialis`, `idDokter`, `idPasien`, `tanggalPesan`, `tanggalPeriksa`) VALUES
(1, 4, 5, 3, '2022-07-03', '2022-07-05'),
(2, 1, 1, 2, '2022-07-04', '2022-08-07'),
(3, 1, 1, 1, '2022-07-05', '2022-08-09'),
(4, 2, 3, 4, '2022-07-05', '2022-07-29'),
(5, 3, 4, 2, '2022-07-05', '2022-07-25');

-- --------------------------------------------------------

--
-- Table structure for table `dokter`
--

CREATE TABLE `dokter` (
  `idDokter` int(10) NOT NULL AUTO_INCREMENT,
  `idSpesialis` int(10) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(1) NOT NULL,
  `jamMulaiPrak` int(2) NOT NULL,
  `jamSelesaiPrak` int(2) NOT NULL,
  `pendapatan` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dokter`
--

INSERT INTO `dokter` (`idDokter`, `idSpesialis`, `firstName`, `lastName`, `email`, `address`, `phone`, `dob`, `gender`, `jamMulaiPrak`, `jamSelesaiPrak`, `pendapatan`) VALUES
(1, 1, 'Dr. Rahmat', 'Sutanto', 'rahmatsutanto@gmail.com', 'Jl. Pajajaran no. 100', '081231231234', '1982-07-15', 'M', 10, 19, 300000),
(2, 1, 'Dr. Rita', 'Rosa', 'ritarosa@gmail.com', 'Jl. Pasirkaliki no. 50', '083211231234', '1971-03-24', 'F', 11, 18, 400000),
(3, 2, 'Dr. Budi', 'Budiman', 'budibudiman@gmail.com', 'Jl. Pasirkoja no. 75', '083213211234', '1965-12-30', 'M', 13, 20, 500000),
(4, 3, 'Dr. Ani', 'Sumarni', 'anisumarni@gmail.com', 'Jl. Cicendo no. 20', '083213213214', '1990-10-11', 'F', 12, 20, 350000),
(5, 4, 'Dr. Agus', 'Toni', 'agustoni@gmail.com', 'Jl. Durian no. 5', '083214323214', '1988-12-21', 'M', 12, 19, 250000);

-- --------------------------------------------------------

--
-- Table structure for table `koas`
--

CREATE TABLE `koas` (
  `idKoas` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(1) NOT NULL,
  `universitas` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `koas`
--

INSERT INTO `koas` (`idKoas`, `firstName`, `lastName`, `email`, `address`, `phone`, `dob`, `gender`, `universitas`) VALUES
(1, 'Anto', 'Sumanto', 'antosumanto@gmail.com', 'Jl. Cempaka no. 1', '081235435431', '1997-04-16', 'M', 'UNIVERSITAS INDONESIA'),
(2, 'Aurel', 'Angelica', 'aurelangelica@gmail.com', 'Jl. Otista no. 99', '081239879870', '1999-02-15', 'F', 'UNIVERSITAS PADJAJARAN');

-- --------------------------------------------------------

--
-- Table structure for table `pasien`
--

CREATE TABLE `pasien` (
  `idPasien` int(10) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `address` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(1) NOT NULL,
  `penyakit` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pasien`
--

INSERT INTO `pasien` (`idPasien`, `firstName`, `lastName`, `email`, `address`, `phone`, `dob`, `gender`, `penyakit`) VALUES
(1, 'Hansel', 'Raphaelo', 'hanselrk@gmail.com', 'Jl. Muara no. 2', '081701799912', '2003-07-09', 'M', ''),
(2, 'Vincent', 'Christian', 'vcl36@gmail.com', 'Jl. Astana Anyar no. 40', '081122799912', '2002-12-31', 'M', ''),
(3, 'Michaela', 'Sheren', 'mikaela@gmail.com', 'Jl. Mekar Wangi no. 33', '081846129912', '2003-04-22', 'F', 'Mata Katarak'),
(4, 'Felicia', 'Kiani', 'felicia@gmail.com', 'Jl. BKR no. 123', '081846996312', '2003-08-12', 'F', '');

-- --------------------------------------------------------

--
-- Table structure for table `pemeriksaan`
--

CREATE TABLE `pemeriksaan` (
  `idPemeriksaan` int(10) NOT NULL AUTO_INCREMENT,
  `idDokter` int(10) NOT NULL,
  `idPasien` int(10) NOT NULL,
  `idKoas` int(10) NOT NULL,
  `biaya` int(15) NOT NULL,
  `penyakit` varchar(255) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pemeriksaan`
--

INSERT INTO `pemeriksaan` (`idPemeriksaan`, `idDokter`, `idPasien`, `idKoas`, `biaya`, `penyakit`, `tanggal`) VALUES
(1, 5, 3, 1, 1000000, 'Mata Katarak', '2022-07-05');

-- --------------------------------------------------------

--
-- Table structure for table `spesialis`
--

CREATE TABLE `spesialis` (
  `idSpesialis` int(10) NOT NULL AUTO_INCREMENT,
  `bidangSpesialis` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `spesialis`
--

INSERT INTO `spesialis` (`idSpesialis`, `bidangSpesialis`) VALUES
(1, 'Spesialis Anak'),
(2, 'Spesialis Saraf'),
(3, 'Spesialis Bedah'),
(4, 'Spesialis Mata');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`username`, `password`, `fullName`, `email`, `role`) VALUES
('manager', 'manager', 'Saya Manager', 'managernihbos@gmail.com', 'MANAGER'),
('admin', 'admin', 'Saya Admin', 'adminnihbos@gmail.com', 'ADMIN'),
('user1', 'user1', 'Saya User 1', 'user1@gmail.com', 'PENGGUNA'),
('user2', 'user2', 'Saya User 2', 'user2@gmail.com', 'PENGGUNA'),
('user3', 'user3', 'Saya User 3', 'user3@gmail.com', 'PENGGUNA');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `antrian`
--
ALTER TABLE `antrian`
  ADD PRIMARY KEY (`idAntrian`),
  ADD KEY `idSpesialis` (`idSpesialis`),
  ADD KEY `idDokter` (`idDokter`),
  ADD KEY `idPasien` (`idPasien`);

--
-- Indexes for table `dokter`
--
ALTER TABLE `dokter`
  ADD PRIMARY KEY (`idDokter`),
  ADD KEY `idSpesialis` (`idSpesialis`);

--
-- Indexes for table `koas`
--
ALTER TABLE `koas`
  ADD PRIMARY KEY (`idKoas`);

--
-- Indexes for table `pasien`
--
ALTER TABLE `pasien`
  ADD PRIMARY KEY (`idPasien`);

--
-- Indexes for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD PRIMARY KEY (`idPemeriksaan`),
  ADD KEY `idDokter` (`idDokter`),
  ADD KEY `idPasien` (`idPasien`),
  ADD KEY `idKoas` (`idKoas`);

--
-- Indexes for table `spesialis`
--
ALTER TABLE `spesialis`
  ADD PRIMARY KEY (`idSpesialis`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `antrian`
--
ALTER TABLE `antrian`
  ADD CONSTRAINT `antrian_ibfk_1` FOREIGN KEY (`idDokter`) REFERENCES `dokter` (`idDokter`),
  ADD CONSTRAINT `antrian_ibfk_2` FOREIGN KEY (`idPasien`) REFERENCES `pasien` (`idPasien`),
  ADD CONSTRAINT `antrian_ibfk_3` FOREIGN KEY (`idSpesialis`) REFERENCES `spesialis` (`idSpesialis`);

--
-- Constraints for table `dokter`
--
ALTER TABLE `dokter`
  ADD CONSTRAINT `dokter_ibfk_1` FOREIGN KEY (`idSpesialis`) REFERENCES `spesialis` (`idSpesialis`);

--
-- Constraints for table `pemeriksaan`
--
ALTER TABLE `pemeriksaan`
  ADD CONSTRAINT `pemeriksaan_ibfk_1` FOREIGN KEY (`idDokter`) REFERENCES `dokter` (`idDokter`),
  ADD CONSTRAINT `pemeriksaan_ibfk_2` FOREIGN KEY (`idPasien`) REFERENCES `pasien` (`idPasien`),
  ADD CONSTRAINT `pemeriksaan_ibfk_3` FOREIGN KEY (`idKoas`) REFERENCES `koas` (`idKoas`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
