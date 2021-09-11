/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : game_01

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-09-11 19:13:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for name_01
-- ----------------------------
DROP TABLE IF EXISTS `name_01`;
CREATE TABLE `name_01` (
  `uid` int(11) NOT NULL COMMENT '主键用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of name_01
-- ----------------------------
INSERT INTO `name_01` VALUES ('1', '1', '1', '2021-09-24 11:02:28');

-- ----------------------------
-- Table structure for name_03
-- ----------------------------
DROP TABLE IF EXISTS `name_03`;
CREATE TABLE `name_03` (
  `uid` int(11) NOT NULL COMMENT '主键用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of name_03
-- ----------------------------
INSERT INTO `name_03` VALUES ('3', '3', '3', null);
