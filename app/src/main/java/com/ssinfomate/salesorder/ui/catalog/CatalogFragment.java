package com.ssinfomate.salesorder.ui.catalog;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.PersistableBundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.weservices.WebServiceClient;
import com.ssinfomate.salesorder.weservices.catalog.CatalogListViewModel;
import com.ssinfomate.salesorder.weservices.catalog.RequestCatalog;
import com.ssinfomate.salesorder.weservices.userloginmodel.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatalogFragment extends Fragment implements View.OnClickListener,
             ICatalogListener{

    RecyclerView recycleCatalogList;
    ICatalogListener iCatalogListener;
    private  CatalogListAdapter catalogListAdapter;
    private ArrayList<CatalogListViewModel> listCatalogList;
    public static CatalogFragment newInstance() {
        return new CatalogFragment();
    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_catalog);
//
//        recycleCatalogList = findViewById(R.id.recycle_catalog_list);
//    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        recycleCatalogList = view.findViewById(R.id.recycle_catalog_list);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        getCatalogDataFromServer();
    }

    public void getCatalogDataFromServer(){
        RequestCatalog requestCatalog = new RequestCatalog();
        UserModel userModel = AppPreference.getLoginDataPreferences(getContext());
        requestCatalog.setCobrId("01");//userModel.getCobrids());
        Call<ArrayList<CatalogListViewModel>> callCatalogListView = WebServiceClient
                .getCatalogListData()
                .getCatalogList(requestCatalog);
        callCatalogListView.enqueue(new Callback<ArrayList<CatalogListViewModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CatalogListViewModel>> call, Response<ArrayList<CatalogListViewModel>> response) {
                if (response.isSuccessful()){
                    listCatalogList = response.body();
                    catalogListAdapter = new CatalogListAdapter(listCatalogList,iCatalogListener);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,GridLayoutManager.VERTICAL,false);
                    recycleCatalogList.setLayoutManager(gridLayoutManager);
                    recycleCatalogList.setAdapter(catalogListAdapter);
                }
                else{
                    Toast.makeText(getContext(), "Server not available !", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<CatalogListViewModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCatalogShareButton(CatalogListViewModel catalogListViewModel) {

    }
}