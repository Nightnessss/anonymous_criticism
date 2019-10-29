package com.fehead.anonymous.controller;

import com.fehead.anonymous.error.BusinessException;
import com.fehead.anonymous.error.EmBusinessError;
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
 * @author Nightnessss 2019/8/15 17:29
 */
@RestController
@RequestMapping("/api/v1.0/comment")
@CrossOrigin("*")
public class CommentController extends BaseController {
    @Autowired
    private TeacherService teacherService;

    /**
     * 发布评论
     * @param teacherId
     * @param commentContent
     * @param isAnonymous
     * @param userId
     * @return
     * @throws BusinessException
     */
    @PostMapping("/send")
    @ApiOperation("发送评论")
    public CommonReturnType insert(@RequestParam("teacherId") int teacherId,
                                   @RequestParam("commentContent") String commentContent,
                                   @RequestParam("isAnonymous") boolean isAnonymous,
                                   @RequestParam("userId") int userId) throws BusinessException {
        if(commentContent.isEmpty()||userId == 0 ||teacherId == 0 ){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数异常");
        }
        teacherService.insert(teacherId,commentContent,isAnonymous,userId);
        return  CommonReturnType.creat("评论成功");

    }

    /**
     * 通过教师id获取评论
     * @param id
     * @param page
     * @return
     */
    @GetMapping("lists/{id}")
    @ApiOperation("通过教师id获取评论")
    public CommonReturnType getCommentById(@PathVariable("id") Integer id, @RequestParam(name = "page", defaultValue = "1") int page){
        return CommonReturnType.creat(teacherService.getCommentById(id, page));
    }

}
