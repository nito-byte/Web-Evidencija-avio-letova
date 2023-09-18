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
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Surname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Pol` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `BirthDay` date DEFAULT NULL,
  `Username` varchar(250) CHARACTER SET utf8 NOT NULL,
  `Password` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `Email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `PrihvacenZahtev` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `TipKorisnika` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `Airline` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Licenca` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `Username_UNIQUE` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (3,'ana','peric','zenski','1991-12-12','anaperic','Asdf2A2@e','ana@gmail.com','false','stujardesa','airline1',NULL),(4,'ana','petrovic','zenski','1990-12-12','anapetrovic','A1aaz@A2z','anap@gmail.com','false','stujardesa','airline1',NULL),(6,'jovana','jovic','zenski','1989-12-12','jovanajovic','A2swd@Ade','jovana@gmail.com','true','stujardesa','airline1',NULL),(12,'jana','jovic','zenski','1990-12-10','admin','A1aaz@A2z','user1@gmail.com','true','admin','airline1',NULL),(14,'ivana','jovanovic','zenski','1991-12-11','ivanaj','Asdf2A2@e','ivanaj@gmail.com','true','stujardesa','airline1',NULL),(15,'mira','dukic','zenski','1993-08-20','miradukic','Asdf2A2@l','mirad@gmail.com','true','stujardesa','airline1',NULL),(17,'mina','zaric','zenski','1994-08-20','minazaric','A2sdeS@ert','tijana@gmail.com','true','stujardesa','airline1',NULL),(18,'ivana','jovic','zenski','1993-08-25','ivanajovic','Asqw2@eDw','ivan@gmail.com','true','stujardesa','airline1',NULL),(19,'ivana ','antic','zenski','1992-08-25','ivaantic','Asqw2@eDw','ivana@gmail.com','true','stujardesa','airline1',NULL),(21,'mina ','jovic','zenski','1993-08-10','minajovic','Asqw2@eDw','mina@gmail.com','true','stujardesa','airline1',NULL),(22,'mila','jovanovic','zenski','1990-09-03','milajovanovic','Awqw2@eDw','milan@gmail.com','false','stujardesa','airline2',NULL),(23,'petra','colic','zenski','1992-09-03','petracolic','Aeqw2@eDw','pera@gmail.com','true','stujardesa','airline2',NULL),(24,'sanja','saric','zenski','1992-07-03','sanjasaric','Aeqw2@eDe','sanja@gmail.com','true','stujardesa','airline2',NULL),(25,'lara','kocic','zenski','1992-07-03','larakocic','Aeqw2@eDd','lara@gmail.com','true','stujardesa','airline2',NULL),(26,'nikolina','kocic','zenski','1992-06-03','nikolinakocic','Aeqw2@eDr','nikolina@gmail.com','false','stujardesa','airline2',NULL),(27,'dragana','saric','zenski','1993-02-03','draganasaric','Aeqw2@eDo','dragana@gmail.com','false','stujardesa','aiirline2',NULL),(28,'mirka','nikolic','zenski','1994-09-03','mirkanikolic','Aeqw2@eDp','mirka@gmail.com','false','stujardesa','airline2',NULL),(29,'dara','vjalic','zenski','1994-09-03','daravlajic','Aeqw2@eDs','darav@gmail.com','true','stujardesa','airline2',NULL),(31,'rada','nikolic','zenski','2017-09-03','radanikolic','Aeqw2@eDx','rada@gmail.com','true','stujardesa','airline2',NULL),(32,'ana','vjalic','zenski','1993-09-03','anavlajic','Aeqw2@eDh','anav@gmail.com','false','stujardesa','airline3',NULL),(33,'ranka','nikolic','zenski','1991-09-03','rankanikolic','Aeqw2@eDxx','ranka@gmail.com','true','stujardesa','airline3',NULL),(34,'ana','volic','zenski','1992-09-03','anavolic','Aeqw2@eDhh','anav@gmail.com','false','stujardesa','airline3',NULL),(35,'ranka','nesic','zenski','1992-09-03','rankanesic','Aeqw2@eDxp','rankaa@gmail.com','true','stujardesa','airline3',NULL),(36,'lila','tatic','zenski','1993-09-03','lilatatic','Aeqw2@eDhh','lilat@gmail.com','true','stujardesa','airline3',NULL),(37,'ceca','nikic','zenski','1993-09-03','cecanikic','Aeqw2@eDxx','cecani@gmail.com','true','stujardesa','airline3',NULL),(38,'vera','lelic','zenski','1992-09-03','veralelic','Aeqw2@eDh','ceral@gmail.com','false','stujardesa','airline3',NULL),(39,'boba','olic','zenski','1990-09-03','bobaolic','Aeqw2@eDxx','bobao@gmail.com','true','stujardesa','airline3',NULL),(40,'nika','vjalic','zenski','1990-09-03','nikavjalic','Aeqw2@eDh','nikavj@gmail.com','false','stujardesa','airline3',NULL),(41,'lena','nikolic','zenski','1990-09-03','lenanikolic','Aeqw2@eDxx','lenanik@gmail.com','true','stujardesa','airline3',NULL),(42,'pero','volic','muski','1993-09-03','perovolic','Aeqw2@eDhh','perov@gmail.com','false','pilot','airline1',NULL),(43,'pera','nesic','muski','1992-09-03','peranesic','Aeqw2@eDxp','peraa@gmail.com','true','pilot','airline1','AA1234567'),(44,'mirko','tatic','muski','1994-09-03','mirkotatic','Aeqw2@eDhh','mirkot@gmail.com','true','pilot','airline1','TU1234123'),(45,'milan','nikic','muski','1993-09-03','milannikic','Aeqw2@eDxx','milanni@gmail.com','true','pilot','airline2',NULL),(46,'boro','lelic','muski','1992-09-03','borolelic','Aeqw2@eDh','borol@gmail.com','false','pilot','airline2',NULL),(47,'boban','olic','muski','1992-09-03','bobanolic','Aeqw2@eDxx','bobano@gmail.com','true','pilot','airline2','BC1234123'),(48,'bojan','vjalic','muski','1994-09-03','bojanvjalic','Aeqw2@eDh','bojanj@gmail.com','false','pilot','airline3',NULL),(49,'lav','nikolic','muski','1994-09-03','lavnikolic','Aeqw2@eDxx','lavnik@gmail.com','true','pilot','airline3',NULL),(50,'ilija','nikolic','muski','1993-09-03','ilijanikolic','Aeqw2@eDxq','ilijanik@gmail.com','true','pilot','airline3',NULL),(51,'perica','volic','muski','1994-09-03','pericavolic','Aeqw2@eDhh','pericav@gmail.com','false','radnik','airline1',NULL),(52,'adam','nesic','muski','1992-09-03','adamnesic','Aeqw2@eDxp','adama@gmail.com','true','radnik','airline1',NULL),(53,'mijat','tatic','muski','1992-09-03','mijattatic','Aeqw2@eDhh','mijatt@gmail.com','true','radnik','airline1',NULL),(54,'oleg','nikic','muski','1992-09-03','olegnikic','Aeqw2@eDxx','olegni@gmail.com','true','radnik','airline2',NULL),(55,'bojan','lelic','muski','1991-09-03','bojanlelic','Aeqw2@eDh','bojanl@gmail.com','false','radnik','airline2',NULL),(56,'igor','olic','muski','1991-09-03','igorolic','Eeqw2@eDxx','igoro@gmail.com','true','radnik','airline2',NULL),(57,'lav','vjalic','muski','1992-09-03','lavvjalic','Aeqw2@eDh','lavj@gmail.com','false','radnik','airline3',NULL),(58,'nesa','nikolic','muski','1993-09-03','nesanikolic','Aeqw2@eDxx','nesanik@gmail.com','true','radnik','airline3',NULL),(59,'rastko','nikolic','muski','1993-09-03','rastkonikolic','Aeqw2@eDxx','rastkonik@gmail.com','true','radnik','airline3',NULL),(60,'Ana','Joksimovic','zenski','1999-03-12','anajoksimovic','As2aabA@4','sadsf@adfs.com','false','radnik','airline3',NULL),(61,'Anica','Joksimovic','zenski','1993-12-12','anicajoksimovic','Asqw2A@431','anicajok@gmail.com','true','stujardesa','airline1',NULL);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-13 17:37:16
