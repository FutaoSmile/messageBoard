package com.up.study.message.board.controller.model;

import com.up.study.message.board.entity.MessageCommentEntity;
import com.up.study.message.board.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Getter
@Setter
public class CommentWithUserDTO extends MessageCommentEntity {
    /**
     * 发表评论的用户
     */
    private UserEntity user;
}
