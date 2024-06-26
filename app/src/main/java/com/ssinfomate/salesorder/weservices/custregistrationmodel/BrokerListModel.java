package com.ssinfomate.salesorder.weservices.custregistrationmodel;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BrokerListModel {

    @SerializedName("led_key")
    @Expose
    private String ledKey;
    @SerializedName("Led_Name")
    @Expose
    private String ledName;

    /**
     * No args constructor for use in serialization
     *
     */
    public BrokerListModel() {
    }

    /**
     *
     * @param ledName
     * @param ledKey
     */
    public BrokerListModel(String ledKey, String ledName) {
        super();
        this.ledKey = ledKey;
        this.ledName = ledName;
    }

    public String getLedKey() {
        return ledKey;
    }

    public void setLedKey(String ledKey) {
        this.ledKey = ledKey;
    }

    public String getLedName() {
        return ledName;
    }

    public void setLedName(String ledName) {
        this.ledName = ledName;
    }

}