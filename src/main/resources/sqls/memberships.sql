/*
Navicat MySQL Data Transfer

Source Server         : localhost_weixin_ctsh
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : xiuniang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-02 10:15:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `memberships`
-- ----------------------------
DROP TABLE IF EXISTS `memberships`;
CREATE TABLE `memberships` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL,
  `dianyuan_id` int(11) DEFAULT NULL,
  `card_id` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `postcode` int(11) DEFAULT NULL,
  `education_backgro` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL,
  `income` varchar(255) DEFAULT NULL,
  `habit` varchar(255) DEFAULT NULL,
  `bonus` int(11) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `user_card_status` varchar(255) DEFAULT NULL,
  `has_active` tinyint(1) DEFAULT NULL,
  `total_consumption` int(11) DEFAULT NULL COMMENT '一共消费的总额',
  `recent_consumption` int(11) DEFAULT NULL COMMENT '最近消费的总额（从去年的一月一日起到现在的消费额',
  `total_num` int(11) DEFAULT NULL COMMENT '一共消费的笔数',
  `update_points_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_memberships_on_openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

