package com.ssinfomate.salesorder.weservices.custregistrationmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountTypeModel {

    @SerializedName("Acclgrp_key")
    @Expose
    private String acclgrpKey;
    @SerializedName("Acclgrp_name")
    @Expose
    private String acclgrpName;

    /**
     * No args constructor for use in serialization
     *
     */
    public AccountTypeModel() {
    }

    /**
     *
     * @param acclgrpKey
     * @param acclgrpName
     */
    public AccountTypeModel(String acclgrpKey, String acclgrpName) {
        super();
        this.acclgrpKey = acclgrpKey;
        this.acclgrpName = acclgrpName;
    }

    public String getAcclgrpKey() {
        return acclgrpKey;
    }

    public void setAcclgrpKey(String acclgrpKey) {
        this.acclgrpKey = acclgrpKey;
    }

    public String getAcclgrpName() {
        return acclgrpName;
    }

    public void setAcclgrpName(String acclgrpName) {
        this.acclgrpName = acclgrpName;
    }

}