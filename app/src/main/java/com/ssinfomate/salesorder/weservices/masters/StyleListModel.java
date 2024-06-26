package com.ssinfomate.salesorder.weservices.masters;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StyleListModel {

    @SerializedName("style_key")
    @Expose
    private String styleKey;
    @SerializedName("style_code")
    @Expose
    private String styleCode;

    /**
     * No args constructor for use in serialization
     *
     */
    public StyleListModel() {
    }

    /**
     *
     * @param styleKey
     * @param styleCode
     */
    public StyleListModel(String styleKey, String styleCode) {
        super();
        this.styleKey = styleKey;
        this.styleCode = styleCode;
    }

    public String getStyleKey() {
        return styleKey;
    }

    public void setStyleKey(String styleKey) {
        this.styleKey = styleKey;
    }

    public String getStyleCode() {
        return styleCode;
    }

    public void setStyleCode(String styleCode) {
        this.styleCode = styleCode;
    }

}