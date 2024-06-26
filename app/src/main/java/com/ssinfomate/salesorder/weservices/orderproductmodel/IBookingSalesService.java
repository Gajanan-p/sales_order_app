package com.ssinfomate.salesorder.weservices.orderproductmodel;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface IBookingSalesService {

    @Headers("Content-Type: application/json")
    @POST("api/User/barcodescan")
    Call<ArrayList<BookOrderModel>> getBookOrderList(@Body RequestBookOrderModel bookOrderModel);


}
