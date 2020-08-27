/*
SQLyog Trial v10.2 
MySQL - 5.5.28 : Database - hu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hu` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hu`;

/*Table structure for table `info` */

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
  `accttype` varchar(100) DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `info` varchar(1000) DEFAULT NULL,
  `pay` varchar(100) DEFAULT NULL,
  `save` float DEFAULT NULL,
  `tranday` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `Id` int(11) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `result` */

DROP TABLE IF EXISTS `result`;

CREATE TABLE `result` (
  `resultcode` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `resultinfo` */

DROP TABLE IF EXISTS `resultinfo`;

CREATE TABLE `resultinfo` (
  `count` int(20) DEFAULT NULL,
  `pageno` int(20) DEFAULT NULL,
  `payqb` float DEFAULT NULL,
  `per` int(20) DEFAULT NULL,
  `saveqb` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* Procedure structure for procedure `hu_Tin` */

/*!50003 DROP PROCEDURE IF EXISTS  `hu_Tin` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `hu_Tin`(in param int)
begin
select param;
set param = 5;
select param;
end */$$
DELIMITER ;

/* Procedure structure for procedure `proc3` */

/*!50003 DROP PROCEDURE IF EXISTS  `proc3` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `proc3`()
begin
declare x1 varchar(5) default 'aaa';
begin
declare x1 varchar(5) default 'bbb';
select x1;
end;
select x1;
end */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
