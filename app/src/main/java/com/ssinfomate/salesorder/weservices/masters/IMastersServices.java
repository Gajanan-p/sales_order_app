package com.ssinfomate.salesorder.weservices.masters;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IMastersServices {

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<ItemGroupModel>> getItemGroupModel(@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<ItemSubGroupModel>> getItemSubGroupModel(@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<ItemSizeListModel>> getItemSizeListModel(@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<ShadeListModel>> getShadeListModel (@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<StationStateCountryModel>> getStationStateCountryModel(@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<StyleListModel>> getStyleListModel(@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<StyleSizeListModel>> getStyleSizeListModel(@Body JsonObject object);

    @Headers("Content-Type: application/json")
    @POST("api/User/itemgroup")
    Call<ArrayList<TypeListModel>> getTypeListModel(@Body JsonObject object);


//     @Headers("Content-Type: application/json")
//    @GET("api/User/Accounttype")
//    Call<ArrayList<AccountTypeModel>> getAccountTypeData();
}
