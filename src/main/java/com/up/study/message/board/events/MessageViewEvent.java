package com.up.study.message.board.events;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * 浏览被浏览事件
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class MessageViewEvent extends ApplicationEvent {
    /**
     * 留言id
     */
    private Long messageId;

    public MessageViewEvent(Long messageId) {
        super(messageId);
        this.messageId = messageId;
    }
}
