package com.up.study.message.board.controller;

import com.up.study.message.board.controller.model.UserRegisterBody;
import com.up.study.message.board.service.MessageBoardUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Resource
    private MessageBoardUserService messageBoardUserService;

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterBody userRegisterBody) {
        messageBoardUserService.register(userRegisterBody);
    }
}
