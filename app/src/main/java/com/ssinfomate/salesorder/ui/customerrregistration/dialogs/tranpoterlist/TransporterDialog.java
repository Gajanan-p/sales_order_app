package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.tranpoterlist;

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

public class TransporterDialog extends Dialog implements IListener {
    ArrayList<TransporterListModel> transporterListModels;
    RecyclerView recyclerView;
    TransporterAdapter adapter;
    IListener iListener;
    AppCompatEditText editTextTransporter;

    public TransporterDialog(@NonNull Context context,
                        ArrayList<TransporterListModel> transporterListModels,
                        IListener iListener)
    {
        super(context);
        this.transporterListModels = transporterListModels;
        this.iListener = iListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_transporter_list);
        recyclerView = findViewById(R.id.list_transporter);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),1);
        recyclerView.setLayoutManager(layoutManager);
        editTextTransporter = findViewById(R.id.edit_text_transporter_name);
        openList();
        editTextTransporter.addTextChangedListener(new TextWatcher() {
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
        adapter = new TransporterAdapter(getContext(),transporterListModels,iListener);
        recyclerView.setAdapter(adapter);
    }

}
