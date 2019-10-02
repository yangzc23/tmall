/*
Navicat MySQL Data Transfer

Source Server         : mysql_local
Source Server Version : 50721
Source Host           : 127.0.0.1:3306
Source Database       : tmall

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-10-02 09:41:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item` (
  `id` int(11) NOT NULL,
  `order_id` varchar(50) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  `quality` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `t_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`),
  CONSTRAINT `t_item_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` varchar(50) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `total_amount` float(10,2) DEFAULT NULL,
  `actual_total_amount` float(10,2) DEFAULT NULL,
  `discount_by_credit` float(10,2) DEFAULT NULL,
  `payment_gateway` int(11) DEFAULT NULL,
  `payment_status` int(11) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `use_credit` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_product
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `price` float(10,2) DEFAULT NULL,
  `exchange_credit` int(11) DEFAULT NULL,
  `exchange_count_limit` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `exchange_flag` tinyint(1) DEFAULT NULL,
  `img_url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('8001', '天猫魔盒', '189.00', '99', '1', '500000', '1', 'images/tmmh.png');
INSERT INTO `t_product` VALUES ('8002', '明星同款太阳镜', '300.00', null, null, '50', '0', 'images/mxtktyj.png');
INSERT INTO `t_product` VALUES ('8003', 'tp-link路由器', '100.00', null, null, '60', '0', 'images/tplink.png');
INSERT INTO `t_product` VALUES ('8004', '云南白药牙膏', '10.00', null, null, '70', '0', 'images/ynbyyg.png');
INSERT INTO `t_product` VALUES ('8005', '康师傅红烧方便面', '5.00', null, null, '80', '0', 'images/ksfhsnrm.png');
INSERT INTO `t_product` VALUES ('8006', '小米音箱', '200.00', null, null, '90', '0', 'images/xiaomiaiyx.png');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1001', 'test', '123456', '60');
INSERT INTO `t_user` VALUES ('1002', 'scott', '123456', '200');
