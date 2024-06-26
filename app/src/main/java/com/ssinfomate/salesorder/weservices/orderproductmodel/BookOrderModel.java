package com.ssinfomate.salesorder.weservices.orderproductmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookOrderModel {

    @SerializedName("style_key")
    @Expose
    private String styleKey;
    @SerializedName("Shade_key")
    @Expose
    private String shadeKey;
    @SerializedName("stylecode")
    @Expose
    private String stylecode;
    @SerializedName("Shadename")
    @Expose
    private String shadename;
    @SerializedName("wsp")
    @Expose
    private String wsp;

    /**
     * No args constructor for use in serialization
     *
     */
    public BookOrderModel() {
    }

    /**
     *
     * @param shadename
     * @param wsp
     * @param shadeKey
     * @param styleKey
     * @param stylecode
     */
    public BookOrderModel(String styleKey, String shadeKey, String stylecode, String shadename, String wsp) {
        super();
        this.styleKey = styleKey;
        this.shadeKey = shadeKey;
        this.stylecode = stylecode;
        this.shadename = shadename;
        this.wsp = wsp;
    }

    public String getStyleKey() {
        return styleKey;
    }

    public void setStyleKey(String styleKey) {
        this.styleKey = styleKey;
    }

    public String getShadeKey() {
        return shadeKey;
    }

    public void setShadeKey(String shadeKey) {
        this.shadeKey = shadeKey;
    }

    public String getStylecode() {
        return stylecode;
    }

    public void setStylecode(String stylecode) {
        this.stylecode = stylecode;
    }

    public String getShadename() {
        return shadename;
    }

    public void setShadename(String shadename) {
        this.shadename = shadename;
    }

    public String getWsp() {
        return wsp;
    }

    public void setWsp(String wsp) {
        this.wsp = wsp;
    }

}