package com.ssinfomate.salesorder.weservices.custregistrationmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscountModel {

    @SerializedName("txtmtds_key")
    @Expose
    private String txtmtdsKey;
    @SerializedName("txtmtds_Name")
    @Expose
    private String txtmtdsName;
    @SerializedName("tax1Led_perc")
    @Expose
    private String tax1LedPerc;
    @SerializedName("addsubtract")
    @Expose
    private String addsubtract;

    /**
     * No args constructor for use in serialization
     *
     */
    public DiscountModel() {
    }

    /**
     *
     * @param txtmtdsName
     * @param addsubtract
     * @param tax1LedPerc
     * @param txtmtdsKey
     */
    public DiscountModel(String txtmtdsKey, String txtmtdsName, String tax1LedPerc, String addsubtract) {
        super();
        this.txtmtdsKey = txtmtdsKey;
        this.txtmtdsName = txtmtdsName;
        this.tax1LedPerc = tax1LedPerc;
        this.addsubtract = addsubtract;
    }

    public String getTxtmtdsKey() {
        return txtmtdsKey;
    }

    public void setTxtmtdsKey(String txtmtdsKey) {
        this.txtmtdsKey = txtmtdsKey;
    }

    public String getTxtmtdsName() {
        return txtmtdsName;
    }

    public void setTxtmtdsName(String txtmtdsName) {
        this.txtmtdsName = txtmtdsName;
    }

    public String getTax1LedPerc() {
        return tax1LedPerc;
    }

    public void setTax1LedPerc(String tax1LedPerc) {
        this.tax1LedPerc = tax1LedPerc;
    }

    public String getAddsubtract() {
        return addsubtract;
    }

    public void setAddsubtract(String addsubtract) {
        this.addsubtract = addsubtract;
    }

}