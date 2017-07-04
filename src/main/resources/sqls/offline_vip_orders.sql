/*
Navicat MySQL Data Transfer

Source Server         : localhost_weixin_ctsh
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : xiuniang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-02 10:15:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `offline_vip_orders`
-- ----------------------------
DROP TABLE IF EXISTS `offline_vip_orders`;
CREATE TABLE `offline_vip_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vip_card` varchar(255) DEFAULT NULL,
  `trade_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `gkmc` varchar(255) DEFAULT NULL,
  `sex` int(2) DEFAULT NULL COMMENT '0:女 1:男',
  `get_money` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `vshop` varchar(255) DEFAULT NULL,
  `vempcode` varchar(255) DEFAULT NULL,
  `vspcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='线下vip会员订单表';

-- ----------------------------
-- Records of offline_vip_orders
-- ----------------------------
