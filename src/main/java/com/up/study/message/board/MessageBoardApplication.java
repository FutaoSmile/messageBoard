package com.up.study.message.board;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@MapperScan("com.up.study.message.board.mapper")
@SpringBootApplication
public class MessageBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(MessageBoardApplication.class, args);
    }

}
