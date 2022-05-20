
CREATE TABLE `world` (
    `id` int(10) NOT NULL AUTO_INCREMENT,
    `time` varchar(100) DEFAULT NULL COMMENT '时间',
    `confirmed_count` int(15) DEFAULT NULL COMMENT '现存',
    `province_name` varchar(20) DEFAULT NULL COMMENT '名称',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16295808 DEFAULT CHARSET=utf8

CREATE TABLE `trend` (
     `id` int(10) NOT NULL AUTO_INCREMENT,
     `date_id` int(15) DEFAULT '0' COMMENT '时间值',
     `confirmed_count` int(10) DEFAULT '0' COMMENT '累计确诊',
     `cured_count` int(10) DEFAULT '0' COMMENT '累计治愈',
     `current_confirmed_count` int(10) DEFAULT '0' COMMENT '现存确诊',
     `dead_count` int(10) DEFAULT '0' COMMENT '累计死亡',
     `cured_incr` int(10) DEFAULT NULL COMMENT '新增治愈',
     `dead_incr` int(10) DEFAULT NULL COMMENT '新增死亡',
     `confirmed_incr` int(10) DEFAULT NULL COMMENT '新增确诊',
     `current_confirmed_incr` int(10) DEFAULT NULL COMMENT '病例变化',
     `time` varchar(20) CHARACTER SET latin1 DEFAULT NULL COMMENT '数据插入时间',
     PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=849 DEFAULT CHARSET=utf8

CREATE TABLE `history_bean` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `time` varchar(20) DEFAULT NULL COMMENT '日期',
    `current_confirmed_count` int(11) DEFAULT NULL COMMENT '累计确诊',
    `confirmed_count` int(11) DEFAULT NULL COMMENT '现存确诊',
    `cured_count` int(11) DEFAULT NULL COMMENT '累计治愈',
    `dead_count` int(11) DEFAULT NULL COMMENT '累计死亡',
    `province_name` varchar(10) DEFAULT NULL COMMENT '国家',
    `statistics_data` varchar(100) DEFAULT NULL COMMENT '数据增长链接',
    `incr_vo` varchar(200) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4

CREATE TABLE `details` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `time` varchar(20) NOT NULL COMMENT '收集日期',
   `province_short_name` varchar(20) NOT NULL COMMENT '省份名',
   `current_onfirmed_count` int(10) DEFAULT '0' COMMENT '现有确诊',
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4