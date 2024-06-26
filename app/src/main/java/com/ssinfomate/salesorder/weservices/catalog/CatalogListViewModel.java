package com.ssinfomate.salesorder.weservices.catalog;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CatalogListViewModel {

    @SerializedName("itemname")
    @Expose
    private String itemname;
    @SerializedName("salerate")
    @Expose
    private String salerate;
    @SerializedName("stylecode")
    @Expose
    private String stylecode;
    @SerializedName("shadename")
    @Expose
    private String shadename;
    @SerializedName("mrp")
    @Expose
    private String mrp;
    @SerializedName("styleimagef")
    @Expose
    private String styleimagef;

    /**
     * No args constructor for use in serialization
     *
     */
    public CatalogListViewModel() {
    }

    /**
     *
     * @param shadename
     * @param salerate
     * @param itemname
     * @param styleimagef
     * @param mrp
     * @param stylecode
     */
    public CatalogListViewModel(String itemname, String salerate, String stylecode, String shadename, String mrp, String styleimagef) {
        super();
        this.itemname = itemname;
        this.salerate = salerate;
        this.stylecode = stylecode;
        this.shadename = shadename;
        this.mrp = mrp;
        this.styleimagef = styleimagef;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getSalerate() {
        return salerate;
    }

    public void setSalerate(String salerate) {
        this.salerate = salerate;
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

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getStyleimagef() {
        return styleimagef;
    }

    public void setStyleimagef(String styleimagef) {
        this.styleimagef = styleimagef;
    }

}