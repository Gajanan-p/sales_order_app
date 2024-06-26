package com.ssinfomate.salesorder.weservices.custregistrationmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StationListModel {

    @SerializedName("stn_key")
    @Expose
    private String stnKey;
    @SerializedName("stn_name")
    @Expose
    private String stnName;

    /**
     * No args constructor for use in serialization
     *
     */
    public StationListModel() {
    }

    /**
     *
     * @param stnKey
     * @param stnName
     */
    public StationListModel(String stnKey, String stnName) {
        super();
        this.stnKey = stnKey;
        this.stnName = stnName;
    }

    public String getStnKey() {
        return stnKey;
    }

    public void setStnKey(String stnKey) {
        this.stnKey = stnKey;
    }

    public String getStnName() {
        return stnName;
    }

    public void setStnName(String stnName) {
        this.stnName = stnName;
    }

}