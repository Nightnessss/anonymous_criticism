package com.fehead.anonymous.service.impl;

import com.fehead.anonymous.controller.vo.CommentDetailVO;
import com.fehead.anonymous.controller.vo.TeacherDetailVO;
import com.fehead.anonymous.controller.vo.TeacherListsVO;
import com.fehead.anonymous.controller.vo.UserVO;
import com.fehead.anonymous.error.BusinessException;
import com.fehead.anonymous.error.EmBusinessError;
import com.fehead.anonymous.model.CommentModel;
import com.fehead.anonymous.model.TeacherModel;
import com.fehead.anonymous.model.UserModel;
import com.fehead.anonymous.service.CloudService;
import com.fehead.anonymous.service.TeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    CloudService cloudService;

    @Override
    public TeacherDetailVO getById(int id) throws BusinessException {

        TeacherDetailVO teacherDetailVO = new TeacherDetailVO();
        TeacherModel teacherModel = cloudService.getTeacherById(id);
        BeanUtils.copyProperties(teacherModel, teacherDetailVO);
        return teacherDetailVO;
    }

    @Override
    public List<CommentDetailVO> getCommentById(int id, int page) {

        List<CommentDetailVO> comments = new ArrayList<>();
        List<CommentModel> commentModelList = cloudService.getCommentById(id, page);
        for(CommentModel commentModel:commentModelList){
            CommentDetailVO commentDetailVO = new CommentDetailVO();
            BeanUtils.copyProperties(commentModel, commentDetailVO);
//            System.out.println(commentDetailVO.toString());
            comments.add(commentDetailVO);
        }

//        System.out.println(comments);
        return comments;
    }

    @Override
    public List<UserVO> getAllUserByPageId(int p) throws BusinessException {
        List<UserModel> userModelList = new ArrayList<>();
        List<UserVO> userVOList =new ArrayList<>();
        try {
            userModelList = cloudService.getAllUserByPageId(p);
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATA_ERROR);
        }
        for (UserModel userModel1:userModelList) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(userModel1, userVO);
            userVOList.add(userVO);
        }
        return userVOList;
    }

    @Override
    public UserVO selectByPrimaryKey(int id){
        UserModel userModel = cloudService.selectByPrimaryKey(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

    @Override
    public List<TeacherListsVO> getAllTeacher(int p) throws BusinessException {

        List<TeacherListsVO> teacherListsVOList = new ArrayList<>();
        List<TeacherModel> teacherModelList = new ArrayList<>();
        try {
            teacherModelList = cloudService.getAllTeacher(p);
        } catch (Exception e) {
            throw new BusinessException(EmBusinessError.DATA_ERROR);
        }
        for(TeacherModel teacherModel:teacherModelList){
            TeacherListsVO teacherListsVO = new TeacherListsVO();
            BeanUtils.copyProperties(teacherModel, teacherListsVO);
            teacherListsVOList.add(teacherListsVO);
        }
        return teacherListsVOList;
    }

    @Override
    public void insert(int teacherId,String commentContent,boolean isAnonymous,int userId){
        cloudService.insert(teacherId,commentContent,isAnonymous,userId);
    }

}
