package com.ssinfomate.salesorder.weservices.userloginmodel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IUserLoginService {

    @Headers("Content-type: application/json")
    @POST("api/User/Login")
    Call<ArrayList<UserModel>> getUserModel(@Body RequestUser user);

    @Headers("Content-type:application/json")
    @GET("api/User/companylist")
    Call<ArrayList<ChangeCompanyModel>> getChangeCompany();
}
