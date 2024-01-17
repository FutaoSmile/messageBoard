package com.up.study.message.board.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.up.study.message.board.controller.model.AddMessageReq;
import com.up.study.message.board.controller.model.MessagePageDTO;
import com.up.study.message.board.controller.model.MessageWithCategoryTagDTO;
import com.up.study.message.board.entity.MessageEntity;

/**
 * @author Administrator
 * @description 针对表【message_board_message(留言表)】的数据库操作Service
 * @createDate 2024-01-16 11:16:12
 */
public interface MessageBoardMessageService extends IService<MessageEntity> {

    void addMessage(AddMessageReq addMessageReq);

    MessageWithCategoryTagDTO detail(Long id);

    Page<MessageWithCategoryTagDTO> page(MessagePageDTO messagePageDTO, Long userId);
}
