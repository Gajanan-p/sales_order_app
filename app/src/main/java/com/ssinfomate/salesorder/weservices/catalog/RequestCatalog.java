package com.ssinfomate.salesorder.weservices.catalog;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RequestCatalog {

    @SerializedName("cobr_id")
    @Expose
    private String cobrId;
    @SerializedName("itemsubgrp_key")
    @Expose
    private String itemsubgrpKey;
    @SerializedName("style_key")
    @Expose
    private String styleKey;
    @SerializedName("item_name")
    @Expose
    private String itemName;
    @SerializedName("brand_key")
    @Expose
    private String brandKey;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestCatalog() {
    }

    /**
     *
     * @param itemName
     * @param itemsubgrpKey
     * @param brandKey
     * @param styleKey
     * @param cobrId
     */
    public RequestCatalog(String cobrId, String itemsubgrpKey, String styleKey, String itemName, String brandKey) {
        super();
        this.cobrId = cobrId;
        this.itemsubgrpKey = itemsubgrpKey;
        this.styleKey = styleKey;
        this.itemName = itemName;
        this.brandKey = brandKey;
    }

    public String getCobrId() {
        return cobrId;
    }

    public void setCobrId(String cobrId) {
        this.cobrId = cobrId;
    }

    public String getItemsubgrpKey() {
        return itemsubgrpKey;
    }

    public void setItemsubgrpKey(String itemsubgrpKey) {
        this.itemsubgrpKey = itemsubgrpKey;
    }

    public String getStyleKey() {
        return styleKey;
    }

    public void setStyleKey(String styleKey) {
        this.styleKey = styleKey;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBrandKey() {
        return brandKey;
    }

    public void setBrandKey(String brandKey) {
        this.brandKey = brandKey;
    }

}