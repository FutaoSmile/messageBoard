create database message_board;
use message_board;

create table `message_board`.`message_board_user`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
    username           VARCHAR(100) NOT NULL COMMENT '用户名',
    role               tinyint      not null default 1 comment '角色',

    password           VARCHAR(255) NOT NULL COMMENT '密码（实际应用中通常会加密存储）',
    email              VARCHAR(255) NOT NULL COMMENT '邮箱',
    phone              VARCHAR(20)           DEFAULT NULL COMMENT '手机号',
    avatar             VARCHAR(255)          DEFAULT NULL COMMENT '头像URL或路径',
    last_login_time    BIGINT                DEFAULT 0 COMMENT '上次登录时间戳（单位：毫秒）',
    status             INT          NOT NULL DEFAULT 0 COMMENT '用户状态，参考UserStatusEnum枚举',
    gender             VARCHAR(10)  NOT NULL DEFAULT '' COMMENT '性别，参考GenderEnum枚举',
    birthday           BIGINT                DEFAULT 0 COMMENT '生日时间戳（单位：毫秒）',
    register_date_time BIGINT       NOT NULL DEFAULT 0 COMMENT '注册日期时间戳（单位：毫秒）',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '用户表';


create table `message_board`.`message_board_login_record`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `user_id`          BIGINT       NOT NULL COMMENT '用户ID',
    `ip`               VARCHAR(20)  NOT NULL COMMENT '登录IP',
    `browser`          VARCHAR(255) NOT NULL COMMENT '浏览器',
    `os`               VARCHAR(255) NOT NULL COMMENT '操作系统',
    `user_agent`       VARCHAR(255) NOT NULL COMMENT 'UserAgent',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '用户登录记录表';

create table `message_board`.`message_board_message_commons`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `user_id`          BIGINT       NOT NULL COMMENT '用户ID',
    `message_id`       BIGINT       NOT NULL COMMENT '留言ID',
    `content`          varchar(255) NOT NULL COMMENT '内容',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '留言评论表';

create table `message_board`.`message_board_message`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `user_id`          BIGINT       NOT NULL COMMENT '用户ID',
    `title`            varchar(255) NOT NULL COMMENT '标题',
    `content`          longtext     NOT NULL COMMENT '内容',
    `view_count`       int          not null default 0 comment '浏览量',
    `star_count`       int          not null default 0 comment '点赞量',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '留言表';

create table `message_board`.`message_board_tag`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `tag_name`         varchar(255) NOT NULL COMMENT '标签名',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '标签表';

create table `message_board`.`message_board_category`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `category_name`    varchar(255) NOT NULL COMMENT '分类名',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '分类表';

create table `message_board`.`message_board_message_tag`
(
    id                 BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
    `message_id`       BIGINT       NOT NULL COMMENT '留言消息id',
    `tag_id`           BIGINT       NOT NULL COMMENT '关联的标签id',

    `create_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '创建者',
    `create_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '创建时间戳（单位：毫秒）',
    `update_by`        VARCHAR(100) NOT NULL DEFAULT '' COMMENT '更新者',
    `update_date_time` BIGINT       NOT NULL DEFAULT 0 COMMENT '更新时间戳（单位：毫秒）'
) engine = 'innodb'
  charset = 'utf8mb4'
  collate = 'utf8mb4_general_ci' comment '留言-标签关联表';