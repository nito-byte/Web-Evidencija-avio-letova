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
-- Table structure for table `Posada`
--

DROP TABLE IF EXISTS `Posada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Posada` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `p1` varchar(45) DEFAULT NULL,
  `p2` varchar(45) DEFAULT NULL,
  `s1` varchar(45) DEFAULT NULL,
  `s2` varchar(45) DEFAULT NULL,
  `s3` varchar(45) DEFAULT NULL,
  `s4` varchar(45) DEFAULT NULL,
  `s5` varchar(45) DEFAULT NULL,
  `BrojLeta` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Posada`
--

LOCK TABLES `Posada` WRITE;
/*!40000 ALTER TABLE `Posada` DISABLE KEYS */;
INSERT INTO `Posada` VALUES (1,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let1'),(2,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic','radanikolic','let2'),(3,'milannikic','bobanolic','petracolic','sanjasaric','larakocic',NULL,NULL,'let3'),(7,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic',NULL,'let4'),(8,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let5'),(15,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic','radanikolic','let6'),(16,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic','radanikolic','let6a'),(17,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic','radanikolic','let6b'),(18,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic','radanikolic','let6c'),(28,'peranesic','mirkotatic','ivanajovic','ivaantic','minajovic','anicajoksimovic',NULL,'let7'),(35,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let9'),(45,'milannikic','bobanolic','petracolic','sanjasaric','larakocic',NULL,NULL,'let11'),(46,'milannikic','bobanolic','petracolic','sanjasaric','larakocic',NULL,NULL,'let11a'),(47,'milannikic','bobanolic','petracolic','sanjasaric','larakocic',NULL,NULL,'let11b'),(48,'milannikic','bobanolic','petracolic','sanjasaric','larakocic','daravlajic','radanikolic','let12'),(49,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let13'),(50,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let14'),(51,'milannikic','bobanolic','petracolic','sanjasaric','larakocic',NULL,NULL,'let15'),(52,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let17'),(53,'peranesic','mirkotatic','jovanajovic','ivanaj','miradukic',NULL,NULL,'let18');
/*!40000 ALTER TABLE `Posada` ENABLE KEYS */;
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
