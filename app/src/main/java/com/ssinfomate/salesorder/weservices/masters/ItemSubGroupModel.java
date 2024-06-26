package com.ssinfomate.salesorder.weservices.masters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemSubGroupModel {

    @SerializedName("itemsubgrp_key")
    @Expose
    private String itemsubgrpKey;
    @SerializedName("itemsubgrp_name")
    @Expose
    private String itemsubgrpName;
    @SerializedName("itemgrp_key")
    @Expose
    private String itemgrpKey;

    /**
     * No args constructor for use in serialization
     *
     */
    public ItemSubGroupModel() {
    }

    /**
     *
     * @param itemgrpKey
     * @param itemsubgrpKey
     * @param itemsubgrpName
     */
    public ItemSubGroupModel(String itemsubgrpKey, String itemsubgrpName, String itemgrpKey) {
        super();
        this.itemsubgrpKey = itemsubgrpKey;
        this.itemsubgrpName = itemsubgrpName;
        this.itemgrpKey = itemgrpKey;
    }

    public String getItemsubgrpKey() {
        return itemsubgrpKey;
    }

    public void setItemsubgrpKey(String itemsubgrpKey) {
        this.itemsubgrpKey = itemsubgrpKey;
    }

    public String getItemsubgrpName() {
        return itemsubgrpName;
    }

    public void setItemsubgrpName(String itemsubgrpName) {
        this.itemsubgrpName = itemsubgrpName;
    }

    public String getItemgrpKey() {
        return itemgrpKey;
    }

    public void setItemgrpKey(String itemgrpKey) {
        this.itemgrpKey = itemgrpKey;
    }

}