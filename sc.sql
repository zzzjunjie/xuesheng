/*
 Navicat Premium Data Transfer

 Source Server         : zhou-server
 Source Server Type    : MySQL
 Source Server Version : 50646
 Source Host           : 39.108.108.125:3306
 Source Schema         : sc

 Target Server Type    : MySQL
 Target Server Version : 50646
 File Encoding         : 65001

 Date: 14/12/2019 01:06:55
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `t_id` int(11) NOT NULL COMMENT '教师编号',
  `t_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `t_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师密码',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (2001, '小明老师', '2001');

-- ----------------------------
-- Table structure for t_class
-- ----------------------------
DROP TABLE IF EXISTS `t_class`;
CREATE TABLE `t_class`  (
  `s_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生id',
  `c_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程id',
  `c_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `c_teacher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程教师',
  `c_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上课地址',
  `c_credits` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程学分',
  `c_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '课程学时',
  `c_result` int(255) NULL DEFAULT NULL COMMENT '该课程分数'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_class
-- ----------------------------
INSERT INTO `t_class` VALUES ('1001', '1', 'jsp程序设计', '小明老师', '教学楼三栋503', '3', '65h', 0);

-- ----------------------------
-- Table structure for t_result
-- ----------------------------
DROP TABLE IF EXISTS `t_result`;
CREATE TABLE `t_result`  (
  `t_sid` int(11) NOT NULL COMMENT '学号',
  `t_cid` int(11) NOT NULL COMMENT '课程号',
  `t_result` int(20) NOT NULL COMMENT '课程成绩'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_result
-- ----------------------------
INSERT INTO `t_result` VALUES (1001, 2001, 50);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `s_id` int(11) NOT NULL COMMENT '学号',
  `s_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `s_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `s_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '家庭地址',
  `s_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属系部',
  `s_cnum` int(255) NOT NULL COMMENT '班级编号',
  `s_class` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在班级',
  `s_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所在年级',
  `s_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生电话',
  PRIMARY KEY (`s_id`) USING BTREE,
  INDEX `s_cnum`(`s_cnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (4, NULL, NULL, NULL, NULL, 0, NULL, NULL, NULL);
INSERT INTO `t_student` VALUES (1001, '张三', '女', '广东省广州市广州大学松田学院', '计算机科学与技术系', 1, '软件工程二班', '18级', '13675645213');
INSERT INTO `t_student` VALUES (1002, '李四', '男', '广东省广州市广州大学松田学院', '计算机科学与技术系', 1, '软件工程二班', '18级', '123756385726');
INSERT INTO `t_student` VALUES (1003, '王五', '男', '广东省广州市广州大学松田学院', '计算机科学与技术系', 1, '软件工程二班', '18级', '1236551237461');
INSERT INTO `t_student` VALUES (1004, '小红', '女', '广东省广州市广州大学松田学院', '计算机科学与技术系', 1, '软件工程二班', '18级', '1236551237461');
INSERT INTO `t_student` VALUES (1005, '小六', '女', '广东省', '计算机', 1, '物联网一班', '19级', '19283762713');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `t_id` int(20) NOT NULL COMMENT '教师编号',
  `t_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师姓名',
  `t_sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师性别',
  `t_year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师年龄',
  `t_professional` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师专业',
  `t_cid` int(11) NULL DEFAULT NULL COMMENT '所教课程号',
  `t_cnum` int(255) NOT NULL COMMENT '所教班级编号',
  `t_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教师电话',
  `t_cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所教班级名称',
  PRIMARY KEY (`t_id`) USING BTREE,
  INDEX `t_cnum`(`t_cnum`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (2001, '小明老师', '男', '30岁', '计算机专业', 1, 1, '13672746251', '19软件工程二班');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `u_id` int(11) NOT NULL COMMENT '学生学号（关联学生表）',
  `u_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生姓名',
  `u_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学生密码',
  PRIMARY KEY (`u_id`) USING BTREE,
  CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `t_student` (`s_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1001, '张三', '1001');

-- ----------------------------
-- View structure for teacher_student
-- ----------------------------
DROP VIEW IF EXISTS `teacher_student`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teacher_student` AS select `t_student`.`s_id` AS `s_id`,`t_student`.`s_name` AS `s_name`,`t_student`.`s_sex` AS `s_sex`,`t_student`.`s_address` AS `s_address`,`t_student`.`s_department` AS `s_department`,`t_student`.`s_class` AS `s_class`,`t_student`.`s_grade` AS `s_grade`,`t_student`.`s_phone` AS `s_phone`,`t_student`.`s_cnum` AS `s_cnum`,`t_teacher`.`t_id` AS `t_id` from (`t_student` join `t_teacher` on((`t_teacher`.`t_cnum` = `t_student`.`s_cnum`))) where (`t_teacher`.`t_cnum` = `t_student`.`s_cnum`);

-- ----------------------------
-- View structure for teacher_student_class
-- ----------------------------
DROP VIEW IF EXISTS `teacher_student_class`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `teacher_student_class` AS select `t_student`.`s_name` AS `s_name`,`t_student`.`s_sex` AS `s_sex`,`t_student`.`s_department` AS `s_department`,`t_student`.`s_class` AS `s_class`,`t_student`.`s_grade` AS `s_grade`,`t_class`.`c_name` AS `c_name`,`t_class`.`c_result` AS `c_result`,`t_student`.`s_id` AS `s_id`,`t_teacher`.`t_id` AS `t_id` from ((`t_teacher` join `t_student` on((`t_teacher`.`t_cnum` = `t_student`.`s_cnum`))) join `t_class` on(((`t_student`.`s_id` = `t_class`.`s_id`) and (`t_teacher`.`t_cid` = `t_class`.`c_id`))));

SET FOREIGN_KEY_CHECKS = 1;
