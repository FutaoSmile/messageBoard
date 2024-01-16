package com.up.study.message.board.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 留言评论表
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@TableName("message_board_message_commons")
@Builder
public class MessageCommonsEntity extends BaseIdUserTime {
    /**
     * 评论用户id
     */
    private String userId;
    /**
     * 评论的留言id
     */
    private Long messageId;
    /**
     * 评论内容
     */
    private String content;
}
