package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.category;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.CategoryModel;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryModel>categoryModels = new ArrayList<>();
    IListener iListener;
    int position;

    public CategoryAdapter(ArrayList<CategoryModel> categoryModels, IListener iListener, int position) {
        this.categoryModels = categoryModels;
        this.iListener = iListener;
        this.position = position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_category,
                parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel categoryModel = categoryModels.get(position);
        holder.textViewName.setText(categoryModel.getCategoryName());
        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onCategoryClicked(categoryModel,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textViewName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.row_dialog_category);
        }
    }
}
