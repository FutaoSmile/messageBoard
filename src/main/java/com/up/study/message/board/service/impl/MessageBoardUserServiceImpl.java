package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.controller.model.AddUserReq;
import com.up.study.message.board.controller.model.UserPageReq;
import com.up.study.message.board.controller.model.UserRegisterBody;
import com.up.study.message.board.entity.UserEntity;
import com.up.study.message.board.entity.enums.UserStatusEnum;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.user.CurrentUser;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.framework.util.TimeUtils;
import com.up.study.message.board.service.MessageBoardUserService;
import com.up.study.message.board.mapper.MessageBoardUserMapper;
import org.springframework.beans.BeanUtils;
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
        Asserts.equals(userCount, 0L, "当前账号已注册，请勿重复注册");
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone(userRegisterBody.getPhone());
        userEntity.setPassword(DigestUtils.md5DigestAsHex(userRegisterBody.getPassword().getBytes(StandardCharsets.UTF_8)));
        userEntity.setStatus(UserStatusEnum.NORMAL.getStatus());
        userEntity.setRole(UserRoleEnum.NORMAL_USER.getRole());
        userEntity.setRegisterDateTime(TimeUtils.currentTimestamp());
        this.save(userEntity);
    }

    @Override
    public UserEntity profile() {
        return this.getById(CurrentUser.getUser().getId());
    }

    @Override
    public Page<UserEntity> page(UserPageReq userPageReq) {
        return this.page(new Page<>(userPageReq.getPageNo(), userPageReq.getPageSize()), Wrappers.<UserEntity>lambdaQuery()
                .eq(userPageReq.getGender() != null, UserEntity::getGender, userPageReq.getGender())
                .eq(userPageReq.getRole() != null, UserEntity::getRole, userPageReq.getRole())
                .like(userPageReq.getUsername() != null, UserEntity::getUsername, userPageReq.getUsername())
                .like(userPageReq.getPhone() != null, UserEntity::getPhone, userPageReq.getPhone())
                .ge(userPageReq.getRegisterStartDateTime() != null, UserEntity::getRegisterDateTime, userPageReq.getRegisterStartDateTime())
                .lt(userPageReq.getRegisterEndDateTime() != null, UserEntity::getRegisterDateTime, userPageReq.getRegisterEndDateTime())
                .orderByDesc(UserEntity::getCreateDateTime)
        );
    }

    @Override
    public void addUser(AddUserReq addUserReq) {
        long userCount = this.count(Wrappers.<UserEntity>lambdaQuery()
                .eq(UserEntity::getPhone, addUserReq.getPhone())
        );
        Asserts.equals(userCount, 0L, "当前账号已注册，请勿重复注册");
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(addUserReq, entity);
        entity.setPassword(DigestUtils.md5DigestAsHex(addUserReq.getPassword().getBytes(StandardCharsets.UTF_8)));
        entity.setRegisterDateTime(TimeUtils.currentTimestamp());
        this.save(entity);
    }
}




