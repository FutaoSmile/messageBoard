package com.up.study.message.board.framework.login.peoperties;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Component
@ConfigurationProperties(prefix = "basic.login")
public class BasicLoginProperties {
    /**
     * 登录会话有效时长
     */
    private Duration loginSessionDuration = Duration.ofMinutes(30L);

    public void setLoginSessionDuration(Duration loginSessionDuration) {
        this.loginSessionDuration = loginSessionDuration;
    }
}