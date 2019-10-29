package com.fehead.anonymous.controller.vo;

import java.util.Date;

public class CommentDetailVO {
    private int commentId;
    private String commentContent;
    private Date commentDate;
    private UserVO commentUser;
    private boolean isAnonymous;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public UserVO getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(UserVO commentUser) {
        this.commentUser = commentUser;
    }

    public boolean isAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(boolean anonymous) {
        isAnonymous = anonymous;
    }

    @Override
    public String toString() {
        return "CommentDetailVO{" +
                "commentId=" + commentId +
                ", commentContent='" + commentContent + '\'' +
                ", commentDate=" + commentDate +
                ", commentUser=" + commentUser +
                ", isAnonymous=" + isAnonymous +
                '}';
    }
}
