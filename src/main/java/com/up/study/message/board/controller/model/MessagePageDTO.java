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
public class MessagePageDTO extends BasePageDTO {
    @NotBlank(message = "请选择分类")
    private Long categoryId;
}
