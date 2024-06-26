package com.ssinfomate.salesorder.weservices.custregistrationmodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ICustRegService {


    @Headers("Content-Type: application/json")
    @GET("api/User/Accounttype")
    Call<ArrayList<AccountTypeModel>> getAccountTypeData();

    @Headers("Content-Type: application/json")
    @GET("api/User/pricelist")
    Call<ArrayList<PriceListModel>> getPriceListData();

    @Headers("Content-Type: application/json")
    @GET("api/User/Discounttaxtermstds")
    Call<ArrayList<DiscountModel>> getDiscountData();

    @Headers("Content-Type: application/json")
    @GET("api/User/saletype")
    Call<ArrayList<SaleTypeModel>> getSaleTypeData();

    @Headers("Content-Type: application/json")
    @POST("api/User/CustomerRegistration")
    Call<SaveCustomerRegistrationModel> setSaveCustomerRegistrationData(@Body RequestSaveCustomerRegistrationModel requestSaveCustomerRegistrationModel);

    @Headers("Content-Type: application/json")
    @GET("api/User/Stationlist")
    Call<ArrayList<StationListModel>> getStationListData();

    @Headers("Content-Type: application/json")
    @GET("api/User/Brokerlist")
    Call<ArrayList<BrokerListModel>> getBrokerListData();

    @Headers("Content-Type: application/json")
    @GET("api/User/transpoterlist")
    Call<ArrayList<TransporterListModel>> getTransporterListData();

}
