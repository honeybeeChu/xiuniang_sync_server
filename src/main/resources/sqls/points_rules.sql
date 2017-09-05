/*
Navicat MySQL Data Transfer

Source Server         : localhost_weixin_ctsh
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : xiuniang

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-02 10:15:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `points_rules`
-- ----------------------------
DROP TABLE IF EXISTS `points_rules`;
CREATE TABLE `points_rules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `level` int(2) DEFAULT NULL COMMENT '等级，从0开始，为预备会员',
  `consumption` int(11) NOT NULL COMMENT '消费的累计金额',
  `name` varchar(255) DEFAULT NULL COMMENT '等级名称，如预备会员，金卡会员',
  `trade_num` int(11) NOT NULL COMMENT '消费的笔数',
  `conditions` int(2) DEFAULT NULL COMMENT 
  '升级到此level的条件，0：consumption消费金额满足即可，1： :trand_num交易笔数满足即可，2：金额和笔数有一个满足即可，3：金额和笔数同事满足即可,4：单笔消费金额',
  `rate` float DEFAULT NULL COMMENT '此等级下的会员，消费金额和积分的增加比例，如，1.2  表示1元给1.2个积分',
  `discount` float DEFAULT 1 COMMENT '此等级下的会员，线下消费时享受的折扣率，0~1',
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of points_rules
-- ----------------------------
