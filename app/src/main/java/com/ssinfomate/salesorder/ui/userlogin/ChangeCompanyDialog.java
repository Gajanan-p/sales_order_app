package com.ssinfomate.salesorder.ui.userlogin;

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
import com.ssinfomate.salesorder.weservices.userloginmodel.ChangeCompanyModel;
import java.util.ArrayList;

public class ChangeCompanyDialog extends Dialog implements IChangeCompany {
    ArrayList<ChangeCompanyModel> companyModels;
    RecyclerView recyclerView;
    ChangeCompanyAdapter adapter;
    IChangeCompany iChangeCompany;
    AppCompatEditText editTextChangeCompanyName;

    public ChangeCompanyDialog(@NonNull Context context,
                               ArrayList<ChangeCompanyModel> companyModels,
                               IChangeCompany iChangeCompany) {
        super(context);
        this.companyModels = companyModels;
        this.iChangeCompany = iChangeCompany;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.dialog_change_company);
        recyclerView = findViewById(R.id.list_change_company);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        editTextChangeCompanyName = findViewById(R.id.edit_text_change_company);
        openList();
        editTextChangeCompanyName.addTextChangedListener(new TextWatcher() {
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
        adapter = new ChangeCompanyAdapter(getContext(), companyModels, iChangeCompany);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onChangeCompanyName(ChangeCompanyModel changeCompanyModel, int position) {

    }
}