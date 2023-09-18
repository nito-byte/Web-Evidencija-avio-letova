-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: let1
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Flight`
--

DROP TABLE IF EXISTS `Flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Flight` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BrojLeta` varchar(45) DEFAULT NULL,
  `AirportFrom` varchar(45) DEFAULT NULL,
  `AirportTo` varchar(45) DEFAULT NULL,
  `Start` datetime DEFAULT NULL,
  `Time` time DEFAULT NULL,
  `Airplane` varchar(45) DEFAULT NULL,
  `PlaniranoVreme` datetime DEFAULT NULL,
  `OcekivanoVreme` datetime DEFAULT NULL,
  `VremeSletanja` datetime DEFAULT NULL,
  `Grad1` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `AvioKompanija` varchar(45) DEFAULT NULL,
  `Grad2` varchar(45) DEFAULT NULL,
  `Izmena` varchar(45) DEFAULT NULL,
  `Carter` int(11) DEFAULT '0',
  `Najblizi` varchar(45) DEFAULT NULL,
  `Iznajmljeno` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `BrojLeta_UNIQUE` (`BrojLeta`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Flight`
--

LOCK TABLES `Flight` WRITE;
/*!40000 ALTER TABLE `Flight` DISABLE KEYS */;
INSERT INTO `Flight` VALUES (1,'let1','Aerodrom Beograd','Aerodrom Skopje','2017-09-05 04:10:11','04:11:00','11111','2017-09-05 08:21:11','2017-09-04 08:21:11','2017-09-05 08:21:52','Beograd','sleteo','airline1','Skoplje',NULL,0,NULL,NULL),(2,'let2','Aerodrom Beograd','Aerodrom Berlin','2017-09-20 00:00:00','03:00:00','11111','2017-09-20 03:00:00','2017-09-20 03:00:00',NULL,'Beograd',NULL,'airline2','Berlin',NULL,0,NULL,NULL),(3,'let3','Aerodrom Beograd','Aerodrom London','2017-09-14 02:05:04','03:00:00','11111','2017-09-14 05:05:04','2017-09-14 05:05:04',NULL,'Beograd',NULL,'airline2','London',NULL,0,NULL,NULL),(19,'let4','Aerodrom Beograd','Aerodrom Moskva','2017-09-13 00:00:00','05:14:00','11111','2017-09-13 05:14:00','2017-09-13 05:14:00',NULL,'Beograd',NULL,'airline2','Moskva',NULL,0,NULL,NULL),(20,'let4a','Aerodrom Beograd','Aerodrom Moskva','2017-09-20 00:00:00','05:14:00','11111','2017-09-20 05:14:00','2017-09-20 05:14:00',NULL,'Beograd',NULL,'airline2','Moskva',NULL,0,NULL,NULL),(21,'let4b','Aerodrom Beograd','Aerodrom Moskva','2017-09-27 00:00:00','05:14:00','11111','2017-09-27 05:14:00','2017-09-27 05:14:00',NULL,'Beograd',NULL,'airline2','Moskva',NULL,0,NULL,NULL),(22,'let5','Aerodrom Zagreb','Aerodrom Skopje','2017-09-12 06:00:00','04:00:00','11111','2017-09-12 10:00:00','2017-09-12 10:00:00','2017-09-06 10:00:16','Zagreb','priprema','airline1','Skopje',NULL,1,'Aerodrom Zagreb',NULL),(55,'let6','Aerodrom London','Aerodrom Beograd','2017-09-15 15:00:00','04:00:00','11112','2017-09-15 19:00:00','2017-09-15 19:00:00',NULL,'London',NULL,'airline2','Beograd',NULL,0,NULL,NULL),(56,'let6a','Aerodrom London','Aerodrom Beograd','2017-09-16 00:00:00','04:00:00','11112','2017-09-16 04:00:00','2017-09-16 04:00:00',NULL,'London',NULL,'airline2','Beograd',NULL,0,NULL,NULL),(57,'let6b','Aerodrom London','Aerodrom Beograd','2017-09-23 00:00:00','04:00:00','11112','2017-09-23 04:00:00','2017-09-23 04:00:00',NULL,'London',NULL,'airline2','Beograd',NULL,0,NULL,NULL),(58,'let6c','Aerodrom London','Aerodrom Beograd','2017-09-30 00:00:00','04:00:00','11112','2017-09-30 04:00:00','2017-09-30 04:00:00',NULL,'London',NULL,'airline2','Beograd',NULL,0,NULL,NULL),(72,'let7','Aerodrom London','Aerodrom Zagreb','2017-09-13 08:00:00','03:00:00','11112','2017-09-13 11:00:00','2017-09-13 11:00:00',NULL,'London',NULL,'airline1','Zagreb',NULL,1,NULL,NULL),(78,'let9','Aerodrom Beograd','Aerodrom Pariz','2017-09-13 10:00:00','02:00:00','11111','2017-09-13 12:00:00','2017-09-13 12:00:00',NULL,'Beograd',NULL,'airline1','Paris',NULL,1,NULL,NULL),(88,'let11','Aerodrom Berlin','Aerodrom Pariz','2017-09-13 06:00:00','02:00:00','11114','2017-09-13 08:00:00','2017-09-13 08:00:00',NULL,'Berlin',NULL,'airline2','Pariz',NULL,0,NULL,NULL),(89,'let11a','Aerodrom Berlin','Aerodrom Pariz','2017-09-20 06:00:00','02:00:00','11114','2017-09-20 08:00:00','2017-09-20 08:00:00',NULL,'Berlin',NULL,'airline2','Pariz',NULL,0,NULL,NULL),(90,'let11b','Aerodrom Berlin','Aerodrom Pariz','2017-09-27 06:00:00','02:00:00','11114','2017-09-27 08:00:00','2017-09-27 08:00:00',NULL,'Berlin',NULL,'airline2','Pariz',NULL,0,NULL,NULL),(92,'let12','Aerodrom Berlin','Aerdrom Njujork','2017-09-13 00:00:00','11:00:00','11115','2017-09-13 11:00:00','2017-09-13 11:00:00',NULL,'Berlin',NULL,'airline2','Njujork',NULL,1,NULL,'airline1'),(93,'let13','Aerodrom Beograd','Aerodrom Pariz','2017-09-14 06:15:16','03:00:00','11111','2017-09-14 09:15:16','2017-09-14 09:15:16',NULL,'Beograd',NULL,'airline1','Pariz',NULL,1,NULL,'airline2'),(94,'let14','Aerodrom Pariz','Aerodrom London','2017-09-14 13:00:00','02:00:00','11112','2017-09-14 15:00:00','2017-09-14 15:00:00',NULL,'Pariz',NULL,'airline1','London',NULL,1,NULL,'airline2'),(95,'let15','Aerodrom Pariz','Aerodrom Beograd','2017-09-15 07:17:00','02:00:00','11113','2017-09-15 09:17:00','2017-09-15 09:17:00',NULL,'Pariz',NULL,'airline2','Beograd',NULL,1,NULL,'airline1'),(97,'let17','Aerodrom London','Aerdrom Njujork','2017-09-14 09:00:00','05:00:00','11113','2017-09-14 14:00:00','2017-09-14 14:00:00',NULL,'London',NULL,'airline1','Njujork',NULL,1,NULL,'airline2'),(98,'let18','Aerdrom Njujork','Aerodrom London','2017-09-15 10:00:00','03:00:00','11112','2017-09-15 13:00:00','2017-09-15 13:00:00',NULL,'Njujork',NULL,'airline1','London',NULL,1,NULL,'airline2');
/*!40000 ALTER TABLE `Flight` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-13 17:37:15
