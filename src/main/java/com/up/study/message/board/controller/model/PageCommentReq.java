package com.up.study.message.board.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class PageCommentReq extends BasePageDTO {
    /**
     * 留言id
     */
    @NotBlank(message = "留言id不能为空")
    private Long messageId;
}
