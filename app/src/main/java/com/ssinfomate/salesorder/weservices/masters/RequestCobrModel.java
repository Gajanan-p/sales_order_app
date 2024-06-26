package com.ssinfomate.salesorder.weservices.masters;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestCobrModel {

    @SerializedName("cobr_id")
    @Expose
    private String cobrId;
    @SerializedName("itemgrp_key")
    @Expose
    private String itemgrpKey;
    @SerializedName("item_key")
    @Expose
    private String itemKey;
    @SerializedName("brand_key")
    @Expose
    private String brandKey;
    @SerializedName("style_key")
    @Expose
    private String styleKey;


    /**
     * No args constructor for use in serialization
     *
     */
    public RequestCobrModel() {
    }

    /**
     *
     * @param itemgrpKey
     * @param cobrId
     * @param styleKey
     * @param itemKey
     * @param brandKey

     */
    public RequestCobrModel(String cobrId, String itemgrpKey, String itemKey, String brandKey, String styleKey) {
        super();
        this.cobrId = cobrId;
        this.itemgrpKey = itemgrpKey;
        this.itemKey = itemKey;
        this.brandKey = brandKey;
        this.styleKey = styleKey;
    }

    public String getCobrId() {
        return cobrId;
    }

    public void setCobrId(String cobrId) {
        this.cobrId = cobrId;
    }

    public String getItemgrpKey() {
        return itemgrpKey;
    }

    public void setItemgrpKey(String itemgrpKey) {
        this.itemgrpKey = itemgrpKey;
    }

    public String getItemKey() {
        return itemKey;
    }

    public void setItemKey(String itemKey) {
        this.itemKey = itemKey;
    }

    public String getBrandKey() {
        return brandKey;
    }

    public void setBrandKey(String brandKey) {
        this.brandKey = brandKey;
    }

    public String getStyleKey() {
        return styleKey;
    }

    public void setStyleKey(String styleKey) {
        this.styleKey = styleKey;
    }
}