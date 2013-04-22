use mdmp;

SET SESSION sql_mode='';
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `app`
-- ----------------------------
DROP TABLE IF EXISTS `app`;

CREATE TABLE `app` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `oid` varchar(36) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  KEY `oid` (`oid`),
  UNIQUE KEY `name` (`name`,`oid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `datasource`
-- ----------------------------
DROP TABLE IF EXISTS `datasource`;

CREATE TABLE `datasource` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `aid` varchar(36) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  UNIQUE KEY `name` (`name`,`aid`) USING BTREE
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
-- ----------------------------
-- Table structure for `report`
-- ----------------------------
DROP TABLE IF EXISTS `report`;

 CREATE TABLE `report` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `aid` varchar(36) NOT NULL,
  `rpttype` varchar(36) NOT NULL,
  `mid` varchar(36) NOT NULL,
  `did` varchar(36) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `logic` varchar(1024) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `aid` (`aid`),
  KEY `mid` (`mid`),
  KEY `did` (`did`),
  KEY `uid` (`uid`),
  UNIQUE KEY `name` (`name`,`aid`) USING BTREE
 ) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 
 -- ----------------------------
-- Table structure for `model`
-- ----------------------------
DROP TABLE IF EXISTS `model`;


CREATE TABLE `model` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `logic` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`),
  UNIQUE KEY `name` (`name`,`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `oid` varchar(36) NOT NULL,
  `role` varchar(36) NOT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `oid` (`oid`),
  UNIQUE KEY `name` (`name`,`oid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `org`
-- ----------------------------
DROP TABLE IF EXISTS `org`;

CREATE TABLE `org` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for `dashboard`
-- ----------------------------
DROP TABLE IF EXISTS `dashboard`;

CREATE TABLE `dashboard` (
  `id` varchar(36) NOT NULL,
  `name` varchar(255) NOT NULL,
  `uid` varchar(36) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `reports` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`uid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Init Default Org
-- ----------------------------
INSERT INTO `org` VALUES ('o180fe12-93cc-417e-8b99-b1b9710838e5', 'Mac_Johnny_App_Company', 'test', '2013-04-22 14:51:01', '2013-04-22 14:51:01');

-- ----------------------------
-- Init Default member
-- ----------------------------
INSERT INTO `member` VALUES ('u180fe12-93cc-417e-8b99-b1b9710838e5', 'mac.zhenfang@gmail.com', 'o180fe12-93cc-417e-8b99-b1b9710838e5', 'admin', '2013-04-22 14:51:01', '2013-04-22 14:51:01');

-- ----------------------------
-- Init Default Model
-- ----------------------------

INSERT INTO `model` VALUES ('m180fe12-93cc-417e-8b99-b1b9710838e5', 'sum', 'u180fe12-93cc-417e-8b99-b1b9710838e5', ' ','{input:["$input$"],op:"incr",val:"1",where:"",groupby:["$groupbykey$]",output:["$output$"]}', '2013-02-28 14:51:01', '2013-04-22 14:51:01');
