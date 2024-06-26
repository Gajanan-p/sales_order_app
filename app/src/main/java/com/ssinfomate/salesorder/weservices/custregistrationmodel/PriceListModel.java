package com.ssinfomate.salesorder.weservices.custregistrationmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PriceListModel {

    @SerializedName("ratecat_id")
    @Expose
    private String ratecatId;
    @SerializedName("ratecat_name")
    @Expose
    private String ratecatName;

    /**
     * No args constructor for use in serialization
     *
     */
    public PriceListModel() {
    }

    /**
     *
     * @param ratecatId
     * @param ratecatName
     */
    public PriceListModel(String ratecatId, String ratecatName) {
        super();
        this.ratecatId = ratecatId;
        this.ratecatName = ratecatName;
    }

    public String getRatecatId() {
        return ratecatId;
    }

    public void setRatecatId(String ratecatId) {
        this.ratecatId = ratecatId;
    }

    public String getRatecatName() {
        return ratecatName;
    }

    public void setRatecatName(String ratecatName) {
        this.ratecatName = ratecatName;
    }

}
