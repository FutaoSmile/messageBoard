package com.up.study.message.board.controller;

import com.up.study.message.board.controller.model.AddMessageReq;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.service.MessageBoardMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 留言管理
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/message")
@Validated
public class MessageController {

    @Resource
    private MessageBoardMessageService messageBoardMessageService;

    /**
     * 新增留言
     *
     * @param addMessageReq
     */
    @LoginRequire
    @PostMapping
    public void addMessage(@RequestBody @Validated AddMessageReq addMessageReq) {
        messageBoardMessageService.addMessage(addMessageReq);
    }
}
