-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: localhost    Database: bandas
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.19-MariaDB

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
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `album` (
  `Titulo` varchar(100) NOT NULL,
  `Capa` varchar(45) NOT NULL,
  `Preco` float DEFAULT NULL,
  `NomeArtista` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Titulo`),
  KEY `FK_AlbumArtista` (`NomeArtista`),
  CONSTRAINT `FK_AlbumArtista` FOREIGN KEY (`NomeArtista`) REFERENCES `artista` (`NomeArtista`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES ('2','imagens/capas/2.jpg',49.9,'Mac Demarco'),('A Praia','imagens/capas/apraia.jpg',29.9,'Cicero'),('As Plantas Que Curam','imagens/capas/asplantas.jpg',49.9,'Boogarins'),('Canções de Apartamento','imagens/capas/cancoes.jpg',29.9,'Cicero'),('Currents','imagens/capas/currents.jpg',59.9,'Tame Impala'),('InnerSpeaker','imagens/capas/innerspeaker.jpg',65.9,'Tame Impala'),('Lonerism','imagens/capas/lonerism.jpg',45.99,'Tame Impala'),('Manual','imagens/capas/manual.jpg',70,'Boogarins'),('Salad Days','imagens/capas/saladdays.jpg',49.5,'Mac Demarco'),('teste','teste',0,'teste');
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-30 20:33:24
