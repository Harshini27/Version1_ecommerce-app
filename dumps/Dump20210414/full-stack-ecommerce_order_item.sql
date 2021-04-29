-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: full-stack-ecommerce
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `image_url` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `unit_price` decimal(19,2) DEFAULT NULL,
  `order_id` bigint DEFAULT NULL,
  `product_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `K_order_id` (`order_id`),
  KEY `FK_product_id` (`product_id`),
  CONSTRAINT `FK_order_id` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `FK_product_id` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,1,26),(2,'assets/images/products/mousepads/mousepad-1.png',1,17.99,1,51),(3,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,2,26),(4,'assets/images/products/mousepads/mousepad-1.png',1,17.99,2,51),(5,'assets/images/products/mousepads/mousepad-1.png',1,17.99,3,51),(6,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,3,26),(7,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,4,26),(8,'assets/images/products/mousepads/mousepad-1.png',1,17.99,4,51),(9,'assets/images/products/books/book-6.png',1,23.99,5,6),(10,'assets/images/products/books/book-1.png',1,14.99,5,1),(11,'assets/images/products/books/book-8.png',1,16.99,5,8),(12,'assets/images/products/books/book-7.png',1,14.99,5,7),(13,'assets/images/products/books/book-2.png',1,20.99,5,2),(14,'assets/images/products/books/book-5.png',1,18.99,5,5),(15,'assets/images/products/books/book-3.png',1,14.99,5,3),(16,'assets/images/products/books/book-3.png',1,14.99,6,3),(17,'assets/images/products/books/book-5.png',1,18.99,6,5),(18,'assets/images/products/books/book-4.png',1,13.99,6,4),(19,'assets/images/products/books/book-6.png',1,23.99,6,6),(20,'assets/images/products/books/book-1.png',1,14.99,6,1),(21,'assets/images/products/books/book-2.png',1,20.99,6,2),(22,'assets/images/products/books/book-7.png',1,14.99,6,7),(23,'assets/images/products/books/book-2.png',1,20.99,8,2),(24,'assets/images/products/books/book-4.png',1,13.99,8,4),(25,'assets/images/products/books/book-3.png',1,14.99,8,3),(26,'assets/images/products/books/book-1.png',1,14.99,8,1),(27,'assets/images/products/books/book-7.png',4,14.99,9,7),(28,'assets/images/products/luggagetags/luggagetag-1.png',1,16.99,10,76),(29,'assets/images/products/luggagetags/luggagetag-3.png',1,16.99,10,78),(30,'assets/images/products/luggagetags/luggagetag-2.png',1,16.99,10,77),(31,'assets/images/products/coffeemugs/coffeemug-2.png',1,18.99,11,27),(32,'assets/images/products/coffeemugs/coffeemug-4.png',1,18.99,11,29),(33,'assets/images/products/coffeemugs/coffeemug-3.png',1,18.99,11,28),(34,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,11,26),(35,'assets/images/products/books/book-2.png',1,20.99,12,2),(36,'assets/images/products/books/book-3.png',1,14.99,12,3),(37,'assets/images/products/books/book-4.png',1,13.99,12,4),(38,'assets/images/products/books/book-1.png',1,14.99,12,1),(39,'assets/images/products/books/book-12.png',1,19.99,13,12),(40,'assets/images/products/books/book-2.png',1,20.99,13,2),(41,'assets/images/products/books/book-4.png',1,13.99,13,4),(42,'assets/images/products/books/book-3.png',1,14.99,13,3),(43,'assets/images/products/books/book-4.png',1,13.99,14,4),(44,'assets/images/products/books/book-2.png',1,20.99,14,2),(45,'assets/images/products/books/book-3.png',1,14.99,14,3),(46,'assets/images/products/books/book-3.png',1,14.99,15,3),(47,'assets/images/products/books/book-4.png',1,13.99,15,4),(48,'assets/images/products/books/book-1.png',1,14.99,16,1),(49,'assets/images/products/books/book-2.png',1,20.99,16,2),(50,'assets/images/products/books/book-4.png',1,13.99,17,4),(51,'assets/images/products/books/book-3.png',1,14.99,17,3),(52,'assets/images/products/books/book-2.png',1,20.99,18,2),(53,'assets/images/products/books/book-1.png',1,14.99,18,1),(54,'assets/images/products/books/book-3.png',1,14.99,18,3),(55,'assets/images/products/books/book-4.png',1,13.99,19,4),(56,'assets/images/products/books/book-3.png',1,14.99,19,3),(57,'assets/images/products/books/book-2.png',1,20.99,19,2),(58,'assets/images/products/books/book-2.png',1,20.99,20,2),(59,'assets/images/products/books/book-3.png',1,14.99,20,3),(60,'assets/images/products/books/book-1.png',1,14.99,20,1),(61,'assets/images/products/books/book-4.png',1,13.99,20,4),(62,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,23,26),(63,'assets/images/products/coffeemugs/coffeemug-3.png',1,18.99,23,28),(64,'assets/images/products/coffeemugs/coffeemug-2.png',1,18.99,23,27),(65,'assets/images/products/coffeemugs/coffeemug-2.png',1,18.99,24,27),(66,'assets/images/products/coffeemugs/coffeemug-3.png',1,18.99,24,28),(67,'assets/images/products/coffeemugs/coffeemug-1.png',1,18.99,24,26),(68,'assets/images/products/books/book-3.png',1,14.99,25,3),(69,'assets/images/products/books/book-4.png',1,13.99,25,4),(70,'assets/images/products/books/book-2.png',1,20.99,26,2),(71,'assets/images/products/books/book-7.png',1,14.99,26,7),(72,'assets/images/products/books/book-4.png',1,13.99,27,4),(73,'assets/images/products/books/book-2.png',1,20.99,27,2),(74,'assets/images/products/books/book-3.png',1,14.99,27,3),(75,'assets/images/products/books/book-3.png',1,14.99,28,3),(76,'assets/images/products/books/book-2.png',1,20.99,28,2),(77,'assets/images/products/books/book-4.png',1,13.99,28,4),(78,'assets/images/products/books/book-2.png',1,20.99,29,2),(79,'assets/images/products/books/book-3.png',1,14.99,29,3),(80,'assets/images/products/books/book-4.png',1,13.99,29,4),(81,'assets/images/products/books/book-2.png',1,20.99,30,2),(82,'assets/images/products/books/book-3.png',1,14.99,30,3),(83,'assets/images/products/books/book-3.png',1,14.99,31,3),(84,'assets/images/products/books/book-2.png',1,20.99,31,2),(85,'assets/images/products/mousepads/mousepad-3.png',1,17.99,32,53),(86,'assets/images/products/books/book-2.png',1,20.99,33,2),(87,'assets/images/products/books/book-3.png',1,14.99,34,3),(88,'assets/images/products/books/book-2.png',1,20.99,34,2),(89,'assets/images/products/books/book-4.png',1,13.99,34,4),(90,'assets/images/products/dresses/dress-1',1,100.00,35,105),(91,'assets/images/products/books/book-4.png',1,13.99,36,4),(92,'assets/images/products/books/book-3.png',1,14.99,36,3);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-29 18:03:45
