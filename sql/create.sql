# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.23)
# Database: elf
# Generation Time: 2015-09-11 16:44:05 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table city
# ------------------------------------------------------------
DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键 id',
  `name` varchar(30) NOT NULL DEFAULT ' ' COMMENT '城市名称',
  `is_valid` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否有效，默认0：有效 1：删除',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user_basic_info
# ------------------------------------------------------------
DROP TABLE IF EXISTS `user_basic_info`;

CREATE TABLE `user_basic_info` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '表主键 自增长',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户的姓名',
  `mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '用户手机号',
  `mobile_ischeck` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户手机号是否通过验证 0:未验证, 1:已验证',
  `gender` tinyint(4) NOT NULL DEFAULT '1' COMMENT '用户性别 0:女 1:男',
  `py_name` varchar(30) NOT NULL DEFAULT '' COMMENT '用户姓名的拼音',
  `city_id` int(11) NOT NULL DEFAULT '1' COMMENT 'city表主键',
  `email` varchar(64) NOT NULL DEFAULT '' COMMENT '用户email',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile` (`mobile`),
  UNIQUE KEY `email` (`email`),
  KEY `ix_mobile` (`mobile`),
  KEY `ix_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table user_session
# ------------------------------------------------------------
DROP TABLE IF EXISTS `user_session`;

CREATE TABLE `user_session` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT 'user表主键',
  `user_passwd` varchar(20) NOT NULL DEFAULT '' COMMENT '用户密码md5',
  `salt` varchar(64) NOT NULL DEFAULT '' COMMENT '盐',
  `cookie` varchar(64) NOT NULL DEFAULT '' COMMENT '用户session值',
  `cookid_expiretime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT 'session过期时间',
  `registr_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '注册时间',
  `last_login_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '最近一次登录时间',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;