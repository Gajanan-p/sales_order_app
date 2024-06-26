package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.gender;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;

import java.util.ArrayList;

public class GenderAdapter extends RecyclerView.Adapter<GenderAdapter.ViewHolder> {
    ArrayList<GenderModel>genderModels = new ArrayList<>();
    IGenderListener iGenderListener;
    int position;

    public GenderAdapter(ArrayList<GenderModel> genderModels, IGenderListener iGenderListener, int position) {
        this.genderModels = genderModels;
        this.iGenderListener = iGenderListener;
        this.position = position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_gender_layout,
                parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        GenderModel genderModel = genderModels.get(position);
        holder.textViewName.setText(genderModel.getName());
        holder.textViewName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iGenderListener.onGenderClick(genderModel,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return genderModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textViewName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.row_gender_name);
        }
    }
}
