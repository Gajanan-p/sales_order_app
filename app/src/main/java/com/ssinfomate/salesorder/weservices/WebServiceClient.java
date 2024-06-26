package com.ssinfomate.salesorder.weservices;

import com.ssinfomate.salesorder.weservices.catalog.ICatalogList;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.ICustRegService;
import com.ssinfomate.salesorder.weservices.home.IHomeService;
import com.ssinfomate.salesorder.weservices.masters.IMastersServices;
import com.ssinfomate.salesorder.weservices.orderproductmodel.IBookingSalesService;
import com.ssinfomate.salesorder.weservices.userloginmodel.IUserLoginService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebServiceClient {
    static Retrofit retrofit;
    public static String BASE_URL = "http://salesorder.greenorb.in/";
    public static ICustRegService iCustRegService;
    public static IMastersServices iMastersServices;
    public static ICatalogList iCatalogList;
    public static IUserLoginService iUserLoginService;
    public static IHomeService iHomeService;
    public static IBookingSalesService iBookingSalesService;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null)
        {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static IUserLoginService getUserLoginService()
    {
        if (iUserLoginService==null)
        {
            iUserLoginService = getRetrofitClient().create(IUserLoginService.class);
        }
        return iUserLoginService;
    }
    public static ICustRegService getCustRegServiceData()
    {
        if (iCustRegService==null)
        {
            iCustRegService=getRetrofitClient().create(ICustRegService.class);
        }
        return iCustRegService;
    }

    public static IMastersServices getMastersServicesData(){
        if (iMastersServices==null)
        {
            iMastersServices = getRetrofitClient().create(IMastersServices.class);
        }
        return iMastersServices;
    }

    public static ICatalogList getCatalogListData(){
        if (iCatalogList==null)
        {
            iCatalogList = getRetrofitClient().create(ICatalogList.class);
        }
        return iCatalogList;
    }
    public static IHomeService getHomeServiceData(){
        if (iHomeService==null)
        {
            iHomeService = getRetrofitClient().create(IHomeService.class);
        }
        return iHomeService;
    }

    public static IBookingSalesService getBookingSalesServiceData(){
        if (iBookingSalesService==null)
        {
            iBookingSalesService = getRetrofitClient().create(IBookingSalesService.class);
        }
        return iBookingSalesService;
    }
}
