/*
 Navicat Premium Data Transfer

 Source Server         : mysql8-local
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : owep-dev-base1

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 24/01/2024 14:01:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_action
-- ----------------------------
DROP TABLE IF EXISTS `t_action`;
CREATE TABLE `t_action`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `action_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行为名',
  `action_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行描述',
  `action_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行为url',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本呢',
  `action_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '行为代号',
  `action_value` int(11) NULL DEFAULT NULL COMMENT '行为值，将来可以通过二进制来拆分',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '行为表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_action
-- ----------------------------
INSERT INTO `t_action` VALUES (21, '查询', '只读', NULL, '2020-10-28 09:28:23', NULL, 1, 'Re', NULL);
INSERT INTO `t_action` VALUES (22, '添加', '新增条目', NULL, '2020-10-28 09:28:38', NULL, 1, 'Ad', NULL);
INSERT INTO `t_action` VALUES (23, '修改', '改变原有', NULL, '2020-10-28 09:28:52', NULL, 1, 'Ed', NULL);
INSERT INTO `t_action` VALUES (24, '删除', '删减条目', NULL, '2020-10-28 09:29:05', NULL, 1, 'Dd', NULL);
INSERT INTO `t_action` VALUES (25, '导入', '导入excel模板文件', NULL, '2020-11-24 15:29:06', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (26, '导出', '导出excel模板文件', NULL, '2020-11-24 15:29:22', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (27, '分配用户组', '为平台用户分配用户所在的组', NULL, '2020-11-24 15:29:54', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (28, '修改状态', '修改数据的状态', NULL, '2020-11-24 15:30:33', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (29, '分配班级', '为学员 / 用户 分配所在的班级', NULL, '2020-11-24 15:30:59', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (30, '分配角色', '权限管理中给用户分配角色', NULL, '2020-11-24 15:31:46', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (31, '分配权限', '在权限管理中，为角色分配权限', NULL, '2020-11-24 15:32:19', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (32, '分配菜单', '在权限管理中，为角色分配菜单', NULL, '2020-11-24 15:32:45', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (33, '分配行为', '在权限管理，为菜单分配具体的操作行为', NULL, '2020-11-24 15:33:35', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (34, '视频上传', '视频管理中，上传视频的权限', NULL, '2020-11-24 15:44:24', NULL, 1, NULL, NULL);
INSERT INTO `t_action` VALUES (35, '设置方案', '添加方案和设置方案', NULL, '2020-11-24 15:45:32', NULL, 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_advice
-- ----------------------------
DROP TABLE IF EXISTS `t_advice`;
CREATE TABLE `t_advice`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `email` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '目标EMAIL',
  `advice_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议内容',
  `suggest_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '建议人',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '建议时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '反馈建议表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_advice
-- ----------------------------
INSERT INTO `t_advice` VALUES (1, '165555@dnfjkd.com', '整体样式还有待完善', 'GG', '2020-07-08 14:47:44', '2020-07-09 14:47:37', 1);
INSERT INTO `t_advice` VALUES (4, '68350680@ofgjk.com', '这个好约课的app做的不错', '秦始皇', '2020-07-09 09:49:48', '2020-07-09 09:49:48', 1);
INSERT INTO `t_advice` VALUES (5, '13487@gg.com', '不知道真正使用起来怎么样', '汉武帝', '2020-07-09 09:49:50', '2020-07-09 09:49:50', 1);
INSERT INTO `t_advice` VALUES (6, 'huizong@huicong.com', 'app名好听。。。', '唐太宗', '2020-07-09 09:49:50', '2020-07-09 09:49:50', 1);
INSERT INTO `t_advice` VALUES (7, '9853045@jir.com', '总体来说用户体验还可以接受，望再接再厉。。。', '明太祖', '2020-07-09 09:49:50', '2020-07-09 09:49:50', 1);
INSERT INTO `t_advice` VALUES (8, 'sss@ofgjk.com', '许多页面不能直接找到，只能按图索骥一步步点击去。。。', '明成祖', '2020-07-09 09:49:50', '2020-07-09 09:49:50', 1);
INSERT INTO `t_advice` VALUES (9, '68350680@ofgjk.com', '这个好约课的app做的不错', '秦始皇', '2020-07-10 15:57:47', NULL, 1);
INSERT INTO `t_advice` VALUES (10, 'sss@ofgjk.com', '许多页面不能直接找到，只能按图索骥一步步点击去。。。', '明成祖', '2020-07-10 15:57:47', '2020-07-10 15:59:24', 2);
INSERT INTO `t_advice` VALUES (11, 'huizong@huicong.com', 'app名好听。。。', '唐太宗', '2020-07-10 15:57:47', NULL, 1);
INSERT INTO `t_advice` VALUES (12, '9853045@jir.com', '总体来说用户体验还可以接受，望再接再厉。。。', '明太祖', '2020-07-10 15:57:48', NULL, 1);
INSERT INTO `t_advice` VALUES (13, 'sss@ofgjk.com', '许多页面不能直接找到，只能按图索骥一步步点击去。。。', '明成祖', '2020-07-10 15:57:48', NULL, 1);

-- ----------------------------
-- Table structure for t_assign_record
-- ----------------------------
DROP TABLE IF EXISTS `t_assign_record`;
CREATE TABLE `t_assign_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fk_from_user_id` int(11) NOT NULL COMMENT '外键，从哪个咨询师转出',
  `fk_to_user_id` int(11) NULL DEFAULT NULL COMMENT '外键，转到目标咨询师',
  `fk_client_id` int(11) NULL DEFAULT NULL COMMENT '外键，哪个意向客户',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '转出事由',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_clientuser_client`(`fk_client_id`) USING BTREE,
  CONSTRAINT `fk_clientuser_client` FOREIGN KEY (`fk_client_id`) REFERENCES `t_client` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '意向客户分配记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_assign_record
-- ----------------------------
INSERT INTO `t_assign_record` VALUES (5, 1, 2, 2, '2020-07-08 21:46:35', '打王者没有时间', '2020-07-10 18:40:14', 2);
INSERT INTO `t_assign_record` VALUES (6, 1, 2, 2, '2020-07-08 21:46:42', '特殊原因', '2020-07-08 21:46:42', 1);
INSERT INTO `t_assign_record` VALUES (7, 1, 2, 2, '2020-07-08 21:46:51', '特殊原因', '2020-07-08 21:46:51', 1);
INSERT INTO `t_assign_record` VALUES (8, 1, 2, 2, '2020-07-10 18:40:03', '特殊原因', '2020-07-10 18:40:03', 1);
INSERT INTO `t_assign_record` VALUES (9, 2, 1, 1, '2020-07-15 15:39:50', '打王者没有时间', '2020-07-15 15:39:50', 1);
INSERT INTO `t_assign_record` VALUES (10, 2, 1, 2, '2020-07-15 15:39:50', '打王者没有时间', '2020-07-15 15:39:50', 1);
INSERT INTO `t_assign_record` VALUES (11, 2, 1, 4, '2020-07-15 15:39:50', '打王者没有时间', '2020-07-15 15:39:50', 1);

-- ----------------------------
-- Table structure for t_branch_institute
-- ----------------------------
DROP TABLE IF EXISTS `t_branch_institute`;
CREATE TABLE `t_branch_institute`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `branch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分支名称',
  `fk_org_id` int(11) NULL DEFAULT NULL COMMENT '外键，指向T_ORG_INSTITUTE表的ID',
  `version` int(3) NOT NULL COMMENT '版本号',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NOT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_branch_institute_org_id`(`fk_org_id`) USING BTREE,
  CONSTRAINT `fk_branch_institute_org_id` FOREIGN KEY (`fk_org_id`) REFERENCES `t_org_institute` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分支机构表，与 组织机构是多对一' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_branch_institute
-- ----------------------------
INSERT INTO `t_branch_institute` VALUES (4, '苏州分中心', 1, 1, '2020-07-10 16:07:44', '2020-07-10 16:07:44');
INSERT INTO `t_branch_institute` VALUES (5, '上海分中心', 1, 3, '2020-07-13 09:04:50', '2020-07-14 14:04:25');
INSERT INTO `t_branch_institute` VALUES (6, '计算机学院', 2, 1, '2020-07-13 09:36:11', '2020-07-13 09:36:11');
INSERT INTO `t_branch_institute` VALUES (7, '电子信息学院', 2, 1, '2020-07-14 14:03:34', '2020-07-14 14:03:34');
INSERT INTO `t_branch_institute` VALUES (8, '物联网学院', 8, 1, '2024-01-24 11:47:09', '2024-01-24 11:47:25');

-- ----------------------------
-- Table structure for t_channel
-- ----------------------------
DROP TABLE IF EXISTS `t_channel`;
CREATE TABLE `t_channel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `channel_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道名称',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `fk_channeltype_id` int(255) NOT NULL COMMENT '外键，渠道类型ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_channel_channeltype`(`fk_channeltype_id`) USING BTREE,
  CONSTRAINT `fk_channel_channeltype` FOREIGN KEY (`fk_channeltype_id`) REFERENCES `t_channel_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '渠道表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_channel
-- ----------------------------
INSERT INTO `t_channel` VALUES (1, '英雄联盟', '2020-07-08 21:55:36', 2, '2020-07-10 18:41:11', 1);
INSERT INTO `t_channel` VALUES (2, '品质联盟', '2020-07-08 21:53:09', 1, '2020-07-08 21:53:09', 1);

-- ----------------------------
-- Table structure for t_channel_type
-- ----------------------------
DROP TABLE IF EXISTS `t_channel_type`;
CREATE TABLE `t_channel_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '渠道类型自增id',
  `channel_type_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道类型名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` datetime(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '渠道类型表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_channel_type
-- ----------------------------
INSERT INTO `t_channel_type` VALUES (1, '招聘网站', '2020-07-09 16:24:00', 1, '2020-07-09 16:24:00');
INSERT INTO `t_channel_type` VALUES (2, '学校', '2020-07-09 09:32:08', 1, '2020-07-09 09:32:08');
INSERT INTO `t_channel_type` VALUES (3, '企业', '2020-07-09 09:34:54', 2, '2020-07-10 18:41:53');
INSERT INTO `t_channel_type` VALUES (4, '其他', '2020-07-09 09:33:33', 1, '2020-07-09 09:33:33');

-- ----------------------------
-- Table structure for t_chapter
-- ----------------------------
DROP TABLE IF EXISTS `t_chapter`;
CREATE TABLE `t_chapter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '章id',
  `chapter_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '章编号',
  `chapter_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '章名称',
  `chapter_image_url` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章图片名称',
  `chapter_status` int(1) NOT NULL COMMENT '章状态：1启用、2未启用',
  `chapter_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章描述',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `video_status` int(1) NULL DEFAULT NULL COMMENT '视频观看状态：1允许观看、2不允许观看',
  `fk_course_id` int(11) NOT NULL COMMENT '课程编号',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除：1未删除、0 已删除',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问一次时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_chapter_course`(`fk_course_id`) USING BTREE,
  CONSTRAINT `fk_chapter_course` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程列表中的章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_chapter
-- ----------------------------
INSERT INTO `t_chapter` VALUES (1, '1', 'oracle基础知识', 'https/b409.jpg', 1, 'oracle基础知识', '2020-07-08 19:04:59', 1, 1, 1, NULL, '2020-07-10 18:46:40');
INSERT INTO `t_chapter` VALUES (2, '1', 'oracle基础知识', 'https://sedn9.jpg', 1, 'oracle基础知识', '2020-07-10 18:46:19', 1, 1, 1, 1, NULL);
INSERT INTO `t_chapter` VALUES (3, '1', '123', NULL, 1, '123', '2020-11-30 13:58:00', NULL, 1, NULL, 1, NULL);
INSERT INTO `t_chapter` VALUES (4, '1', '99', NULL, 1, '45', '2020-11-30 14:01:59', NULL, 1, 0, 2, '2020-11-30 14:55:33');
INSERT INTO `t_chapter` VALUES (5, '89', '89', NULL, 1, '89', '2020-11-30 15:21:12', NULL, 1, 0, 1, NULL);
INSERT INTO `t_chapter` VALUES (6, '99', '99', NULL, 1, '99', '2020-11-30 15:21:33', NULL, 1, 1, 1, NULL);
INSERT INTO `t_chapter` VALUES (7, '1', '1', NULL, 1, '1', '2020-12-03 16:19:30', NULL, 5, 1, 1, NULL);
INSERT INTO `t_chapter` VALUES (8, '1', '22', NULL, 1, '1', '2020-12-03 16:20:19', NULL, 5, 1, 2, '2020-12-03 16:22:03');

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `class_number` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' 班级编号',
  `class_name` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级名称',
  `start_time` timestamp(0) NOT NULL COMMENT '开始日期',
  `end_time` timestamp(0) NOT NULL COMMENT '结束日期',
  `class_status` int(1) NOT NULL COMMENT ' 启用状态（1：启用 2：未启用）',
  `institute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属机构',
  `branch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属分支',
  `class_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 班级描述',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '老师名',
  `fk_profession_id` int(11) NOT NULL COMMENT '专业管理id',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '是否删除（1：未删除 0：已删除）',
  `version` int(3) NULL DEFAULT NULL COMMENT ' 版本号',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `old_class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旧的班级名',
  `old_class_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旧的班级编号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_class_profession_id`(`fk_profession_id`) USING BTREE,
  CONSTRAINT `fk_class_profession_id` FOREIGN KEY (`fk_profession_id`) REFERENCES `t_profession` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES (1, 'TEST20200708', ' 软件测试（1）期', '2020-07-08 00:00:00', '2020-07-09 00:00:00', 1, '三山教育集团', '苏州分中心', '班级描述信息', '刘drd', 1, 1, 15, NULL, '2020-12-04 09:14:42', 'updateClassName', 'JAVAEE20200708');
INSERT INTO `t_class` VALUES (2, 'JAVAEE20200709', '软件开发（1）期', '2020-07-10 00:00:00', '2020-07-10 00:00:00', 1, '三山教育集团', '苏州分中心', '班级描述信息', NULL, 2, 0, 3, '2020-07-10 17:18:37', '2020-07-16 14:46:20', 'updateClassName', 'JAVAEE20200709');
INSERT INTO `t_class` VALUES (3, 'JAVAEE20200709', '计算机（10）期', '2020-07-13 00:00:00', '2020-07-13 00:00:00', 1, '三山教育集团', ' 上海分中心', '班级描述信息', NULL, 3, 0, 1, '2020-07-13 13:57:54', '2020-07-16 14:46:19', NULL, NULL);
INSERT INTO `t_class` VALUES (4, 'JAVAEE20200709', '计算机（11）期', '2020-07-16 00:00:00', '2020-07-16 00:00:00', 1, '苏州大学', '计算机学院', '班级描述信息', NULL, 3, 0, 1, '2020-07-16 11:14:32', '2020-07-16 14:46:19', NULL, NULL);
INSERT INTO `t_class` VALUES (5, 'DZGC20200709', '电子工程（3）期', '2020-07-16 00:00:00', '2020-07-16 00:00:00', 1, '苏州大学', '计算机学院', '班级描述信息', 'sfaefwae', 4, 1, 13, '2020-07-16 14:47:27', '2020-12-03 09:08:32', 'java企业级开发', 'JAVAEE20200709');
INSERT INTO `t_class` VALUES (9, 'DZGC20201201', '电子工程（4）期', '2020-01-01 00:00:00', '2020-03-01 00:00:00', 1, '苏州大学', '电子信息学院', '班级描述信息', '生日', 4, 0, 1, '2020-12-01 10:59:54', '2020-12-01 11:19:29', NULL, NULL);
INSERT INTO `t_class` VALUES (10, 'DZGC20240102', '电子工程（5）期', '2020-06-01 00:00:00', '2020-07-09 00:00:00', 1, '苏州科技大学', '物联网学院', '班级描述信息', 'tggww', 4, 0, 1, '2020-12-01 11:05:32', '2020-12-01 11:19:29', NULL, NULL);
INSERT INTO `t_class` VALUES (11, 'WLW20240103', '物联网（6）期', '2020-02-01 00:00:00', '2020-03-01 00:00:00', 1, '苏州科技大学', '物联网学院', '班级描述信息', 'rgrwg', 5, 0, 1, '2020-12-01 11:07:25', '2020-12-01 11:12:19', NULL, NULL);
INSERT INTO `t_class` VALUES (12, 'ZNZZ20240104', '智能制造（1）期', '2020-02-01 00:00:00', '2020-03-01 00:00:00', 1, '苏州科技大学', '物联网学院', ' 班级描述信息', 'jmj,mnn,', 6, 0, 1, '2020-12-01 11:11:13', '2020-12-01 11:13:21', NULL, NULL);
INSERT INTO `t_class` VALUES (13, 'DZGC20240203', '电子工程（8）期', '2020-02-01 00:00:00', '2020-02-13 00:00:00', 1, '苏州科技大学', '物联网学院', '班级描述信息', '法尔', 7, 1, 2, '2020-12-03 17:31:35', '2020-12-03 17:31:57', '阿色', 'JAVAEE20201203');

-- ----------------------------
-- Table structure for t_class_planmanager
-- ----------------------------
DROP TABLE IF EXISTS `t_class_planmanager`;
CREATE TABLE `t_class_planmanager`  (
  `fk_plan_id` int(11) NOT NULL COMMENT '外键 方案id',
  `fk_class_id` int(11) NOT NULL COMMENT '外键 班级id',
  PRIMARY KEY (`fk_plan_id`, `fk_class_id`) USING BTREE,
  INDEX `fk_planmanager_class_id`(`fk_class_id`) USING BTREE,
  CONSTRAINT `fk_planmanager_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_planmanager_manager_id` FOREIGN KEY (`fk_plan_id`) REFERENCES `t_planmanager` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级/方案中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class_planmanager
-- ----------------------------
INSERT INTO `t_class_planmanager` VALUES (1, 1);
INSERT INTO `t_class_planmanager` VALUES (1, 2);
INSERT INTO `t_class_planmanager` VALUES (1, 5);
INSERT INTO `t_class_planmanager` VALUES (1, 9);
INSERT INTO `t_class_planmanager` VALUES (1, 10);
INSERT INTO `t_class_planmanager` VALUES (1, 11);
INSERT INTO `t_class_planmanager` VALUES (1, 12);
INSERT INTO `t_class_planmanager` VALUES (1, 13);

-- ----------------------------
-- Table structure for t_class_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_class_resource`;
CREATE TABLE `t_class_resource`  (
  `fk_class_id` int(11) NOT NULL COMMENT '外键 班级id',
  `fk_resource_id` int(11) NOT NULL COMMENT '外键 资源id',
  PRIMARY KEY (`fk_class_id`, `fk_resource_id`) USING BTREE,
  INDEX `fk_class_resource_resource_id`(`fk_resource_id`) USING BTREE,
  CONSTRAINT `fk_class_resource_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_class_resource_resource_id` FOREIGN KEY (`fk_resource_id`) REFERENCES `t_resource` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '班级/资源管理中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_class_resource
-- ----------------------------

-- ----------------------------
-- Table structure for t_client
-- ----------------------------
DROP TABLE IF EXISTS `t_client`;
CREATE TABLE `t_client`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '意向客户id',
  `client_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '意向客户的姓名',
  `client_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '意向客户电话',
  `gender` int(1) NOT NULL COMMENT '客户性别：1男、0女',
  `client_experience` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '意向客户的工作经历，或自我介绍',
  `salseman_describe` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市场人员对意向客户的评价',
  `advance_pay` double NULL DEFAULT NULL COMMENT '预付金额',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `total_pay` double NULL DEFAULT NULL COMMENT '总金额',
  `month_pay` double NULL DEFAULT NULL COMMENT '每月还款',
  `pay_ment` int(11) NULL DEFAULT NULL COMMENT '还款金额',
  `is_assign_class` int(1) NOT NULL COMMENT '是否分配班级：1未分配、2已分配',
  `client_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `loan_status` int(1) NOT NULL COMMENT '是否贷款：1贷款、0未贷款',
  `loan` double NULL DEFAULT NULL COMMENT '贷款金额',
  `interview_time_start` timestamp(0) NULL DEFAULT NULL COMMENT '面试起始时间',
  `interview_time_end` timestamp(0) NULL DEFAULT NULL COMMENT '面试结束时间',
  `client_state` int(1) NULL DEFAULT NULL COMMENT '客户状态：1无意向、2已签约、3潜在客户、4标准客户',
  `fk_profession_id` int(11) NULL DEFAULT NULL COMMENT '专业id',
  `major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `sign_time` timestamp(0) NULL DEFAULT NULL COMMENT '签约时间',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除：1未删除、0删除',
  `fk_channel_id` int(11) NOT NULL COMMENT '外键，渠道id',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `fk_user_id` int(11) NULL DEFAULT NULL COMMENT '外键，指向咨询师',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_client_channel`(`fk_channel_id`) USING BTREE,
  INDEX `fk_client_user_id`(`fk_user_id`) USING BTREE,
  CONSTRAINT `fk_client_channel` FOREIGN KEY (`fk_channel_id`) REFERENCES `t_channel` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_client_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '意向客户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_client
-- ----------------------------
INSERT INTO `t_client` VALUES (1, '王二小', '18803031363', 1, '此人很优秀', '此人棒棒', 2000, '2020-07-09 16:22:00', 200000, 5000, 5000, 1, '1210736981@qq.com', 1, 10000, '2020-07-09 16:24:00', '2020-10-09 16:24:00', 2, 1, '软件技术', '2020-07-09 16:24:00', 1, 1, 1, '2020-07-09 16:24:00', 1);
INSERT INTO `t_client` VALUES (2, '谭建', '18807041364', 1, '你为何如此优秀', '此人很优秀', 3000, '2020-07-08 18:13:45', 30000, 6000, 6000, 1, '413127846@qq.com', 1, 30000, '2020-07-08 18:13:45', '2022-09-11 09:11:00', 2, 1, '软件技术', '2020-07-08 18:13:45', 1, 1, 1, '2020-07-08 18:13:45', 1);
INSERT INTO `t_client` VALUES (4, '张二丰', '18812345655', 1, '你为何如此优秀', '此人很优秀', 3000, '2020-07-10 18:50:04', 30000, 6000, 6000, 1, '413127846@qq.com', 1, 30000, '2020-07-10 18:50:04', '2022-09-11 09:11:00', 2, 1, '软件技术', '2020-07-10 18:50:04', 1, 1, 1, '2020-07-10 18:50:04', 1);
INSERT INTO `t_client` VALUES (5, '张山丰', '18812345655', 1, '你为何如此优秀', '此人很优秀', 111, '2020-07-15 15:31:10', 30000, 200, 5000, 1, '413127846@qq.com', 1, 30000, '2020-07-15 16:41:09', '2022-09-11 09:11:00', 2, 1, '软件技术', '2020-07-15 16:31:06', 1, 1, 5, '2020-07-15 16:41:08', 1);
INSERT INTO `t_client` VALUES (6, '章一封', '18807031363', 1, NULL, NULL, NULL, '2020-07-15 16:00:12', NULL, NULL, NULL, 1, '1210736891@qq.com', 2, NULL, NULL, NULL, 2, 1, '软件技术', NULL, 1, 1, 1, '2020-07-15 16:00:12', 1);

-- ----------------------------
-- Table structure for t_client_note
-- ----------------------------
DROP TABLE IF EXISTS `t_client_note`;
CREATE TABLE `t_client_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '跟进记录的自增id',
  `fk_client_id` int(11) NOT NULL COMMENT '意向客户id',
  `client_note` mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '跟进记录',
  `client_state` int(11) NULL DEFAULT NULL COMMENT '客户状态',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_clientnote_client`(`fk_client_id`) USING BTREE,
  CONSTRAINT `fk_clientnote_client` FOREIGN KEY (`fk_client_id`) REFERENCES `t_client` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '客户跟踪记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_client_note
-- ----------------------------
INSERT INTO `t_client_note` VALUES (1, 1, '意向客户', 1, '2020-07-10 18:52:22', 2, '2020-07-10 18:53:03');
INSERT INTO `t_client_note` VALUES (3, 1, '该客户已经找到工作', 1, '2020-07-10 18:52:37', 1, '2020-07-10 18:52:37');
INSERT INTO `t_client_note` VALUES (4, 1, '意向客户', 1, '2020-07-15 16:52:00', 1, NULL);

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE IF EXISTS `t_course`;
CREATE TABLE `t_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号id',
  `course_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程编号',
  `course_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称',
  `start_time` timestamp(0) NOT NULL COMMENT '课程开始时间',
  `end_time` timestamp(0) NOT NULL COMMENT '课程结束时间',
  `course_period` int(255) NOT NULL COMMENT '课程学时',
  `course_status` int(1) UNSIGNED NOT NULL COMMENT '课程使用状态：1启用、2未启用',
  `course_image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程封面图片url',
  `course_desc` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程描述',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `course_open_status` int(1) NOT NULL COMMENT '视频公开状态：1公开视频、2私有视频',
  `video_status` int(1) NOT NULL COMMENT '是否允许观看：1允许观看2：不允许观看',
  `free` tinyint(1) NULL DEFAULT NULL COMMENT '1 表示免费，0表示不免费',
  `hot` tinyint(1) NULL DEFAULT NULL COMMENT '1：表示热门、0表示不热门',
  `listener` tinyint(1) NULL DEFAULT NULL COMMENT '1 表示监听， 0 表示不监听',
  `course_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程类型',
  `fk_course_category_id` int(11) NULL DEFAULT NULL COMMENT '课程分类表id  外键',
  `course_send_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此字段有值，代表是从总控平台传送过来的数据',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除1:未删除 0:已删除',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_courseitem`(`fk_course_category_id`) USING BTREE,
  CONSTRAINT `fk_course_courseitem` FOREIGN KEY (`fk_course_category_id`) REFERENCES `t_course_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course
-- ----------------------------
INSERT INTO `t_course` VALUES (1, 'KC_20181207145339', '企业级框架（SpringBoot）', '2020-07-10 18:55:20', '2020-01-02 18:55:20', 40, 1, 'aaa.jpg', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的', '2020-07-10 18:55:20', 1, 1, 1, 1, 1, '框架', 1, '此属性有值，代表是从总控平台传送过来的数据', 1, 2, '2020-07-10 18:55:21');
INSERT INTO `t_course` VALUES (2, 'KC_20181207145339', '企业级框架（SpringSecurity）', '2020-07-09 10:37:27', '2020-01-02 10:37:27', 40, 1, 'aaa.jpg', 'Spring Boot是由Pivotal团队提供的全新框架，其设计目的是用来简化新Spring应用的', '2020-07-09 10:37:27', 1, 1, 1, 1, 1, '框架', 1, '此属性有值，代表是从总控平台传送过来的数据', 1, 5, '2020-12-05 10:30:26');
INSERT INTO `t_course` VALUES (3, 'KC_20181207142639', '项目管理工具（Maven）', '2020-07-09 10:38:19', '2020-01-02 10:38:19', 40, 1, 'aaa.jpg', 'Maven项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和文档的项目管理工具软...', '2020-07-09 10:38:19', 1, 1, 1, 1, 1, '框架', 1, '此属性有值，代表是从总控平台传送过来的数据', 1, 3, '2020-12-05 10:30:29');
INSERT INTO `t_course` VALUES (4, 'KC_20181204113845', '企业级框架（SpringMVC）', '2020-07-09 10:38:58', '2020-01-02 10:38:58', 40, 1, 'aaa.jpg', 'Spring MVC属于SpringFrameWork的后续产品，已经融合在Spring Web F...', '2020-07-09 10:38:58', 1, 1, 1, 1, 1, '框架', 1, '此属性有值，代表是从总控平台传送过来的数据', 1, 1, NULL);
INSERT INTO `t_course` VALUES (5, 'KC_20181204113845', '企业级框架（Mybatis)', '2020-07-10 18:55:13', '2020-01-02 18:55:13', 40, 1, 'aaa.jpg', 'Spring MVC属于SpringFrameWork的后续产品，已经融合在Spring Web F...', '2020-07-10 18:55:13', 1, 1, 1, 1, 1, '框架', 1, '此属性有值，代表是从总控平台传送过来的数据', 1, 1, NULL);

-- ----------------------------
-- Table structure for t_course_category
-- ----------------------------
DROP TABLE IF EXISTS `t_course_category`;
CREATE TABLE `t_course_category`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `category_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类名称',
  `category_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类描述',
  `fk_parent_id` int(11) NULL DEFAULT NULL COMMENT '分类别id',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除：1未删除，2已删除',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_category_parent_id`(`fk_parent_id`) USING BTREE,
  CONSTRAINT `fk_course_category_parent_id` FOREIGN KEY (`fk_parent_id`) REFERENCES `t_course_category` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course_category
-- ----------------------------
INSERT INTO `t_course_category` VALUES (1, '数据库', '数据库相关的产品', NULL, '2020-07-09 11:18:00', 1, 5, '2020-07-15 09:34:17');
INSERT INTO `t_course_category` VALUES (2, '企业级开发框架', '包含各种主流的企业级开发框架', NULL, '2020-07-09 10:50:27', 1, 1, '2020-07-09 10:50:27');
INSERT INTO `t_course_category` VALUES (3, '前端技术', '包含主流的前端开发技术', NULL, '2020-07-09 10:52:43', 0, 1, '2020-07-09 10:52:43');
INSERT INTO `t_course_category` VALUES (4, '服务器环境搭建', '主要是Linux下的常用命令与软件安装', NULL, '2020-07-09 10:53:04', 1, 1, '2020-07-09 10:53:04');
INSERT INTO `t_course_category` VALUES (5, '数据库访问技术', '数据库访问技术', NULL, '2020-07-09 10:53:20', 1, 1, '2020-07-09 10:53:20');
INSERT INTO `t_course_category` VALUES (7, 'Mysql开发技术', '关系型数据库', 1, '2020-07-09 11:13:54', 1, 1, '2020-07-09 11:13:54');
INSERT INTO `t_course_category` VALUES (8, 'Mybatis开发框架', '企业级开发框架', 2, '2020-07-09 11:14:52', 1, 1, '2020-07-09 11:14:52');
INSERT INTO `t_course_category` VALUES (9, 'Spring Framework', '企业级开发框架', 2, '2020-07-09 11:17:21', 1, 1, '2020-07-09 11:17:21');
INSERT INTO `t_course_category` VALUES (10, 'Spring Boot', '企业级开发框架', 2, '2020-07-10 18:53:42', 1, 1, '2020-07-10 18:53:42');
INSERT INTO `t_course_category` VALUES (11, '项目管理', '项目管理相关的课程', NULL, '2020-07-15 09:46:00', 0, 1, NULL);
INSERT INTO `t_course_category` VALUES (12, '开发辅助工具', '辅助开发技术', NULL, '2020-07-15 09:47:49', 1, 1, '2020-07-15 09:47:50');
INSERT INTO `t_course_category` VALUES (13, '运维工具', '运维相关的技术', NULL, '2020-11-26 16:05:30', 1, 3, '2020-11-30 09:34:54');
INSERT INTO `t_course_category` VALUES (14, ' 编程语言', '各种编程语言', NULL, '2020-11-26 16:08:28', 0, 2, '2020-11-26 16:38:44');
INSERT INTO `t_course_category` VALUES (16, 'Redis开发技术', '一种NO SQL系列数据库', 1, '2020-11-27 11:22:32', 0, 2, '2020-11-27 13:40:39');
INSERT INTO `t_course_category` VALUES (17, 'Spring Security', '认证和鉴权框架', 2, '2020-11-27 13:22:09', 1, 1, '2020-11-27 13:22:06');
INSERT INTO `t_course_category` VALUES (18, 'Thymeleaf', '一种前端页面模板技术', 2, '2020-11-27 14:15:53', 1, 1, '2020-11-27 14:15:50');
INSERT INTO `t_course_category` VALUES (20, 'HTML&CSS', 'HTML5, CSS3', 3, '2020-11-27 14:53:12', 0, 2, '2020-11-27 14:53:19');
INSERT INTO `t_course_category` VALUES (21, 'JavaScript', 'js', 3, '2020-11-30 09:34:43', 1, 1, '2020-11-30 09:34:40');
INSERT INTO `t_course_category` VALUES (23, 'Vue.js', 'VUE3', 3, '2020-12-03 16:23:43', 1, 2, '2020-12-03 16:23:53');
INSERT INTO `t_course_category` VALUES (24, 'jQuery框架', ' jquery前端框架', 3, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (25, 'Bootstrap框架', ' 一种前端框架', 3, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (26, 'Jdbc技术', ' jdbc', 5, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (27, 'Linux操作系统', ' linux', 4, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (28, 'Maven', 'maven', 12, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (29, 'Git', 'git', 12, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (30, 'Java核心编程', ' java语言', 14, NULL, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (31, 'Pyhton编程', ' python', 14, NULL, 1, 1, NULL);

-- ----------------------------
-- Table structure for t_course_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_course_comment`;
CREATE TABLE `t_course_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `comment_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后访问时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本',
  `fk_student_id` int(11) NOT NULL COMMENT '用户id 外键',
  `fk_course_id` int(11) NOT NULL COMMENT '课程id 外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_comment_stu_id`(`fk_student_id`) USING BTREE,
  INDEX `fk_course_comment_course_id`(`fk_course_id`) USING BTREE,
  CONSTRAINT `fk_course_comment_course_id` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_course_comment_stu_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生对课程的评价' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course_comment
-- ----------------------------
INSERT INTO `t_course_comment` VALUES (1, 'xxx学生的评价内容', '2020-07-10 18:54:52', '2020-07-10 18:54:52', 1, 1, 1);

-- ----------------------------
-- Table structure for t_course_report
-- ----------------------------
DROP TABLE IF EXISTS `t_course_report`;
CREATE TABLE `t_course_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生课程统计id',
  `course_learn_count` int(11) NULL DEFAULT NULL COMMENT '课程学习总数',
  `practice_count` int(11) NULL DEFAULT NULL COMMENT '练习总数 ',
  `notes_count` int(11) NULL DEFAULT NULL COMMENT '笔记总数',
  `sign_count` int(11) NULL DEFAULT NULL COMMENT '签到次数 ',
  `question_count` int(11) NULL DEFAULT NULL COMMENT '提问总次数',
  `video_play_count` int(11) NULL DEFAULT NULL COMMENT '视频播放次数',
  `answer_count` int(11) NULL DEFAULT NULL COMMENT '回答问题次数',
  `test_count` int(11) NULL DEFAULT NULL COMMENT '考试完成数',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `homework_count` int(11) NULL DEFAULT NULL COMMENT '作业总数量',
  `homework_finished_count` int(11) NULL DEFAULT NULL COMMENT '作业完成数',
  `video_count` int(11) NULL DEFAULT NULL COMMENT '视频总数',
  `video_finished_count` int(11) NULL DEFAULT NULL COMMENT '已学视频总数 ',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '用户id  外键',
  `fk_course_id` int(11) NULL DEFAULT NULL COMMENT '课程id  外键',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_coursereport_course`(`fk_course_id`) USING BTREE,
  INDEX `fk_course_report_fk_student_id`(`fk_student_id`) USING BTREE,
  CONSTRAINT `fk_course_report_fk_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_coursereport_course` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course_report
-- ----------------------------
INSERT INTO `t_course_report` VALUES (1, 50, 20, 10, 20, 10, 10, 15, 2, '2020-07-10 18:56:29', 3, 2, 50, 32, 1, 1, 2, '2020-07-10 18:56:37');

-- ----------------------------
-- Table structure for t_db_copy
-- ----------------------------
DROP TABLE IF EXISTS `t_db_copy`;
CREATE TABLE `t_db_copy`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备份的sql文件名',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备份的sql文件路径',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '备份的状态，1表示成功，0表示失败',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '备份的时间',
  `version` int(3) NULL DEFAULT 1 COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1019 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '数据库备份表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_db_copy
-- ----------------------------
INSERT INTO `t_db_copy` VALUES (1, 'db_backup_20240124001.sql', 'hello/hello', 1, '2024-01-24 13:40:40', 1, '2020-07-08 16:14:43');

-- ----------------------------
-- Table structure for t_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `t_evaluate`;
CREATE TABLE `t_evaluate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` int(3) NOT NULL COMMENT '版本',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `fk_user_id` int(11) NULL DEFAULT NULL COMMENT '外键，老师ID',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员ID',
  `fk_class_id` int(11) NULL DEFAULT NULL COMMENT '外键，班级ID',
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `evaluate_status` int(1) NOT NULL COMMENT '状态,1 表示有效，0表示无效',
  `evaluate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评价内容',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_evaluate_user_id`(`fk_user_id`) USING BTREE,
  INDEX `fk_evaluate_student_id`(`fk_student_id`) USING BTREE,
  INDEX `fk_evaluate_class_id`(`fk_class_id`) USING BTREE,
  CONSTRAINT `fk_evaluate_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_evaluate_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_evaluate_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生评价表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `exam_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试名称',
  `exam_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试分类',
  `exam_status` int(2) NULL DEFAULT NULL COMMENT '考试状态，0为禁用，1为正常',
  `exam_pass_score` double(10, 1) NULL DEFAULT NULL COMMENT '及格分数',
  `exam_test_sequecing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试题排序',
  `exam_show` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试展示',
  `exam_choice_sequecing` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '选项排序',
  `exam_number` int(5) NULL DEFAULT NULL COMMENT '可考次数',
  `exam_notice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试须知',
  `exam_start` timestamp(0) NULL DEFAULT NULL COMMENT '开考时间',
  `exam_end` timestamp(0) NULL DEFAULT NULL COMMENT '结束时间',
  `exam_time` int(5) NULL DEFAULT NULL COMMENT '考试时长',
  `exam_score_announcement` timestamp(0) NULL DEFAULT NULL COMMENT '成绩公布时间',
  `exam_timelimit` int(11) NULL DEFAULT NULL COMMENT '参加限制',
  `exam_limit` int(11) NULL DEFAULT NULL COMMENT '交卷限制',
  `exam_answer_announcement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公布答案',
  `exam_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '查看详情',
  `is_delete` int(3) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问的时间',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改考试的用户名称',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT 't_exam_answerpaper的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_t_exam_paper_id`(`paper_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_t_exam_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `t_exam_paper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体类考试' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_answerpaper
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_answerpaper`;
CREATE TABLE `t_exam_answerpaper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NULL DEFAULT NULL COMMENT 't_user的id值',
  `exam_id` int(11) NULL DEFAULT NULL COMMENT 't_exam的id',
  `exam_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考试的名称',
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `topic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '大题名称',
  `user_answer` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '考生答案',
  `ques_answer` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '标准答案',
  `answer_score` double(10, 1) NULL DEFAULT NULL COMMENT '考生一题的答案所得分数',
  `ques_score` double(10, 1) NULL DEFAULT NULL COMMENT '一题的总分',
  `status` int(3) NULL DEFAULT NULL COMMENT '批改状态（0为未批改，1为批改)',
  `is_delete` int(3) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_answerpaper_t_exam_1`(`exam_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_answerpaper_t_exam_1` FOREIGN KEY (`exam_id`) REFERENCES `t_exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体类	学生的答卷类（学生查看试卷,老师修改考卷）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_answerpaper
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_answerpaper_ques
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_answerpaper_ques`;
CREATE TABLE `t_exam_answerpaper_ques`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `answerpaper_id` int(11) NULL DEFAULT NULL COMMENT '答卷的id（t_exam_answerpaper的id）',
  `answerpaper_ques_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答卷问题题干',
  `answerpaper_ques_choice` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '(若为选择，判断)问题的选项',
  `answerpaper_ques_status` int(3) NULL DEFAULT NULL COMMENT '判断是否为正确答案(0为错误，1为正确)',
  `answerpaper_ques_score` double(10, 1) NULL DEFAULT NULL COMMENT '标准答案的分数',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_answerpaper_ques_t_exam_answerpaper_1`(`answerpaper_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_answerpaper_ques_t_exam_answerpaper_1` FOREIGN KEY (`answerpaper_id`) REFERENCES `t_exam_answerpaper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体类 	答卷的题干表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_answerpaper_ques
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_bank
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_bank`;
CREATE TABLE `t_exam_bank`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `bank_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 题库名称',
  `bank_status` int(2) NOT NULL COMMENT '题库状态，0为禁用，1为正常',
  `bank_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题库说明',
  `bank_security` int(3) NULL DEFAULT NULL COMMENT '访问权限(1为完全私有，2为只读共享)',
  `ques_number` int(11) NULL DEFAULT NULL COMMENT '试题数量',
  `is_delete` int(2) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次的访问时间',
  `user_id` int(11) NULL DEFAULT NULL COMMENT 't_user的id表示题库的创建人',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_exam_bank_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `fk_exam_bank_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体表 题库' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_bank
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_bank_log
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_bank_log`;
CREATE TABLE `t_exam_bank_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `bank_id` int(11) NULL DEFAULT NULL COMMENT 't_exam_bank的id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 't_user的user_name',
  `use_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_bank_log_bank_id`(`bank_id`) USING BTREE,
  CONSTRAINT `fk_bank_log_bank_id` FOREIGN KEY (`bank_id`) REFERENCES `t_exam_bank` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '题库共享日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_bank_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_log
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_log`;
CREATE TABLE `t_exam_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `exam_id` int(11) NULL DEFAULT NULL COMMENT 't_exam的id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT 't_user的id',
  `user_start` timestamp(0) NULL DEFAULT NULL COMMENT '该用户的开考时间',
  `user_end` timestamp(0) NULL DEFAULT NULL COMMENT '该用户结束考试的时间',
  `user_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考生的ip地址',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_log_t_exam_1`(`exam_id`) USING BTREE,
  INDEX `fk_t_exam_log_user_id`(`user_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_log_t_exam_1` FOREIGN KEY (`exam_id`) REFERENCES `t_exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_exam_log_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_memberset
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_memberset`;
CREATE TABLE `t_exam_memberset`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `exam_id` int(11) NULL DEFAULT NULL COMMENT 't_exam的id',
  `user_id` int(11) NULL DEFAULT NULL COMMENT 't_user的id',
  `class_id` int(11) NULL DEFAULT NULL COMMENT 't_class的id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_t_user_t_class_t_exam_1`(`exam_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_t_user_t_class_t_exam_1` FOREIGN KEY (`exam_id`) REFERENCES `t_exam` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考试人员设置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_memberset
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper`;
CREATE TABLE `t_exam_paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID值',
  `paper_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷名称',
  `paper_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试卷分类',
  `paper_status` int(2) NULL DEFAULT NULL COMMENT '试卷状态0为禁用，1为正常',
  `paper_security` int(3) NULL DEFAULT NULL COMMENT '管理权限（0为完全私有，1为只读共享）',
  `paper_total` double(10, 1) NULL DEFAULT NULL COMMENT '试卷总分',
  `is_delete` int(2) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该试卷创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体类	试卷' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_paper
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_paper_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper_topic`;
CREATE TABLE `t_exam_paper_topic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `topic_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '大题题目',
  `topic_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '题目描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体表 	大题类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_paper_topic
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_paper_topic_quesset
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_paper_topic_quesset`;
CREATE TABLE `t_exam_paper_topic_quesset`  (
  `id` int(11) NOT NULL COMMENT '主键',
  `paper_id` int(11) NULL DEFAULT NULL COMMENT 't_exam_paper的id',
  `topic_id` int(11) NULL DEFAULT NULL COMMENT 't_exam_paper_topic的id',
  `ques_id` int(11) NULL DEFAULT NULL COMMENT 't_exam_ques的id',
  `ques_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '试题题干',
  `score` double(10, 1) NULL DEFAULT NULL COMMENT '分值',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_paper_topic_quesset_t_exam_paper_id`(`paper_id`) USING BTREE,
  INDEX `fk_t_exam_paper_topic_quesset_t_exam_ques_id`(`ques_id`) USING BTREE,
  INDEX `fk_t_exam_paper_topic_quesset_t_exam_paper_topic_id`(`topic_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_paper_topic_quesset_t_exam_paper_id` FOREIGN KEY (`paper_id`) REFERENCES `t_exam_paper` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_exam_paper_topic_quesset_t_exam_paper_topic_id` FOREIGN KEY (`topic_id`) REFERENCES `t_exam_paper_topic` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_exam_paper_topic_quesset_t_exam_ques_id` FOREIGN KEY (`ques_id`) REFERENCES `t_exam_ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体类	大题里试题设置类' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_paper_topic_quesset
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_ques
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_ques`;
CREATE TABLE `t_exam_ques`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ques_type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试题类型',
  `ques_hard_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试题难度',
  `ques_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源',
  `ques_lable` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '试题标签',
  `ques_status` int(2) NOT NULL COMMENT '试题状态，0为禁用，1为正常',
  `ques_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '试题题干',
  `correct_answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '该单选题或多选题的正确答案[冗余设计]\r\n',
  `ques_analyze` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '答案解析',
  `is_delete` int(2) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `use_count` int(11) NULL DEFAULT NULL COMMENT '引用次数',
  `bank_id` int(11) NULL DEFAULT NULL COMMENT 't_exam_bank的id',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人【以当前登录者的唯一名称为值】',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_ques_t_exam_bank_id`(`bank_id`) USING BTREE,
  INDEX `fk_t_exam_ques_t_exam_ques_hard_level`(`ques_hard_level`) USING BTREE,
  INDEX `fk_t_exam_ques_t_exam_ques_type_name`(`ques_type_name`) USING BTREE,
  CONSTRAINT `fk_t_exam_ques_t_exam_bank_id` FOREIGN KEY (`bank_id`) REFERENCES `t_exam_bank` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_exam_ques_t_exam_ques_hard_level` FOREIGN KEY (`ques_hard_level`) REFERENCES `t_exam_ques_hard` (`hard_level`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_t_exam_ques_t_exam_ques_type_name` FOREIGN KEY (`ques_type_name`) REFERENCES `t_exam_ques_type` (`type_name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体表	试题\r\n通过试题所属的共享题库将试题放入共享试题中' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_ques
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_ques_answerset
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_ques_answerset`;
CREATE TABLE `t_exam_ques_answerset`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ques_id` int(11) NULL DEFAULT NULL COMMENT '所属试题的id(t_exam_ques的id)',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属试题类型',
  `answer_content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '答案设置的内容',
  `answer_status` int(2) NULL DEFAULT NULL COMMENT '判断答案是否正确(0为false，1为true)',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_t_exam_ques_answerset_t_exam_ques_1`(`ques_id`) USING BTREE,
  CONSTRAINT `fk_t_exam_ques_answerset_t_exam_ques_1` FOREIGN KEY (`ques_id`) REFERENCES `t_exam_ques` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体表	答案设置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_ques_answerset
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_ques_hard
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_ques_hard`;
CREATE TABLE `t_exam_ques_hard`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `hard_level` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '难度的等级',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UNIQUE_LEVEL`(`hard_level`) USING BTREE COMMENT '让难度变唯一约束'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '实体表	难度' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_ques_hard
-- ----------------------------

-- ----------------------------
-- Table structure for t_exam_ques_type
-- ----------------------------
DROP TABLE IF EXISTS `t_exam_ques_type`;
CREATE TABLE `t_exam_ques_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `type_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型名称(单选，多选，判断，填空，回答，附件)',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UNIQUE_TYPE`(`type_name`) USING BTREE COMMENT '让试题类型变唯一约束'
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_exam_ques_type
-- ----------------------------

-- ----------------------------
-- Table structure for t_group
-- ----------------------------
DROP TABLE IF EXISTS `t_group`;
CREATE TABLE `t_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组名称',
  `group_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `max_count` int(10) NOT NULL DEFAULT 3 COMMENT '  角色最大分配数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户组 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_group
-- ----------------------------
INSERT INTO `t_group` VALUES (24, '后台管理组', '负责后台事务处理和系统维护', '2020-10-13 17:08:29', '2020-10-24 16:09:17', 1, 3);
INSERT INTO `t_group` VALUES (30, '教师教务组', '授课老师和组长', '2020-10-24 11:09:48', '2020-10-24 16:15:13', 1, 3);
INSERT INTO `t_group` VALUES (32, '技术维护组', '维护页面', '2020-10-24 11:13:16', '2020-10-24 16:15:16', 1, 3);
INSERT INTO `t_group` VALUES (37, '普通用户', '无特殊权限', '2020-10-26 14:10:33', NULL, 1, 3);
INSERT INTO `t_group` VALUES (38, '开发项目组', '完全权限', '2020-10-28 09:26:42', NULL, 1, 3);
INSERT INTO `t_group` VALUES (39, '监测组', '只能看', '2020-10-29 10:40:37', NULL, 1, 3);

-- ----------------------------
-- Table structure for t_group_role
-- ----------------------------
DROP TABLE IF EXISTS `t_group_role`;
CREATE TABLE `t_group_role`  (
  `group_id` int(11) NOT NULL COMMENT '用户外键ID',
  `role_id` int(11) NOT NULL COMMENT '角色外键ID',
  PRIMARY KEY (`group_id`, `role_id`) USING BTREE,
  INDEX `fk_role_id`(`role_id`) USING BTREE,
  CONSTRAINT `fk_group_id` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组和角色的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_group_role
-- ----------------------------
INSERT INTO `t_group_role` VALUES (32, 1);
INSERT INTO `t_group_role` VALUES (38, 1);
INSERT INTO `t_group_role` VALUES (32, 2);
INSERT INTO `t_group_role` VALUES (38, 2);
INSERT INTO `t_group_role` VALUES (30, 3);
INSERT INTO `t_group_role` VALUES (30, 4);
INSERT INTO `t_group_role` VALUES (30, 5);
INSERT INTO `t_group_role` VALUES (24, 6);

-- ----------------------------
-- Table structure for t_homework
-- ----------------------------
DROP TABLE IF EXISTS `t_homework`;
CREATE TABLE `t_homework`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '作业id',
  `work_title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作业标题',
  `work_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '作业内容',
  `fk_course_id` int(11) NOT NULL COMMENT '外键，课程ID',
  `fk_chapter_id` int(11) NOT NULL COMMENT '外键，章ID',
  `fk_section_id` int(11) NOT NULL COMMENT '外键 节id',
  `fk_class_id` int(11) NULL DEFAULT NULL COMMENT '班级id',
  `work_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '作业文件',
  `work_status` int(1) NULL DEFAULT NULL COMMENT '作业状态，1表示已批阅，0表示未批阅',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属课程名',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `version` int(11) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_homework_class_id`(`fk_class_id`) USING BTREE,
  INDEX `fk_section_id_cascade`(`fk_section_id`) USING BTREE,
  INDEX `fk_homework_chapter_id`(`fk_chapter_id`) USING BTREE,
  INDEX `fk_homework_course_id`(`fk_course_id`) USING BTREE,
  CONSTRAINT `fk_homework_chapter_id` FOREIGN KEY (`fk_chapter_id`) REFERENCES `t_chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_homework_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_homework_course_id` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_section_id_cascade` FOREIGN KEY (`fk_section_id`) REFERENCES `t_section` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程作业' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_homework
-- ----------------------------
INSERT INTO `t_homework` VALUES (1, 'update课后作业', '完成课题案例', 1, 1, 1, 1, 'd://file/123465.docx', 0, 'java核心技术(一)', '2020-07-10 10:30:56', 1, NULL);

-- ----------------------------
-- Table structure for t_homework_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_homework_answer`;
CREATE TABLE `t_homework_answer`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `answer_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代码作业提交的git地址',
  `answer_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '答案内容',
  `answer_attachment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学员所上传的作业附件',
  `answer_status` int(1) NULL DEFAULT NULL COMMENT '作业状态，1表示已完成，0表示未完成',
  `audit_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核内容',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次修改时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `fk_homework_id` int(11) NULL DEFAULT NULL COMMENT '外键，作业id',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_homework_answer_id`(`fk_homework_id`) USING BTREE,
  INDEX `fk_homework_student_id`(`fk_student_id`) USING BTREE,
  CONSTRAINT `fk_homework_answer_id` FOREIGN KEY (`fk_homework_id`) REFERENCES `t_homework` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_homework_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学员作业完成表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_homework_answer
-- ----------------------------
INSERT INTO `t_homework_answer` VALUES (1, NULL, '集合', NULL, 1, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_homework_answer` VALUES (5, NULL, '基础', NULL, 1, 'aaaaa', NULL, NULL, NULL, 1, 1);
INSERT INTO `t_homework_answer` VALUES (6, NULL, '1', NULL, 1, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_homework_answer` VALUES (7, NULL, '1', NULL, 1, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_homework_answer` VALUES (8, NULL, '1', NULL, 1, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_homework_answer` VALUES (9, NULL, '1', NULL, 1, NULL, NULL, NULL, NULL, 1, 1);

-- ----------------------------
-- Table structure for t_illegal
-- ----------------------------
DROP TABLE IF EXISTS `t_illegal`;
CREATE TABLE `t_illegal`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` int(255) NOT NULL COMMENT '版本',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `fk_user_id` int(11) NULL DEFAULT NULL COMMENT '外键，老师ID',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员ID',
  `fk_class_id` int(11) NULL DEFAULT NULL COMMENT '外键，班级ID',
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '违纪学员姓名',
  `discipline_time` timestamp(0) NOT NULL COMMENT '违规时间',
  `presentation_condition` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '情况说明',
  `attachment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '证据文件，以学员名#id.扩展名 命名',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_illegal_student_id`(`fk_student_id`) USING BTREE,
  INDEX `fk_illegal_user_id`(`fk_user_id`) USING BTREE,
  INDEX `fk_illegal_class_id`(`fk_class_id`) USING BTREE,
  CONSTRAINT `fk_illegal_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_illegal_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_illegal_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '违纪处理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_illegal
-- ----------------------------
INSERT INTO `t_illegal` VALUES (4, 1, '2020-07-08 16:27:39', NULL, 1, 1, 1, 'shen', '2020-07-08 16:27:39', NULL, NULL);
INSERT INTO `t_illegal` VALUES (5, 1, '2020-07-08 17:22:12', NULL, 1, 1, 1, 'shen', '2020-07-08 17:22:12', NULL, NULL);
INSERT INTO `t_illegal` VALUES (6, 1, '2020-07-14 17:10:33', NULL, 1, 1, 1, 'qian', '2020-07-14 17:10:33', NULL, NULL);

-- ----------------------------
-- Table structure for t_leave
-- ----------------------------
DROP TABLE IF EXISTS `t_leave`;
CREATE TABLE `t_leave`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` int(3) NOT NULL COMMENT '版本',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后修改时间',
  `leave_time` timestamp(0) NOT NULL COMMENT '请假时间',
  `end_time` timestamp(0) NOT NULL COMMENT '结束时间',
  `reason_leave` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假事由',
  `approval_status` int(3) NULL DEFAULT NULL COMMENT '审核状态,1.待审核， 2， 审核通过， 0 未通过',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学生id',
  `fk_class_id` int(11) NULL DEFAULT NULL COMMENT '外键，班级id',
  `option` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '意见',
  `student_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `leave_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请假类型',
  `serial_number` int(11) NULL DEFAULT NULL COMMENT '序号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_leave_student_id`(`fk_student_id`) USING BTREE,
  INDEX `fk_leave_class_id`(`fk_class_id`) USING BTREE,
  CONSTRAINT `fk_leave_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_leave_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '请假处理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_leave
-- ----------------------------
INSERT INTO `t_leave` VALUES (1, 3, '2020-07-08 10:36:52', '2020-07-13 10:58:29', '2020-07-08 10:36:52', '2020-07-08 10:36:52', NULL, 5, 1, 1, NULL, 'shen', NULL, NULL);
INSERT INTO `t_leave` VALUES (3, 1, '2020-07-08 10:37:48', NULL, '2020-07-08 10:37:48', '2020-07-08 10:37:48', NULL, NULL, 1, 1, NULL, 'shen', NULL, NULL);
INSERT INTO `t_leave` VALUES (5, 1, '2020-07-13 10:58:03', NULL, '2020-07-13 10:58:03', '2020-07-13 10:58:03', NULL, NULL, 1, 1, NULL, 'shen', NULL, NULL);
INSERT INTO `t_leave` VALUES (6, 1, '2020-07-13 10:58:03', NULL, '2020-07-13 10:58:03', '2020-07-13 10:58:03', NULL, NULL, 1, 1, NULL, 'shen', NULL, NULL);
INSERT INTO `t_leave` VALUES (8, 2, '2020-07-13 10:58:03', '2020-07-14 17:02:45', '2020-07-13 10:58:03', '2020-07-13 10:58:03', NULL, 3, 1, 1, NULL, 'shen', NULL, NULL);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fk_parent_id` int(11) NULL DEFAULT NULL COMMENT '父级菜单ID',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单名',
  `menu_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `menu_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单描述',
  `menu_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单代号',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_parent_id`(`fk_parent_id`) USING BTREE,
  CONSTRAINT `fk_parent_id` FOREIGN KEY (`fk_parent_id`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 73 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (1, NULL, '系统配置', '#', '系统配置 一级菜单', 'a11', '2020-07-08 15:38:31', '2020-10-27 11:35:22', 4);
INSERT INTO `t_menu` VALUES (2, NULL, '用户管理', '#', '用户管理一级菜单', 'a12', '2020-07-08 15:38:32', NULL, 1);
INSERT INTO `t_menu` VALUES (3, 1, '参数信息', '/system/paraminfo', '二级菜单 页面', 'a13', '2020-07-08 15:38:32', '2020-10-26 09:55:49', 3);
INSERT INTO `t_menu` VALUES (4, 1, '配置资料', '/system/config', '二级菜单', 'a14', '2020-07-08 15:38:32', '2020-10-26 09:56:07', 2);
INSERT INTO `t_menu` VALUES (5, 1, '数据库备份', '/system/backup', '二级菜单，需要系统后台管理权限', 'a15', NULL, '2020-10-26 09:56:32', 2);
INSERT INTO `t_menu` VALUES (7, 2, '管理员管理', '/user/adminList', '二级菜单页面 管理拥有管理员权限的用户', 'a17', NULL, '2020-10-26 09:57:25', 2);
INSERT INTO `t_menu` VALUES (8, 2, '学生管理', '/user/stuList', '管理用户', 'a18', NULL, '2020-11-24 13:11:11', 3);
INSERT INTO `t_menu` VALUES (14, 2, '教师管理', '/user/teacherList', '管理教师账号的页面', NULL, '2020-10-15 11:52:26', '2020-10-26 09:58:12', 3);
INSERT INTO `t_menu` VALUES (15, 2, '咨询师管理', '/user/advisorList', '管理后台咨询账户的页面', NULL, '2020-10-15 11:54:05', '2020-10-26 09:58:43', 3);
INSERT INTO `t_menu` VALUES (16, 22, '用户组管理', '/privilege/userGroup', '管理用户组的角色的页面', NULL, '2020-10-15 12:53:44', '2020-10-28 13:09:21', 4);
INSERT INTO `t_menu` VALUES (19, 22, '角色管理', '/privilege/roleList', '管理角色拥有的权限的页面', NULL, '2020-10-15 13:15:49', '2020-10-26 10:03:13', 3);
INSERT INTO `t_menu` VALUES (22, NULL, '权限管理', '#', '权限管理 一级菜单', NULL, '2020-10-26 09:51:45', NULL, 1);
INSERT INTO `t_menu` VALUES (23, NULL, '资源管理', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (24, NULL, '培养方案', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (25, NULL, '班级管理', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (26, NULL, '授课管理', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (27, NULL, '考试管理', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (28, NULL, '考评管理', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (29, NULL, '数据分析', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (30, NULL, '组织机构', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (31, NULL, '通知公告', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (32, NULL, '咨询管理', '#', '', NULL, NULL, '2020-11-24 15:52:46', NULL);
INSERT INTO `t_menu` VALUES (33, NULL, '意向用户', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (34, NULL, '操作日志', '#', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_menu` VALUES (35, 22, '角色权限', '/privilege/rolePriv', '管理角色权限的页面', NULL, '2020-10-26 10:00:48', NULL, 1);
INSERT INTO `t_menu` VALUES (38, 22, '菜单管理', '/privilege/menuList', '管理菜单和菜单行为的页面', NULL, '2020-10-26 10:08:12', NULL, 1);
INSERT INTO `t_menu` VALUES (39, 22, '行为管理', '/privilege/actionList', '控制页面行为的页面', NULL, '2020-10-26 10:09:04', NULL, 1);
INSERT INTO `t_menu` VALUES (40, 23, '资源类型', '/resources/resourceType', '用于管理页面资源 管理页面 一级菜单', NULL, '2020-10-27 12:59:31', NULL, 1);
INSERT INTO `t_menu` VALUES (45, 23, '文档管理', '/resources/resourceList', '', NULL, '2020-11-24 13:09:21', NULL, 1);
INSERT INTO `t_menu` VALUES (46, 23, '视频管理', '/resources/videoMgmt', '视频管理', NULL, '2020-11-24 13:09:57', NULL, 1);
INSERT INTO `t_menu` VALUES (47, 24, '方案列表', '/training/schemaList', '列出所有方案', NULL, '2020-11-24 13:13:11', NULL, 1);
INSERT INTO `t_menu` VALUES (48, 24, '课程列表', '/training/courseList', '列出所有课程', NULL, '2020-11-24 13:14:51', NULL, 1);
INSERT INTO `t_menu` VALUES (49, 24, '课程分类', '/training/courseCategory', '课程分类', NULL, '2020-11-24 13:23:21', NULL, 1);
INSERT INTO `t_menu` VALUES (50, 25, '专业方向', '/clazz/major', '专业方向', NULL, '2020-11-24 13:24:02', NULL, 1);
INSERT INTO `t_menu` VALUES (51, 25, '班级列表', '/clazz/clazzList', '班级列表', NULL, '2020-11-24 13:24:26', NULL, 1);
INSERT INTO `t_menu` VALUES (53, 25, '布置作业', '/clazz/homework', '布置作业', NULL, '2020-11-24 13:25:18', NULL, 1);
INSERT INTO `t_menu` VALUES (54, 25, '学习进度', '/clazz/studyProcess', '学习进度', NULL, '2020-11-24 13:25:45', NULL, 1);
INSERT INTO `t_menu` VALUES (55, 26, '课堂教学', '/teaching/teaching', '课堂教学', NULL, '2020-11-24 13:26:21', NULL, 1);
INSERT INTO `t_menu` VALUES (56, 27, '题库管理', '/exam/titleList', '题库管理', NULL, '2020-11-24 13:26:51', NULL, 1);
INSERT INTO `t_menu` VALUES (57, 27, '试题管理', '/exam/testItemList', '试题管理', NULL, '2020-11-24 13:27:20', NULL, 1);
INSERT INTO `t_menu` VALUES (58, 27, '试卷管理', '/exam/paperManagementList', '对各种考试试卷进行CRUD操作', NULL, '2020-11-24 13:27:40', '2020-11-24 15:08:44', 2);
INSERT INTO `t_menu` VALUES (59, 27, '考试汇总', '/exam/examManagementList', '考试汇总', NULL, '2020-11-24 13:28:15', NULL, 1);
INSERT INTO `t_menu` VALUES (60, 28, '考评选项', '/evaluation/pollItem', '考评选项', NULL, '2020-11-24 13:28:57', '2020-11-24 13:30:38', 2);
INSERT INTO `t_menu` VALUES (61, 28, '考评模板', '/evaluation/pollTemplate', '考评模板', NULL, '2020-11-24 13:29:25', NULL, 1);
INSERT INTO `t_menu` VALUES (62, 28, '教师考评', '/evaluation/teacherPoll', '教师考评', NULL, '2020-11-24 13:29:58', NULL, 1);
INSERT INTO `t_menu` VALUES (63, 29, '班级统计', '/analysis/clazzCount', '班级统计', NULL, '2020-11-24 13:32:47', NULL, 1);
INSERT INTO `t_menu` VALUES (64, 29, '学员观看记录', '/analysis/watchVideoCount', '学院观看记录', NULL, '2020-11-24 13:33:34', NULL, 1);
INSERT INTO `t_menu` VALUES (65, 30, '机构列表', '/organization/orgList', '机构列表', NULL, '2020-11-24 13:34:24', NULL, 1);
INSERT INTO `t_menu` VALUES (66, 30, '分支机构', '/organization/branchList', '分支机构', NULL, '2020-11-24 13:34:58', NULL, 1);
INSERT INTO `t_menu` VALUES (67, 31, '公告管理', '/notice/noticeList', '公告管理', NULL, '2020-11-24 13:35:24', NULL, 1);
INSERT INTO `t_menu` VALUES (68, 31, '新闻资讯', '/notice/newsList', '新闻资讯', NULL, '2020-11-24 13:35:52', NULL, 1);
INSERT INTO `t_menu` VALUES (69, 32, '建议咨询', '/advisor/advice', '建议咨询', NULL, '2020-11-24 13:36:20', NULL, 1);
INSERT INTO `t_menu` VALUES (70, 33, '客户列表', '/potentialClient/clientList', '客户列表', NULL, '2020-11-24 13:36:46', NULL, 1);
INSERT INTO `t_menu` VALUES (71, 33, '数据报表', '/potentialClient/dataReport', '数据报表', NULL, '2020-11-24 13:37:18', NULL, 1);
INSERT INTO `t_menu` VALUES (72, 34, '日志列表', '/log/list', '日志列表', NULL, '2020-11-24 13:37:49', NULL, 1);

-- ----------------------------
-- Table structure for t_menu_action_per
-- ----------------------------
DROP TABLE IF EXISTS `t_menu_action_per`;
CREATE TABLE `t_menu_action_per`  (
  `menu_id` int(11) NOT NULL,
  `per_id` int(11) NOT NULL,
  `action_id` int(11) NOT NULL,
  PRIMARY KEY (`per_id`, `menu_id`, `action_id`) USING BTREE,
  INDEX `fk_menu_id`(`menu_id`) USING BTREE,
  INDEX `fk_action_id`(`action_id`) USING BTREE,
  CONSTRAINT `fk_action_id` FOREIGN KEY (`action_id`) REFERENCES `t_action` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_per_id` FOREIGN KEY (`per_id`) REFERENCES `t_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_menu_action_per
-- ----------------------------
INSERT INTO `t_menu_action_per` VALUES (7, 2, 21);
INSERT INTO `t_menu_action_per` VALUES (7, 2, 22);
INSERT INTO `t_menu_action_per` VALUES (7, 2, 23);
INSERT INTO `t_menu_action_per` VALUES (7, 2, 24);
INSERT INTO `t_menu_action_per` VALUES (7, 2, 26);
INSERT INTO `t_menu_action_per` VALUES (7, 2, 28);
INSERT INTO `t_menu_action_per` VALUES (8, 2, 21);
INSERT INTO `t_menu_action_per` VALUES (8, 2, 22);
INSERT INTO `t_menu_action_per` VALUES (8, 2, 23);
INSERT INTO `t_menu_action_per` VALUES (8, 2, 24);
INSERT INTO `t_menu_action_per` VALUES (14, 2, 21);
INSERT INTO `t_menu_action_per` VALUES (14, 2, 22);
INSERT INTO `t_menu_action_per` VALUES (14, 2, 23);
INSERT INTO `t_menu_action_per` VALUES (14, 2, 24);
INSERT INTO `t_menu_action_per` VALUES (14, 16, 21);
INSERT INTO `t_menu_action_per` VALUES (14, 16, 22);
INSERT INTO `t_menu_action_per` VALUES (14, 16, 23);
INSERT INTO `t_menu_action_per` VALUES (14, 16, 24);
INSERT INTO `t_menu_action_per` VALUES (15, 2, 21);
INSERT INTO `t_menu_action_per` VALUES (15, 2, 22);
INSERT INTO `t_menu_action_per` VALUES (15, 2, 23);
INSERT INTO `t_menu_action_per` VALUES (15, 2, 24);
INSERT INTO `t_menu_action_per` VALUES (15, 16, 21);
INSERT INTO `t_menu_action_per` VALUES (15, 16, 22);
INSERT INTO `t_menu_action_per` VALUES (15, 16, 23);
INSERT INTO `t_menu_action_per` VALUES (15, 16, 24);
INSERT INTO `t_menu_action_per` VALUES (16, 1, 21);
INSERT INTO `t_menu_action_per` VALUES (16, 1, 22);
INSERT INTO `t_menu_action_per` VALUES (16, 1, 23);
INSERT INTO `t_menu_action_per` VALUES (16, 1, 24);
INSERT INTO `t_menu_action_per` VALUES (16, 16, 21);
INSERT INTO `t_menu_action_per` VALUES (19, 1, 21);
INSERT INTO `t_menu_action_per` VALUES (19, 1, 22);
INSERT INTO `t_menu_action_per` VALUES (19, 1, 23);
INSERT INTO `t_menu_action_per` VALUES (19, 1, 24);
INSERT INTO `t_menu_action_per` VALUES (19, 16, 21);
INSERT INTO `t_menu_action_per` VALUES (35, 1, 21);
INSERT INTO `t_menu_action_per` VALUES (35, 1, 22);
INSERT INTO `t_menu_action_per` VALUES (35, 1, 23);
INSERT INTO `t_menu_action_per` VALUES (35, 1, 24);
INSERT INTO `t_menu_action_per` VALUES (35, 16, 21);
INSERT INTO `t_menu_action_per` VALUES (38, 1, 21);
INSERT INTO `t_menu_action_per` VALUES (38, 1, 22);
INSERT INTO `t_menu_action_per` VALUES (38, 1, 23);
INSERT INTO `t_menu_action_per` VALUES (38, 1, 24);
INSERT INTO `t_menu_action_per` VALUES (38, 16, 21);
INSERT INTO `t_menu_action_per` VALUES (39, 1, 21);
INSERT INTO `t_menu_action_per` VALUES (39, 1, 22);
INSERT INTO `t_menu_action_per` VALUES (39, 1, 23);
INSERT INTO `t_menu_action_per` VALUES (39, 1, 24);
INSERT INTO `t_menu_action_per` VALUES (39, 16, 21);

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 ',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息头',
  `content` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `read` int(1) NULL DEFAULT NULL COMMENT ' 是否已读，1表示已读，0表示未读',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `from_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 发送消息人名',
  `to_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收消息人员',
  `fk_from_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，指向学员表',
  `fk_to_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，指向目标学员',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_from_student_id`(`fk_from_student_id`) USING BTREE,
  INDEX `fk_to_student_id`(`fk_to_student_id`) USING BTREE,
  CONSTRAINT `fk_from_student_id` FOREIGN KEY (`fk_from_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_to_student_id` FOREIGN KEY (`fk_to_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_message
-- ----------------------------
INSERT INTO `t_message` VALUES (2, 'java如何遍历三维数组？', '大哥教教我呗，我请你吃糖...', 0, '2020-07-15 15:10:54', '2020-07-15 15:10:54', NULL, '张三', '李四', NULL, NULL);
INSERT INTO `t_message` VALUES (7, 'java如何遍历三维数组？', '大哥教教我呗，我请你吃糖...', 0, '2020-07-15 16:23:38', '2020-07-15 16:23:38', NULL, '张三', '李四', 2, NULL);

-- ----------------------------
-- Table structure for t_news
-- ----------------------------
DROP TABLE IF EXISTS `t_news`;
CREATE TABLE `t_news`  (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '新闻资讯的id',
  `news_title` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻资讯的标题',
  `news_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻资讯的内容',
  `news_type` int(255) NULL DEFAULT NULL COMMENT '新闻资讯的类型',
  `news_publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻资讯的发起人',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '新闻资讯的新闻发布时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '新闻资讯的版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '新闻资讯的最后访问时间',
  `news_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻链接',
  `read_size` int(11) NULL DEFAULT NULL COMMENT '阅读量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '新闻资讯' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_news
-- ----------------------------
INSERT INTO `t_news` VALUES (1, '新闻标题', '高考内容', 1, '发起人', '2020-07-08 19:46:37', 1, '2020-07-08 19:46:37', 'www.baidu.com', 1);
INSERT INTO `t_news` VALUES (2, '贵州公交车坠湖', '随着7月7日安顺市公交车坠湖事件进展持续进行时，该消息已引发社会极其关注。。。', 1, '发起人', '2020-07-08 19:46:37', 1, '2020-07-08 19:46:37', 'www.baidu.com', 1);
INSERT INTO `t_news` VALUES (4, '高考生坐澡盆被民警护送进考场', '8日上午，昆明东川区4.2级地震。监控显示，汤丹中学正在上课，感知到地震后同学们不约而同迅速钻到课桌', 1, '发起人', '2020-07-09 09:25:26', 1, '2020-07-09 09:25:26', 'www.baidu.com', 1);
INSERT INTO `t_news` VALUES (5, '开考5分钟父亲取回准考证后大哭', '8日上午，昆明东川区4.2级地震。监控显示，汤丹中学正在上课，感知到地震后同学们不约而同迅速钻到课桌', 1, '发起人', '2020-07-09 09:25:28', 1, '2020-07-09 09:25:28', 'www.baidu.com', 1);
INSERT INTO `t_news` VALUES (6, '中国气象局连发三个预警', '7月8日18点，中国气象局连续发布地质灾害气象风险预警、暴雨橙色预警、山洪灾害气象预警三个预警', 1, '发起人', '2020-07-09 09:28:45', 1, '2020-07-09 09:28:45', 'www.baidu.com', 4890000);
INSERT INTO `t_news` VALUES (7, '新闻标题', '高考内容', 1, '发起人', '2020-07-10 15:51:36', 1, NULL, 'www.baidu.com', 1);
INSERT INTO `t_news` VALUES (8, '中国气象局连发三个预警', '7月8日18点，中国气象局连续发布地质灾害气象风险预警、暴雨橙色预警、山洪灾害气象预警三个预警', 1, '发起人', '2020-07-10 15:51:37', 2, '2020-07-10 15:53:12', 'www.baidu.com', 4890000);
INSERT INTO `t_news` VALUES (9, '地震瞬间昆弥学生1秒爆头避震', '8日上午，昆明东川区4.2级地震。监控显示，汤丹中学正在上课，感知到地震后同学们不约而同迅速钻到课桌', 1, '发起人', '2020-07-10 15:51:37', 1, NULL, 'www.baidu.com', 1);
INSERT INTO `t_news` VALUES (10, '高考生坐澡盆被民警护送进考场', '8日上午，昆明东川区4.2级地震。监控显示，汤丹中学正在上课，感知到地震后同学们不约而同迅速钻到课桌', 1, '发起人', '2020-07-10 15:51:37', 1, NULL, 'www.baidu.com', 6876450);
INSERT INTO `t_news` VALUES (11, '开考5分钟父亲取回准考证后大哭', '8日上午，昆明东川区4.2级地震。监控显示，汤丹中学正在上课，感知到地震后同学们不约而同迅速钻到课桌', 1, '发起人', '2020-07-10 15:51:37', 1, NULL, 'www.baidu.com', 200000);
INSERT INTO `t_news` VALUES (12, '社区书记凌晨嘶吼喊话救3200人', '8日上午，昆明东川区4.2级地震。监控显示，汤丹中学正在上课，感知到地震后同学们不约而同迅速钻到课桌', 1, '发起人', '2020-07-10 15:51:37', 1, NULL, 'www.baidu.com', 100000);

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告管理的id',
  `notice_title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告管理的标题',
  `notice_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告管理的内容',
  `notice_publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告管理的发布人',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '公告管理的的发布时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '公告管理的版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '公告管理的最后一次访问时间',
  `notice_status` int(1) NULL DEFAULT NULL COMMENT '公告状态，1表示已发布，0表示未发布',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公告管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES (1, '今日公告', '张某与7月8日被xxx公司录取成功，7000/月', 'teacher', '2020-07-08 16:53:29', 1, '2020-07-08 16:53:29', 1);
INSERT INTO `t_notice` VALUES (2, '高考福利大赠送', '高考即将结束，暑假即将来临...', 'teacher', '2020-07-08 16:53:29', 1, '2020-07-08 16:53:29', 1);
INSERT INTO `t_notice` VALUES (3, '好约课暑假福利发赠送', '好约课暑假福利大赠送，会员8折，学费全部九折...', '张老师', '2020-07-08 17:15:34', 3, '2020-07-10 15:43:10', 0);
INSERT INTO `t_notice` VALUES (4, '高考福利大赠送', '高考即将结束，暑假即将来临...', 'teacher', '2020-07-08 16:59:17', 1, '2020-07-08 16:59:17', 1);
INSERT INTO `t_notice` VALUES (5, '今日公告', '张某与7月8日被xxx公司录取成功，7000/月', 'teacher', '2020-07-08 18:39:52', 1, '2020-07-08 18:39:52', 1);
INSERT INTO `t_notice` VALUES (6, '今日公告', '张某与7月8日被xxx公司录取成功，7000/月', 'teacher', '2020-07-10 15:40:17', 1, NULL, 1);
INSERT INTO `t_notice` VALUES (7, '高考福利大赠送', '高考即将结束，暑假即将来临...', 'teacher', '2020-07-10 15:40:17', 1, NULL, 1);

-- ----------------------------
-- Table structure for t_org_institute
-- ----------------------------
DROP TABLE IF EXISTS `t_org_institute`;
CREATE TABLE `t_org_institute`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `institute_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '机构名称',
  `institute_type` int(1) NOT NULL COMMENT '机构类型,采用枚举，1表示学校机构，2 表示培训机构',
  `is_delete` int(1) NULL DEFAULT 0 COMMENT '是否逻辑删除，1表示未删除，0表示已删除',
  `version` int(3) NOT NULL COMMENT '版本号',
  `create_time` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `last_access_time` timestamp(0) NOT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '组织机构 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_org_institute
-- ----------------------------
INSERT INTO `t_org_institute` VALUES (1, '三山教育集团', 2, 1, 1, '2024-01-24 11:45:10', '2020-07-08 18:28:02');
INSERT INTO `t_org_institute` VALUES (2, '苏州大学', 1, 1, 1, '2024-01-24 11:45:16', '2020-07-08 18:29:51');
INSERT INTO `t_org_institute` VALUES (8, '苏州科技大学', 1, 0, 1, '2024-01-24 11:45:27', '2020-07-17 14:39:40');

-- ----------------------------
-- Table structure for t_perm_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_perm_menu`;
CREATE TABLE `t_perm_menu`  (
  `menu_id` int(11) NOT NULL,
  `perm_id` int(11) NOT NULL,
  PRIMARY KEY (`menu_id`, `perm_id`) USING BTREE,
  INDEX `fk_perm_menu_perm_id`(`perm_id`) USING BTREE,
  CONSTRAINT `fk_perm_menu_menu_id` FOREIGN KEY (`menu_id`) REFERENCES `t_menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_perm_menu_perm_id` FOREIGN KEY (`perm_id`) REFERENCES `t_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限与菜单的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_perm_menu
-- ----------------------------
INSERT INTO `t_perm_menu` VALUES (16, 1);
INSERT INTO `t_perm_menu` VALUES (19, 1);
INSERT INTO `t_perm_menu` VALUES (22, 1);
INSERT INTO `t_perm_menu` VALUES (35, 1);
INSERT INTO `t_perm_menu` VALUES (38, 1);
INSERT INTO `t_perm_menu` VALUES (39, 1);
INSERT INTO `t_perm_menu` VALUES (2, 2);
INSERT INTO `t_perm_menu` VALUES (7, 2);
INSERT INTO `t_perm_menu` VALUES (8, 2);
INSERT INTO `t_perm_menu` VALUES (14, 2);
INSERT INTO `t_perm_menu` VALUES (15, 2);
INSERT INTO `t_perm_menu` VALUES (23, 3);
INSERT INTO `t_perm_menu` VALUES (40, 3);
INSERT INTO `t_perm_menu` VALUES (45, 3);
INSERT INTO `t_perm_menu` VALUES (46, 3);
INSERT INTO `t_perm_menu` VALUES (25, 4);
INSERT INTO `t_perm_menu` VALUES (50, 4);
INSERT INTO `t_perm_menu` VALUES (51, 4);
INSERT INTO `t_perm_menu` VALUES (53, 4);
INSERT INTO `t_perm_menu` VALUES (54, 4);
INSERT INTO `t_perm_menu` VALUES (24, 11);
INSERT INTO `t_perm_menu` VALUES (47, 11);
INSERT INTO `t_perm_menu` VALUES (48, 11);
INSERT INTO `t_perm_menu` VALUES (49, 11);
INSERT INTO `t_perm_menu` VALUES (26, 15);
INSERT INTO `t_perm_menu` VALUES (29, 15);
INSERT INTO `t_perm_menu` VALUES (30, 15);
INSERT INTO `t_perm_menu` VALUES (31, 15);
INSERT INTO `t_perm_menu` VALUES (32, 15);
INSERT INTO `t_perm_menu` VALUES (33, 15);
INSERT INTO `t_perm_menu` VALUES (55, 15);
INSERT INTO `t_perm_menu` VALUES (27, 16);
INSERT INTO `t_perm_menu` VALUES (56, 16);
INSERT INTO `t_perm_menu` VALUES (57, 16);
INSERT INTO `t_perm_menu` VALUES (58, 16);
INSERT INTO `t_perm_menu` VALUES (59, 16);
INSERT INTO `t_perm_menu` VALUES (28, 17);
INSERT INTO `t_perm_menu` VALUES (34, 17);
INSERT INTO `t_perm_menu` VALUES (60, 17);
INSERT INTO `t_perm_menu` VALUES (61, 17);
INSERT INTO `t_perm_menu` VALUES (62, 17);
INSERT INTO `t_perm_menu` VALUES (1, 18);
INSERT INTO `t_perm_menu` VALUES (3, 18);
INSERT INTO `t_perm_menu` VALUES (4, 18);
INSERT INTO `t_perm_menu` VALUES (5, 18);
INSERT INTO `t_perm_menu` VALUES (29, 19);
INSERT INTO `t_perm_menu` VALUES (63, 19);
INSERT INTO `t_perm_menu` VALUES (64, 19);
INSERT INTO `t_perm_menu` VALUES (30, 20);
INSERT INTO `t_perm_menu` VALUES (65, 20);
INSERT INTO `t_perm_menu` VALUES (66, 20);
INSERT INTO `t_perm_menu` VALUES (31, 21);
INSERT INTO `t_perm_menu` VALUES (33, 21);
INSERT INTO `t_perm_menu` VALUES (67, 21);
INSERT INTO `t_perm_menu` VALUES (68, 21);
INSERT INTO `t_perm_menu` VALUES (70, 21);
INSERT INTO `t_perm_menu` VALUES (71, 21);
INSERT INTO `t_perm_menu` VALUES (32, 22);
INSERT INTO `t_perm_menu` VALUES (69, 22);
INSERT INTO `t_perm_menu` VALUES (33, 23);
INSERT INTO `t_perm_menu` VALUES (70, 23);
INSERT INTO `t_perm_menu` VALUES (71, 23);
INSERT INTO `t_perm_menu` VALUES (34, 24);
INSERT INTO `t_perm_menu` VALUES (72, 24);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `permission_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT 'id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1, '权限管理', '管理用户组权限的权限 后台管理权限', '2020-07-08 14:05:19', '2020-10-26 10:01:47', 3);
INSERT INTO `t_permission` VALUES (2, '用户管理', '管理用户的权限 后台管理权限', '2020-07-08 14:05:19', '2020-10-26 10:01:31', 3);
INSERT INTO `t_permission` VALUES (3, '资源管理', '管理网页资源的权限', '2020-07-08 14:05:19', '2020-10-26 09:47:15', 2);
INSERT INTO `t_permission` VALUES (4, '班级管理', '进入班级管理页面操作的权限', '2020-07-08 14:05:19', '2020-11-24 11:54:58', 5);
INSERT INTO `t_permission` VALUES (11, '培养方案', '进入培养方案页面的权限', '2020-10-14 13:29:31', '2020-11-24 11:55:55', 4);
INSERT INTO `t_permission` VALUES (15, '授课管理', '进入授课管理页面', '2020-10-26 14:12:26', '2020-11-24 11:56:35', 2);
INSERT INTO `t_permission` VALUES (16, '考试管理', '进入考试管理页面的权限', '2020-10-26 14:13:02', '2020-11-24 11:57:14', 2);
INSERT INTO `t_permission` VALUES (17, '考评管理', '进入考评管理页面的权限', '2020-10-26 14:13:32', '2020-11-24 11:57:50', 2);
INSERT INTO `t_permission` VALUES (18, '系统配置', '进入系统配置页面的权限', '2020-10-29 09:13:49', '2020-11-24 11:58:18', 3);
INSERT INTO `t_permission` VALUES (19, '数据分析', '进入数据分析页面的权限', '2020-10-29 09:15:22', '2020-11-24 11:58:45', 2);
INSERT INTO `t_permission` VALUES (20, '组织机构', '进入组织机构页面的权限', '2020-10-29 09:17:02', '2020-11-24 13:43:38', 2);
INSERT INTO `t_permission` VALUES (21, '通知公告', '拥有对通知公告的访问权限', '2020-11-24 11:58:48', '2020-11-24 13:44:01', 2);
INSERT INTO `t_permission` VALUES (22, '咨询管理', '拥有对咨询管理的访问权限', '2020-11-24 13:44:36', NULL, 1);
INSERT INTO `t_permission` VALUES (23, '意向客户', '拥有对意向客户的访问权限', '2020-11-24 13:45:12', NULL, 1);
INSERT INTO `t_permission` VALUES (24, '操作日志', '拥有对操作日志的管理权限', '2020-11-24 13:45:42', NULL, 1);

-- ----------------------------
-- Table structure for t_planmanager
-- ----------------------------
DROP TABLE IF EXISTS `t_planmanager`;
CREATE TABLE `t_planmanager`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '方案id',
  `plan_number` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方案编号',
  `plan_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方案名称',
  `plan_status` int(1) NOT NULL COMMENT '方案状态：1启用、2未启用',
  `plan_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '方案描述',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除：1、未删除、2已删除',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 124 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '方案管理表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_planmanager
-- ----------------------------
INSERT INTO `t_planmanager` VALUES (1, '	FA_20200612143616', 'Java企业开发课程', 1, '方案描述', 1, '2020-01-13 00:00:00', 1, '2020-01-13 00:00:00');
INSERT INTO `t_planmanager` VALUES (2, 'FA_20200327153221', '数据库开发课程', 1, 'JAVAEE企业全栈开发描述', 1, '2020-07-14 09:37:15', 15, '2020-12-05 10:19:09');
INSERT INTO `t_planmanager` VALUES (3, 'FA_20200327153222', '项目加强实训课程', 1, 'JAVAEE企业全栈开发描述', 1, '2020-07-14 09:37:15', 7, '2020-12-04 10:58:23');
INSERT INTO `t_planmanager` VALUES (4, 'FA_20200327153223', '全栈工程师课程', 1, 'JAVAEE企业全栈开发描述', 1, '2020-07-14 09:37:15', 7, '2020-12-04 10:58:23');

-- ----------------------------
-- Table structure for t_planmanager_course
-- ----------------------------
DROP TABLE IF EXISTS `t_planmanager_course`;
CREATE TABLE `t_planmanager_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fk_planmanager_id` int(11) NOT NULL COMMENT '方案id 外键',
  `fk_course_id` int(11) NOT NULL COMMENT '课程编号 外键',
  `stage_num` int(11) NOT NULL COMMENT '阶段编号',
  `stage_name` int(11) NULL DEFAULT NULL COMMENT '阶段名称',
  `course_order` int(11) NOT NULL COMMENT '阶段内课程排序',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除：1未删除、2已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建 时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_planmanager`(`fk_course_id`) USING BTREE,
  INDEX `fk_planmanager_course`(`fk_planmanager_id`) USING BTREE,
  CONSTRAINT `fk_course_planmanager` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_planmanager_course` FOREIGN KEY (`fk_planmanager_id`) REFERENCES `t_planmanager` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '方案和课程的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_planmanager_course
-- ----------------------------
INSERT INTO `t_planmanager_course` VALUES (1, 1, 1, 1, 1, 1, 0, '2020-07-10 18:57:05', 1);
INSERT INTO `t_planmanager_course` VALUES (12, 3, 1, 1, 1, 1, 0, '2020-12-02 16:32:57', 1);
INSERT INTO `t_planmanager_course` VALUES (13, 3, 1, 9, 9, 1, 0, '2020-12-02 16:33:12', 1);
INSERT INTO `t_planmanager_course` VALUES (14, 3, 5, 9, 9, 2, 0, '2020-12-02 16:33:25', 1);
INSERT INTO `t_planmanager_course` VALUES (16, 3, 1, 2, 2, 1, 0, '2020-12-03 09:02:05', 1);
INSERT INTO `t_planmanager_course` VALUES (22, 2, 4, 1, 1, 2, 1, '2020-12-04 15:08:55', 30);
INSERT INTO `t_planmanager_course` VALUES (25, 2, 3, 1, 1, 1, 1, '2020-12-05 10:32:38', 18);
INSERT INTO `t_planmanager_course` VALUES (26, 2, 3, 1, 1, 3, 1, '2020-12-05 10:32:48', 25);
INSERT INTO `t_planmanager_course` VALUES (27, 2, 1, 4, 4, 2, 1, '2020-12-05 10:32:56', 4);
INSERT INTO `t_planmanager_course` VALUES (28, 2, 4, 4, 4, 1, 1, '2020-12-05 10:33:06', 4);

-- ----------------------------
-- Table structure for t_poll_ltem
-- ----------------------------
DROP TABLE IF EXISTS `t_poll_ltem`;
CREATE TABLE `t_poll_ltem`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '考评选项id',
  `poll_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考评选项编号',
  `poll_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考评内容',
  `poll_status` int(1) NOT NULL COMMENT '是否启用：1.启用 2.禁用',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考评选项表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_poll_ltem
-- ----------------------------

-- ----------------------------
-- Table structure for t_poll_record
-- ----------------------------
DROP TABLE IF EXISTS `t_poll_record`;
CREATE TABLE `t_poll_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考评ip地址',
  `poll_score` double(5, 2) NOT NULL COMMENT '考评得分',
  `poll_count` int(10) NOT NULL COMMENT '考评选项条数',
  `poll_suggest` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考评建议',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `create_time` timestamp(0) NOT NULL COMMENT '考评时间',
  `poll_status` tinyint(1) NULL DEFAULT NULL COMMENT '考评状态0.有效 1.无效',
  `fk_teacher_poll_id` int(11) NOT NULL COMMENT '外键，教师考评id',
  `poll_item_1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_7` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_8` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_9` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_10` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_11` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_12` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_13` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_14` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  `poll_item_15` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所选模块中第一条,采用 条件:分值 的格式存储',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_teacher_poll_id`(`fk_teacher_poll_id`) USING BTREE,
  CONSTRAINT `fk_teacher_poll_id` FOREIGN KEY (`fk_teacher_poll_id`) REFERENCES `t_teacher_poll` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考评记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_poll_record
-- ----------------------------

-- ----------------------------
-- Table structure for t_poll_template
-- ----------------------------
DROP TABLE IF EXISTS `t_poll_template`;
CREATE TABLE `t_poll_template`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '模板id',
  `template_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板内容',
  `template_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板名称',
  `template_num` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板编号',
  `template_status` int(1) NOT NULL COMMENT '模板状态：1.启用 2.未启用',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考评模板表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_poll_template
-- ----------------------------

-- ----------------------------
-- Table structure for t_profession
-- ----------------------------
DROP TABLE IF EXISTS `t_profession`;
CREATE TABLE `t_profession`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键 专业id',
  `prof_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专业名称',
  `prof_desc` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业描述',
  `prof_status` int(1) NOT NULL COMMENT '专业启用状态 1：已启用 2：未启用',
  `institute_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属机构名称',
  `institute_branch_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属机构下的分支名',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '是否删除 1:正常 0：删除',
  `order_profe_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旧的专业名称',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `fk_branch_id` int(11) NULL DEFAULT NULL COMMENT '外键',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `constraint_fk_branch_id`(`fk_branch_id`) USING BTREE,
  CONSTRAINT `constraint_fk_branch_id` FOREIGN KEY (`fk_branch_id`) REFERENCES `t_branch_institute` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '专业表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_profession
-- ----------------------------
INSERT INTO `t_profession` VALUES (1, '软件测试', '测试数据内容', 1, '三山教育集团', '苏州分中心', 1, NULL, NULL, '2020-07-08 12:14:55', NULL, 4);
INSERT INTO `t_profession` VALUES (2, '软件开发', 'Java方向的软件开发', 1, '三山教育集团', '上海分中心', 1, '软件开发', 7, '2020-12-03 17:28:25', '2020-12-03 17:28:23', 5);
INSERT INTO `t_profession` VALUES (3, '计算机科学与技术', 'wqeq', 1, '苏州大学', ' 计算机学院', 0, '天龙八', 3, '2020-11-25 13:59:32', '2020-11-25 13:59:32', 6);
INSERT INTO `t_profession` VALUES (4, '电子工程', 'we', 1, '苏州大学', '电子信息学院', 0, NULL, 1, '2020-11-25 09:33:39', NULL, 7);
INSERT INTO `t_profession` VALUES (5, '物联网', 'QWEQW', 1, '苏州科技大学', '物联网学院', 0, NULL, 1, '2020-11-25 13:32:42', NULL, 8);
INSERT INTO `t_profession` VALUES (6, '智能制造', 'QWEQW', 0, '苏州科技大学', '物联网学院', 0, NULL, 1, '2020-11-25 14:18:39', NULL, 8);
INSERT INTO `t_profession` VALUES (7, '电子工程', 'QWEQW', 0, '苏州科技大学', '物联网学院', 0, NULL, 1, '2020-11-25 14:18:59', NULL, 8);

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '问答时间',
  `question_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '问答内容',
  `question_type` int(1) NULL DEFAULT NULL COMMENT '问答类型，1 评论，0 问题',
  `question_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提问者',
  `favour_count` int(10) NULL DEFAULT NULL COMMENT '点赞数',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `fk_video_id` int(11) NULL DEFAULT NULL COMMENT '外键，视频ID',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员ID',
  `fk_class_id` int(11) NULL DEFAULT NULL COMMENT '外键，班级ID',
  `fk_course_id` int(11) NULL DEFAULT NULL COMMENT '外键，课程ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_question_video_id`(`fk_video_id`) USING BTREE,
  INDEX `fk_question_student_id`(`fk_student_id`) USING BTREE,
  INDEX `fk_question_class_id`(`fk_class_id`) USING BTREE,
  INDEX `fk_question_couse_id`(`fk_course_id`) USING BTREE,
  CONSTRAINT `fk_question_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_question_couse_id` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_question_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_question_video_id` FOREIGN KEY (`fk_video_id`) REFERENCES `t_video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频问答表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_question
-- ----------------------------

-- ----------------------------
-- Table structure for t_question_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_question_reply`;
CREATE TABLE `t_question_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `reply_content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复内容',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '回复时间',
  `reply_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复人',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次修改时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `fk_video_question_id` int(11) NULL DEFAULT NULL COMMENT '外键，视频问答表ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_video_question_reply_question_id`(`fk_video_question_id`) USING BTREE,
  CONSTRAINT `fk_video_question_reply_question_id` FOREIGN KEY (`fk_video_question_id`) REFERENCES `t_question` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频问答回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_question_reply
-- ----------------------------

-- ----------------------------
-- Table structure for t_release
-- ----------------------------
DROP TABLE IF EXISTS `t_release`;
CREATE TABLE `t_release`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '发布时间',
  `ver` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版本号，不是其它实体类的那种更新版本号',
  `description` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '此发布版本的描述',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_release
-- ----------------------------
INSERT INTO `t_release` VALUES (4, '2020-07-08 14:24:31', 'Ver 1.1', '此版本修复了之前版本的很多bug', NULL);
INSERT INTO `t_release` VALUES (5, '2020-07-08 14:25:18', 'Ver 1.1', '学海无涯版', NULL);

-- ----------------------------
-- Table structure for t_release_log
-- ----------------------------
DROP TABLE IF EXISTS `t_release_log`;
CREATE TABLE `t_release_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发布日志内容',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新增、修复bug、提高效率等',
  `seq` int(11) NULL DEFAULT NULL COMMENT '序号',
  `fk_release_id` int(11) NULL DEFAULT NULL COMMENT '外键，发布的版本ID',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建日期',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_release_log_release_id`(`fk_release_id`) USING BTREE,
  CONSTRAINT `fk_release_log_release_id` FOREIGN KEY (`fk_release_id`) REFERENCES `t_release` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统新版本时的更新日志' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_release_log
-- ----------------------------
INSERT INTO `t_release_log` VALUES (2, '修复了并发时造成的死锁问题', 'Bug', 1, 5, '2020-07-08 15:09:06');
INSERT INTO `t_release_log` VALUES (3, '添加了动态加载的功能', '新增', 2, 5, '2020-07-08 14:32:24');

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `resource_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `resource_type` int(1) NULL DEFAULT NULL COMMENT '资源类型, 1 表示课程资源，2 表示公共资源',
  `resource_suffix` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源扩展名，如：docx, ppt, md, 等',
  `resource_size` int(10) NULL DEFAULT NULL COMMENT '资源大小',
  `resource_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源标题',
  `resource_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件路径',
  `resource_label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源标签',
  `resource_desc` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除，1表示未删除，0表示已删除',
  `fk_section_id` int(11) NULL DEFAULT NULL COMMENT '外键，节ID',
  `fk_chapter_id` int(11) NULL DEFAULT NULL COMMENT '外键，章节ID',
  `fk_course_id` int(11) NULL DEFAULT NULL COMMENT '外键，课程ID',
  `fk_resource_type_id` int(11) NULL DEFAULT NULL COMMENT '外键，资源类型ID',
  `old_resourcename` int(11) NULL DEFAULT NULL COMMENT '旧资源名称',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_resource_chapter_id`(`fk_chapter_id`) USING BTREE,
  INDEX `fk_resource_section_id`(`fk_section_id`) USING BTREE,
  INDEX `fk_resource_course_id`(`fk_course_id`) USING BTREE,
  INDEX `fk_resource_resource_type_id`(`fk_resource_type_id`) USING BTREE,
  CONSTRAINT `fk_resource_chapter_id` FOREIGN KEY (`fk_chapter_id`) REFERENCES `t_chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_resource_course_id` FOREIGN KEY (`fk_course_id`) REFERENCES `t_course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_resource_resource_type_id` FOREIGN KEY (`fk_resource_type_id`) REFERENCES `t_resource_type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_resource_section_id` FOREIGN KEY (`fk_section_id`) REFERENCES `t_section` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES (1, 'springboot学习笔记', 1, '.pdf', 6165, NULL, NULL, NULL, ' 很好的学习笔记', '2020-07-13 09:09:24', 1, 1, 1, 1, 1, NULL, 1, NULL);

-- ----------------------------
-- Table structure for t_resource_type
-- ----------------------------
DROP TABLE IF EXISTS `t_resource_type`;
CREATE TABLE `t_resource_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `type_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型名称',
  `type_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源描述',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除，1表示未删除，0表示已删除',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源类型 表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_resource_type
-- ----------------------------
INSERT INTO `t_resource_type` VALUES (1, '公共资源', '公开的资源 ', '2020-07-08 19:07:12', 1, NULL, '2020-07-16 14:35:27');
INSERT INTO `t_resource_type` VALUES (5, '课程资源', '课程资源', '2020-07-10 11:59:01', 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名',
  `role_description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `fk_parent_id` int(11) NULL DEFAULT NULL COMMENT '父角色',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_pid_copy_1`(`fk_parent_id`) USING BTREE,
  CONSTRAINT `fk_pid_copy_1` FOREIGN KEY (`fk_parent_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '测试', '测试', '2020-07-08 10:25:18', '2020-07-10 15:37:44', 2, NULL);
INSERT INTO `t_role` VALUES (2, '开发', '开发', '2020-07-08 10:25:18', '2020-10-24 16:34:56', 1, NULL);
INSERT INTO `t_role` VALUES (3, '教务', '教务', '2020-07-08 10:25:18', '2020-10-24 16:34:59', 1, NULL);
INSERT INTO `t_role` VALUES (4, '咨询', '咨询', '2020-07-08 10:25:18', '2020-10-24 16:35:01', 1, NULL);
INSERT INTO `t_role` VALUES (5, '教师', '教师', '2020-10-12 16:24:25', '2020-10-24 16:35:03', 1, NULL);
INSERT INTO `t_role` VALUES (6, '管理员', 'admin', '2020-10-12 16:24:49', '2020-10-26 10:14:53', 2, NULL);
INSERT INTO `t_role` VALUES (21, '一般用户', '普通用户，无特殊权限，正常浏览，无可用进阶访问操作', '2020-10-26 14:11:37', NULL, 1, NULL);

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`, `permission_id`) USING BTREE,
  INDEX `fk_permission_id`(`permission_id`) USING BTREE,
  CONSTRAINT `fk_permission_id` FOREIGN KEY (`permission_id`) REFERENCES `t_permission` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_role_permission_role_id` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与权限的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (6, 1);
INSERT INTO `t_role_permission` VALUES (2, 2);
INSERT INTO `t_role_permission` VALUES (5, 2);
INSERT INTO `t_role_permission` VALUES (6, 2);
INSERT INTO `t_role_permission` VALUES (2, 3);
INSERT INTO `t_role_permission` VALUES (5, 3);
INSERT INTO `t_role_permission` VALUES (6, 3);
INSERT INTO `t_role_permission` VALUES (2, 4);
INSERT INTO `t_role_permission` VALUES (3, 4);
INSERT INTO `t_role_permission` VALUES (5, 4);
INSERT INTO `t_role_permission` VALUES (6, 4);
INSERT INTO `t_role_permission` VALUES (2, 11);
INSERT INTO `t_role_permission` VALUES (5, 11);
INSERT INTO `t_role_permission` VALUES (6, 11);
INSERT INTO `t_role_permission` VALUES (2, 15);
INSERT INTO `t_role_permission` VALUES (5, 15);
INSERT INTO `t_role_permission` VALUES (6, 15);
INSERT INTO `t_role_permission` VALUES (21, 15);
INSERT INTO `t_role_permission` VALUES (5, 16);
INSERT INTO `t_role_permission` VALUES (6, 16);
INSERT INTO `t_role_permission` VALUES (3, 17);
INSERT INTO `t_role_permission` VALUES (5, 17);
INSERT INTO `t_role_permission` VALUES (6, 17);
INSERT INTO `t_role_permission` VALUES (6, 18);
INSERT INTO `t_role_permission` VALUES (6, 19);
INSERT INTO `t_role_permission` VALUES (6, 20);
INSERT INTO `t_role_permission` VALUES (5, 21);
INSERT INTO `t_role_permission` VALUES (6, 21);
INSERT INTO `t_role_permission` VALUES (3, 22);
INSERT INTO `t_role_permission` VALUES (6, 22);
INSERT INTO `t_role_permission` VALUES (1, 23);
INSERT INTO `t_role_permission` VALUES (4, 23);
INSERT INTO `t_role_permission` VALUES (6, 23);
INSERT INTO `t_role_permission` VALUES (6, 24);

-- ----------------------------
-- Table structure for t_section
-- ----------------------------
DROP TABLE IF EXISTS `t_section`;
CREATE TABLE `t_section`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '节id',
  `section_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '节名称',
  `section_number` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '节编号',
  `section_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节描述',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `video_status` int(1) NULL DEFAULT NULL COMMENT '视频观看状态：1允许观看、2不允许观看',
  `fk_chapter_id` int(11) NOT NULL COMMENT '章id',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除：1未删除、0已删除',
  `experiment_ducument_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验文档',
  `experiment_environment_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验环境地址',
  `experiment_instrusction` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '实验指令',
  `experiment` int(1) NULL DEFAULT NULL COMMENT '是否开启实验：1开启实验、不开启实验',
  `look_video_status` int(1) NOT NULL COMMENT '查看视频状态，1表示可以，0表示不可以',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_section_chapter`(`fk_chapter_id`) USING BTREE,
  CONSTRAINT `fk_section_chapter` FOREIGN KEY (`fk_chapter_id`) REFERENCES `t_chapter` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程列表中的节表，可以关联多段视频' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_section
-- ----------------------------
INSERT INTO `t_section` VALUES (1, '节名称1', '节编号1', NULL, '2020-07-08 19:06:01', 1, 1, 1, NULL, NULL, NULL, NULL, 1, NULL, NULL);
INSERT INTO `t_section` VALUES (2, '节名称2', '节编号2', NULL, '2020-07-08 19:06:01', 1, 2, 1, NULL, NULL, NULL, NULL, 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_section_video
-- ----------------------------
DROP TABLE IF EXISTS `t_section_video`;
CREATE TABLE `t_section_video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fk_section_id` int(11) NOT NULL COMMENT '节ID',
  `fk_video_id` int(11) NOT NULL COMMENT '视频ID',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_section_video_section_id`(`fk_section_id`) USING BTREE,
  INDEX `fk_video_section_id`(`fk_video_id`) USING BTREE,
  CONSTRAINT `fk_section_video_section_id` FOREIGN KEY (`fk_section_id`) REFERENCES `t_section` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_video_section_id` FOREIGN KEY (`fk_video_id`) REFERENCES `t_video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程节与视频的关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_section_video
-- ----------------------------
INSERT INTO `t_section_video` VALUES (1, 1, 1, '2020-07-10 18:59:31', '2020-07-10 18:59:31', 1);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录学员的用户名',
  `stu_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码，采用密文存储',
  `stu_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学号',
  `stu_phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学员手机号',
  `stu_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学员邮箱',
  `stu_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学员真实姓名',
  `email_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email密文',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别，1表示男，0表示女，-1 表示未知',
  `card_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `status` int(1) NULL DEFAULT NULL COMMENT ' 用户状态，1表示启用，0表示禁用',
  `effective_date` date NULL DEFAULT NULL COMMENT '截止有效期限',
  `birth` date NULL DEFAULT NULL COMMENT '学员生日',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片路径',
  `description` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户描述信息',
  `stu_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学员的类型，如：应届生，往届生',
  `stu_school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学员就读的大学',
  `stu_college` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT ' 学员所在的院系',
  `stu_major` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业',
  `stu_education` int(1) NULL DEFAULT NULL COMMENT '学历，枚举，1.博士，2.硕士，3. 本科，4.专科，5.高中，6.中职，7.其它',
  `english_level` int(1) NULL DEFAULT NULL COMMENT '英语水平，枚举，1.AB,2.4级，3. 6级，4.8级， 5. 雅思，6，托福',
  `perfect_status` int(1) NOT NULL DEFAULT 0 COMMENT '个人资料是否完善，1表示已完善，0表示未完善',
  `is_delete` int(1) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NOT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT 1 COMMENT '版本号',
  `fk_class_id` int(11) NULL DEFAULT NULL COMMENT '外键 ，班级ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_student_class_id`(`fk_class_id`) USING BTREE,
  CONSTRAINT `fk_student_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表，包含管理员，教师，咨询师等用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (1, '楚云飞', '123456', '20240101', '13899007766', 'cyf@163.com', '楚云飞', NULL, 1, NULL, NULL, '2020-12-31', NULL, NULL, NULL, '应届生', NULL, NULL, NULL, NULL, NULL, 0, 1, '2020-07-08 12:18:10', NULL, 1, 1);
INSERT INTO `t_student` VALUES (2, '周芷若', '123456', '20240102', '18655442288', ' zzr@163.com', '周芷若', NULL, 0, NULL, NULL, NULL, NULL, NULL, NULL, '应届生', NULL, NULL, NULL, NULL, NULL, 0, 0, '2020-07-15 16:22:21', NULL, 1, 1);

-- ----------------------------
-- Table structure for t_student_note
-- ----------------------------
DROP TABLE IF EXISTS `t_student_note`;
CREATE TABLE `t_student_note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `note_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '笔记标题',
  `note_content` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '笔记简要内容',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次修改时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员id',
  `fk_course_id` int(11) NULL DEFAULT NULL COMMENT '外键，属性哪一门做的笔记',
  `fk_video_id` int(11) NULL DEFAULT NULL COMMENT '外键，在看哪一个视频时做的笔记',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_cascade_student_note_id`(`fk_student_id`) USING BTREE,
  CONSTRAINT `fk_cascade_student_note_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学员笔记表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student_note
-- ----------------------------

-- ----------------------------
-- Table structure for t_student_report
-- ----------------------------
DROP TABLE IF EXISTS `t_student_report`;
CREATE TABLE `t_student_report`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建 时间',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `chapter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章名',
  `section_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节名',
  `video_study_time` int(10) NULL DEFAULT NULL COMMENT '视频学习时长，单位为秒',
  `homework_count` int(10) NULL DEFAULT NULL COMMENT '作业数量',
  `question_count` int(10) NULL DEFAULT NULL COMMENT '提问数量',
  `leave_count` int(10) NULL DEFAULT NULL COMMENT '请假次数',
  `illegal_count` int(10) NULL DEFAULT NULL COMMENT '违纪次数',
  `note_count` int(10) NULL DEFAULT NULL COMMENT '笔记个数',
  `exam_count` int(10) NULL DEFAULT NULL COMMENT '考试次数',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员ID',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_student_report_stu_id`(`fk_student_id`) USING BTREE,
  CONSTRAINT `fk_student_report_stu_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学员学习进度报告' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_student_report
-- ----------------------------

-- ----------------------------
-- Table structure for t_studyrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_studyrecord`;
CREATE TABLE `t_studyrecord`  (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '学习记录id',
  `progress_status` int(255) NOT NULL COMMENT '学习进度标识 1:未观看或未观看结束 2:已观看结(只有为2时，才能观看下一个视频)',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `fk_student_id` int(11) NOT NULL COMMENT '学员id',
  `fk_section_id` int(11) NULL DEFAULT NULL COMMENT '课程节的ID',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程名称， 冗余设计，减少关联',
  `chapter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章名称，冗余设计，减少关联',
  `section_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节名称，冗余设计',
  `video_rate` double(12, 0) NULL DEFAULT NULL COMMENT '视频观看最大进度,因为有可能会有多次查看视频，单位为秒',
  `video_length` int(11) NULL DEFAULT NULL COMMENT '视频时长',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_student_id`(`fk_student_id`) USING BTREE,
  CONSTRAINT `fk_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '学生学习记录表, 每打开一节时，就产生一条记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_studyrecord
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_statistics
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_statistics`;
CREATE TABLE `t_sys_statistics`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '记录时间',
  `online_count` int(11) NULL DEFAULT NULL COMMENT '在线人数',
  `access_count` int(11) NULL DEFAULT NULL COMMENT '访问人数',
  `clazz_count` int(11) NULL DEFAULT NULL COMMENT '班级数量',
  `student_count` int(11) NULL DEFAULT NULL COMMENT '学员数量',
  `plan_count` int(11) NULL DEFAULT NULL COMMENT '方案数量',
  `course_count` int(11) NULL DEFAULT NULL COMMENT '课程数量',
  `video_count` int(11) NULL DEFAULT NULL COMMENT '视频数量',
  `doc_count` int(11) NULL DEFAULT NULL COMMENT '文档资源数量',
  `exam_count` int(11) NULL DEFAULT NULL COMMENT '试卷数量',
  `test_item_count` int(11) NULL DEFAULT NULL COMMENT '题库数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统 统计表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_statistics
-- ----------------------------

-- ----------------------------
-- Table structure for t_syslog
-- ----------------------------
DROP TABLE IF EXISTS `t_syslog`;
CREATE TABLE `t_syslog`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '日志主题(菜单标题)',
  `module_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作模块名',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作菜单名',
  `ip_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip地址',
  `method` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求方法',
  `request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志类型【后台管理或是学员访问】',
  `login_user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `last_access_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '最后访问时间',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_syslog
-- ----------------------------

-- ----------------------------
-- Table structure for t_system_config
-- ----------------------------
DROP TABLE IF EXISTS `t_system_config`;
CREATE TABLE `t_system_config`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `system_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统名称',
  `copy_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版权所属',
  `login_page_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录页LOGO',
  `system_page_logo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '系统页LOGO',
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `login_count` int(11) NULL DEFAULT NULL COMMENT '登录次数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统信息配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_system_config
-- ----------------------------
INSERT INTO `t_system_config` VALUES (1, '苏州青英培训学校（乐码学院）', '苏州青英培训学校（乐码学院）', 'img/copy', 'img/system', '2024-01-24 13:53:12', 1, NULL, NULL);

-- ----------------------------
-- Table structure for t_teacher_poll
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher_poll`;
CREATE TABLE `t_teacher_poll`  (
  `id` int(64) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `teacher_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '老师名称',
  `class_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '班级',
  `poll_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考评地址',
  `poll_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考评成绩',
  `effective_time` timestamp(0) NULL DEFAULT NULL COMMENT '有效期',
  `poll_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '考评状态 1:未开始 2:进行中 3:已结束(未审核) 4:已结束(已审核)',
  `poll_count` int(11) NOT NULL COMMENT '考评人数',
  `poll_suggest` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '考评建议',
  `fk_template_id` int(128) NOT NULL COMMENT '模板id',
  `fk_user_id` int(128) NOT NULL COMMENT '用户id',
  `fk_class_id` int(128) NOT NULL COMMENT '班级id',
  `allow_ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '允许ip地址',
  `ip_limit` int(1) NULL DEFAULT NULL COMMENT '是否限定IP网段, 1表示限定，0表示不限定',
  `start_time` timestamp(0) NOT NULL COMMENT '开始时间',
  `end_time` timestamp(0) NOT NULL COMMENT '结束时间',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后访问时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_teacher_poll_template_id`(`fk_template_id`) USING BTREE,
  INDEX `fk_teacher_poll_user_id`(`fk_user_id`) USING BTREE,
  INDEX `fk_teacher_poll_class_id`(`fk_class_id`) USING BTREE,
  CONSTRAINT `fk_teacher_poll_class_id` FOREIGN KEY (`fk_class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacher_poll_template_id` FOREIGN KEY (`fk_template_id`) REFERENCES `t_poll_template` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_teacher_poll_user_id` FOREIGN KEY (`fk_user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老师考评表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_teacher_poll
-- ----------------------------

-- ----------------------------
-- Table structure for t_template_item
-- ----------------------------
DROP TABLE IF EXISTS `t_template_item`;
CREATE TABLE `t_template_item`  (
  `poll_id` int(11) NOT NULL COMMENT '考评选项id',
  `template_id` int(11) NOT NULL COMMENT '考评模板id',
  PRIMARY KEY (`poll_id`, `template_id`) USING BTREE,
  INDEX `fk_template_id`(`template_id`) USING BTREE,
  CONSTRAINT `fk_poll_id` FOREIGN KEY (`poll_id`) REFERENCES `t_poll_ltem` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_template_id` FOREIGN KEY (`template_id`) REFERENCES `t_poll_template` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '考评选项、考评模板的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_template_item
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT ' 主键',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录用户名',
  `user_pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码，采用密文存储',
  `user_phone` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户手机号',
  `real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `user_email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `email_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'email密文',
  `gender` int(1) NULL DEFAULT NULL COMMENT '性别',
  `card_num` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号码',
  `status` int(1) NULL DEFAULT NULL COMMENT ' 用户状态，1表示启用，0表示禁用',
  `effective_date` date NULL DEFAULT NULL COMMENT '截止有效期限',
  `user_type` int(1) NULL DEFAULT NULL COMMENT '用户类型，采用枚举下标存储',
  `birth` date NULL DEFAULT NULL COMMENT '用户生日',
  `image_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像图片路径',
  `description` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户描述信息',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '员工用户的职位',
  `perfect_status` int(1) NOT NULL DEFAULT 0 COMMENT '个人资料是否完善，1表示已完善，0表示未完善',
  `is_delete` int(1) NULL DEFAULT 1 COMMENT ' 是否已经逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT 1 COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 50 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表，包含管理员，教师，咨询师等用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '123456', '18099002255', '叶加飞', 'yejf@lemait.com', 'yejf_securet@kclmedu.com', 1, '362581190890234456', 1, '2022-01-12', 1, '1980-01-30', NULL, '描述用户', '管理员', 0, 1, '2020-07-07 16:35:22', '2024-01-24 11:38:17', 1);
INSERT INTO `t_user` VALUES (7, 'gaojj', '123456', '18011223344', '高静静', 'gaojj@lemait.com', NULL, 0, '362581190890234458', 1, '2020-10-31', 1, NULL, NULL, NULL, ' 咨询师', 0, 1, NULL, '2020-11-20 17:25:20', 1);
INSERT INTO `t_user` VALUES (8, 'lvhx', '123456', '13800001111', '吕海侠', 'lvhx@lemait.com', NULL, 0, '362581190890234459', 1, '2021-01-28', 1, NULL, NULL, NULL, ' 项目经理', 0, 1, NULL, NULL, 1);

-- ----------------------------
-- Table structure for t_user_class
-- ----------------------------
DROP TABLE IF EXISTS `t_user_class`;
CREATE TABLE `t_user_class`  (
  `user_id` int(11) NOT NULL COMMENT '用户外键ID',
  `class_id` int(11) NOT NULL COMMENT '班级外键ID',
  PRIMARY KEY (`user_id`, `class_id`) USING BTREE,
  INDEX `fk_class_id_20201204`(`class_id`) USING BTREE,
  CONSTRAINT `fk_class_id_20201204` FOREIGN KEY (`class_id`) REFERENCES `t_class` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_id_20201204` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '老师(用户)和班级的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_class
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_group
-- ----------------------------
DROP TABLE IF EXISTS `t_user_group`;
CREATE TABLE `t_user_group`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `group_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `group_id`) USING BTREE,
  INDEX `fk_gourp_id`(`group_id`) USING BTREE,
  CONSTRAINT `fk_gourp_id` FOREIGN KEY (`group_id`) REFERENCES `t_group` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户t_user表和组t_group表的中间表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_user_group
-- ----------------------------
INSERT INTO `t_user_group` VALUES (1, 24);
INSERT INTO `t_user_group` VALUES (7, 30);
INSERT INTO `t_user_group` VALUES (8, 38);

-- ----------------------------
-- Table structure for t_video
-- ----------------------------
DROP TABLE IF EXISTS `t_video`;
CREATE TABLE `t_video`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `video_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频名',
  `type` int(3) NULL DEFAULT NULL COMMENT '类型，1 表示单一视频， 2表示 视频合辑',
  `fk_parent_id` int(11) NULL DEFAULT NULL COMMENT '外键，父文件夹',
  `video_count` int(11) NULL DEFAULT 1 COMMENT '视频个数，如果是视视频合辑，就是总数，如果是单一视频，就是1',
  `video_length` double(8, 1) NULL DEFAULT NULL COMMENT '视频时长，以秒为存储单位',
  `video_size` bigint(20) NULL DEFAULT NULL COMMENT '视频大小，以字节为单位',
  `video_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频来源，也就是视频上传者',
  `status` int(1) NULL DEFAULT NULL COMMENT '视频状态，1表示通过，0表示未通过审核',
  `video_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频路径',
  `video_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '视频描述',
  `is_delete` int(1) NULL DEFAULT NULL COMMENT '逻辑删除，1表示未删除，0表示已删除',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_video_parent_id`(`fk_parent_id`) USING BTREE,
  CONSTRAINT `fk_video_parent_id` FOREIGN KEY (`fk_parent_id`) REFERENCES `t_video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_video
-- ----------------------------
INSERT INTO `t_video` VALUES (1, 'java基本语法', 1, NULL, 1, 123456.0, 1234, 'tanj', 1, NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `t_video` VALUES (2, 'java面向对象编程', 1, NULL, 2, 123456.0, 1234, 'zhang_hy', 1, NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `t_video` VALUES (3, 'jsp视频合集', 2, NULL, 5, 123456.0, 1234, 'zhang_hy', 1, NULL, NULL, 1, NULL, NULL, NULL);
INSERT INTO `t_video` VALUES (4, 'jsp-day1', 1, 3, 1, 123456.0, 1234, 'zhang_hy', 1, NULL, NULL, 1, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_video_collect
-- ----------------------------
DROP TABLE IF EXISTS `t_video_collect`;
CREATE TABLE `t_video_collect`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fk_student_id` int(11) NULL DEFAULT NULL COMMENT '外键，收藏的学员ID',
  `fk_section_id` int(11) NULL DEFAULT NULL COMMENT '外键，节ID',
  `fk_video_id` int(11) NULL DEFAULT NULL COMMENT '外键，收藏的视频ID',
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名',
  `chapter_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '章名',
  `section_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '节名',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '收藏时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_video_student_id`(`fk_student_id`) USING BTREE,
  INDEX `fk_video_video_id`(`fk_video_id`) USING BTREE,
  CONSTRAINT `fk_video_student_id` FOREIGN KEY (`fk_student_id`) REFERENCES `t_student` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_video_video_id` FOREIGN KEY (`fk_video_id`) REFERENCES `t_video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频收藏记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_video_collect
-- ----------------------------
INSERT INTO `t_video_collect` VALUES (3, 2, NULL, NULL, 'mysql从入门到精通', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_videowatch_history
-- ----------------------------
DROP TABLE IF EXISTS `t_videowatch_history`;
CREATE TABLE `t_videowatch_history`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `fk_study_record_id` int(11) NULL DEFAULT NULL COMMENT '外键，学员ID',
  `watch_position` double(10, 1) NULL DEFAULT NULL COMMENT '已观看时间，单位为秒',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建 时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_study_record_id`(`fk_study_record_id`) USING BTREE,
  CONSTRAINT `fk_study_record_id` FOREIGN KEY (`fk_study_record_id`) REFERENCES `t_studyrecord` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '视频播放历史表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_videowatch_history
-- ----------------------------

-- ----------------------------
-- Table structure for t_videowatch_record
-- ----------------------------
DROP TABLE IF EXISTS `t_videowatch_record`;
CREATE TABLE `t_videowatch_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '观看绝对历史id',
  `start_time` timestamp(0) NOT NULL COMMENT '开始时间',
  `start_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '开始位置，记录第几章节',
  `end_time` timestamp(0) NOT NULL COMMENT '结束时间',
  `end_position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '结束位置',
  `fk_video_id` int(11) NOT NULL COMMENT '外键，视频id',
  `fk_studyrecord_id` int(11) NULL DEFAULT NULL COMMENT '外键，学习记录id',
  `current_progress` double(12, 0) NULL DEFAULT NULL COMMENT '当前视频看到的位置，以秒为单位',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  `last_access_time` timestamp(0) NULL DEFAULT NULL COMMENT '最后一次访问时间',
  `version` int(3) NULL DEFAULT NULL COMMENT '版本',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_studyrecord_id`(`fk_studyrecord_id`) USING BTREE,
  INDEX `fk_video_id_name`(`fk_video_id`) USING BTREE,
  CONSTRAINT `fk_studyrecord_id` FOREIGN KEY (`fk_studyrecord_id`) REFERENCES `t_studyrecord` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_video_id_name` FOREIGN KEY (`fk_video_id`) REFERENCES `t_video` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '看视频记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_videowatch_record
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
