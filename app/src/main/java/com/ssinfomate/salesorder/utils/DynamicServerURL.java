package com.ssinfomate.salesorder.utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DynamicServerURL {
    @SerializedName("server_url")
    @Expose
    private String serverURL;


    public DynamicServerURL(String serverURL)

    {
        this.serverURL = serverURL;
    }

    public String getServerURL() {
        return serverURL;
    }

    public void setServerURL(String serverURL) {
        this.serverURL = serverURL;
    }
}
