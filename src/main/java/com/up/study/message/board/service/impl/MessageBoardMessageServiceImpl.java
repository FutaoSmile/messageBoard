package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.service.MessageBoardMessageService;
import com.up.study.message.board.mapper.MessageBoardMessageMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【message_board_message(留言表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardMessageServiceImpl extends ServiceImpl<MessageBoardMessageMapper, MessageEntity>
        implements MessageBoardMessageService {

}




