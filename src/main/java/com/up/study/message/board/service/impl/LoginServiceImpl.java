package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.up.study.message.board.entity.UserEntity;
import com.up.study.message.board.framework.login.service.LoginService;
import com.up.study.message.board.framework.user.BasicUser;
import com.up.study.message.board.service.MessageBoardUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    private MessageBoardUserService messageBoardUserService;

    @Override
    public BasicUser loginByUsernamePassword(String username, String password) {
        return messageBoardUserService.getOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getUsername, username)
                .eq(UserEntity::getPassword, DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8))));
    }

    @Override
    public BasicUser loginByPhonePassword(String phone, String password) {
        return messageBoardUserService.getOne(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getPhone, phone)
                .eq(UserEntity::getPassword, DigestUtils.md5DigestAsHex(password.getBytes(StandardCharsets.UTF_8))));
    }
}
