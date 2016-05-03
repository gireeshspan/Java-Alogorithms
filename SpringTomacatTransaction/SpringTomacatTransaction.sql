# --------------------------------------------------------
# Host:                         localhost
# Database:                     companya
# Server version:               5.5.5-10.1.10-MariaDB
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2016-05-03 18:16:02
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for companya
DROP DATABASE IF EXISTS `companya`;
CREATE DATABASE IF NOT EXISTS `companya` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `companya`;


# Dumping structure for table companya.employeea
DROP TABLE IF EXISTS `employeea`;
CREATE TABLE IF NOT EXISTS `employeea` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `age` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
