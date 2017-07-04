/*
Navicat MySQL Data Transfer

Source Server         : localhost_weixin_ctsh
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : xiuniang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-02 10:15:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `points_records`
-- ----------------------------
DROP TABLE IF EXISTS `points_records`;
CREATE TABLE `points_records` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fans_id` int(11) DEFAULT NULL,
  `openid` varchar(255) DEFAULT NULL,
  `kdt_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  `client_hash` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_points_records_on_openid` (`openid`),
  KEY `index_points_records_on_mobile` (`mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of points_records
-- ----------------------------
