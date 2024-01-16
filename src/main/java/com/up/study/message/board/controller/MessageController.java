package com.up.study.message.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}