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
  `sex` int(11) DEFAULT NULL COMMENT '0:女，1：男',
  `phone` varchar(255) DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `idcard` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `postcode` int(11) DEFAULT NULL,
  `education_backgro` varchar(255) DEFAULT NULL,
  `industry` varchar(255) DEFAULT NULL COMMENT '从事行业',
  `income` varchar(255) DEFAULT NULL,
  `habit` varchar(255) DEFAULT NULL,
  `bonus` int(11) DEFAULT 0 COMMENT '积分',
  `balance` int(11) DEFAULT 0 COMMENT '余额',
  `level` int(11) DEFAULT 0 COMMENT '会员等级',
  `user_card_status` varchar(255) DEFAULT NULL,
  `has_active` tinyint(1) DEFAULT 0 COMMENT 'Boolean类型，0：false,领取没有激活，1：true，激活状态',
  `total_consumption` int(11) DEFAULT 0,
  `recent_consumption` int(11) DEFAULT 0,
  `total_num` int(11) DEFAULT 0,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `index_memberships_on_openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

