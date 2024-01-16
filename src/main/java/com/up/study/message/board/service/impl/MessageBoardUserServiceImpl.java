package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.controller.model.UserRegisterBody;
import com.up.study.message.board.entity.UserEntity;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.service.MessageBoardUserService;
import com.up.study.message.board.mapper.MessageBoardUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author Administrator
 * @description 针对表【message_board_user(用户表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardUserServiceImpl extends ServiceImpl<MessageBoardUserMapper, UserEntity>
        implements MessageBoardUserService {

    @Override
    public void register(UserRegisterBody userRegisterBody) {
        long userCount = this.count(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getPhone, userRegisterBody.getPhone())
        );
        Asserts.equals(userCount, 0, "当前账号已注册，请勿重复注册");
        this.save(UserEntity.builder()
                .phone(userRegisterBody.getPhone())
                .password(DigestUtils.md5DigestAsHex(userRegisterBody.getPassword().getBytes(StandardCharsets.UTF_8)))
                .build());
    }
}




