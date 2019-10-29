package com.fehead.anonymous.model;

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
 * @author Nightnessss 2019/8/15 17:35
 */
public class UserModel {

    private int userId;
    private String username;
    private String userAvatar;
    private String yibanAccount;

    public UserModel(String username, String userAvatar, String yibanAccount) {
        this.username = username;
        this.userAvatar = userAvatar;
        this.yibanAccount = yibanAccount;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getYibanAccount() {
        return yibanAccount;
    }

    public void setYibanAccount(String yibanAccount) {
        this.yibanAccount = yibanAccount;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", userAvatar='" + userAvatar + '\'' +
                ", yibanAccount='" + yibanAccount + '\'' +
                '}';
    }
}
