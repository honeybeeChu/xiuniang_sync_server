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
DROP TABLE IF EXISTS `efast_orders`;
CREATE TABLE `efast_orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sell_record_code` varchar(255) DEFAULT NULL COMMENT 'efast 订单号',
  `order_status` varchar(255) DEFAULT NULL COMMENT '订单状态 0-未确认；1-已确认；3-已作废；5-已完成',
  `shipping_status` int(11) DEFAULT NULL COMMENT '0-未发货 1-已通知配货 2-拣货中(已分配拣货任务) 3-已完成拣货4-已发货',
  `pay_status` varchar(255) DEFAULT NULL COMMENT '支付状态 0:未付款 2:已付款',
  `sale_channel_code` varchar(255) DEFAULT NULL COMMENT '销售平台  taobao jingdong',
  `shop_code` varchar(255) DEFAULT NULL COMMENT '店铺代码',
  `buyer_name` varchar(255) DEFAULT NULL COMMENT '会员昵称',
  `receiver_name` varchar(255) DEFAULT NULL COMMENT '收货人',
  `receiver_country` varchar(255) DEFAULT NULL COMMENT '国家编号',
  `receiver_province` varchar(255) DEFAULT NULL COMMENT '省（名称）',
  `receiver_city` varchar(255) DEFAULT NULL COMMENT '市（名称）',
  `receiver_district` varchar(255) DEFAULT NULL COMMENT '区（名称）',
  `receiver_street` varchar(255) DEFAULT NULL COMMENT '街道（名称）',
  `receiver_address` varchar(255) DEFAULT NULL COMMENT '收货地址(包含省市',
  `receiver_addr` varchar(255) DEFAULT NULL COMMENT '收货地址(不包含省市',
  `receiver_zip_code` varchar(255) DEFAULT NULL COMMENT '收货邮编 ',
  `receiver_mobile` varchar(255) DEFAULT NULL COMMENT '收货手机号码 ',
  `receiver_phone` varchar(255) DEFAULT NULL COMMENT '收货电话 ',
  `receiver_email` varchar(255) DEFAULT NULL COMMENT '收货邮箱 ',
  `payable_money` int(11) DEFAULT NULL COMMENT '订单应付款=商品均摊金额之和+运费 ',
  `order_money` int(11) DEFAULT NULL COMMENT '订单总额sum（单价*数量） ',
  `discount_fee` int(11) DEFAULT NULL COMMENT '优惠金额 订单总额-订单应付款 ',
  `pay_code` varchar(255) DEFAULT NULL COMMENT '支付方式 ',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间 ',
  `openid` varchar(255) DEFAULT NULL COMMENT '这个订单属于哪个会员',
  PRIMARY KEY (`id`),
  KEY `index_efast_orders_on_openid` (`openid`),
  KEY `index_efast_orders_on_receiver_mobile` (`receiver_mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=4013 DEFAULT CHARSET=utf8;
