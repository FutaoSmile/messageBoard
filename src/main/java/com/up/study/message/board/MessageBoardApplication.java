package com.up.study.message.board;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@MapperScan("com.up.study.message.board.mapper")
@SpringBootApplication
@EnableAsync
@Slf4j
public class MessageBoardApplication implements ApplicationRunner {

    @Value("${app.imgs-dir}")
    private String imgsDir;

    public static void main(String[] args) {
        SpringApplication.run(MessageBoardApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("当前图片存储位置为:{}", imgsDir);
    }
}
