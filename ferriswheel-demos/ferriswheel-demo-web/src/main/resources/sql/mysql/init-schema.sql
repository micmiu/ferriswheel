/*
 Navicat Premium Data Transfer

 Source Server         : micmiu@mysql
 Source Server Type    : MySQL
 Source Server Version : 50171
 Source Host           : 192.168.6.230
 Source Database       : micmiu

 Target Server Type    : MySQL
 Target Server Version : 50171
 File Encoding         : utf-8

 Date: 11/24/2014 14:32:58 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_blog`
-- ----------------------------
DROP TABLE IF EXISTS `t_blog`;
CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `creater` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  `publish_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `alias_name` varchar(50) DEFAULT NULL,
  `menu_name` varchar(50) DEFAULT NULL,
  `menu_type` varchar(10) DEFAULT NULL,
  `menu_url` longtext,
  `order_num` int(11) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2B50BAFC8E8D3A77` (`parent_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_sys_permssion`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permssion`;
CREATE TABLE `t_sys_permssion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `operation` varchar(50) DEFAULT NULL,
  `res_cn_name` varchar(50) DEFAULT NULL,
  `res_name` varchar(50) DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK362A53B4BCBF5A2` (`menu_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_sys_r2p`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_r2p`;
CREATE TABLE `t_sys_r2p` (
  `role_id` bigint(20) NOT NULL,
  `perm_id` bigint(20) NOT NULL,
  KEY `FK53FA6533BCFFBCE1` (`perm_id`),
  KEY `FK53FA6533653A8A42` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_sys_u2r`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_u2r`;
CREATE TABLE `t_sys_u2r` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK53FA7078653A8A42` (`role_id`),
  KEY `FK53FA7078A654E22` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `login_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `other` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
