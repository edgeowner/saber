CREATE TABLE `price` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `total` decimal(12,2) DEFAULT '0.00' COMMENT '总值',
  `front` decimal(12,2) DEFAULT '0.00' COMMENT '消费前',
  `end` decimal(12,2) DEFAULT '0.00' COMMENT '消费后',
  `add_time` timestamp NULL DEFAULT NULL COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP, COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8



CREATE TABLE `price_version` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `total` decimal(12,2) DEFAULT '0.00' COMMENT '总值',
  `front` decimal(12,2) DEFAULT '0.00' COMMENT '消费前',
  `end` decimal(12,2) DEFAULT '0.00' COMMENT '消费后',
  `version` int(11) DEFAULT '0' COMMENT '并发版本控制',
  `add_time` timestamp NULL DEFAULT NULL  COMMENT '添加时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
