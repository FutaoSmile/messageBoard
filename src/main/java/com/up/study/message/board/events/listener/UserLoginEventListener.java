package com.up.study.message.board.events.listener;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.up.study.message.board.entity.UserEntity;
import com.up.study.message.board.events.UserLoginEvent;
import com.up.study.message.board.framework.util.TimeUtils;
import com.up.study.message.board.service.MessageBoardLoginRecordService;
import com.up.study.message.board.service.MessageBoardUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 用户登录时间监听器
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@Async
@Component
public class UserLoginEventListener implements ApplicationListener<UserLoginEvent> {

    @Resource
    private MessageBoardLoginRecordService messageBoardLoginRecordService;
    @Resource
    private MessageBoardUserService messageBoardUserService;

    @Override
    public void onApplicationEvent(UserLoginEvent event) {
        log.info("接收到用户登录事件:{}", JSON.toJSONString(event));
        messageBoardLoginRecordService.save(event.getLoginRecordEntity());
        messageBoardUserService.update(null, Wrappers.<UserEntity>lambdaUpdate()
                .set(UserEntity::getLastLoginTime, TimeUtils.currentTimestamp()));
    }
}
