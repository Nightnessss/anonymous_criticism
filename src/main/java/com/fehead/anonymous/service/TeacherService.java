package com.fehead.anonymous.service;

import com.fehead.anonymous.controller.vo.CommentDetailVO;
import com.fehead.anonymous.controller.vo.TeacherDetailVO;
import com.fehead.anonymous.controller.vo.TeacherListsVO;
import com.fehead.anonymous.controller.vo.UserVO;
import com.fehead.anonymous.error.BusinessException;
import com.fehead.anonymous.model.CommentModel;

import java.util.List;

public interface TeacherService {

    public TeacherDetailVO getById(int id) throws BusinessException;

    public List<CommentDetailVO> getCommentById(int id, int page);

    public List<UserVO> getAllUserByPageId(int page) throws BusinessException;

    public UserVO selectByPrimaryKey(int id);

    public List<TeacherListsVO> getAllTeacher(int p) throws BusinessException;

    public void insert(int teacherId,String commentContent,boolean isAnonymous,int userId);

}
