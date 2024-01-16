package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.entity.LoginRecordEntity;
import com.up.study.message.board.service.MessageBoardLoginRecordService;
import com.up.study.message.board.mapper.MessageBoardLoginRecordMapper;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 针对表【message_board_login_record(用户登录记录表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardLoginRecordServiceImpl extends ServiceImpl<MessageBoardLoginRecordMapper, LoginRecordEntity>
        implements MessageBoardLoginRecordService {

}




