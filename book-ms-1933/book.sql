/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : class1

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2020-11-10 14:40:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', '水浒传', '施耐庵', '99');
INSERT INTO `book` VALUES ('3', '西游记', '吴承恩', '99');
INSERT INTO `book` VALUES ('4', '红楼梦', '曹雪芹', '99');
INSERT INTO `book` VALUES ('7', '三国演义', '罗贯中', '120');
INSERT INTO `book` VALUES ('12', 'Spring框架基础', 'James', '65');
INSERT INTO `book` VALUES ('14', 'mysql高级技术', 'tom', '22');
INSERT INTO `book` VALUES ('15', 'Vue从入门到精通', '忘记了', '66');
INSERT INTO `book` VALUES ('17', 'Sql Server', '忘记了', '33');
