-- MySQL dump 10.13  Distrib 5.6.48, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: message_board
-- ------------------------------------------------------
-- Server version	5.7.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `message_board_category`
--

DROP TABLE IF EXISTS `message_board_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类名',
  `create_by` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_category`
--

LOCK TABLES `message_board_category` WRITE;
/*!40000 ALTER TABLE `message_board_category` DISABLE KEYS */;
INSERT INTO `message_board_category` VALUES (1,'前端开发','2',1705393863029,'',0),(2,'后端开发','2',1705393872066,'',0),(3,'数据库管理','2',1705393876502,'',0),(4,'移动应用开发','2',1705393884430,'',0),(5,'云计算与网络安全','2',1705393890649,'',0),(6,'人工智能与机器学习','2',1705393896017,'',0),(7,'前沿技术与趋势','2',1705393902157,'',0),(8,'其他','2',1705393907321,'',0);
/*!40000 ALTER TABLE `message_board_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_board_login_record`
--

DROP TABLE IF EXISTS `message_board_login_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_login_record` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `ip` varchar(20) DEFAULT NULL COMMENT '登录IP',
  `browser` varchar(255) DEFAULT NULL COMMENT '浏览器',
  `os` varchar(255) DEFAULT NULL COMMENT '操作系统',
  `user_agent` varchar(255) DEFAULT NULL COMMENT 'UserAgent',
  `create_by` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COMMENT='用户登录记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_login_record`
--

LOCK TABLES `message_board_login_record` WRITE;
/*!40000 ALTER TABLE `message_board_login_record` DISABLE KEYS */;
INSERT INTO `message_board_login_record` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'',0),(2,2,'127.0.0.1','Robot/Spider','Unknown',NULL,'0',1705388851088,'',0),(3,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705388989718,'',0),(4,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705389104759,'',0),(5,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705389105286,'',0),(6,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705389106016,'',0),(7,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705390031068,'',0),(8,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705390149862,'',0),(9,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705390319358,'',0),(10,3,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705390532452,'',0),(11,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705390554975,'',0),(12,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705393445967,'',0),(13,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705393858226,'',0),(14,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705405705434,'',0),(15,2,'127.0.0.1','Robot/Spider','Unknown','Apache-HttpClient/4.5.14 (Java/17.0.9)','0',1705406054525,'',0);
/*!40000 ALTER TABLE `message_board_login_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_board_message`
--

DROP TABLE IF EXISTS `message_board_message`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `category_id` bigint(20) NOT NULL COMMENT '关联的分类id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` longtext NOT NULL COMMENT '内容',
  `view_count` int(11) NOT NULL DEFAULT '0' COMMENT '浏览量',
  `star_count` int(11) NOT NULL DEFAULT '0' COMMENT '点赞量',
  `create_by` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='留言表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_message`
--

LOCK TABLES `message_board_message` WRITE;
/*!40000 ALTER TABLE `message_board_message` DISABLE KEYS */;
INSERT INTO `message_board_message` VALUES (1,2,1,'关于活动安排的建议','我觉得我们应该增加更多的户外活动，这样能够促进同学们之间的交流和团队合作。希望组织方能考虑一下这个建议。谢谢！',0,0,'2',1705406073860,'',0),(2,2,2,'感谢组织者的辛勤付出','非常感谢组织者为我们筹备这次活动，一切都安排得非常周到。大家都玩得很开心，学到了很多知识。再次感谢你们的辛勤付出！',0,0,'2',1705406137822,'',0);
/*!40000 ALTER TABLE `message_board_message` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_board_message_commons`
--

DROP TABLE IF EXISTS `message_board_message_commons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_message_commons` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `message_id` bigint(20) NOT NULL COMMENT '留言ID',
  `content` varchar(255) NOT NULL COMMENT '内容',
  `create_by` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='留言评论表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_message_commons`
--

LOCK TABLES `message_board_message_commons` WRITE;
/*!40000 ALTER TABLE `message_board_message_commons` DISABLE KEYS */;
/*!40000 ALTER TABLE `message_board_message_commons` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_board_message_tag`
--

DROP TABLE IF EXISTS `message_board_message_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_message_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `message_id` bigint(20) NOT NULL COMMENT '留言消息id',
  `tag_id` bigint(20) NOT NULL COMMENT '关联的标签id',
  `create_by` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COMMENT='留言-标签关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_message_tag`
--

LOCK TABLES `message_board_message_tag` WRITE;
/*!40000 ALTER TABLE `message_board_message_tag` DISABLE KEYS */;
INSERT INTO `message_board_message_tag` VALUES (1,1,1,'2',1705406073938,'',0),(2,1,2,'2',1705406073952,'',0),(3,1,3,'2',1705406073961,'',0),(4,2,2,'2',1705406137831,'',0),(5,2,3,'2',1705406137833,'',0),(6,2,4,'2',1705406137835,'',0);
/*!40000 ALTER TABLE `message_board_message_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_board_tag`
--

DROP TABLE IF EXISTS `message_board_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_tag` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `tag_name` varchar(255) NOT NULL COMMENT '标签名',
  `create_by` varchar(100) DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='标签表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_tag`
--

LOCK TABLES `message_board_tag` WRITE;
/*!40000 ALTER TABLE `message_board_tag` DISABLE KEYS */;
INSERT INTO `message_board_tag` VALUES (1,'问题','2',1705393447972,'',0),(2,'建议','2',1705393456028,'',0),(3,'技术支持','2',1705393460504,'',0),(4,'投诉','2',1705393465734,'',0),(5,'表扬','2',1705393473595,'',0),(6,'咨询','2',1705393477766,'',0),(7,'感谢','2',1705393482875,'',0),(8,'其它','2',1705393486758,'',0);
/*!40000 ALTER TABLE `message_board_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `message_board_user`
--

DROP TABLE IF EXISTS `message_board_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `message_board_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `role` tinyint(4) NOT NULL DEFAULT '1' COMMENT '角色',
  `password` varchar(255) NOT NULL COMMENT '密码（实际应用中通常会加密存储）',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像URL或路径',
  `last_login_time` bigint(20) DEFAULT '0' COMMENT '上次登录时间戳（单位：毫秒）',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态，参考UserStatusEnum枚举',
  `gender` varchar(10) DEFAULT '' COMMENT '性别，参考GenderEnum枚举',
  `birthday` bigint(20) DEFAULT '0' COMMENT '生日时间戳（单位：毫秒）',
  `register_date_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '注册日期时间戳（单位：毫秒）',
  `create_by` varchar(100) NOT NULL DEFAULT '' COMMENT '创建者',
  `create_date_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建时间戳（单位：毫秒）',
  `update_by` varchar(100) NOT NULL DEFAULT '' COMMENT '更新者',
  `update_date_time` bigint(20) NOT NULL DEFAULT '0' COMMENT '更新时间戳（单位：毫秒）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `message_board_user`
--

LOCK TABLES `message_board_user` WRITE;
/*!40000 ALTER TABLE `message_board_user` DISABLE KEYS */;
INSERT INTO `message_board_user` VALUES (1,NULL,1,'e10adc3949ba59abbe56e057f20f883e',NULL,'18700000001',NULL,1705406054567,0,'',0,1705386263930,'0',1705386263935,'',0),(2,'超级管理员',0,'e10adc3949ba59abbe56e057f20f883e',NULL,'admin',NULL,1705406054567,0,'',0,1705386263930,'0',1705386263935,'',0),(3,'zhangSan',1,'e10adc3949ba59abbe56e057f20f883e','111@qq.com','zhangSan','header.jpg',1705406054567,0,'1',1705334400000,1705390320126,'2',1705390320129,'',0),(4,'wangEr',0,'e10adc3949ba59abbe56e057f20f883e','111@qq.com','wangEr','header.jpg',1705406054567,0,'1',1705334400000,1705390558727,'2',1705390558730,'',0);
/*!40000 ALTER TABLE `message_board_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-01-16 21:05:07
