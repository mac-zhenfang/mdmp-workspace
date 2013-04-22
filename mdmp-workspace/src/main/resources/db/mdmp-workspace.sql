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
  `description` varchar(1024) DEFAULT NULL,
  `createdTime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `lastModifiedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;