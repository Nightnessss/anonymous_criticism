package com.fehead.anonymous.service;

import com.fehead.anonymous.controller.vo.CommentDetailVO;
import com.fehead.anonymous.model.CommentModel;
import com.fehead.anonymous.model.TeacherModel;
import com.fehead.anonymous.model.UserModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "DATA-SERVER")
public interface CloudService {

    @GetMapping("/api/v1.0/model/comment/{teacherId}")
    public List<CommentModel> getCommentById(@PathVariable("teacherId") int teacherId, @RequestParam("p") int p);

    @GetMapping("/api/v1.0/model/teacher/{id}")
    public TeacherModel getTeacherById(@PathVariable("id") int id);

    @GetMapping("/api/v1.0/model/teacher")
    public List<TeacherModel> getAllTeacher(@RequestParam("p") int p);

    @GetMapping("/api/v1.0/model/user")
    public List<UserModel> getAllUserByPageId(@RequestParam("p") int p);

    @GetMapping("/api/v1.0/model/user/{id}")
    public UserModel selectByPrimaryKey(@PathVariable("id") int id);

    @GetMapping("/api/v1.0/model/login/thirdPartyId")
    public UserModel alreadyLogin(@RequestParam("thirdPartyId") String thirdPartyId);

    @PostMapping("/api/v1.0/model/comment/{teacherId}")
    public void insert(@PathVariable("teacherId") int teacherId,
                                  @RequestParam("commentContent") String commentContent,
                                  @RequestParam("isAnonymous") boolean isAnonymous,
                                  @RequestParam("userId") int userId);

    @PostMapping("/api/v1.0/model/login/addUser")
    public int addUser(@RequestBody UserModel userModel);
}
