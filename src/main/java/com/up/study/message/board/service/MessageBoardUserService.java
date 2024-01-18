package com.up.study.message.board.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.up.study.message.board.controller.model.AddUserReq;
import com.up.study.message.board.controller.model.UpdateProfileReq;
import com.up.study.message.board.controller.model.UserPageReq;
import com.up.study.message.board.controller.model.UserRegisterBody;
import com.up.study.message.board.entity.UserEntity;

/**
 * @author Administrator
 * @description 针对表【message_board_user(用户表)】的数据库操作Service
 * @createDate 2024-01-16 11:16:12
 */
public interface MessageBoardUserService extends IService<UserEntity> {

    void register(UserRegisterBody userRegisterBody);

    UserEntity profile();

    Page<UserEntity> page(UserPageReq userPageReq);

    void addUser(AddUserReq addUserReq);

    UserEntity updateProfile(UpdateProfileReq updateProfileReq);
}
