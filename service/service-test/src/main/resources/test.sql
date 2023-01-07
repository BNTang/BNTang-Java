CREATE TABLE `t_user`  (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `USERNAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `DEPT_ID` bigint(20) NULL DEFAULT NULL COMMENT '部门ID',
  `EMAIL` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `MOBILE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `STATUS` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态 0锁定 1有效',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `LAST_LOGIN_TIME` datetime(0) NULL DEFAULT NULL COMMENT '最近访问时间',
  `SSEX` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
  `AVATAR` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `DESCRIPTION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

INSERT INTO `t_user`
VALUES (1, 'BNTang', '$2a$10$gzhiUb1ldc1Rf3lka4k/WOoFKKGPepHSzJxzcPSN5/65SzkMdc.SK', 1, '303158131@qq.com',
        '17788888888', '1', '2019-06-14 20:39:22', '2019-07-19 10:18:36', '2019-08-02 15:57:00', '0', 'default.jpg',
        '我是帅比作者。');

CREATE TABLE `t_role`
(
    `ROLE_ID`     bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '角色ID',
    `ROLE_NAME`   varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '角色名称',
    `REMARK`      varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
    `CREATE_TIME` datetime(0)                                             NOT NULL COMMENT '创建时间',
    `MODIFY_TIME` datetime(0)                                             NULL DEFAULT NULL COMMENT '修改时间',
    PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '角色表'
  ROW_FORMAT = Dynamic;

INSERT INTO `t_role`
VALUES (1, '管理员', '管理员', '2019-08-08 16:23:11', '2019-08-09 14:38:59');

CREATE TABLE `t_menu`  (
  `MENU_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '菜单/按钮ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级菜单ID',
  `MENU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单/按钮名称',
  `PATH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应路由path',
  `COMPONENT` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '对应路由组件component',
  `PERMS` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `TYPE` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类型 0菜单 1按钮',
  `ORDER_NUM` double(20, 0) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime(0) NOT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

INSERT INTO `t_menu` VALUES (1, 0, '系统管理', '/system', 'Layout', NULL, 'el-icon-set-up', '0', 1, '2017-12-27 16:39:07', '2019-07-20 16:19:04');
INSERT INTO `t_menu` VALUES (2, 1, '用户管理', '/system/user', 'bntang/system/user/Index', 'user:view', '', '0', 1, '2017-12-27 16:47:13', '2019-01-22 06:45:55');
INSERT INTO `t_menu` VALUES (3, 2, '新增用户', '', '', 'user:add', NULL, '1', NULL, '2017-12-27 17:02:58', NULL);
INSERT INTO `t_menu` VALUES (4, 2, '修改用户', '', '', 'user:update', NULL, '1', NULL, '2017-12-27 17:04:07', NULL);
INSERT INTO `t_menu` VALUES (5, 2, '删除用户', '', '', 'user:delete', NULL, '1', NULL, '2017-12-27 17:04:58', NULL);

CREATE TABLE `t_user_role`  (
  `USER_ID` bigint(20) NOT NULL COMMENT '用户ID',
  `ROLE_ID` bigint(20) NOT NULL COMMENT '角色ID'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

INSERT INTO `t_user_role` VALUES (1, 1);

CREATE TABLE `t_role_menu`  (
  `ROLE_ID` bigint(20) NOT NULL,
  `MENU_ID` bigint(20) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色菜单关联表' ROW_FORMAT = Dynamic;

INSERT INTO `t_role_menu` VALUES (1, 1);
INSERT INTO `t_role_menu` VALUES (1, 2);
INSERT INTO `t_role_menu` VALUES (1, 3);
INSERT INTO `t_role_menu` VALUES (1, 4);
INSERT INTO `t_role_menu` VALUES (1, 5);

CREATE TABLE `t_dept`  (
  `DEPT_ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `PARENT_ID` bigint(20) NOT NULL COMMENT '上级部门ID',
  `DEPT_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门名称',
  `ORDER_NUM` double(20, 0) NULL DEFAULT NULL COMMENT '排序',
  `CREATE_TIME` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `MODIFY_TIME` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`DEPT_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

INSERT INTO `t_dept` VALUES (1, 0, '开发部', 1, '2018-01-04 15:42:26', '2019-01-05 21:08:27');