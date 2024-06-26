package com.ssinfomate.salesorder.weservices.home;


import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IHomeService {

    @Headers("Content-Type: application/json")
    @POST("api/User/totalsalesorder")
    Call<ArrayList<TodaySellOrderModel>> getTodaySellOrderData (@Body RequestMonthlySellOrderModel requestMonthlySellOrderModel);

    @Headers("Content-Type: application/json")
    @POST("api/User/Monthlysalesorder")
    Call<ArrayList<MonthlySellOrderModel>> getMonthlySellOrder (@Body RequestMonthlySellOrderModel requestMonthlySellOrderModel);

    @Headers("Content-Type: application/json")
    @POST("api/User/totalsalesorder")
    Call<ArrayList<TotalSaleOrderModel>> getTotalSaleOrder (@Body RequestMonthlySellOrderModel requestMonthlySellOrderModel);
}
