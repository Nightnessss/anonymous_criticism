package com.fehead.anonymous.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
public class CommentModel {
    private int commentId;
    private int teacherId;
    private int userId;
    private Date commentDate;
    private String commentContent;
    private boolean isAnonymous;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date comentDate) {
        this.commentDate = comentDate;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "commentId=" + commentId +
                ", teacherId=" + teacherId +
                ", userId=" + userId +
                ", commentDate=" + commentDate +
                ", commentContent='" + commentContent + '\'' +
                ", isAnonymous=" + isAnonymous +
                '}';
    }
}
