/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50727
Source Host           : 123.57.237.176:3306
Source Database       : issue_comment

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-03 11:22:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `topic_id` int(10) unsigned NOT NULL,
  `content` varchar(3000) NOT NULL,
  `status` tinyint(4) NOT NULL,
  `like` int(10) unsigned NOT NULL DEFAULT '0',
  `dislike` int(10) unsigned NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
