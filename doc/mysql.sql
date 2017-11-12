CREATE TABLE `yunziru_movie` (
  `id` bigint(20) NOT NULL auto_increment,
  `title` varchar(100) default NULL,
  `poster` varchar(255) default NULL,
  `name` varchar(100) default NULL,
  `trans_name` varchar(100) default NULL,
  `year` int(11) default NULL,
  `location` varchar(200) default NULL,
  `type` varchar(200) default NULL,
  `language` varchar(100) default NULL,
  `release_time` varchar(200) default NULL,
  `length_mins` int(11) default NULL,
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
  UNIQUE KEY `TID` (`tid`)
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
  `tag_name` varchar(100) default NULL,
  `tag_desc` varchar(255) default NULL,
  `create_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `yunziru_movie_tag` (
  `id` bigint(20) NOT NULL auto_increment,
  `movie_id` bigint(20) default NULL,
  `tag_id` int(11) default NULL,
  `create_time` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


