/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.28-MariaDB : Database - baza
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`baza` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `baza`;

/*Table structure for table `counter` */

DROP TABLE IF EXISTS `counter`;

CREATE TABLE `counter` (
  `TableName` varchar(100) NOT NULL DEFAULT '',
  `Counter` int(11) DEFAULT '0',
  PRIMARY KEY (`TableName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `counter` */

insert  into `counter`(`TableName`,`Counter`) values 
('DKIspitnaPrijava',11);

/*Table structure for table `dkprijavaclanova` */

DROP TABLE IF EXISTS `dkprijavaclanova`;

CREATE TABLE `dkprijavaclanova` (
  `sifraPrijave` int(11) NOT NULL DEFAULT '0',
  `ime` varchar(100) DEFAULT NULL,
  `prezime` int(100) DEFAULT '0',
  `pozicija` varchar(100) DEFAULT '0',
  `Datum` date DEFAULT NULL,
  PRIMARY KEY (`sifraPrijave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `dkprijavaclanova` */

insert  into `dkprijavaclanova`(`sifraPrijave`,`ime`,`prezime`,`pozicija`,`Datum`) values 
(1,'000000',0,'5','2018-10-31'),
(2,'000000',0,'5','2018-10-31'),
(3,'000000',0,'5','2018-10-31'),
(4,'000000',0,'5','2018-10-31'),
(5,'000000',0,'5','2018-10-31'),
(6,'000000',0,'5','2018-10-31'),
(8,'000000',0,'5','2018-10-31'),
(9,'0000-00',0,'5','2018-10-31');

/* Procedure structure for procedure `upgrade_database` */

/*!50003 DROP PROCEDURE IF EXISTS  `upgrade_database` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `upgrade_database`()
BEGIN
 DECLARE _count INT;
 SET _count = (  SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS  
 WHERE   TABLE_SCHEMA = 'PAF4' AND TABLE_NAME = 'Counter' AND COLUMN_NAME = 'TableName'); 
 IF _count = 0 THEN  ALTER TABLE Counter ADD COLUMN  `TableName` varchar(100)  ; END IF; 
   
 SET _count = (  SELECT COUNT(*) FROM INFORMATION_SCHEMA.COLUMNS  
 WHERE   TABLE_SCHEMA = 'PAF4' AND TABLE_NAME = 'Counter' AND COLUMN_NAME = 'Counter'); 
 IF _count = 0 THEN  ALTER TABLE Counter ADD COLUMN  `Counter` int  DEFAULT 0; END IF;
SET _count = (  SELECT COUNT(*) FROM Counter);  
 IF _count = 0 THEN   insert  into `counter`(`TableName`,`Counter`) values  ('IspitnaPrijava',0); END IF; 
 
   
END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
