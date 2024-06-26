package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.brokerlist;

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

public class BrokerDialog extends Dialog implements IListener {
    ArrayList<BrokerListModel> brokerListModels;
    RecyclerView recyclerView;
    BrokerAdapter adapter;
    IListener iListener;
    AppCompatEditText editTextBrokerName;

    public BrokerDialog(@NonNull Context context,
                           ArrayList<BrokerListModel> brokerListModels,
                           IListener iListener)
    {
        super(context);
        this.brokerListModels = brokerListModels;
        this.iListener = iListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_broker_list);
        recyclerView = findViewById(R.id.list_broker_name);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        editTextBrokerName = findViewById(R.id.edit_text_broker_name);
        openList();
        editTextBrokerName.addTextChangedListener(new TextWatcher() {
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
        adapter = new BrokerAdapter(getContext(),brokerListModels,iListener);
        recyclerView.setAdapter(adapter);
    }

}
