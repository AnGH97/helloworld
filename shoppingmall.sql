-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: shoppingmall
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '주문번호',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 정보',
  `adate` date NOT NULL COMMENT '장바구니 추가 날짜',
  `cnt` int NOT NULL COMMENT '상품 수량',
  `product_id1` int DEFAULT NULL COMMENT '장바구니 상품 참조키',
  `color` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품 색상',
  `size` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품 사이즈',
  `user_id1` int DEFAULT NULL COMMENT '사용자 ID',
  PRIMARY KEY (`id`),
  KEY `fk_cart_product1_idx` (`product_id1`),
  KEY `fk_cart_user1_idx` (`user_id1`),
  CONSTRAINT `fk_cart_product1` FOREIGN KEY (`product_id1`) REFERENCES `product` (`id`),
  CONSTRAINT `fk_cart_user1` FOREIGN KEY (`user_id1`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='장바구니';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category1`
--

DROP TABLE IF EXISTS `category1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category1` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '부모 카테고리 번호',
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '부모 카테고리 이름',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='상품 카테고리1';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category1`
--

LOCK TABLES `category1` WRITE;
/*!40000 ALTER TABLE `category1` DISABLE KEYS */;
INSERT INTO `category1` VALUES (1,'프로모션'),(3,'커뮤니티'),(9,'베스트'),(10,'1+1'),(11,'우먼즈'),(12,'맨즈'),(13,'테니스'),(14,'용품');
/*!40000 ALTER TABLE `category1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category2`
--

DROP TABLE IF EXISTS `category2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category2` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '자식 카테고리 번호',
  `name` varchar(150) NOT NULL COMMENT '자식 카테고리 이름',
  `category1_id` int DEFAULT NULL COMMENT '부모 카테고리 참조키',
  PRIMARY KEY (`id`),
  KEY `fk_category2_category11_idx` (`category1_id`),
  CONSTRAINT `fk_category2_category11` FOREIGN KEY (`category1_id`) REFERENCES `category1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='상품 카테고리2';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category2`
--

LOCK TABLES `category2` WRITE;
/*!40000 ALTER TABLE `category2` DISABLE KEYS */;
INSERT INTO `category2` VALUES (7,'공지사항',3),(8,'자주묻는질문',3),(9,'상품 문의',3),(10,'반품 문의',3),(11,'교환 문의',3),(12,'전국 매장 안내',3),(13,'상의',10),(14,'하의',10),(15,'용품',10),(16,'상의',11),(17,'하의',11),(18,'아우터',11),(19,'조거팬츠',11),(20,'세트',11),(21,'상의',12),(22,'하의',12),(23,'아우터',12),(24,'조거팬츠',12),(25,'맨즈',13),(26,'우먼즈',13),(27,'용품',13),(28,'양말',14),(29,'모자',14),(30,'가방',14),(31,'홈트용품',14),(32,'세트',12);
/*!40000 ALTER TABLE `category2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category2_has_product`
--

DROP TABLE IF EXISTS `category2_has_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category2_has_product` (
  `category2_id` int DEFAULT NULL COMMENT '자식 카테고리 참조키',
  `product_id` int DEFAULT NULL COMMENT '상품 번호 참조키',
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'Category2_has_product의 PK',
  PRIMARY KEY (`id`),
  KEY `fk_category2_has_product_product1_idx` (`product_id`),
  KEY `fk_category2_has_product_category21_idx` (`category2_id`),
  CONSTRAINT `fk_category2_has_product_category21` FOREIGN KEY (`category2_id`) REFERENCES `category2` (`id`),
  CONSTRAINT `fk_category2_has_product_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='자식 카테고리와 상품의 관계 ';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category2_has_product`
--

LOCK TABLES `category2_has_product` WRITE;
/*!40000 ALTER TABLE `category2_has_product` DISABLE KEYS */;
INSERT INTO `category2_has_product` VALUES (17,6,4),(17,7,5),(17,10,6),(16,8,7),(16,9,8),(19,11,9),(19,12,10),(20,13,11),(20,14,12),(18,15,13),(18,16,14);
/*!40000 ALTER TABLE `category2_has_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `document`
--

DROP TABLE IF EXISTS `document`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `document` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '게시글 번호',
  `type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '게시판 종류',
  `writer` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '작성자 아이디',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '게시물 비밀번호',
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '게시글 제목',
  `content` blob NOT NULL COMMENT '게시글 내용',
  `hit` int NOT NULL COMMENT '게시글 조회수',
  `reg_date` date NOT NULL COMMENT '게시글 작성일',
  `star` int DEFAULT NULL COMMENT '리뷰 별점',
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_document_user1_idx` (`user_id`),
  CONSTRAINT `fk_document_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='게시판 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `document`
--

LOCK TABLES `document` WRITE;
/*!40000 ALTER TABLE `document` DISABLE KEYS */;
INSERT INTO `document` VALUES (1,'review','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',NULL,NULL),(2,'review','angachi566','12345','리뷰글',_binary 'Hello World',5,'2023-05-31',NULL,NULL),(3,'review','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',NULL,NULL),(4,'review','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',NULL,NULL),(6,'review','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',5,NULL),(8,'content2','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',NULL,NULL),(9,'content3','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',NULL,NULL),(13,'review','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',NULL,NULL),(14,'review','angachi566','12345','리뷰글',_binary 'Hello World',5,'2023-05-31',NULL,NULL),(18,'review','angachi576','12345','리뷰글',_binary 'Hello World',0,'2023-05-31',4,1),(19,'review','angachi575','12345','리뷰글',_binary 'Hello',0,'2023-05-31',4,1),(20,'review','angachi575','12345','공지사항',_binary 'Hello',0,'2023-05-31',4,1),(21,'top1','angachi575','12345','공지사항',_binary 'Hello',0,'2023-05-31',4,1),(22,'top1','ccyyan','12345','공지사항',_binary 'Hello',0,'2023-05-31',3,5),(23,'content1','angachi576','1234567','테스트 중',_binary 'Hello World\r\nHow are you\r\nI\'m fine Thank you\r\nAnd You?',0,'2023-06-07',NULL,NULL),(24,'content2','angachi5786','123456789','테스트1',_binary '글번호 시험중 입니다.',0,'2023-06-07',NULL,NULL);
/*!40000 ALTER TABLE `document` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img`
--

DROP TABLE IF EXISTS `img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '상품 이미지 일련번호',
  `img_path` varchar(2000) NOT NULL COMMENT '이미지 경로',
  `product_id` int DEFAULT NULL COMMENT '상품 번호 참조키',
  `thumbnail` enum('1','2') CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '대표 이미지 설정',
  PRIMARY KEY (`id`),
  KEY `fk_img_product1_idx` (`product_id`),
  CONSTRAINT `fk_img_product1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='상품 이미지';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img`
--

LOCK TABLES `img` WRITE;
/*!40000 ALTER TABLE `img` DISABLE KEYS */;
INSERT INTO `img` VALUES (9,'/assets/img/womens/bottom/product1_11.jpg',6,'1'),(10,'/assets/img/womens/bottom/product1_21.jpg',6,'2'),(11,'/assets/img/womens/bottom/product2_11.jpg',7,'1'),(12,'/assets/img/womens/top/product3_11.jpg',8,'1'),(13,'/assets/img/womens/top/product3_21.jpg',8,'2'),(14,'/assets/img/womens/top/product4_11.jpg',9,'1'),(15,'/assets/img/womens/top/product4_21.jpg',9,'2'),(16,'/assets/img/womens/bottom/product2_21.jpg',7,'2'),(17,'/assets/img/womens/bottom/product5_11.jpg',10,'1'),(18,'/assets/img/womens/bottom/product5_21.jpg',10,'2'),(19,'/assets/img/womens/jogger/product6_11.jpg',11,'1'),(20,'/assets/img/womens/jogger/product6_21.jpg',11,'2'),(21,'/assets/img/womens/jogger/product7_11.jpg',12,'1'),(22,'/assets/img/womens/jogger/product7_21.jpg',12,'2'),(23,'/assets/img/womens/set/product8_11.jpg',13,'1'),(24,'/assets/img/womens/set/product8_21.jpg',13,'2'),(25,'/assets/img/womens/set/product9_11.jpg',14,'1'),(26,'/assets/img/womens/set/product9_21.jpg',14,'2'),(27,'/assets/img/womens/outer/product10_11.jpg',15,'1'),(28,'/assets/img/womens/outer/product10_21.jpg',15,'2'),(29,'/assets/img/womens/outer/product11_11.jpg',16,'1'),(30,'/assets/img/womens/outer/product11_21.jpg',16,'2');
/*!40000 ALTER TABLE `img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '상품 번호',
  `name` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품 이름',
  `price` int NOT NULL COMMENT '정가',
  `sale` int NOT NULL COMMENT '판매가',
  `color` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품 색상',
  `size` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '상품 사이즈',
  `product_txt` blob NOT NULL COMMENT '상품 설명 글',
  `best` enum('Y','N') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'best 상품 노출 여부',
  `sort` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '정렬 순서',
  `category1_id` int DEFAULT NULL COMMENT '카테고리 1의 아이디',
  PRIMARY KEY (`id`),
  KEY `fk_product_category11_idx` (`category1_id`),
  CONSTRAINT `fk_product_category11` FOREIGN KEY (`category1_id`) REFERENCES `category1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='상품';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (6,'젤라 인텐션 레깅스 1+1',78000,29800,'블랙,멜로우그레이,토프그레이,잉크그레이,마젠타헤이즈','s,m,l,xl,xxl,xxxl',_binary 'HTML로 작성될 부분입니다.','Y','f',11),(7,'젤라 인텐션 바이커 쇼츠 5부 1+1',72000,29800,'블랙,마그넷그레이,오션네이비,콤부그린,드래곤플라이블루','s,m,l',_binary 'HTML로 작성될 부분입니다.','N','g',11),(8,'아이스페더 숏슬리브 1+1',56000,24800,'블랙,다크그레이,백아이보리,트로피칼핑크,베이비블루,','s,m,l,xl',_binary 'HTML로 작성될 부분입니다.','Y','e',11),(9,'XXMX 세미 루즈핏 티셔츠 1+1',78000,44800,'블랙,아이보리,다이아몬드핑크,라임,블루헤런,코랄아몬드','free',_binary 'HTML로 작성될 부분입니다.','N','h',11),(10,'스포티 테리 배색 쇼츠',48000,29800,'블랙,아이보리,에덴그린','s,m,l',_binary 'HTML로 작성될 부분입니다.','N','d',11),(11,'미디움페더 인밴드 조거팬츠 1+1',96000,68800,'블랙,코랄틴트,피치코랄,피넛베이지','s,m,l',_binary 'HTML로 작성될 부분입니다.','Y','i',11),(12,'스트레치 카고 조거팬츠 블랙',99000,89800,'블랙,화이트','s,m,l',_binary 'HTML로 작성될 부분입니다.','N','c',11),(13,'[입문자용] 베이직 인텐션 SET',96000,57800,'블랙,백아이보리,슈가베이지,데이코랄,블랑실버','s,m,l,xl',_binary 'HTML로 작성될 부분입니다.','Y','j',11),(14,'에어 마일드 SET',163000,98800,'블랙,아발론그레이,라이트멜란지,미디움멜란지,로즈스모크','s,m,l,xl',_binary 'HTML로 작성될 부분입니다.','N','b',11),(15,'슬림핏 크롭 집업자켓 1+1',108000,60800,'옐로우바나나,우드애쉬,핑키베이지,올드로즈,실버세이지','s,m',_binary 'HTML로 작성될 부분입니다.','Y','k',11),(16,'XXMX 데일리 코튼 크롭 가디건',47000,29800,'블랙,아이보리,엔젤핑크,아이비그린','s,m,l',_binary 'HTML로 작성될 부분입니다.','N','a',11);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '회원 아이디 번호',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 이름',
  `user_pw` varchar(150) NOT NULL,
  `email` varchar(150) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 이메일',
  `birthdate` date NOT NULL COMMENT '회원 생년월일',
  `gender` enum('M','F') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 성별(''M'', ''F'')',
  `tel` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 연락처',
  `address` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '회원 주소',
  `is_out` enum('Y','N') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'N' COMMENT '회원 탈퇴여부',
  `reg_date` datetime NOT NULL COMMENT '회원 가입 일시',
  `user_id` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '회원 가입 아이디',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='회원 테이블';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'안가현','e10adc3949ba59abbe56e057f20f883e','angachi576@naver.com','1997-03-20','F','010-4456-7536','서울시 구로구 새말로 31','N','2023-05-31 00:00:00','angachi576'),(2,'조용진','ba00819f263287af1ff0100c5a323355','cyj960921@naver.com','1996-09-21','M','010-9876-6433','경기도 의왕시 내손로 57','N','2023-05-31 00:00:00','cyj960921'),(5,'안정훈','e10adc3949ba59abbe56e057f20f883e','ccyyan@naver.com','1998-11-30','M','010-2396-7536','서울시 영등포구 당산로 61','N','2023-05-31 00:00:00','ccyyan');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-09  3:33:46
