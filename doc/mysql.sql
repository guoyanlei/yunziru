CREATE TABLE `yunziru_movie` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(100) default NULL,
  `poster` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `year` int(11) default NULL,
  `location` varchar(200) default NULL,
  `type` varchar(200) default NULL,
  `summary` text,
  `screenshot` text,
  `ed2k_link` text,
  `baidu_link` text,
  `baidu_pwd` varchar(200) default NULL,
  `tid` int(20) default NULL,
  `prise_count` int(11) default '0',
  `hot_count` int(11) default '0',
  `create_time` bigint(20) default NULL,
  `update_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `TID` (`tid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `yunziru_recommend` (
  `id` bigint(20) NOT NULL auto_increment,
  `movie_id` bigint(20) default NULL,
  `create_time` bigint(20) default NULL,
  `update_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yunziru_tag` (
  `id` int(11) NOT NULL auto_increment,
  `tag_name` varchar(100) NOT NULL,
  `tag_desc` varchar(255) default NULL,
  `dim_id` int(11) NOT NULL,
  `create_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yunziru_movie_tag` (
  `id` bigint(20) NOT NULL auto_increment,
  `movie_id` bigint(20) NOT NULL,
  `tag_id` int(11) NOT NULL,
  `create_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yunziru_admin_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `yunziru_admin_user` VALUES ('1', 'admin', '9F6128C8A07BB33F68AC8F24416A6E10');

CREATE TABLE `yunziru_dimension` (
  `id` int(11) NOT NULL auto_increment,
  `dimension` varchar(50) NOT NULL,
  `desc` varchar(100) default NULL,
  `create_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


INSERT into yunziru_tag
SELECT null
      ,type
			,tag_desc
			,1
			,1510582833000
  from (
				SELECT DISTINCT type
							,type as tag_desc
					FROM
							(
								SELECT  TRIM(
													SUBSTRING_INDEX(
															SUBSTRING_INDEX(type, '/', seq),
															'/' ,-1
													)
												) type
									FROM
											(
											 SELECT @rownum:=@rownum+1 AS seq
												 FROM
														 (
															SELECT
															@rownum:=0
														 ) r
												 , yunziru_movie
											) b
									CROSS JOIN yunziru_movie
									WHERE
											seq BETWEEN 1
									AND (
											SELECT
													1 + LENGTH(type) - LENGTH(REPLACE(type, '/', ''))
											)
							) a
				WHERE LENGTH(type) = 6
) a

CREATE TABLE `yunziru_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `rank` int(11) DEFAULT NULL,
  `use_status` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yunziru_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `summary` text,
  `screenshot` text,
  `ed2k_link` text,
  `baidu_link` text,
  `prise_count` int(255) DEFAULT NULL,
  `hot_count` int(255) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `menu` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `MENU` (`menu`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `yunziru_meiju` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(100) default NULL,
  `date` varchar(50) default NULL,
  `image` varchar(255) default NULL,
  `summary` text,
  `down_links` text,
  `update_status` varchar(100) default NULL,
  `tag_ch` varchar(50) default NULL,
  `tag_en` varchar(50) default NULL,
  `category_ch` varchar(50) default NULL,
  `category_en` varchar(50) default NULL,
  `is_end` int(1) default NULL,
  `tid` bigint(20) default NULL,
  `prise_count` int(11) default NULL,
  `hot_count` int(11) default NULL,
  `create_time` bigint(20) default NULL,
  `update_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
