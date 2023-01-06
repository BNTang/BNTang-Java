CREATE TABLE `t_user`
(
    `USER_ID`         bigint(20)                                              NOT NULL AUTO_INCREMENT COMMENT '用户ID',
    `USERNAME`        varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL COMMENT '用户名',
    `PASSWORD`        varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
    `DEPT_ID`         bigint(20)                                              NULL DEFAULT NULL COMMENT '部门ID',
    `EMAIL`           varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
    `MOBILE`          varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '联系电话',
    `STATUS`          char(1) CHARACTER SET utf8 COLLATE utf8_general_ci      NOT NULL COMMENT '状态 0锁定 1有效',
    `CREATE_TIME`     datetime(0)                                             NOT NULL COMMENT '创建时间',
    `MODIFY_TIME`     datetime(0)                                             NULL DEFAULT NULL COMMENT '修改时间',
    `LAST_LOGIN_TIME` datetime(0)                                             NULL DEFAULT NULL COMMENT '最近访问时间',
    `SSEX`            char(1) CHARACTER SET utf8 COLLATE utf8_general_ci      NULL DEFAULT NULL COMMENT '性别 0男 1女 2保密',
    `AVATAR`          varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
    `DESCRIPTION`     varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  CHARACTER SET = utf8
  COLLATE = utf8_general_ci COMMENT = '用户表'
  ROW_FORMAT = Dynamic;

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