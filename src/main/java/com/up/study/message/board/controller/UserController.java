package com.up.study.message.board.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.up.study.message.board.controller.model.AddUserReq;
import com.up.study.message.board.controller.model.UserPageReq;
import com.up.study.message.board.controller.model.UserRegisterBody;
import com.up.study.message.board.entity.UserEntity;
import com.up.study.message.board.framework.exception.ApplicationException;
import com.up.study.message.board.framework.exception.Asserts;
import com.up.study.message.board.framework.login.annotations.LoginRequire;
import com.up.study.message.board.framework.user.enums.UserRoleEnum;
import com.up.study.message.board.framework.util.StrUtils;
import com.up.study.message.board.service.MessageBoardUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 用户接口
 *
 * @author fish_temp_author
 * @since fish_temp_since
 */
@Slf4j
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Value("${app.imgs-dir}")
    private String imgsDir;

    @Resource
    private MessageBoardUserService messageBoardUserService;

    /**
     * 注册普通用户
     *
     * @param userRegisterBody
     */
    @PostMapping("/register")
    public void register(@RequestBody UserRegisterBody userRegisterBody) {
        messageBoardUserService.register(userRegisterBody);
    }

    /**
     * 个人信息
     *
     * @return
     */
    @LoginRequire
    @GetMapping("/profile")
    public UserEntity profile() {
        return messageBoardUserService.profile();
    }

    /**
     * 分页查询用户列表
     *
     * @param userPageReq
     * @return
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN})
    @GetMapping("/page")
    public Page<UserEntity> page(@Validated UserPageReq userPageReq) {
        return messageBoardUserService.page(userPageReq);
    }

    /**
     * 新增用户
     *
     * @param addUserReq
     */
    @LoginRequire(requireRoles = {UserRoleEnum.ADMIN})
    @PostMapping
    public void addUser(@RequestBody @Validated AddUserReq addUserReq) {
        messageBoardUserService.addUser(addUserReq);
    }

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
            Files.write(Paths.get(imgsDir, newFileId), file.getBytes(), StandardOpenOption.CREATE);
            return newFileId;
        } catch (IOException e) {
            throw ApplicationException.ae(e.getMessage(), e);
        }
    }
}
