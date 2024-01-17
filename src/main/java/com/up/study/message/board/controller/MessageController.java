package com.up.study.message.board.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.up.study.message.board.controller.model.AddMessageReq;
import com.up.study.message.board.controller.model.BasePageDTO;
import com.up.study.message.board.controller.model.MessagePageDTO;
import com.up.study.message.board.controller.model.MessageWithCategoryTagDTO;
import com.up.study.message.board.entity.CategoryEntity;
import com.up.study.message.board.entity.MessageEntity;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.user.CurrentUser;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.service.MessageBoardCategoryService;
import com.up.study.message.board.service.MessageBoardMessageService;
import com.up.study.message.board.service.MessageBoardMessageTagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 留言管理
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/message")
@Validated
public class MessageController {

    @Resource
    private MessageBoardMessageService messageBoardMessageService;
    @Resource
    private MessageBoardMessageTagService messageBoardMessageTagService;
    @Resource
    private MessageBoardCategoryService messageBoardCategoryService;

    /**
     * 新增留言
     *
     * @param addMessageReq
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN, UserRoleEnum.NORMAL_USER})
    @PostMapping
    public void addMessage(@RequestBody @Validated AddMessageReq addMessageReq) {
        messageBoardMessageService.addMessage(addMessageReq);
    }

    /**
     * 我的留言
     *
     * @param basePageDTO
     * @return
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN, UserRoleEnum.NORMAL_USER})
    @GetMapping("/page/mine")
    public Page<MessageWithCategoryTagDTO> messagePage(BasePageDTO basePageDTO) {
        MessagePageDTO messagePageDTO = new MessagePageDTO();
        BeanUtils.copyProperties(basePageDTO, messagePageDTO);
        return messageBoardMessageService.page(messagePageDTO, CurrentUser.getUser().getId());
    }

    /**
     * 详情
     *
     * @param id
     * @return
     */
    @GetMapping("/detail/{id}")
    public MessageWithCategoryTagDTO detail(@PathVariable("id") Long id) {
        return messageBoardMessageService.detail(id);
    }

    /**
     * 留言列表
     *
     * @return
     */
    @GetMapping("/page")
    public Page<MessageWithCategoryTagDTO> messagePage(@Validated MessagePageDTO messagePageDTO) {
        return messageBoardMessageService.page(messagePageDTO, null);
    }

}
