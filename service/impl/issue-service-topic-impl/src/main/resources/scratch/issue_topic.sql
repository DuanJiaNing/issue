/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50727
Source Host           : 123.57.237.176:3306
Source Database       : issue_topic

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-03 11:23:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `topic`
-- ----------------------------
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) NOT NULL,
  `title` varchar(200) NOT NULL,
  `notes` varchar(2000) DEFAULT NULL,
  `like` int(10) unsigned NOT NULL DEFAULT '0',
  `dislike` int(10) unsigned NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of topic
-- ----------------------------
