package com.ssinfomate.salesorder.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.weservices.WebServiceClient;
import com.ssinfomate.salesorder.weservices.home.MonthlySellOrderModel;
import com.ssinfomate.salesorder.weservices.home.RequestMonthlySellOrderModel;
import com.ssinfomate.salesorder.weservices.home.TodaySellOrderModel;
import com.ssinfomate.salesorder.weservices.home.TotalSaleOrderModel;
import com.ssinfomate.salesorder.weservices.userloginmodel.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment implements View.OnClickListener {


    NavController navController;
    AppCompatButton buttonRegistration,buttonSaleOrder,buttonOrderProduct;
    AppCompatTextView textViewTodayTotalOrder,textViewMonthlyTotalOrder,textViewTotalOrder;
    ImageView imageViewRegistration;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        textViewTodayTotalOrder = view.findViewById(R.id.text_home_today_total_order);
        textViewTodayTotalOrder.setOnClickListener(this);

        textViewMonthlyTotalOrder = view.findViewById(R.id.text_home_monthly_total_order);
        textViewMonthlyTotalOrder.setOnClickListener(this);

        textViewTotalOrder = view.findViewById(R.id.text_home_total_order);
        textViewTotalOrder.setOnClickListener(this);

        imageViewRegistration = view.findViewById(R.id.img_add_registration);
        imageViewRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_home_to_nav_registration);
            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    }

    @Override
    public void onResume() {
        super.onResume();
//        getMonthlySaleOrder();
//        getTodaySaleData();
//        getTotalSaleOrderData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.text_home_today_total_order:{
                navController.navigate(R.id.action_nav_home_to_bottom_nav_pendingOrder);
                break;
            }
            case R.id.text_home_monthly_total_order:{
                navController.navigate(R.id.action_nav_home_to_bottom_nav_pendingOrder);
                break;
            }
            case R.id.text_home_total_order:{
                navController.navigate(R.id.action_nav_home_to_bottom_nav_pendingOrder);
                break;
            }
        }
    }

    void getTodaySaleData(){
        RequestMonthlySellOrderModel todaySellOrderModel = new RequestMonthlySellOrderModel();
        UserModel userModel = AppPreference.getLoginDataPreferences(getContext());
        todaySellOrderModel.setCobrId(userModel.getCobrids());
        todaySellOrderModel.setCreatedBy("1");
        todaySellOrderModel.setFdate("01/01/2020");
        todaySellOrderModel.setTodate("22/06/2022");

        Call<ArrayList<TodaySellOrderModel>> callTodaySellOrder = WebServiceClient
                .getHomeServiceData()
                .getTodaySellOrderData(todaySellOrderModel);
        callTodaySellOrder.enqueue(new Callback<ArrayList<TodaySellOrderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TodaySellOrderModel>> call, Response<ArrayList<TodaySellOrderModel>> response) {
               if (response.isSuccessful())
               {
                   if(!response.body().get(0).getTotalorder().equals(0)) {
                       textViewTodayTotalOrder.setText(response.body().get(0).getTotalorder());
                   }else {
                       textViewTodayTotalOrder.setText(0);
                   }
               }
            }

            @Override
            public void onFailure(Call<ArrayList<TodaySellOrderModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    void getMonthlySaleOrder(){
        RequestMonthlySellOrderModel monthlySellOrderModel = new RequestMonthlySellOrderModel();
        UserModel userModel = AppPreference.getLoginDataPreferences(getContext());
        monthlySellOrderModel.setCobrId(userModel.getCobrids());
        monthlySellOrderModel.setCreatedBy("1");
        monthlySellOrderModel.setFdate("01/01/2020");
        monthlySellOrderModel.setTodate("22/06/2022");

        Call<ArrayList<MonthlySellOrderModel>> callMonthlySellOrder = WebServiceClient
                .getHomeServiceData()
                .getMonthlySellOrder(monthlySellOrderModel);
        callMonthlySellOrder.enqueue(new Callback<ArrayList<MonthlySellOrderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<MonthlySellOrderModel>> call, Response<ArrayList<MonthlySellOrderModel>> response) {
                if (response.isSuccessful()) {
//                    if (response.body().size() != 0) {
//                        textViewMonthlyTotalOrder.setText(response.body().get(0).getTotalorder());
//                    }
                }
            }

            @Override
            public void onFailure(Call<ArrayList<MonthlySellOrderModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });

    }
    
    void getTotalSaleOrderData(){
        RequestMonthlySellOrderModel totalSellOrderModel = new RequestMonthlySellOrderModel();
        UserModel userModel = AppPreference.getLoginDataPreferences(getContext());
        totalSellOrderModel.setCobrId(userModel.getCobrids());
        totalSellOrderModel.setCreatedBy("1");
        totalSellOrderModel.setFdate("01/01/2020");
        totalSellOrderModel.setTodate("22/06/2022");

        Call<ArrayList<TotalSaleOrderModel>> callTotalSaleOrder = WebServiceClient
                .getHomeServiceData()
                .getTotalSaleOrder(totalSellOrderModel);
        callTotalSaleOrder.enqueue(new Callback<ArrayList<TotalSaleOrderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TotalSaleOrderModel>> call, Response<ArrayList<TotalSaleOrderModel>> response) {
                if (response.isSuccessful()){
                    textViewTotalOrder.setText(response.body().get(0).getTotalorder());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TotalSaleOrderModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}