/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : game_00

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-09-11 19:13:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for name_00
-- ----------------------------
DROP TABLE IF EXISTS `name_00`;
CREATE TABLE `name_00` (
  `uid` int(11) NOT NULL COMMENT '主键用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of name_00
-- ----------------------------
INSERT INTO `name_00` VALUES ('0', '0', '0', '2021-08-31 11:02:17');

-- ----------------------------
-- Table structure for name_02
-- ----------------------------
DROP TABLE IF EXISTS `name_02`;
CREATE TABLE `name_02` (
  `uid` int(11) NOT NULL COMMENT '主键用户id',
  `name` varchar(255) DEFAULT NULL COMMENT '名字',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of name_02
-- ----------------------------
INSERT INTO `name_02` VALUES ('2', '2', '2', '2021-08-31 11:02:17');
