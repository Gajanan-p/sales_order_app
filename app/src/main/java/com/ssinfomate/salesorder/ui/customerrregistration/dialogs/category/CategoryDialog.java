package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.category;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.CategoryModel;

import java.util.ArrayList;

public class CategoryDialog extends Dialog {
    ArrayList<CategoryModel> categoryModels;
    RecyclerView recyclerView;
    CategoryAdapter adapter;
    IListener iListener;
    int position;

    public CategoryDialog(@NonNull Context context,
                          ArrayList<CategoryModel> categoryModels,
                          IListener iListener,
                          int position)
    {
        super(context);
        this.categoryModels = categoryModels;
        this.iListener = iListener;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_category);
        adapter = new CategoryAdapter(categoryModels,iListener, position);
        recyclerView = findViewById(R.id.list_category_type);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
