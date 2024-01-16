package com.up.study.message.board.events;

import com.up.study.message.board.entity.LoginRecordEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class UserLoginEvent extends ApplicationEvent {
    /**
     * 登录信息
     */
    private LoginRecordEntity loginRecordEntity;

    public UserLoginEvent(LoginRecordEntity source) {
        super(source);
        this.loginRecordEntity = source;
    }
}
