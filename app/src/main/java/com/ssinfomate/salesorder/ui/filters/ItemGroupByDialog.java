package com.ssinfomate.salesorder.ui.filters;

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
import com.ssinfomate.salesorder.weservices.masters.ItemGroupModel;
import com.ssinfomate.salesorder.weservices.masters.ItemSubGroupModel;
import com.ssinfomate.salesorder.weservices.masters.StyleListModel;

import java.util.ArrayList;

public class ItemGroupByDialog extends Dialog implements IFiltersListener {
    ArrayList<ItemGroupModel> itemGroupModels;
    RecyclerView recyclerView;
    ItemGroupByAdapter adapter;
    IFiltersListener iFiltersListener;
    AppCompatEditText editTextItemGroupName;

    public ItemGroupByDialog(@NonNull Context context,
                             ArrayList<ItemGroupModel> itemGroupModels,
                             IFiltersListener iFiltersListener) {
        super(context);
        this.itemGroupModels = itemGroupModels;
        this.iFiltersListener = iFiltersListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_filter_item_group);
        recyclerView = findViewById(R.id.list_filter_item_group);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        editTextItemGroupName = findViewById(R.id.edit_filter_item_group_name);
        openList();
        editTextItemGroupName.addTextChangedListener(new TextWatcher() {
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


    public void openList() {
        adapter = new ItemGroupByAdapter(getContext(), itemGroupModels, iFiltersListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemGroupNameClicked(ItemGroupModel itemGroupModel, int position) {

    }

    @Override
    public void onItemSubGroupNameClicked(ItemSubGroupModel itemSubGroupModel, int position) {

    }

    @Override
    public void onStyleNameClicked(StyleListModel styleListModel, int position) {

    }
}