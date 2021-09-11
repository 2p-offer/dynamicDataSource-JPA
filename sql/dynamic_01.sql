/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50732
Source Host           : localhost:3306
Source Database       : dynamic_01

Target Server Type    : MYSQL
Target Server Version : 50732
File Encoding         : 65001

Date: 2021-09-11 19:11:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for db_info
-- ----------------------------
DROP TABLE IF EXISTS `db_info`;
CREATE TABLE `db_info` (
  `id` int(11) NOT NULL COMMENT 'DBId',
  `write_host` varchar(255) DEFAULT '',
  `write_port` int(11) DEFAULT NULL,
  `read_host` varchar(255) DEFAULT NULL COMMENT '数据库IP',
  `read_port` int(11) DEFAULT NULL,
  `entry_id` int(11) DEFAULT NULL COMMENT 'API服编号，0表示不读取',
  `log_id` int(11) DEFAULT '0' COMMENT '日志数据库信息id',
  `chat_id` int(11) DEFAULT NULL COMMENT '聊天数据库信息id',
  `game_db_name` varchar(50) DEFAULT NULL COMMENT '数据库名',
  `write_user_name` varchar(50) DEFAULT NULL COMMENT '数据库用户名',
  `write_user_pwd` varchar(100) DEFAULT NULL COMMENT '数据库密码',
  `read_user_name` varchar(255) DEFAULT NULL,
  `read_user_pwd` varchar(255) DEFAULT NULL,
  `version` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `enabled` int(11) NOT NULL DEFAULT '1',
  `distribute_isread` int(11) NOT NULL COMMENT '验证中心是否会读本库',
  `chatreport_isread` int(11) NOT NULL COMMENT '聊天举报功能是否读本库',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of db_info
-- ----------------------------
INSERT INTO `db_info` VALUES ('1', 'devthd.accessgames.com', '3306', 'localhost', '3306', '1', '102030', '0', 'game_00', 'root', 'otaku@com', 'root', 'root', '2019-07-24 08:07:11', '1', '0', '0');
INSERT INTO `db_info` VALUES ('2', 'devthd.accessgames.com', '3306', 'localhost', '3306', '1', '102030', '0', 'game_01', 'root', 'otaku@com', 'root', 'root', '2019-07-24 08:07:11', '1', '0', '0');
INSERT INTO `db_info` VALUES ('3', 'devthd.accessgames.com', '3306', 'devthd.accessgames.com', '3306', '2', '102030', '0', 'game_00', 'root', 'otaku@com', 'root', 'otaku@com', '2019-07-24 08:07:11', '1', '0', '0');
INSERT INTO `db_info` VALUES ('4', 'devthd.accessgames.com', '3306', 'devthd.accessgames.com', '3306', '2', '102030', '0', 'game_01', 'root', 'otaku@com', 'root', 'otaku@com', '2019-07-24 08:07:11', '1', '0', '0');

-- ----------------------------
-- Table structure for server_info
-- ----------------------------
DROP TABLE IF EXISTS `server_info`;
CREATE TABLE `server_info` (
  `server_id` int(11) NOT NULL,
  `server_version` int(11) DEFAULT NULL COMMENT '服务器代码版本号',
  `can_compress` int(11) DEFAULT '0' COMMENT '是否支持客户端包压缩',
  `area_id` int(11) DEFAULT NULL,
  `min_client_version` int(11) DEFAULT '0' COMMENT '兼容最小客户端版本号(版本号*100)',
  `max_client_version` int(11) DEFAULT '999999' COMMENT '兼容最大客户端版本号(版本号*100)',
  `server_ip` varchar(50) DEFAULT NULL,
  `server_tcp_port` int(11) DEFAULT NULL,
  `server_rmi_port` int(11) DEFAULT NULL,
  `server_http_port` int(11) DEFAULT NULL,
  `url_contain_port` int(10) DEFAULT '0' COMMENT '1=域名中已经包含端口号,其他值=未包含端口(目前仅用于客户端判断是否增加port)',
  `sftpu_name` varchar(255) DEFAULT NULL,
  `sftpu_password` varchar(255) DEFAULT NULL,
  `sftp_port` int(255) DEFAULT NULL,
  `log_dir_path` varchar(255) DEFAULT NULL,
  `server_type` int(255) DEFAULT '1' COMMENT '服务器类型：1 游戏服；2 战斗服；3 聊天服；4 API服；5 GM服; 6 战斗验证服',
  `chat_id` int(255) DEFAULT '0' COMMENT '聊天服务器id= 非游戏服务器就填0',
  `version` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `lan_ip` varchar(255) DEFAULT NULL COMMENT '内网IP',
  `id` varchar(36) NOT NULL,
  `default_entry` int(10) DEFAULT '0' COMMENT '非选服状态下0=非默认进入1=默认可进入，存在多个默认可进入时随机进入一个',
  `create_date_time` datetime DEFAULT NULL,
  `deleted` int(11) DEFAULT NULL,
  `update_date_time` datetime DEFAULT NULL,
  `default_gm_reqeust` int(1) DEFAULT '0' COMMENT 'gm 默认请求的Server(配置)，每个类型必须且只有一个 1。 此字段目前只有gm使用',
  `is_dev` int(1) DEFAULT '0' COMMENT '值为 1表示是测试服  Gm刷新服务功能开关集合的时候， 只会刷新测试服',
  PRIMARY KEY (`server_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of server_info
-- ----------------------------
INSERT INTO `server_info` VALUES ('1', '1711171730', '1', '1', '0', '999999', 'l1-dev-all-thrud-gs.bilibiligame.net', '11001', '30002', '11003', '1', 'dazhanguo', 'otaku@com', '22', '/data/thrud/Logs/1', '1', '70000', '2021-07-22 16:37:47', '10.9.147.191', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '1', '0');
INSERT INTO `server_info` VALUES ('2', '1711171730', '1', '2', '0', '999999', '10.22.134.87', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '1', '70001', '2021-08-23 18:36:06', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('3', '1711171730', '1', '1', '0', '999999', 'devthd.accessgames.com', '11001', '30002', '11003', '0', 'dazhanguo', 'otaku@com', '22', '/data/thrud/Logs/1', '1', '70000', '2021-02-24 10:33:46', '10.9.147.191', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('5', '1711171730', '1', '5', '0', '999999', '10.22.134.61', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '1', '70001', '2021-07-28 10:51:45', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('14000', '1711171730', '1', '14000', '0', '999999', '10.1.1.102', '10001', '10002', '10003', '0', 'dazhaoguo', 'otaku@com', '22', 'E:/Log', '1', '0', '2020-06-06 10:18:46', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('15000', '1711171730', '1', '15000', '0', '999999', '10.1.1.188', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', '/data/log/thrud/gs', '1', '15000', '2020-06-06 07:55:49', '10.1.1.108', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('15001', '1711171730', '1', '15000', '0', '999999', '10.1.1.188', '30004', '0', '30008', '0', 'dazhanguo', 'otaku@com', '22', '/data/log/thrud/chat', '3', '0', '2020-06-06 07:55:52', '10.1.1.108', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('16000', '1711171730', '1', '16000', '0', '999999', '10.1.1.139', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log/thrud', '1', '0', '2020-04-02 06:38:26', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('17000', '1711171730', '1', '17000', '0', '999999', '10.22.134.90', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log/thrud/', '1', '17001', '2021-07-22 18:38:31', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('17001', '1711171730', '1', '17001', '0', '999999', '10.22.134.90', '30004', '0', '30008', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log/thrud/', '3', '17001', '2021-07-22 18:38:33', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('18000', '1711171730', '1', '18000', '0', '999999', 'l3-prod-all-gs-thrud.bilibiligame.net', '11001', '30002', '11003', '1', 'dazhanguo', 'otaku@com', '22', '/data/thrud/Logs/1', '1', '70002', '2021-07-21 20:39:03', '10.9.147.191', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('19000', '1711171730', '1', '19000', '0', '999999', '10.22.135.68', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '1', '70001', '2021-07-31 16:24:46', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('20000', '1711171730', '1', '20000', '0', '999999', '10.22.133.14', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '1', '70001', '2021-07-31 16:24:46', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('21000', '1711171730', '1', '21000', '0', '999999', '10.22.132.58', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '1', '21001', '2021-09-08 15:08:19', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('21001', '1711171730', '1', '21001', '0', '999999', '10.22.132.58', '30011', '30012', '30013', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '3', '70001', '2021-09-07 18:50:24', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('22000', '1711171730', '1', '22000', '0', '999999', '10.22.132.101', '30001', '30002', '30003', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '1', '70001', '2021-09-01 16:00:20', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('70000', '1711171730', '1', '70000', '0', '999999', 'devthd.accessgames.com', '27000', '0', '27010', '0', 'dazhanguo', 'otaku@com', '22', '/data/thrud/Logs/70000', '3', '70000', '2021-06-23 18:11:37', '10.9.147.191', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '1');
INSERT INTO `server_info` VALUES ('70001', '1711171730', '1', '70001', '0', '999999', '10.22.134.41', '30004', '0', '30008', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '3', '0', '2021-03-01 14:12:55', '10.9.63.89', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('70002', '1711171730', '1', '70002', '0', '999999', '81.69.155.94', '50000', '0', '27010', '0', 'dazhanguo', 'otaku@com', '22', '/data/thrud/Logs/70002', '3', '70002', '2021-07-22 15:24:16', '10.9.147.191', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '1');
INSERT INTO `server_info` VALUES ('80000', '1711171730', '1', '80000', '0', '999999', 'devthd.accessgames.com', '0', '0', '8005', '0', 'dazhanguo', 'otaku@com', '22', '/data/logs/9090', '4', '0', '2021-06-23 18:11:31', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '1', '1');
INSERT INTO `server_info` VALUES ('80001', '1711171730', '1', '80001', '0', '999999', 'devthd.accessgames.com', '0', '0', '9090', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '4', '0', '2021-02-24 10:33:53', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
INSERT INTO `server_info` VALUES ('90000', '1711171730', '1', '90000', '0', '999999', '10.22.134.69', '0', '0', '8080', '0', 'dazhanguo', 'otaku@com', '22', 'E:/Log', '4', '0', '2021-08-14 17:15:14', '', '', null, '2021-08-30 11:01:41', null, '2021-08-30 11:01:41', '0', '0');
