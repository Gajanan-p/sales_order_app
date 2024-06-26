package com.ssinfomate.salesorder.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.AccountTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.BrokerListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.DiscountModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.PriceListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.SaleTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.StationListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.TransporterListModel;
import com.ssinfomate.salesorder.weservices.userloginmodel.ChangeCompanyModel;
import com.ssinfomate.salesorder.weservices.userloginmodel.UserModel;

public class AppPreference {

    private static String TAG="appDataPreferences";
    public static String appPreferences="appPreferences";

    public static String appLoginPreferences="appLoginPreferences";

    public static String appLoginPreferencesKey="appLoginPreferencesKey";

    public static String appServerURlPreferences="appServerURlPreferences";

    public static String appPriceListPreferencesKey="appPriceListPreferencesKey";
    public static String appDiscountPreferencesKey="appDiscountPreferencesKey";
    public static String appAccountTypePreferencesKey="appAccountTypePreferencesKey";
    public static String appSaleTypePreferencesKey="appSaleTypePreferencesKey";
    public static String appStationListPreferencesKey="appStationListPreferencesKey";
    public static String appBrokerListPreferencesKey="appBrokerListPreferencesKey";
    public static String appTransporterListPreferencesKey="appTransporterListPreferencesKey";
    public static String appChangeCompanyPreferencesKey="appChangeCompanyPreferencesKey";
    public static String appDamageReasonPreferencesKey="appDamageReasonPreferencesKey";
    public static String appNewReducedStockDataPreferencesKey="appNewReducedStockDataPreferencesKey";
    public static String appRemarkListPreferencesKey="appRemarkListPreferencesKey";
    public static String appGeneralRemarkListPreferencesKey="appGeneralRemarkListPreferencesKey";
    public static String appAdjustmentTypePreferencesKey="appAdjustmentTypePreferencesKey";

    public static SharedPreferences sharedLoginPreferences;
    public static SharedPreferences sharedServerURLPreferences;
    public static SharedPreferences sharedAppPreferences;

    public static SharedPreferences getAppSharedPreferences(Context context){
        if(sharedAppPreferences==null){
            sharedAppPreferences=context.getSharedPreferences(AppPreference.appPreferences
                    , Context.MODE_PRIVATE);
        }
        return sharedAppPreferences;
    }

    public static SharedPreferences getLoginSharedPreferences(Context context){
        if(sharedLoginPreferences==null){
            sharedLoginPreferences=context.getSharedPreferences(AppPreference.appLoginPreferences, Context.MODE_PRIVATE);
        }
        return sharedLoginPreferences;
    }
    public static SharedPreferences getServerURLSharedPreferences(Context context){
        if(sharedServerURLPreferences==null){
            sharedServerURLPreferences=context.getSharedPreferences(AppPreference.appServerURlPreferences, Context.MODE_PRIVATE);
        }
        return sharedServerURLPreferences   ;
    }

    public static void setLoginDataPreferences(Context context, UserModel userModel){
        Gson gson = new Gson();
        String data=gson.toJson(userModel);
        Log.i(TAG,"Set user model data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getLoginSharedPreferences(context).edit();
        editor.putString(appLoginPreferencesKey,data);
        editor.commit();
    }

    public static UserModel getLoginDataPreferences(Context context){
        String data=getLoginSharedPreferences(context).getString(appLoginPreferencesKey,"");
        Gson gson = new Gson();
        UserModel userModel= gson.fromJson(data,UserModel.class);
        Log.i(TAG,"get user model data");
        Log.i(TAG,data);
        return userModel;
    }

    public static boolean clearLoginDataPreferences(Context context){
        SharedPreferences.Editor editor=getLoginSharedPreferences(context).edit();
        editor.clear();
        editor.apply();
        editor.commit();
        Log.i(TAG,"Clear login Preferences");
        return true;
    }
    public static void setServerUrlDataPreferences(Context context, DynamicServerURL dynamicServerURL){
        Gson gson = new Gson();
        String data=gson.toJson(dynamicServerURL);
        Log.i(TAG,"Set Dynamic Server Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appServerURlPreferences,data);
        editor.commit();
    }

    public static DynamicServerURL getServerUrlDataPreferences(Context context){
        String data=getServerURLSharedPreferences(context).getString(appServerURlPreferences,"");
        Gson gson = new Gson();
        DynamicServerURL dynamicServerURL= gson.fromJson(data,DynamicServerURL.class);
        Log.i(TAG,"get Setting model data");
        Log.i(TAG,data);
        return dynamicServerURL;
    }

    public static void setChangeCompanyListPreferences(Context context, ChangeCompanyModel changeCompanyModel){
        Gson gson = new Gson();
        String data=gson.toJson(changeCompanyModel);
        Log.i(TAG,"Set ChangeCompanyList Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appChangeCompanyPreferencesKey,data);
        editor.commit();
    }

    public static ChangeCompanyModel getChangeCompanyListPreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appChangeCompanyPreferencesKey,"");
        Gson gson = new Gson();
        ChangeCompanyModel changeCompanyModel= gson.fromJson(data,ChangeCompanyModel.class);
        Log.i(TAG,"get ChangeCompanyList data "+ data);
        Log.i(TAG,data);
        return changeCompanyModel;
    }

    public static void setPriceListPreferences(Context context, PriceListModel priceListModel){
        Gson gson = new Gson();
        String data=gson.toJson(priceListModel);
        Log.i(TAG,"Set prise list Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appPriceListPreferencesKey,data);
        editor.commit();
    }

    public static PriceListModel getPriceListPreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appPriceListPreferencesKey,"");
        Gson gson = new Gson();
        PriceListModel priceListModel= gson.fromJson(data,PriceListModel.class);
        Log.i(TAG,"get price list data "+ data);
        Log.i(TAG,data);
        return priceListModel;
    }

    public static void setDiscountPreferences(Context context, DiscountModel discountModel){
        Gson gson = new Gson();
        String data=gson.toJson(discountModel);
        Log.i(TAG,"Set Discount Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appDiscountPreferencesKey,data);
        editor.commit();
    }

    public static DiscountModel getDiscountPreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appDiscountPreferencesKey,"");
        Gson gson = new Gson();
        DiscountModel discountModel= gson.fromJson(data,DiscountModel.class);
        Log.i(TAG,"get Discount data "+ data);
        Log.i(TAG,data);
        return discountModel;
    }
    public static void setAccountTypePreferences(Context context, AccountTypeModel accountTypeModel){
        Gson gson = new Gson();
        String data=gson.toJson(accountTypeModel);
        Log.i(TAG,"Set AccountType Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appAccountTypePreferencesKey,data);
        editor.commit();
    }

    public static AccountTypeModel getAccountTypePreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appAccountTypePreferencesKey,"");
        Gson gson = new Gson();
        AccountTypeModel accountTypeModel= gson.fromJson(data,AccountTypeModel.class);
        Log.i(TAG,"get AccountType data "+ data);
        Log.i(TAG,data);
        return accountTypeModel;
    }

    public static void setSaleTypePreferences(Context context, SaleTypeModel saleTypeModel){
        Gson gson = new Gson();
        String data=gson.toJson(saleTypeModel);
        Log.i(TAG,"Set SaleType Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appSaleTypePreferencesKey,data);
        editor.commit();
    }

    public static SaleTypeModel getSaleTypePreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appSaleTypePreferencesKey,"");
        Gson gson = new Gson();
        SaleTypeModel saleTypeModel= gson.fromJson(data,SaleTypeModel.class);
        Log.i(TAG,"get SaleType data "+ data);
        Log.i(TAG,data);
        return saleTypeModel;
    }
    public static void setStationListPreferences(Context context, StationListModel stationListModel){
        Gson gson = new Gson();
        String data=gson.toJson(stationListModel);
        Log.i(TAG,"Set StationList Data");
         Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appStationListPreferencesKey,data);
        editor.commit();
    }

    public static StationListModel getStationListPreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appStationListPreferencesKey,"");
        Gson gson = new Gson();
        StationListModel stationListModel= gson.fromJson(data,StationListModel.class);
        Log.i(TAG,"get StationList data "+ data);
        Log.i(TAG,data);
        return stationListModel;
    }
    public static void setBrokerListPreferences(Context context, BrokerListModel brokerListModel){
        Gson gson = new Gson();
        String data=gson.toJson(brokerListModel);
        Log.i(TAG,"Set BrokerList Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appBrokerListPreferencesKey,data);
        editor.commit();
    }

    public static BrokerListModel getBrokerListPreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appBrokerListPreferencesKey,"");
        Gson gson = new Gson();
        BrokerListModel brokerListModel= gson.fromJson(data,BrokerListModel.class);
        Log.i(TAG,"get BrokerList data "+ data);
        Log.i(TAG,data);
        return brokerListModel;
    }

    public static void setTransporterListPreferences(Context context, TransporterListModel transporterListModel){
        Gson gson = new Gson();
        String data=gson.toJson(transporterListModel);
        Log.i(TAG,"Set TransporterList Data");
        Log.i(TAG,data);
        SharedPreferences.Editor editor=getAppSharedPreferences(context).edit();
        editor.putString(appTransporterListPreferencesKey,data);
        editor.commit();
    }

    public static TransporterListModel getTransporterListPreferences(Context context){
        String data=getAppSharedPreferences(context).getString(appTransporterListPreferencesKey,"");
        Gson gson = new Gson();
        TransporterListModel transporterListModel= gson.fromJson(data,TransporterListModel.class);
        Log.i(TAG,"get TransporterList data "+ data);
        Log.i(TAG,data);
        return transporterListModel;
    }

}
