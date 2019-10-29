package com.fehead.anonymous;

import com.fehead.anonymous.model.CommentModel;
import com.fehead.anonymous.model.TeacherModel;
import com.fehead.anonymous.model.UserModel;
import com.fehead.anonymous.service.CloudService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
 * @author Nightnessss 2019/8/25 20:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CloudTest {

    @Autowired
    private CloudService cloudService;

    /**
     * 测试获取所有教师信息
     */
    @Test
    public void getAllTeacher() {
        List<TeacherModel> list = cloudService.getAllTeacher(1);

        for (TeacherModel teacherModel : list) {
            System.out.println(teacherModel.toString());
        }
    }

    /**
     * 测试通过教师id查评论
     */
    @Test
    public void getCommentById() {
        List<CommentModel> list = cloudService.getCommentById(1, 1);
        for (CommentModel commentModel: list) {
            System.out.println(commentModel.toString());
        }
    }

    /**
     * 测试通过教师id查找教师
     */
    @Test
    public void getTeacherById() {
        TeacherModel teacherModel = cloudService.getTeacherById(1);
        System.out.println(teacherModel.toString());
    }

    /**
     * 分页查找所有用户信息
     */
    @Test
    public void getAllUserByPageId() {
        List<UserModel> list = cloudService.getAllUserByPageId(1);
        for (UserModel userModel : list) {
            System.out.println(userModel.toString());
        }
    }

    /**
     * 通过用户id查找用户
     */
    @Test
    public void selectByPrimaryKey() {
        UserModel userModel = cloudService.selectByPrimaryKey(1);
        System.out.println(userModel.toString());
    }

    @Test
    public void insert() {
        cloudService.insert(1, "qweret", true, 1);
    }
}
