package com.ssinfomate.salesorder.weservices.orderproductmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestBookOrderModel {

    @SerializedName("cobr_id")
    @Expose
    private String cobrId;
    @SerializedName("barcode")
    @Expose
    private String barcode;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestBookOrderModel() {
    }

    /**
     *
     * @param cobrId
     * @param barcode
     */
    public RequestBookOrderModel(String cobrId, String barcode) {
        super();
        this.cobrId = cobrId;
        this.barcode = barcode;
    }

    public String getCobrId() {
        return cobrId;
    }

    public void setCobrId(String cobrId) {
        this.cobrId = cobrId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

}