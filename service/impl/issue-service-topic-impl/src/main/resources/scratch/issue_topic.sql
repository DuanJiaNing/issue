-- --------------------------------------------------------
-- 主机:                           123.57.237.176
-- 服务器版本:                        5.7.27-0ubuntu0.16.04.1 - (Ubuntu)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 issue_topic 的数据库结构
CREATE DATABASE IF NOT EXISTS `issue_topic` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `issue_topic`;

-- 导出  表 issue_topic.topic 结构
CREATE TABLE IF NOT EXISTS `topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(500) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `title` varchar(200) NOT NULL,
  `notes` varchar(2000) DEFAULT NULL,
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。

-- 导出  表 issue_topic.user_like 结构
CREATE TABLE IF NOT EXISTS `user_like` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` varchar(500) NOT NULL,
  `topic_id` int(10) unsigned NOT NULL,
  `like` tinyint(4) NOT NULL COMMENT '喜欢 1，不喜欢 2',
  `insert_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 数据导出被取消选择。

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
