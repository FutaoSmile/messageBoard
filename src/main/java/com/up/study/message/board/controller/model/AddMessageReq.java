package com.up.study.message.board.controller.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class AddMessageReq {
    /**
     * 标题
     */
    @NotBlank(message = "标题不能为空")
    private String title;
    /**
     * 内容
     */
    @NotBlank(message = "内容不能为空")
    private String content;
    /**
     * 关联的分类id
     */
    @NotNull(message = "请关联分类")
    private Long categoryId;
    /**
     * 关联的标签列表
     */
    @NotEmpty(message = "请关联标签")
    private List<Long> tagIdList;
}
