package com.fehead.anonymous.controller;

import com.fehead.anonymous.controller.vo.TeacherDetailVO;
import com.fehead.anonymous.controller.vo.TeacherListsVO;
import com.fehead.anonymous.error.BusinessException;
import com.fehead.anonymous.model.TeacherModel;
import com.fehead.anonymous.response.CommonReturnType;
import com.fehead.anonymous.service.CloudService;
import com.fehead.anonymous.service.TeacherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
 * @author Nightnessss 2019/8/15 17:29
 */
@RestController
@RequestMapping("/api/v1.0/teacher")
@CrossOrigin("*")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @Autowired
    CloudService cloudService;

    /**
     * 分页获取教师信息
     * @param page
     * @return
     * @throws BusinessException
     */
    @GetMapping("/lists")
    @ApiOperation("分页获取教师信息")
    public CommonReturnType getAllTeacher(@RequestParam(value = "page", defaultValue = "1") int page) throws BusinessException {

//        List<TeacherModel> teacherList = cloudService.getAllTeacher(1);
        List<TeacherListsVO> teacherList = teacherService.getAllTeacher(page);
        return CommonReturnType.creat(teacherList);

    }

    /**
     * 获取教师详细信息
     * @param id
     * @return
     * @throws BusinessException
     */
    @GetMapping("/lists/{id}")
    @ApiOperation("通过教师id获取教师详细信息")
    public CommonReturnType getById(@PathVariable("id") Integer id) throws BusinessException {
        return CommonReturnType.creat(teacherService.getById(id));
    }







}
