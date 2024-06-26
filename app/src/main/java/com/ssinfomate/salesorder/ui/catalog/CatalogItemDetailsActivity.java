package com.ssinfomate.salesorder.ui.catalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.ssinfomate.salesorder.R;

public class CatalogItemDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog_item_details);
        setTitle("item name");
    }
}