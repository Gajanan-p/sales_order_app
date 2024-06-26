package com.ssinfomate.salesorder.weservices.userloginmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChangeCompanyModel {

    @SerializedName("cobr_id")
    @Expose
    private String cobrId;
    @SerializedName("cobr_name")
    @Expose
    private String cobrName;

    /**
     * No args constructor for use in serialization
     *
     */
    public ChangeCompanyModel() {
    }

    /**
     *
     * @param cobrName
     * @param cobrId
     */
    public ChangeCompanyModel(String cobrId, String cobrName) {
        super();
        this.cobrId = cobrId;
        this.cobrName = cobrName;
    }

    public String getCobrId() {
        return cobrId;
    }

    public void setCobrId(String cobrId) {
        this.cobrId = cobrId;
    }

    public String getCobrName() {
        return cobrName;
    }

    public void setCobrName(String cobrName) {
        this.cobrName = cobrName;
    }

}