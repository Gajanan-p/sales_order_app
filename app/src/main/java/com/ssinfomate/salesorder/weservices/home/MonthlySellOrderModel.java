package com.ssinfomate.salesorder.weservices.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MonthlySellOrderModel {

    @SerializedName("totalorder")
    @Expose
    private String totalorder;

    /**
     * No args constructor for use in serialization
     *
     */
    public MonthlySellOrderModel() {
    }

    /**
     *
     * @param totalorder
     */
    public MonthlySellOrderModel(String totalorder) {
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