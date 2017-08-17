/*
Navicat MySQL Data Transfer

Source Server         : localhost_weixin_ctsh
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : xiuniang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-02 10:14:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `efast_orders`
-- ----------------------------
DROP TABLE IF EXISTS `dianyuans`;
CREATE TABLE `dianyuans` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DYDM` varchar(255) NOT NULL,
  `DYMC` varchar(255) NOT NULL,
  `DYXB` varchar(255) DEFAULT NULL,
  `QDDM` varchar(255) DEFAULT NULL,
  `KHDM` varchar(255) DEFAULT NULL COMMENT '店铺代码',
  `XZDM` varchar(255) DEFAULT NULL,
  `ZDZK` varchar(255) DEFAULT NULL,
  `QMM` varchar(255) DEFAULT NULL,
  `BZ` varchar(255) DEFAULT NULL,
  `BYZD1` varchar(255) DEFAULT NULL,
  `BYZD2` varchar(255) DEFAULT NULL,
  `BYZD3` varchar(255) DEFAULT NULL,
  `BYZD4` varchar(255) DEFAULT NULL,
  `ZJF` varchar(255) DEFAULT NULL,
  `KWDM` varchar(255) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `MOBILE` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `BIRTHDAY` datetime DEFAULT NULL,
  `EDUCATION` varchar(255) DEFAULT NULL,
  `ORIGIN` varchar(255) DEFAULT NULL,
  `IDENT_NO` varchar(255) DEFAULT NULL,
  `IN_DATE` datetime DEFAULT NULL,
  `OUT_DATE` datetime DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `ISOUT` varchar(255) DEFAULT NULL,
  `GWDDRQ` datetime DEFAULT NULL,
  `BYZD5` varchar(255) DEFAULT NULL,
  `BYZD6` varchar(255) DEFAULT NULL,
  `BYZD7` varchar(255) DEFAULT NULL,
  `BYZD8` varchar(255) DEFAULT NULL,
  `BYZD9` varchar(255) DEFAULT NULL,
  `QDBZ` varchar(255) DEFAULT NULL,
  `LastChanged` datetime DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1040 DEFAULT CHARSET=utf8;
