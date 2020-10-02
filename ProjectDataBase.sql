-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: all_functiontryout
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `data` (
  `did` int NOT NULL,
  `dname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` VALUES (1,'abc');
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dept_detail`
--

DROP TABLE IF EXISTS `dept_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dept_detail` (
  `did` int NOT NULL,
  `dname` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dept_detail`
--

LOCK TABLES `dept_detail` WRITE;
/*!40000 ALTER TABLE `dept_detail` DISABLE KEYS */;
INSERT INTO `dept_detail` VALUES (51,'HR','Pune'),(52,'Finance','Mumbai'),(53,'Sales','Delhi'),(54,'abc','rajsthan');
/*!40000 ALTER TABLE `dept_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `emp_details`
--

DROP TABLE IF EXISTS `emp_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emp_details` (
  `eid` int NOT NULL,
  `ename` varchar(45) DEFAULT NULL,
  `did` int DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `did_fk_idx` (`did`),
  CONSTRAINT `did_fk` FOREIGN KEY (`did`) REFERENCES `dept_detail` (`did`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emp_details`
--

LOCK TABLES `emp_details` WRITE;
/*!40000 ALTER TABLE `emp_details` DISABLE KEYS */;
INSERT INTO `emp_details` VALUES (11,'Naira',51),(12,'Kartik',52),(13,'Anurag',51),(14,'Prerna',53),(15,'Komolika',51);
/*!40000 ALTER TABLE `emp_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_table`
--

DROP TABLE IF EXISTS `info_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info_table` (
  `name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `adhar_num` varchar(45) NOT NULL,
  PRIMARY KEY (`adhar_num`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_table`
--

LOCK TABLES `info_table` WRITE;
/*!40000 ALTER TABLE `info_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `info_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `new_table`
--

DROP TABLE IF EXISTS `new_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `new_table` (
  `idnew_table` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idnew_table`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `new_table`
--

LOCK TABLES `new_table` WRITE;
/*!40000 ALTER TABLE `new_table` DISABLE KEYS */;
INSERT INTO `new_table` VALUES (1,'A'),(2,'B'),(3,'Priyankamalakolikar01@gmail.com'),(4,'Priyankamalakolikar11@gmail.com');
/*!40000 ALTER TABLE `new_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_emp`
--

DROP TABLE IF EXISTS `sample_emp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sample_emp` (
  `eid` int NOT NULL,
  `enmae` varchar(45) DEFAULT NULL,
  `salary` int DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_emp`
--

LOCK TABLES `sample_emp` WRITE;
/*!40000 ALTER TABLE `sample_emp` DISABLE KEYS */;
INSERT INTO `sample_emp` VALUES (51,'prardnya',25000),(53,'kiran',20000),(54,'Virat',200000);
/*!40000 ALTER TABLE `sample_emp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sample_table`
--

DROP TABLE IF EXISTS `sample_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sample_table` (
  `idnew_table` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idnew_table`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sample_table`
--

LOCK TABLES `sample_table` WRITE;
/*!40000 ALTER TABLE `sample_table` DISABLE KEYS */;
/*!40000 ALTER TABLE `sample_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `td_table`
--

DROP TABLE IF EXISTS `td_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `td_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fname` varchar(45) DEFAULT NULL,
  `lname` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `psw` varchar(45) DEFAULT NULL,
  `cpsw` varchar(45) DEFAULT NULL,
  `Active` varchar(45) DEFAULT NULL,
  `regdate` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `td_table`
--

LOCK TABLES `td_table` WRITE;
/*!40000 ALTER TABLE `td_table` DISABLE KEYS */;
INSERT INTO `td_table` VALUES (1,'priyanka','malakolikar','female','priyankamalakolikar11@gmail.com','12','12','yes','2020-09-18'),(2,'gul','s','female','priyankamalakolikar01@gmail.com','123','123','yes','2020-09-19'),(3,'a','b','f','malakolikarpriyanka@gmail.com','1','1','yes','2020-09-20'),(4,'b','c','f','malakolikarpriyanka11@gmail.com','2','2','yes','2020-09-21'),(5,'c','d','f','','3','3','yes','2020-09-22'),(6,'d','e','f','','4','4','yes','2020-09-23'),(7,'e','f','f','','5','5','not','2020-09-24'),(8,'arti','a','female','','77','77','yes','2020-09-25'),(9,'soham','desh','male',NULL,'11','11','yes','2020-09-27'),(10,'Rushi','malakolikar','male','','123','123','yes','2020-09-28');
/*!40000 ALTER TABLE `td_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `todo_task`
--

DROP TABLE IF EXISTS `todo_task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo_task` (
  `tid` int NOT NULL AUTO_INCREMENT,
  `Task_name` varchar(45) DEFAULT NULL,
  `Description` varchar(45) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `taskdate` date DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo_task`
--

LOCK TABLES `todo_task` WRITE;
/*!40000 ALTER TABLE `todo_task` DISABLE KEYS */;
INSERT INTO `todo_task` VALUES (1,'study123','java','Completed','2020-09-17'),(2,'smile','always smile','Completed','2020-09-18'),(4,'my','java','Completed','2020-09-19'),(9,'eat','proper food','Completed','2020-09-25'),(10,'play','games','Completed','2020-09-25'),(13,'study','8Hrs','Pending',NULL),(14,'abc','Don`t do that','Completed',NULL);
/*!40000 ALTER TABLE `todo_task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'all_functiontryout'
--
/*!50003 DROP FUNCTION IF EXISTS `Addfun` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `Addfun`(a int,b int) RETURNS int
BEGIN

RETURN a+b;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `additionusingsum` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `additionusingsum`(a int ,b int) RETURNS int
BEGIN
declare sum   int;
     set  sum=a+b;
RETURN sum;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `cond` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `cond`(n int) RETURNS varchar(10) CHARSET utf8mb4
BEGIN
declare result varchar(10);
if n % 2=0 then 
set result='even';
else 
set result='odd';
end if;
RETURN result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `factloop` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `factloop`(n int) RETURNS int
BEGIN
declare i int;
declare fact int;
set i=1;
set fact=1;
while i<=n do
set fact=fact*i;
set i=i+1;
end while;
RETURN fact;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `Summession` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `Summession`(in a int ,in b int)
BEGIN
declare sum int;
set sum=a+b;
select sum as result;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-01 16:10:41
