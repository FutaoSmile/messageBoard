package com.up.study.message.board.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class AddCommentReq {
    /**
     * 评论的留言
     */
    @NotNull(message = "messageId不能为空")
    private Long messageId;
    /**
     * 评论内容
     */
    @NotBlank(message = "请输入评论内容")
    private String content;
}
