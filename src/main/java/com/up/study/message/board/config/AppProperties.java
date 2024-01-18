package com.up.study.message.board.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private String imgsDir;

    public String getImgsDir() {
        return imgsDir;
    }

    public void setImgsDir(String imgsDir) {
        this.imgsDir = imgsDir;
    }
}
