package com.up.study.message.board.framework.util;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;

/**
 * 文件工具类
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@UtilityClass
public class FileUtils {
    /**
     * 创建临时文件
     *
     * @return 临时文件
     * @throws IOException 创建失败
     */
    public static File createTempFile() throws IOException {
        // 创建文件，通过 UUID 保证唯一
        File file = File.createTempFile(StrUtils.uuid(), null);
        // 标记 JVM 退出时，自动删除
        file.deleteOnExit();
        return file;
    }
}
