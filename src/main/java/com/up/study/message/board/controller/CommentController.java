package com.up.study.message.board.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.up.study.message.board.controller.model.AddCommentReq;
import com.up.study.message.board.controller.model.CommentWithUserDTO;
import com.up.study.message.board.controller.model.PageCommentReq;
import com.up.study.message.board.entity.MessageCommentEntity;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.user.CurrentUser;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.service.MessageBoardMessageCommentService;
import com.up.study.message.board.service.MessageBoardUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 评论相关接口
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/comment")
@Validated
public class CommentController {

    @Resource
    private MessageBoardMessageCommentService messageBoardMessageCommentService;
    @Resource
    private MessageBoardUserService messageBoardUserService;

    /**
     * 新增评论
     *
     * @param addCommentReq
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN, UserRoleEnum.NORMAL_USER})
    @PostMapping
    public void addComment(@RequestBody @Validated AddCommentReq addCommentReq) {
        MessageCommentEntity entity = new MessageCommentEntity();
        entity.setContent(addCommentReq.getContent());
        entity.setMessageId(addCommentReq.getMessageId());
        entity.setUserId(CurrentUser.getUser().getId());
        messageBoardMessageCommentService.save(entity);
    }

    /**
     * 通过留言id查询所有的评论
     *
     * @param pageCommentReq
     * @return
     */
    @GetMapping("/page/message-id")
    public Page<CommentWithUserDTO> pageByMessageId(PageCommentReq pageCommentReq) {
        Page<MessageCommentEntity> page = messageBoardMessageCommentService.page(new Page<>(pageCommentReq.getPageNo(), pageCommentReq.getPageSize()), Wrappers.<MessageCommentEntity>lambdaQuery()
                .eq(MessageCommentEntity::getMessageId, pageCommentReq.getMessageId())
                .orderByAsc(MessageCommentEntity::getId)
        );

        Page<CommentWithUserDTO> retPage = new Page<>();
        BeanUtils.copyProperties(page, retPage, "records");
        List<CommentWithUserDTO> commentWithUserDTOS = page.getRecords().stream()
                .map(x -> {
                    CommentWithUserDTO commentWithUserDTO = new CommentWithUserDTO();
                    BeanUtils.copyProperties(x, commentWithUserDTO);
                    commentWithUserDTO.setUser(messageBoardUserService.getById(x.getUserId()));
                    return commentWithUserDTO;
                }).collect(Collectors.toList());
        retPage.setRecords(commentWithUserDTOS);
        return retPage;
    }
}
