-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: fresher
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `album`
--

LOCK TABLES `album` WRITE;
/*!40000 ALTER TABLE `album` DISABLE KEYS */;
INSERT INTO `album` VALUES (1,'Lac Troi','imageLactroi','2019-12-10',1,1),(2,'Bua yeu','imageBuaYeu','2019-12-13',2,1),(3,'Nang am xa dan','image','2019-01-01',1,1),(4,'Con mua ngang qua','iamge','2013-01-01',1,2),(5,'Co Khi Nao Roi Xa','iamge','2014-02-04',2,1),(6,'Lang nghe mua xuan ve','image','2012-01-01',3,1),(7,'Anh da quen voi co don','image','2018-02-01',4,1);
/*!40000 ALTER TABLE `album` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `artist`
--

LOCK TABLES `artist` WRITE;
/*!40000 ALTER TABLE `artist` DISABLE KEYS */;
INSERT INTO `artist` VALUES (1,'Son Tung','image','test','test','a1'),(2,'Bich Phuong','image','test','test','a1'),(3,'My Linh','image','test','test','a4'),(4,'Soobin Hoang Son','image','test','test','a3');
/*!40000 ALTER TABLE `artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Pop','pop','imagepop'),(2,'Rap','rap','imagerap'),(3,'EDM','edm','imageedm'),(4,'EDM','nhac dien tu','imageEDM'),(5,'POP','nhac pop','imagePOP');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES ('31/3/2019','1',1),('31/3/2019','1',2),('31/3/2019','3',3),('31/3/2019','2',4);
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `playlist`
--

LOCK TABLES `playlist` WRITE;
/*!40000 ALTER TABLE `playlist` DISABLE KEYS */;
INSERT INTO `playlist` VALUES (1,'image','Nhac Son Tung',2,'1234',1),(2,'image','Nhac Bich Phuong',2,'1235',1);
/*!40000 ALTER TABLE `playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `track`
--

LOCK TABLES `track` WRITE;
/*!40000 ALTER TABLE `track` DISABLE KEYS */;
INSERT INTO `track` VALUES (1,'audio','desc',0,3000,'Lac Troi','1234',1),(2,'audio','desc',0,3000,'Bua Yeu','1235',2);
/*!40000 ALTER TABLE `track` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `track_artist`
--

LOCK TABLES `track_artist` WRITE;
/*!40000 ALTER TABLE `track_artist` DISABLE KEYS */;
/*!40000 ALTER TABLE `track_artist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `track_playlist`
--

LOCK TABLES `track_playlist` WRITE;
/*!40000 ALTER TABLE `track_playlist` DISABLE KEYS */;
/*!40000 ALTER TABLE `track_playlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('a1','Son Tung','10/11/1995','phuonglt@gmail.com',0,'1',2),('a2','Bich Phuong','10/11/1995','phuonglt@gmail.com',1,'1',2),('1','Tri Phuong','10/10/1995','phuong@gmail.com',0,'1',3),('2','Linh','10/10/2000','linh@gmail.com',0,'1',3),('3','Hiep','10/10/1997','hiep@gmail.com',0,'1',3),('4','Hieu','10/11/1998','hieu@gmail.com',0,'1',3),('5','Hoang Anh','10/2/1994','hoanganh@gmail.com',1,'1',3),('a3','Hoang Son','10/2/1994','hoangson@gmail.com',0,'1',2),('a4','My Linh','10/2/1984','mylinh@gmail.com',1,'1',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_type`
--

LOCK TABLES `user_type` WRITE;
/*!40000 ALTER TABLE `user_type` DISABLE KEYS */;
INSERT INTO `user_type` VALUES (1,'Admin'),(2,'Artist'),(3,'User');
/*!40000 ALTER TABLE `user_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-31 21:24:51
