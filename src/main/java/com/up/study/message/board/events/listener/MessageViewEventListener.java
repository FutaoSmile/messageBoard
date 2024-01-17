package com.up.study.message.board.events.listener;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.events.MessageViewEvent;
import com.up.study.message.board.service.MessageBoardMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Async
@Slf4j
@Component
public class MessageViewEventListener implements ApplicationListener<MessageViewEvent> {

    @Resource
    private MessageBoardMessageService messageBoardMessageService;

    @Override
    public void onApplicationEvent(MessageViewEvent event) {
        Long messageId = event.getMessageId();
        log.info("留言被浏览事件:{}", messageId);
        messageBoardMessageService.update(Wrappers.<MessageEntity>lambdaUpdate()
                .setSql("view_count = view_count + 1")
                .eq(MessageEntity::getId, messageId)
        );
    }
}
