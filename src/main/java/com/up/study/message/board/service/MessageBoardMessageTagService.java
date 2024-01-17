package com.up.study.message.board.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.up.study.message.board.entity.MessageTagEntity;
import com.up.study.message.board.entity.TagEntity;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【message_board_message_tag(留言-标签关联表)】的数据库操作Service
 * @createDate 2024-01-16 11:16:12
 */
public interface MessageBoardMessageTagService extends IService<MessageTagEntity> {

    List<TagEntity> queryByMessageId(Long messageId);
}
