/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50727
Source Host           : 123.57.237.176:3306
Source Database       : issue_manage

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-03 12:46:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `proposal`
-- ----------------------------
DROP TABLE IF EXISTS `proposal`;
CREATE TABLE `proposal` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` tinyint(4) NOT NULL,
  `reason` varchar(5000) NOT NULL,
  `proposal_type` tinyint(4) NOT NULL,
  `subject_type` tinyint(4) NOT NULL,
  `subject_id` int(10) unsigned NOT NULL,
  `agree` int(10) unsigned NOT NULL DEFAULT '0',
  `disagree` int(10) unsigned NOT NULL DEFAULT '0',
  `insert_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `close_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of proposal
-- ----------------------------
