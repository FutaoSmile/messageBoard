package com.up.study.message.board.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 留言表
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@TableName("message_board_message")
@Builder
public class MessageEntity extends BaseIdUserTime {
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 留言的用户id
     */
    private Long userId;
    /**
     * 浏览量
     */
    private Integer viewCount;
    /**
     * 点赞量
     */
    private Integer starCount;
}
