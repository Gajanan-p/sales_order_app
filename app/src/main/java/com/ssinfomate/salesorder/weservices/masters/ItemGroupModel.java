package com.ssinfomate.salesorder.weservices.masters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemGroupModel {

    @SerializedName("itemgrp_key")
    @Expose
    private String itemgrpKey;
    @SerializedName("itemgrp_name")
    @Expose
    private String itemgrpName;

    /**
     * No args constructor for use in serialization
     *
     */
    public ItemGroupModel() {
    }

    /**
     *
     * @param itemgrpKey
     * @param itemgrpName
     */
    public ItemGroupModel(String itemgrpKey, String itemgrpName) {
        super();
        this.itemgrpKey = itemgrpKey;
        this.itemgrpName = itemgrpName;
    }

    public String getItemgrpKey() {
        return itemgrpKey;
    }

    public void setItemgrpKey(String itemgrpKey) {
        this.itemgrpKey = itemgrpKey;
    }

    public String getItemgrpName() {
        return itemgrpName;
    }

    public void setItemgrpName(String itemgrpName) {
        this.itemgrpName = itemgrpName;
    }

}