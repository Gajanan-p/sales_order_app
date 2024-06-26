package com.ssinfomate.salesorder.weservices.home;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TodaySellOrderModel {

    @SerializedName("totalorder")
    @Expose
    private String totalorder;

    /**
     * No args constructor for use in serialization
     *
     */
    public TodaySellOrderModel() {
    }

    /**
     *
     * @param totalorder
     */
    public TodaySellOrderModel(String totalorder) {
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