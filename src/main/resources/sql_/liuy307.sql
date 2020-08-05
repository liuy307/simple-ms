/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 50515
 Source Host           : localhost:3306
 Source Schema         : liuy307

 Target Server Type    : MySQL
 Target Server Version : 50515
 File Encoding         : 65001

 Date: 05/08/2020 18:24:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `path` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `parent_menu_id` int(32) DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `menu_name`(`menu_name`) USING BTREE COMMENT '菜单名不能重复'
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '系统管理', '/system', NULL, -1);
INSERT INTO `menu` VALUES (2, '业务管理', '/service', NULL, -1);
INSERT INTO `menu` VALUES (3, '人员管理', '/system/user', NULL, 1);
INSERT INTO `menu` VALUES (4, '角色管理', '/system/role', NULL, 1);
INSERT INTO `menu` VALUES (5, '菜单管理', '/system/menu', NULL, 1);
INSERT INTO `menu` VALUES (6, '业务1', '/service/s1', NULL, 2);
INSERT INTO `menu` VALUES (7, '业务2', '/service/s2', NULL, 2);
INSERT INTO `menu` VALUES (8, '业务1-1', '/service/s1/c1', NULL, 6);
INSERT INTO `menu` VALUES (9, '业务1-2', '/service/s1/c2', NULL, 6);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 'user:add', NULL);
INSERT INTO `permission` VALUES (2, 'user:delete', NULL);
INSERT INTO `permission` VALUES (3, 'user:update', NULL);
INSERT INTO `permission` VALUES (4, 'user:view', NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `role_name`(`role_name`) USING BTREE COMMENT '角色名不能重复'
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '超级管理员', 'sss');
INSERT INTO `role` VALUES (2, '管理员', 'ss');
INSERT INTO `role` VALUES (3, '普通用户', 's');
INSERT INTO `role` VALUES (4, '测试用户1', 'a');
INSERT INTO `role` VALUES (5, '测试用户2', 'b');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `role_id` int(32) DEFAULT NULL,
  `menu_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (1, 1, 1);
INSERT INTO `role_menu` VALUES (2, 1, 2);
INSERT INTO `role_menu` VALUES (3, 1, 3);
INSERT INTO `role_menu` VALUES (4, 1, 4);
INSERT INTO `role_menu` VALUES (5, 1, 5);
INSERT INTO `role_menu` VALUES (6, 1, 6);
INSERT INTO `role_menu` VALUES (7, 1, 7);
INSERT INTO `role_menu` VALUES (8, 2, 2);
INSERT INTO `role_menu` VALUES (9, 2, 6);
INSERT INTO `role_menu` VALUES (10, 2, 7);
INSERT INTO `role_menu` VALUES (12, 3, 7);
INSERT INTO `role_menu` VALUES (13, 4, 1);
INSERT INTO `role_menu` VALUES (14, 4, 2);
INSERT INTO `role_menu` VALUES (15, 4, 3);
INSERT INTO `role_menu` VALUES (16, 5, 3);
INSERT INTO `role_menu` VALUES (17, 5, 4);

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `role_id` int(32) DEFAULT NULL,
  `permission_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (1, 1, 1);
INSERT INTO `role_permission` VALUES (2, 1, 2);
INSERT INTO `role_permission` VALUES (3, 1, 3);
INSERT INTO `role_permission` VALUES (4, 1, 4);
INSERT INTO `role_permission` VALUES (5, 2, 1);
INSERT INTO `role_permission` VALUES (6, 2, 3);
INSERT INTO `role_permission` VALUES (7, 2, 4);
INSERT INTO `role_permission` VALUES (8, 3, 4);
INSERT INTO `role_permission` VALUES (13, 4, 1);
INSERT INTO `role_permission` VALUES (14, 4, 2);
INSERT INTO `role_permission` VALUES (15, 5, 3);
INSERT INTO `role_permission` VALUES (16, 5, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `description` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `account` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '刘勇', '最高权限', 'root', 'admin');
INSERT INTO `user` VALUES (2, 'leo', '次级权限', 'aaa', '123');
INSERT INTO `user` VALUES (3, 'lisa', '普通权限', '是否', '是否');
INSERT INTO `user` VALUES (16, '测试人员', '两种角色', '111', '111');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `user_id` int(32) DEFAULT NULL,
  `role_id` int(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);
INSERT INTO `user_role` VALUES (2, 1, 2);
INSERT INTO `user_role` VALUES (3, 1, 3);
INSERT INTO `user_role` VALUES (4, 2, 2);
INSERT INTO `user_role` VALUES (5, 2, 3);
INSERT INTO `user_role` VALUES (6, 3, 3);
INSERT INTO `user_role` VALUES (7, 16, 4);
INSERT INTO `user_role` VALUES (8, 16, 5);

SET FOREIGN_KEY_CHECKS = 1;
