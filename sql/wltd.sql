-- --------------------------------------------------------
-- 主机:                           localhost
-- 服务器版本:                        10.2.8-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 wltd 的数据库结构
CREATE DATABASE IF NOT EXISTS `wltd` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `wltd`;

-- 导出  表 wltd.eattr 结构
CREATE TABLE IF NOT EXISTS `eattr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '属性名',
  `sensorid` int(11) DEFAULT NULL COMMENT '传感器id',
  `protocol` varchar(255) DEFAULT NULL COMMENT '数据接口',
  `compare` varchar(255) DEFAULT NULL COMMENT '比较类型',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `timer` int(11) DEFAULT NULL COMMENT '周期',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COMMENT='属性';

-- 正在导出表  wltd.eattr 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `eattr` DISABLE KEYS */;
INSERT INTO `eattr` (`id`, `item`, `sensorid`, `protocol`, `compare`, `unit`, `timer`, `note`) VALUES
	(35, '烟量', 9, 'alarmType', '=', '', 1, ''),
	(36, '电量', 9, 'batteryPower', '<', '%', 5, ''),
	(37, '气量', 10, 'gasMmol', '>', '', 1, ''),
	(38, '报警', 10, 'alarmType', '=', '', 1, '');
/*!40000 ALTER TABLE `eattr` ENABLE KEYS */;

-- 导出  表 wltd.ebim 结构
CREATE TABLE IF NOT EXISTS `ebim` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '节点名',
  `platid` int(11) DEFAULT NULL COMMENT '地图id',
  `longitude` varchar(255) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) DEFAULT NULL COMMENT '纬度',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `modelfile` varchar(255) DEFAULT NULL COMMENT '模型文件',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='节点';

-- 正在导出表  wltd.ebim 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `ebim` DISABLE KEYS */;
INSERT INTO `ebim` (`id`, `item`, `platid`, `longitude`, `latitude`, `status`, `level`, `modelfile`, `note`) VALUES
	(13, '兴化西里8号楼', 11, '116.417212', '39.965719', '正常', 0, NULL, ''),
	(17, '北京物联天地信息技术有限公司', 11, '116.414672', '39.966072', '维修', 1, NULL, ''),
	(22, '兴化西里12号楼', 11, '116.416136', '39.966300', '正常', 0, NULL, NULL);
/*!40000 ALTER TABLE `ebim` ENABLE KEYS */;

-- 导出  表 wltd.edevice 结构
CREATE TABLE IF NOT EXISTS `edevice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '设备名',
  `sensorid` int(11) DEFAULT NULL COMMENT '传感器id',
  `roomid` int(11) DEFAULT NULL COMMENT '房间id',
  `protocol` varchar(255) DEFAULT NULL COMMENT '数据接口',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COMMENT='设备';

-- 正在导出表  wltd.edevice 的数据：~10 rows (大约)
/*!40000 ALTER TABLE `edevice` DISABLE KEYS */;
INSERT INTO `edevice` (`id`, `item`, `sensorid`, `roomid`, `protocol`, `status`, `level`, `note`) VALUES
	(23, '1-101-01', 9, 22, '864814048247500', '正常', 0, NULL),
	(24, '1-101-01', 10, 22, '867900046839740', '正常', 0, NULL),
	(25, '1-201-01', 9, 23, '864814048247501', '正常', 0, NULL),
	(26, '1-201-01', 10, 23, '867900046839741', '正常', 0, NULL),
	(27, '1-301-01', 9, 24, '864814048247502', '正常', 0, NULL),
	(28, '1-301-01', 10, 24, '867900046839742', '正常', 0, NULL),
	(29, '101-01', 9, 31, '864814048247505', '维修', 1, NULL),
	(30, '101-01', 10, 31, '867900046839745', '正常', 0, NULL),
	(31, '1-101-02', 9, 22, '864814048247499', '正常', 0, ''),
	(32, '1-101-03', 9, 22, '864814048247499', '正常', 0, '');
/*!40000 ALTER TABLE `edevice` ENABLE KEYS */;

-- 导出  表 wltd.eplat 结构
CREATE TABLE IF NOT EXISTS `eplat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '地图名',
  `projectid` int(11) DEFAULT NULL COMMENT '项目id',
  `province` varchar(255) DEFAULT NULL COMMENT '省',
  `city` varchar(255) DEFAULT NULL COMMENT '市',
  `longitude` varchar(255) DEFAULT NULL COMMENT '中心经度',
  `latitude` varchar(255) DEFAULT NULL COMMENT '中心纬度',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='地图';

-- 正在导出表  wltd.eplat 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `eplat` DISABLE KEYS */;
INSERT INTO `eplat` (`id`, `item`, `projectid`, `province`, `city`, `longitude`, `latitude`, `note`) VALUES
	(8, '海淀区', 13, '北京', '北京', '116.362596', '39.990320', ''),
	(9, '朝阳区', 13, '北京', '北京', '116.489231', '39.951600', ''),
	(10, '西城区', 13, '北京', '北京', '116.361016', '39.919453', ''),
	(11, '东城区', 13, '北京', '北京', '116.414597', '39.955441', '');
/*!40000 ALTER TABLE `eplat` ENABLE KEYS */;

-- 导出  表 wltd.eproject 结构
CREATE TABLE IF NOT EXISTS `eproject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '项目名',
  `fileurl` varchar(255) DEFAULT NULL COMMENT '文件url',
  `servicename` varchar(255) DEFAULT NULL COMMENT '服务名',
  `dburl` varchar(255) DEFAULT NULL COMMENT '数据库地址',
  `detail` text DEFAULT NULL COMMENT '详细内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='项目';

-- 正在导出表  wltd.eproject 的数据：~3 rows (大约)
/*!40000 ALTER TABLE `eproject` DISABLE KEYS */;
INSERT INTO `eproject` (`id`, `item`, `fileurl`, `servicename`, `dburl`, `detail`) VALUES
	(0, '系统', NULL, 'base', 'iot', NULL),
	(1, '井盖', '', 'cover', 'cover', NULL),
	(13, '安防', '', 'security', 'security', '');
/*!40000 ALTER TABLE `eproject` ENABLE KEYS */;

-- 导出  表 wltd.eroom 结构
CREATE TABLE IF NOT EXISTS `eroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '房间名',
  `bimid` int(11) DEFAULT NULL COMMENT '节点id',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `modelfile` varchar(255) DEFAULT NULL COMMENT '模型文件',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='节点';

-- 正在导出表  wltd.eroom 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `eroom` DISABLE KEYS */;
INSERT INTO `eroom` (`id`, `item`, `bimid`, `status`, `level`, `modelfile`, `note`) VALUES
	(22, '1-101', 13, '正常', 0, NULL, NULL),
	(23, '1-201', 13, '正常', 0, NULL, NULL),
	(24, '1-301', 13, '正常', 0, NULL, NULL),
	(31, '101', 17, '维修', 1, NULL, NULL);
/*!40000 ALTER TABLE `eroom` ENABLE KEYS */;

-- 导出  表 wltd.esensor 结构
CREATE TABLE IF NOT EXISTS `esensor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '传感器名',
  `projectid` int(11) DEFAULT NULL COMMENT '项目id',
  `protocol` varchar(255) DEFAULT NULL COMMENT '数据接口',
  `timer` int(11) DEFAULT NULL COMMENT '时间间隔ms',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='传感器';

-- 正在导出表  wltd.esensor 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `esensor` DISABLE KEYS */;
INSERT INTO `esensor` (`id`, `item`, `projectid`, `protocol`, `timer`, `note`) VALUES
	(9, '烟雾报警器', 13, 'smoke', 600, ''),
	(10, '煤气报警器', 13, 'gas', 600, '');
/*!40000 ALTER TABLE `esensor` ENABLE KEYS */;

-- 导出  表 wltd.ethreshold 结构
CREATE TABLE IF NOT EXISTS `ethreshold` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(255) DEFAULT NULL COMMENT '阈值',
  `attrid` int(11) DEFAULT NULL COMMENT '属性id',
  `level` int(11) DEFAULT NULL COMMENT '级别',
  `overtime` int(11) DEFAULT NULL COMMENT '超时（秒）',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='属性';

-- 正在导出表  wltd.ethreshold 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `ethreshold` DISABLE KEYS */;
INSERT INTO `ethreshold` (`id`, `item`, `attrid`, `level`, `overtime`, `note`) VALUES
	(39, '5', 35, 1, 300, NULL),
	(40, '20', 36, 1, 86400, NULL),
	(41, '10', 36, 2, 86400, NULL),
	(42, '5', 36, 3, 86400, NULL),
	(43, '5', 37, 1, 300, NULL),
	(44, '10', 37, 2, 300, NULL),
	(45, '20', 37, 3, 300, NULL),
	(46, '1', 38, 1, 300, NULL),
	(47, '6', 35, 2, 300, NULL),
	(49, '2', 38, 2, 300, NULL),
	(50, '3', 38, 3, 300, NULL);
/*!40000 ALTER TABLE `ethreshold` ENABLE KEYS */;

-- 导出  表 wltd.euser 结构
CREATE TABLE IF NOT EXISTS `euser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `projectid` int(11) DEFAULT NULL COMMENT '项目id',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `realname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `wechat` varchar(255) DEFAULT NULL COMMENT '微信',
  `time` varchar(255) DEFAULT NULL COMMENT '注册时间',
  `status` varchar(255) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=312 DEFAULT CHARSET=utf8 COMMENT='用户';

-- 正在导出表  wltd.euser 的数据：~11 rows (大约)
/*!40000 ALTER TABLE `euser` DISABLE KEYS */;
INSERT INTO `euser` (`id`, `username`, `password`, `projectid`, `type`, `realname`, `phone`, `wechat`, `time`, `status`) VALUES
	(282, 'admin', 'admin', 0, NULL, '管理员', NULL, NULL, '2018-10-23 10:10:10', '可用'),
	(283, 'test1', 'test1', 1, NULL, '测试员', NULL, NULL, '2018-10-29 19:00:10', '可用'),
	(284, 'admin13', 'admin13', 13, '管理员', '安防管理员', NULL, NULL, '2018-10-29 19:11:26', '可用'),
	(302, 'leader1301', 'leader1301', 13, '领导', '领导1', '13504319972', NULL, '2019-02-14 10:45:39', '可用'),
	(303, 'leader1302', 'leader1302', 13, '领导', '领导2', '17701087121', NULL, '2019-02-14 18:56:52', '可用'),
	(305, 'worker1301', 'worker1301', 13, '工人', '工人1', '13504319972', NULL, '2019-02-14 10:45:39', '可用'),
	(306, 'worker1302', 'worker1302', 13, '工人', '工人2', '17701087121', NULL, '2019-02-14 10:45:39', '可用'),
	(307, 'leader1303', 'leader1303', 13, '领导', '领导3', '17701087121', NULL, '2019-02-14 18:56:52', '可用'),
	(308, 'user1301', 'user1301', 13, '用户', '用户', '17701087121', NULL, '2019-02-14 10:45:39', '可用'),
	(309, 'user1302', 'user1302', 13, '用户', '用户', '13504319972', NULL, '2019-02-14 10:45:39', '可用'),
	(310, 'user1303', 'user1302', 13, '用户', '', '13504319972', '', '2019-02-22 12:30:13', '可用');
/*!40000 ALTER TABLE `euser` ENABLE KEYS */;

-- 导出  表 wltd.euserdevice 结构
CREATE TABLE IF NOT EXISTS `euserdevice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '属性名',
  `deviceid` int(11) DEFAULT NULL COMMENT '设备id',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='用户设备';

-- 正在导出表  wltd.euserdevice 的数据：~26 rows (大约)
/*!40000 ALTER TABLE `euserdevice` DISABLE KEYS */;
INSERT INTO `euserdevice` (`id`, `userid`, `deviceid`, `note`) VALUES
	(39, 308, 23, NULL),
	(40, 308, 24, NULL),
	(41, 308, 25, NULL),
	(42, 308, 26, NULL),
	(43, 308, 27, NULL),
	(44, 308, 28, NULL),
	(45, 309, 29, NULL),
	(46, 309, 30, NULL),
	(47, 302, 23, NULL),
	(48, 305, 23, NULL),
	(49, 302, 24, NULL),
	(50, 305, 24, NULL),
	(51, 302, 25, NULL),
	(52, 305, 25, NULL),
	(53, 302, 26, NULL),
	(54, 305, 26, NULL),
	(55, 302, 27, NULL),
	(56, 305, 27, NULL),
	(57, 302, 28, NULL),
	(58, 305, 28, NULL),
	(59, 302, 29, NULL),
	(60, 305, 29, NULL),
	(61, 302, 30, NULL),
	(62, 305, 30, NULL),
	(63, 308, 32, ''),
	(64, 309, 32, '');
/*!40000 ALTER TABLE `euserdevice` ENABLE KEYS */;

-- 导出  表 wltd.euserthreshold 结构
CREATE TABLE IF NOT EXISTS `euserthreshold` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '属性名',
  `thresholdid` int(11) DEFAULT NULL COMMENT '属性id',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 COMMENT='用户阈值';

-- 正在导出表  wltd.euserthreshold 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `euserthreshold` DISABLE KEYS */;
INSERT INTO `euserthreshold` (`id`, `userid`, `thresholdid`, `note`) VALUES
	(39, 302, 39, NULL),
	(40, 302, 40, NULL),
	(41, 302, 43, NULL),
	(42, 302, 46, NULL);
/*!40000 ALTER TABLE `euserthreshold` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
