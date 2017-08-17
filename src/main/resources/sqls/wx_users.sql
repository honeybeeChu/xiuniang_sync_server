SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `wx_users`
-- ----------------------------
DROP TABLE IF EXISTS `wx_users`;
CREATE TABLE `wx_users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '1:男，2：女',
  `language` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `headimgurl` varchar(255) DEFAULT NULL,
  `subscribe_time` varchar(255) DEFAULT NULL,
  `unionid` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `groupid` int(11) DEFAULT NULL,
  `subscribe` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `is_member` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `index_wx_users_on_nickname` (`nickname`),
  KEY `index_wx_users_on_openid` (`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=471 DEFAULT CHARSET=utf8;
