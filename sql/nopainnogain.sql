/*
Navicat MySQL Data Transfer

Source Server         : localhost_shijing
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : nopainnogain

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-11-08 10:09:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for system_config
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `sname` varchar(50) NOT NULL COMMENT '配置名称',
  `scode` varchar(50) NOT NULL COMMENT '配置编码',
  `sstatus` varchar(225) NOT NULL COMMENT '状态',
  `sdescribe` varchar(225) DEFAULT NULL COMMENT '配置描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COMMENT='系统配置表';

-- ----------------------------
-- Records of system_config
-- ----------------------------
INSERT INTO `system_config` VALUES ('1', '是否进行验证码校验', 'checkcode', '1', '0是不校验，1是校验');
INSERT INTO `system_config` VALUES ('2', '是否使用手机号注册登录', 'registerByMobileEnabled', '0', '0不使用，1使用');
INSERT INTO `system_config` VALUES ('3', '服务器地址', 'emailHost', 'smtp.163.com', 'smtp.qq.com;smtp.sina.com;smtp.163.com');
INSERT INTO `system_config` VALUES ('4', '配置邮箱名', 'email_userName', 'zhouyy0919@163.com', '邮箱名');
INSERT INTO `system_config` VALUES ('5', '配置邮箱密码', 'email_password', 'zhouyyyx8', '邮箱密码');
INSERT INTO `system_config` VALUES ('9', '版本号', 'version', 'v1.0.3.4', '');
INSERT INTO `system_config` VALUES ('30', 'ServiceA', 'service', 'A', '');
INSERT INTO `system_config` VALUES ('31', 'ServiceB', 'service', 'B', '');
INSERT INTO `system_config` VALUES ('32', 'ServiceA', 'service', 'A', '');
INSERT INTO `system_config` VALUES ('33', 'ServiceB', 'service', 'B', '');
