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
import com.ssinfomate.salesorder.weservices.masters.ItemGroupModel;
import com.ssinfomate.salesorder.weservices.masters.ItemSubGroupModel;
import com.ssinfomate.salesorder.weservices.masters.StyleListModel;

import java.util.ArrayList;

public class ItemSubGroupByDialog  extends Dialog implements IFiltersListener {
    ArrayList<ItemSubGroupModel> itemSubGroupModels;
    RecyclerView recyclerView;
    ItemSubGroupByAdapter adapter;
    IFiltersListener iFiltersListener;
    AppCompatEditText editTextItemSubGroupName;

    public ItemSubGroupByDialog(@NonNull Context context,
                             ArrayList<ItemSubGroupModel> itemSubGroupModels,
                             IFiltersListener iFiltersListener) {
        super(context);
        this.itemSubGroupModels = itemSubGroupModels;
        this.iFiltersListener = iFiltersListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_filter_item_subgroup);
        recyclerView = findViewById(R.id.list_filter_item_subgroup);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        editTextItemSubGroupName = findViewById(R.id.edit_filter_item_subgroup_name);
        openList();
        editTextItemSubGroupName.addTextChangedListener(new TextWatcher() {
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
        adapter = new ItemSubGroupByAdapter(getContext(), itemSubGroupModels, iFiltersListener);
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