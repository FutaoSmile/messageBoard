package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.entity.MessageCommentEntity;
import com.up.study.message.board.service.MessageBoardMessageCommentService;
import com.up.study.message.board.mapper.MessageBoardMessageCommonsMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【message_board_message_commons(留言评论表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardMessageCommonsServiceImpl extends ServiceImpl<MessageBoardMessageCommonsMapper, MessageCommentEntity>
        implements MessageBoardMessageCommentService {

}




