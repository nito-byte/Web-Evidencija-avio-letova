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
-- Table structure for table `TerminalGejt`
--

DROP TABLE IF EXISTS `TerminalGejt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TerminalGejt` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Terminal` varchar(45) DEFAULT NULL,
  `Gejt` varchar(45) DEFAULT NULL,
  `Airport` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TerminalGejt`
--

LOCK TABLES `TerminalGejt` WRITE;
/*!40000 ALTER TABLE `TerminalGejt` DISABLE KEYS */;
INSERT INTO `TerminalGejt` VALUES (1,'1','A1','ABS'),(2,'1','A2','ABS'),(3,'1','A3','ABS'),(4,'2','A1','ABS'),(5,'1','A1','AZH'),(6,'1','A2','AZH'),(7,'1','A3','AZH'),(8,'1','A4','AZH'),(9,'1','A1','ASM'),(10,'1','A2','ASM'),(11,'1','A1','ABN'),(12,'1','A2','ABN'),(13,'2','A1','ABN'),(14,'2','A2','ABN'),(15,'3','A1','ABN'),(16,'1','A1','ALV'),(17,'1','A2','ALV'),(18,'1','A3','ALV'),(19,'2','A1','ALV'),(20,'3','A1','ALV'),(21,'1','A1','AMR'),(22,'1','A2','AMR'),(23,'1','A3','AMR'),(24,'1','A4','AMR'),(25,'1','A5','AMR'),(26,'1','A1','ANU'),(27,'2','A1','ANU'),(28,'3','A1','ANU'),(29,'4','A1','ANU'),(30,'1','A1','APF'),(31,'1','A1','ABA'),(32,'1','A2','ABA'),(33,'2','A1','ABA');
/*!40000 ALTER TABLE `TerminalGejt` ENABLE KEYS */;
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
