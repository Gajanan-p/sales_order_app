package com.ssinfomate.salesorder.weservices.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestMonthlySellOrderModel {

    @SerializedName("_Created_by")
    @Expose
    private String createdBy;
    @SerializedName("cobr_id")
    @Expose
    private String cobrId;
    @SerializedName("fdate")
    @Expose
    private String fdate;
    @SerializedName("todate")
    @Expose
    private String todate;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestMonthlySellOrderModel() {
    }

    /**
     *
     * @param todate
     * @param createdBy
     * @param fdate
     * @param cobrId
     */
    public RequestMonthlySellOrderModel(String createdBy, String cobrId, String fdate, String todate) {
        super();
        this.createdBy = createdBy;
        this.cobrId = cobrId;
        this.fdate = fdate;
        this.todate = todate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCobrId() {
        return cobrId;
    }

    public void setCobrId(String cobrId) {
        this.cobrId = cobrId;
    }

    public String getFdate() {
        return fdate;
    }

    public void setFdate(String fdate) {
        this.fdate = fdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

}