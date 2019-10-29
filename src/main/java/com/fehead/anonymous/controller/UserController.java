package com.fehead.anonymous.controller;

import com.fehead.anonymous.error.BusinessException;
import com.fehead.anonymous.response.CommonReturnType;
import com.fehead.anonymous.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 写代码 敲快乐
 * だからよ...止まるんじゃねぇぞ
 * ▏n
 * █▏　､⺍
 * █▏ ⺰ʷʷｨ
 * █◣▄██◣
 * ◥██████▋
 * 　◥████ █▎
 * 　　███▉ █▎
 * 　◢████◣⌠ₘ℩
 * 　　██◥█◣\≫
 * 　　██　◥█◣
 * 　　█▉　　█▊
 * 　　█▊　　█▊
 * 　　█▊　　█▋
 * 　　 █▏　　█▙
 * 　　 █
 *
 * @author Nightnessss 2019/8/15 17:28
 */
@RequestMapping("/api/v1.0/model/user")
@RestController
@CrossOrigin("*")
public class UserController {

    @Autowired
    private TeacherService teacherService;

    /**
     * 分页获取所有用户信息
     * @param page
     * @return
     * @throws BusinessException
     */
    @GetMapping
    @ApiOperation("分页获取所有用户信息")
    public CommonReturnType getAllUserByPageId(@RequestParam(value = "page", defaultValue = "1") int page) throws BusinessException {

        return CommonReturnType.creat(teacherService.getAllUserByPageId(page));
    }

    //正确

    /**
     * 根据用户id获取用户信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    @ApiOperation("根据用户id获取用户信息")
    public CommonReturnType selectByPrimaryKey(@PathVariable("id") int id){
        return CommonReturnType.creat(teacherService.selectByPrimaryKey(id));
    }

}
