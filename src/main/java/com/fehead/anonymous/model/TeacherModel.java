package com.fehead.anonymous.model;

public class TeacherModel {
    private int teacherId;
    private String teacherName;
    private String teacherPhoto;
    private String teacherIntroduction;
    private String teacherCollege;
    private String teacherDegree;
    private int commentNumber;

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPhoto() {
        return teacherPhoto;
    }

    public void setTeacherPhoto(String teacherPhoto) {
        this.teacherPhoto = teacherPhoto;
    }

    public String getTeacherIntroduction() {
        return teacherIntroduction;
    }

    public void setTeacherIntroduction(String teacherIntroduction) {
        this.teacherIntroduction = teacherIntroduction;
    }

    public String getTeacherCollege() {
        return teacherCollege;
    }

    public void setTeacherCollege(String teacherCollege) {
        this.teacherCollege = teacherCollege;
    }

    public String getTeacherDegree() {
        return teacherDegree;
    }

    public void setTeacherDegree(String teacherDegree) {
        this.teacherDegree = teacherDegree;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    @Override
    public String toString() {
        return "TeacherModel{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherPhoto='" + teacherPhoto + '\'' +
                ", teacherIntroduction='" + teacherIntroduction + '\'' +
                ", teacherCollege='" + teacherCollege + '\'' +
                ", teacherDegree='" + teacherDegree + '\'' +
                ", commentNumber=" + commentNumber +
                '}';
    }
}
