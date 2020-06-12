-- MySQL dump 10.13  Distrib 5.7.30, for Linux (x86_64)
--
-- Host: localhost    Database: ott
-- ------------------------------------------------------
-- Server version	5.7.30-0ubuntu0.18.04.1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (4,'Category 1'),(63,'Category 1'),(64,'Category 2'),(65,'Category 3'),(66,'Category 4'),(67,'Category 5'),(68,'Category 6'),(69,'Category 7'),(70,'Category 8'),(71,'Category 9'),(72,'Category 10'),(73,'Category 11'),(74,'Category 12'),(75,'Category 13'),(76,'Category 14'),(77,'Category 15'),(78,'Category 16'),(79,'Category 17'),(80,'Category 18'),(81,'Category 19');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_contents`
--

DROP TABLE IF EXISTS `category_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_contents` (
  `category_id` bigint(20) NOT NULL,
  `content_id` bigint(20) NOT NULL,
  `sequence_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`,`content_id`),
  KEY `FKqi3pd7ffci1ddowm4isqrcq42` (`content_id`),
  CONSTRAINT `FKie0wmo4vhdvlog86sek7tdbdm` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKqi3pd7ffci1ddowm4isqrcq42` FOREIGN KEY (`content_id`) REFERENCES `contents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_contents`
--

LOCK TABLES `category_contents` WRITE;
/*!40000 ALTER TABLE `category_contents` DISABLE KEYS */;
INSERT INTO `category_contents` VALUES (4,1,1),(4,9,2),(4,12,3),(4,15,4),(4,18,5),(63,33,1),(63,36,2),(63,39,3),(63,42,4),(64,6,1),(64,21,2),(64,24,3),(64,27,4),(64,30,5);
/*!40000 ALTER TABLE `category_contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `content_images`
--

DROP TABLE IF EXISTS `content_images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `content_images` (
  `id` bigint(20) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `content_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgvfmjxrpjsc9xrlsiaxy2gu2y` (`content_id`),
  CONSTRAINT `FKgvfmjxrpjsc9xrlsiaxy2gu2y` FOREIGN KEY (`content_id`) REFERENCES `contents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `content_images`
--

LOCK TABLES `content_images` WRITE;
/*!40000 ALTER TABLE `content_images` DISABLE KEYS */;
INSERT INTO `content_images` VALUES (2,'portrait','www.google.lk',1),(3,'portrait','www.google.lk',1),(7,'portrait','www.google.lk',6),(8,'portrait','www.google.lk',6),(10,'portrait','www.google.lk',9),(11,'portrait','www.google.lk',9),(13,'portrait','www.google.lk',12),(14,'portrait','www.google.lk',12),(16,'portrait','www.google.lk',15),(17,'portrait','www.google.lk',15),(19,'portrait','www.google.lk',18),(20,'portrait','www.google.lk',18),(22,'portrait','www.google.lk',21),(23,'portrait','www.google.lk',21),(25,'portrait','www.google.lk',24),(26,'portrait','www.google.lk',24),(28,'portrait','www.google.lk',27),(29,'portrait','www.google.lk',27),(31,'portrait','www.google.lk',30),(32,'portrait','www.google.lk',30),(34,'portrait','www.google.lk',33),(35,'portrait','www.google.lk',33),(37,'portrait','www.google.lk',36),(38,'portrait','www.google.lk',36),(40,'portrait','www.google.lk',39),(41,'portrait','www.google.lk',39),(43,'portrait','www.google.lk',42),(44,'portrait','www.google.lk',42),(46,'portrait','www.google.lk',45),(47,'portrait','www.google.lk',45),(49,'portrait','www.google.lk',48),(50,'portrait','www.google.lk',48),(52,'portrait','www.google.lk',51),(53,'portrait','www.google.lk',51),(55,'portrait','www.google.lk',54),(56,'portrait','www.google.lk',54),(58,'portrait','www.google.lk',57),(59,'portrait','www.google.lk',57),(61,'portrait','www.google.lk',60),(62,'portrait','www.google.lk',60);
/*!40000 ALTER TABLE `content_images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contents`
--

DROP TABLE IF EXISTS `contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contents` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `tittle` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contents`
--

LOCK TABLES `contents` WRITE;
/*!40000 ALTER TABLE `contents` DISABLE KEYS */;
INSERT INTO `contents` VALUES (1,'Movie 1','content 1','Movie'),(6,'Movie 2','content 1','Movie'),(9,'Movie 3','content 2','Movie'),(12,'Movie 4','content 3','Movie'),(15,'Movie 5','content 4','Movie'),(18,'Movie 6','content 5','Movie'),(21,'Movie 7','content 6','Movie'),(24,'Movie 8','content 7','Movie'),(27,'Movie 9','content 8','Movie'),(30,'Movie 10','content 9','Movie'),(33,'Movie 11','content 10','Movie'),(36,'Movie 12','content 11','Movie'),(39,'Movie 13','content 12','Movie'),(42,'Movie 14','content 13','Movie'),(45,'Movie 15','content 14','Movie'),(48,'Movie 16','content 15','Movie'),(51,'Movie 17','content 16','Movie'),(54,'Movie 18','content 17','Movie'),(57,'Movie 19','content 18','Movie'),(60,'Movie 20','content 19','Movie');
/*!40000 ALTER TABLE `contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (84),(84),(84),(84);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen_categories`
--

DROP TABLE IF EXISTS `screen_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen_categories` (
  `category_id` bigint(20) NOT NULL,
  `screen_id` bigint(20) NOT NULL,
  `sequence_no` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`,`screen_id`),
  KEY `FKcc3oxwa7xus7yykbykgiddftu` (`screen_id`),
  CONSTRAINT `FKcc3oxwa7xus7yykbykgiddftu` FOREIGN KEY (`screen_id`) REFERENCES `screens` (`id`),
  CONSTRAINT `FKfe601qdxbgwim2dart6cfqy2s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen_categories`
--

LOCK TABLES `screen_categories` WRITE;
/*!40000 ALTER TABLE `screen_categories` DISABLE KEYS */;
INSERT INTO `screen_categories` VALUES (4,5,1),(63,5,4),(64,5,3),(65,5,2);
/*!40000 ALTER TABLE `screen_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screens`
--

DROP TABLE IF EXISTS `screens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screens` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screens`
--

LOCK TABLES `screens` WRITE;
/*!40000 ALTER TABLE `screens` DISABLE KEYS */;
INSERT INTO `screens` VALUES (5,'Home'),(82,'Screen 1'),(83,'Screen 2');
/*!40000 ALTER TABLE `screens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-12  8:34:54
