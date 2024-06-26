package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.saletype;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.AccountTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.BrokerListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.CategoryModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.DiscountModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.PriceListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.SaleTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.StationListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.TransporterListModel;

import java.util.ArrayList;

public class SaleTypeDialog extends Dialog implements IListener {

    ArrayList<SaleTypeModel> saleTypeModels;
    RecyclerView recyclerView;
    SaleTypeAdapter adapter;
    IListener iListener;
    AppCompatEditText editTextSaleType;

    public SaleTypeDialog(@NonNull Context context,
                          ArrayList<SaleTypeModel> saleTypeModels,
                          IListener iListener)
    {
        super(context);
        this.saleTypeModels = saleTypeModels;
        this.iListener = iListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_sale_type);
        recyclerView = findViewById(R.id.list_sale_type);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        editTextSaleType = findViewById(R.id.edit_text_style_type);
        openList();
        editTextSaleType.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence agr0, int agr1, int agr2, int agr3) {

            }

            @Override
            public void onTextChanged(CharSequence agr0, int agr1, int agr2, int agr3) {
                adapter.getFilter().filter(agr0);
            }

            @Override
            public void afterTextChanged(Editable agr0) {

            }
        });
    }

    @Override
    public void onAccountTypeClicked(AccountTypeModel accountTypeModel, int position) {

    }

    @Override
    public void onCategoryClicked(CategoryModel categoryModel, int position) {

    }

    @Override
    public void onDiscountClicked(DiscountModel discountModel, int position) {

    }

    @Override
    public void onSaleTypeClicked(SaleTypeModel saleTypeModel, int position) {

    }

    @Override
    public void onPriceListClicked(PriceListModel priceListModel, int position) {

    }

    @Override
    public void onStationNameClicked(StationListModel stationListModel, int position) {

    }

    @Override
    public void onBrokerNameClicked(BrokerListModel brokerListModel, int position) {

    }

    @Override
    public void onTransporterNameClicked(TransporterListModel transporterListModel, int position) {

    }

    public void openList() {
        adapter = new SaleTypeAdapter(getContext(),saleTypeModels,iListener);
        recyclerView.setAdapter(adapter);
    }

}
