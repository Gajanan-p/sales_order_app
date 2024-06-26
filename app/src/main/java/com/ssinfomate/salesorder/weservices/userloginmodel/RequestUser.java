package com.ssinfomate.salesorder.weservices.userloginmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestUser {
    @SerializedName("login_Name")
    @Expose
    private String loginName;
    @SerializedName("User_Pwd")
    @Expose
    private String userPwd;
    @SerializedName("cobr_id")
    @Expose
    private String cobrId;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestUser() {
    }

    /**
     *
     * @param loginName
     * @param userPwd
     * @param cobrId
     */
    public RequestUser(String loginName, String userPwd, String cobrId) {
        super();
        this.loginName = loginName;
        this.userPwd = userPwd;
        this.cobrId = cobrId;
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

    public String getCobrId() {
        return cobrId;
    }

    public void setCobrId(String cobrId) {
        this.cobrId = cobrId;
    }

}