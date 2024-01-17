package com.up.study.message.board.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.up.study.message.board.entity.MessageTagEntity;
import com.up.study.message.board.entity.TagEntity;
import com.up.study.message.board.framework.db.entity.base.BaseIdCreateDateTime;
import com.up.study.message.board.service.MessageBoardMessageTagService;
import com.up.study.message.board.mapper.MessageBoardMessageTagMapper;
import com.up.study.message.board.service.MessageBoardTagService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @description 针对表【message_board_message_tag(留言-标签关联表)】的数据库操作Service实现
 * @createDate 2024-01-16 11:16:12
 */
@Service
public class MessageBoardMessageTagServiceImpl extends ServiceImpl<MessageBoardMessageTagMapper, MessageTagEntity>
        implements MessageBoardMessageTagService {
    @Resource
    private MessageBoardTagService messageBoardTagService;

    /**
     * 查询留言关联的标签
     *
     * @param messageId 留言id
     * @return
     */
    @Override
    public List<TagEntity> queryByMessageId(Long messageId) {
        List<MessageTagEntity> messageTagEntities = this.list(Wrappers.<MessageTagEntity>lambdaQuery().eq(MessageTagEntity::getMessageId, messageId).orderByAsc(BaseIdCreateDateTime::getId));
        if (CollectionUtils.isEmpty(messageTagEntities)) {
            return new ArrayList<>();
        }
        List<Long> tagIdList = messageTagEntities.stream().map(MessageTagEntity::getTagId).collect(Collectors.toList());
        return messageBoardTagService.list(Wrappers.<TagEntity>lambdaQuery().in(TagEntity::getId, tagIdList));
    }
}




