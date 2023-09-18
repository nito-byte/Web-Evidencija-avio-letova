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
-- Table structure for table `Licenca`
--

DROP TABLE IF EXISTS `Licenca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Licenca` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `licenca` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `surname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Licenca`
--

LOCK TABLES `Licenca` WRITE;
/*!40000 ALTER TABLE `Licenca` DISABLE KEYS */;
INSERT INTO `Licenca` VALUES (1,'peranesic','BB','pera','nesic','peraa@gmail.com'),(2,'mirkotatic','BB','mirko','tatic','mirkot@gmail.com'),(3,'milannikic','BB','milan','nikic','milanni@gmail.com'),(5,'lavnikolic','BB','lav','nikolic','lavnik@gmail.com'),(6,'ilijanikolic','BB','ilija','nikolic','ilijanik@gmail.com'),(7,'peranesic','AA','pera','nesic','peraa@gmail.com'),(8,'peranesic','BA','pera','nesic','peraa@gmail.com'),(10,'bobanolic','BB','boban','olic','bobano@gmail.com'),(11,'milannikic','AA','milan','nikic','milanni@gmail.com'),(12,'milannikic','BA','milan','nikic','milanni@gmail.com'),(13,'milannikic','AB','milan','nikic','milanni@gmail.com'),(14,'milannikic','BC','milan','nikic','milanni@gmail.com'),(15,'milannikic','TU','milan','nikic','milanni@gmail.com'),(16,'bobanolic','AA','boban','olic','bobano@gmail.com'),(17,'bobanolic','BA','boban','olic','bobano@gmail.com'),(18,'bobanolic','TU','boban','olic','bobano@gmail.com'),(19,'mirkotatic','TU','mirko','tatic','mirkot@gmail.com'),(20,'bobanolic','BC','boban','olic','bobano@gmail.com'),(21,'peranesic','TU','pera','nesic','peraa@gmail.com'),(25,'peranesic','AB','pera','nesic','peraa@gmail.com'),(26,'peranesic','BC','pera','nesic','peraa@gmail.com'),(27,'mirkotatic','AA','mirko','tatic','mirkot@gmail.com'),(28,'mirkotatic','BA','mirko','tatic','mirkot@gmail.com'),(29,'mirkotatic','AB','mirko','tatic','mirkot@gmail.com'),(30,'mirkotatic','BC','mirko','tatic','mirkot@gmail.com'),(31,'lavnikolic','AA','lav','nikolic','lavnik@gmail.com'),(32,'lavnikolic','BA','lav','nikolic','lavnik@gmail.com'),(33,'lavnikolic','AB','lav','nikolic','lavnik@gmail.com'),(34,'lavnikolic','BC','lav','nikolic','lavnik@gmail.com'),(35,'lavnikolic','TU','lav','nikolic','lavnik@gmail.com'),(36,'bobanolic','AB','boban','olic','bobano@gmail.com'),(37,'ilijanikolic','AA','ilija','nikolic','ilijanik@gmail.com'),(38,'ilijanikolic','BA','ilija','nikolic','ilijanik@gmail.com'),(39,'ilijanikolic','AB','ilija','nikolic','ilijanik@gmail.com'),(40,'ilijanikolic','BC','ilija','nikolic','ilijanik@gmail.com'),(41,'ilijanikolic','TU','ilija','nikolic','ilijanik@gmail.com');
/*!40000 ALTER TABLE `Licenca` ENABLE KEYS */;
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
