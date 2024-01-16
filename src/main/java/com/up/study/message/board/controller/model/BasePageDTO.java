package com.up.study.message.board.controller.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author idle
 * @date 2022/7/2
 */
@Data
public class BasePageDTO implements Serializable {
    private static final long serialVersionUID = 1722910233508430221L;
    /**
     * 页码，从1开始
     */
    @NotNull(message = "页码不能为空")
    @Range(min = 1L, message = "页码最小为1")
    private Integer pageNo;

    /**
     * 分页大小
     */
    @NotNull(message = "分页大小不能为空")
    @Range(min = 1L, max = 500, message = "分页大小最小为1，最大为500")
    private Integer pageSize;
}
