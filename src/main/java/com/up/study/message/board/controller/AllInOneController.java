package com.up.study.message.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@RestController
@RequestMapping("/all-in-one")
@Validated
@Slf4j
public class AllInOneController {

    @GetMapping("/greet")
    public String greet() {
        log.info("hello");
        return "hello all in one";
    }
}
