package com.up.study.message.board.controller;

import com.up.study.message.board.config.AppProperties;
import com.up.study.message.board.framework.exception.ApplicationException;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.framework.util.StrUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 文件相关
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private AppProperties appProperties;

    /**
     * 上传文件
     *
     * @param file 文件
     * @return
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN, UserRoleEnum.NORMAL_USER})
    @PostMapping("/upload")
    public String upload(MultipartFile file) {
        Asserts.notNull(file, "请选择文件");
        try {
            String originalFilename = file.getOriginalFilename();
            String[] split = originalFilename.split("/.");
            String suffix = split[split.length - 1];
            String newFileId = StrUtils.uuid() + "." + suffix;
            Files.write(Paths.get(appProperties.getImgsDir(), newFileId), file.getBytes(), StandardOpenOption.CREATE);
            return newFileId;
        } catch (IOException e) {
            throw ApplicationException.ae(e.getMessage(), e);
        }
    }
}
