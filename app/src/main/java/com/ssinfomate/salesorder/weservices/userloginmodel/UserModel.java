package com.ssinfomate.salesorder.weservices.userloginmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("login_Name")
    @Expose
    private String loginName;
    @SerializedName("User_Pwd")
    @Expose
    private String userPwd;
    @SerializedName("cobrids")
    @Expose
    private String cobrids;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("WindowStatus")
    @Expose
    private String windowStatus;
    @SerializedName("IsLogin")
    @Expose
    private Integer isLogin;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserModel() {
    }

    /**
     *
     * @param msg
     * @param cobrids
     * @param isLogin
     * @param loginName
     * @param windowStatus
     * @param userPwd
     * @param userId
     */
    public UserModel(Integer userId, String loginName, String userPwd, String cobrids, String msg, String windowStatus, Integer isLogin) {
        super();
        this.userId = userId;
        this.loginName = loginName;
        this.userPwd = userPwd;
        this.cobrids = cobrids;
        this.msg = msg;
        this.windowStatus = windowStatus;
        this.isLogin = isLogin;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getCobrids() {
        return cobrids;
    }

    public void setCobrids(String cobrids) {
        this.cobrids = cobrids;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getWindowStatus() {
        return windowStatus;
    }

    public void setWindowStatus(String windowStatus) {
        this.windowStatus = windowStatus;
    }

    public Integer getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(Integer isLogin) {
        this.isLogin = isLogin;
    }

}