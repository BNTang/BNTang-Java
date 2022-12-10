/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.18.88
 Source Server Type    : MySQL
 Source Server Version : 50739 (5.7.39-log)
 Source Host           : 192.168.18.88:3306
 Source Schema         : mybatisplus

 Target Server Type    : MySQL
 Target Server Version : 50739 (5.7.39-log)
 File Encoding         : 65001

 Date: 10/12/2022 21:51:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user_enum
-- ----------------------------
DROP TABLE IF EXISTS `user_enum`;
CREATE TABLE `user_enum`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NULL DEFAULT NULL COMMENT '邮箱',
  `grade` int(2) NULL DEFAULT NULL COMMENT '年级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_german2_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_enum
-- ----------------------------
INSERT INTO `user_enum` VALUES (1, 'test', 19, 'test', NULL);
INSERT INTO `user_enum` VALUES (2, 'Jack', 20, 'test2@baomidou.com', NULL);
INSERT INTO `user_enum` VALUES (3, 'Tom', 28, 'test3@baomidou.com', NULL);
INSERT INTO `user_enum` VALUES (4, 'Sandy', 21, 'test4@baomidou.com', NULL);
INSERT INTO `user_enum` VALUES (5, 'Billie', 24, 'test5@baomidou.com', NULL);

SET FOREIGN_KEY_CHECKS = 1;
