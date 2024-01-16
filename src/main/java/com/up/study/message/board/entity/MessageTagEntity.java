package com.up.study.message.board.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;
import lombok.Getter;
import lombok.Setter;

/**
 * 留言-标签关联表
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
@TableName("message_board_message_tag")
public class MessageTagEntity extends BaseIdUserTime {
    /**
     * 留言消息id
     */
    private Long messageId;
    /**
     * 关联的标签id
     */
    private Long tagId;
}
