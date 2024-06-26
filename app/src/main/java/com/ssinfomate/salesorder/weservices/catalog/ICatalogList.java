package com.ssinfomate.salesorder.weservices.catalog;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


public interface ICatalogList {

    @Headers("Content-Type: application/json")
    @POST("api/User/catlogdata")
    Call<ArrayList<CatalogListViewModel>> getCatalogList (@Body RequestCatalog requestCatalog);

}
