package com.ssinfomate.salesorder.weservices.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TotalSaleOrderModel {

    @SerializedName("totalorder")
    @Expose
    private String totalorder;

    /**
     * No args constructor for use in serialization
     *
     */
    public TotalSaleOrderModel() {
    }

    /**
     *
     * @param totalorder
     */
    public TotalSaleOrderModel(String totalorder) {
        super();
        this.totalorder = totalorder;
    }

    public String getTotalorder() {
        return totalorder;
    }

    public void setTotalorder(String totalorder) {
        this.totalorder = totalorder;
    }

}