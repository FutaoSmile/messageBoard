package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.entity.MessageTagEntity;
import com.up.study.message.board.service.MessageBoardMessageTagService;
import com.up.study.message.board.mapper.MessageBoardMessageTagMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【message_board_message_tag(留言-标签关联表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardMessageTagServiceImpl extends ServiceImpl<MessageBoardMessageTagMapper, MessageTagEntity>
        implements MessageBoardMessageTagService {

}




