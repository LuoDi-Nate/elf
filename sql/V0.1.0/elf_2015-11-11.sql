DROP TABLE IF EXISTS `elf_session`;

CREATE TABLE `elf_session` (
		`id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '表主键',
		`user_id` int(11) NOT NULL COMMENT '用户表主键',
		`token` varchar(64) NOT NULL DEFAULT '' COMMENT 'token字符串',
		`login_account` tinyint(4) NOT NULL COMMENT '登录验证账户, 0:其他, 1:手机号, 2:账户密码, 3:微信',
		`user_agent` varchar(128) NOT NULL COMMENT '用户登录设备',
		`user_os` varchar(32) NOT NULL COMMENT '用户系统',
		`user_mac` varchar(128) NOT NULL COMMENT '用户登录设备mac地址',
		`expire_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '该记录过期时间',
		`created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录创建时间',
		`updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后更新时间',
		PRIMARY KEY (`id`)
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;



DROP TABLE IF EXISTS `elf_user`;

CREATE TABLE `elf_user` (
		`id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '表主键',
		`mobile` varchar(16) NOT NULL DEFAULT '' COMMENT '用户手机号码,唯一键约束',
		`mobile_check` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户手机号是否通过校验,0:无, 1:有',
		`gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '用户性别,0:女, 1:男',
		`avatar` varchar(512) NOT NULL DEFAULT '' COMMENT '头像url',
		`avatar_check` tinyint(4) NOT NULL DEFAULT '0' COMMENT '头像是否通过审核, 0:否, 1:是',
		`birth_day` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户生日',
		`email` varchar(128) NOT NULL DEFAULT '' COMMENT '用户邮箱, 预留',
		`account` varchar(64) NOT NULL DEFAULT '' COMMENT '用户账户, 预留',
		`password` varchar(32) NOT NULL DEFAULT '' COMMENT '密码,目前使用手机号+salt的md5',
		`salt` varchar(32) NOT NULL DEFAULT '' COMMENT '密码盐, 未开启密码前默认"elf"',
		`signature` varchar(128) NOT NULL COMMENT '用户一句话签名',
		`inviter_id` int(11) NOT NULL DEFAULT '0' COMMENT '邀请者id',
		`signed_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '用户注册的日期',
		`created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录创建时间',
		`updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
		PRIMARY KEY (`id`),
		UNIQUE KEY `mobile` (`mobile`),
		KEY `ix_mobile` (`mobile`),
		KEY `ix_email` (`email`),
		KEY `ix_account` (`account`),
		KEY `ix_create` (`created_at`),
		KEY `ix_update` (`updated_at`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;


