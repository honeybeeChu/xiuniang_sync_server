--mysql
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `wx_shops`
-- ----------------------------
DROP TABLE IF EXISTS `wx_shops`;
CREATE TABLE `wx_shops` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account_id` int(11) DEFAULT NULL COMMENT '所属公众号id',
  `sid` varchar(100) DEFAULT NULL COMMENT '商户自己的id，用于后续审核通过收到poi_id 的通知时，做对应关系。请商户自己保证唯一识别性',
  `business_name` varchar(100) DEFAULT NULL COMMENT '门店名称（仅为商户名，如：国美、麦当劳，不应包含地区、地址、分店名等信息，错误示例：北京国美）',
  `branch_name` varchar(100) DEFAULT NULL COMMENT '分店名称（不应包含地区信息，不应与门店名有重复，错误示例：北京王府井店）20个字以内',
  `province` varchar(100) DEFAULT NULL COMMENT '门店所在的省份（直辖市填城市名,如：北京市）',
  `city` varchar(100) DEFAULT NULL COMMENT '粉丝所在城市',
  `district` varchar(255) DEFAULT NULL COMMENT '门店所在地区', 
  `address` varchar(255) DEFAULT NULL COMMENT '门店所在的详细街道地址（不要填写省市信息）',
  `telephone` varchar(100) DEFAULT NULL COMMENT '门店的电话（纯数字，区号、分机号均由“-”隔开）',
  `categories` varchar(100) DEFAULT NULL COMMENT '门店的类型（不同级分类用“,”隔开，如：美食，川菜，火锅。详细分类参见附件：微信门店类目表）',
  `offset_type` tinyint DEFAULT NULL COMMENT '坐标类型：1 为火星坐标2 为sogou经纬度3 为百度经纬度4 为mapbar经纬度5 为GPS坐标6 为sogou墨卡托坐标',
  `longitude` varchar(100) DEFAULT NULL COMMENT '门店所在地理位置的经度',
  `latitude` varchar(100) DEFAULT NULL COMMENT '门店所在地理位置的纬度（经纬度均为火星坐标，最好选用腾讯地图标记的坐标）',
  `open_time` varchar(100) DEFAULT NULL COMMENT ' 营业时间，24 小时制表示，用“-”连接，如  8:00-20:00', 	
  `introduction` varchar(500) DEFAULT NULL COMMENT '商户简介，主要介绍商户信息等',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信门店';
CREATE INDEX wx_shops_index ON wx_shops (account_id);

-- ----------------------------
-- Records of wx_shops
-- ----------------------------