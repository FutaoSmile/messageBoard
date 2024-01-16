package com.up.study.message.board.framework.util;


import com.up.study.message.board.framework.util.constants.CommonConstant;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.UUID;

/**
 * @author fish_temp_author
 * @since fish_temp_since
 */
@UtilityClass
public class StrUtils {


    public String uuid() {
        return UUID.randomUUID().toString().replace(CommonConstant.MINUS_SIGN, StringUtils.EMPTY);
    }

    public String substring(String string, int targetLength) {
        return Optional.ofNullable(string).filter(str -> str.length() >= targetLength).map(str -> str.substring(0, targetLength)).orElse(StringUtils.EMPTY);
    }
}