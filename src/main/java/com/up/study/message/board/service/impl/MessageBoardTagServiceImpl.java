package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.entity.TagEntity;
import com.up.study.message.board.service.MessageBoardTagService;
import com.up.study.message.board.mapper.MessageBoardTagMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【message_board_tag(标签表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardTagServiceImpl extends ServiceImpl<MessageBoardTagMapper, TagEntity>
        implements MessageBoardTagService {

}




