package com.up.study.message.board.framework.mybatis.plus.config;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.up.study.message.board.framework.db.entity.base.BaseIdUserTime;
import com.up.study.message.board.framework.user.BasicUser;
import com.up.study.message.board.framework.user.CurrentUser;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 字段自动填充
 *
 * @author fish_temp_author
 * @since 2021/11/21
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        BasicUser user = CurrentUser.getUser();
        this.strictInsertFill(metaObject, BaseIdUserTime.ID_FIELD, Long.class, Optional.ofNullable(user).map(BasicUser::getId).orElse(0L));
        this.setFieldValByName(BaseIdUserTime.CREATE_BY_FIELD, System.currentTimeMillis(), metaObject);

        this.setFieldValByName(BaseIdUserTime.CREATE_BY_FIELD, Optional.ofNullable(user).map(BasicUser::getId).orElse(0L), metaObject);
        this.setFieldValByName(BaseIdUserTime.CREATE_DATE_TIME_FIELD, System.currentTimeMillis(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        BasicUser user = CurrentUser.getUser();
        this.setFieldValByName(BaseIdUserTime.UPDATE_BY_FIELD, Optional.ofNullable(user).map(BasicUser::getId).orElse(0L), metaObject);
        this.setFieldValByName(BaseIdUserTime.UPDATE_DATE_TIME_FIELD, System.currentTimeMillis(), metaObject);
    }
}
