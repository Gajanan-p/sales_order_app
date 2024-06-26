package com.ssinfomate.salesorder.ui.userlogin;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.weservices.userloginmodel.ChangeCompanyModel;
import java.util.ArrayList;


public class ChangeCompanyAdapter extends RecyclerView.Adapter<ChangeCompanyAdapter.MyViewHolder> implements Filterable {
    ArrayList<ChangeCompanyModel> companyModels;
    ArrayList<ChangeCompanyModel> filteredCompanyList;
    Context context;
    IChangeCompany iChangeCompany;

    public ChangeCompanyAdapter(Context context,
                                ArrayList<ChangeCompanyModel> arrayCompanyList,
                                IChangeCompany iChangeCompany) {
        this.companyModels = arrayCompanyList;
        this.filteredCompanyList = arrayCompanyList;
        this.context = context;
        this.iChangeCompany = iChangeCompany;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_change_company, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iChangeCompany.onChangeCompanyName(filteredCompanyList.get(myViewHolder.getAdapterPosition()),myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChangeCompanyModel model = filteredCompanyList.get(position);
        holder.textViewCompanyName.setText(model.getCobrName());
        holder.textViewCompanyName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iChangeCompany.onChangeCompanyName(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredCompanyList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String searchString = charSequence.toString();
                if (searchString.isEmpty()) {
                    filteredCompanyList = companyModels;
                } else {
                    ArrayList<ChangeCompanyModel> tempFilteredList = new ArrayList<>();
                    for (ChangeCompanyModel model : companyModels) {
                        if (model.getCobrName().length() > 0) {
                            // search for user title
                            if(model.getCobrName().length()<searchString.length()){
                            }
                            else {if(model.getCobrName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {
                                tempFilteredList.add(model);
                            }}}}
                    filteredCompanyList = tempFilteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredCompanyList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredCompanyList = (ArrayList<ChangeCompanyModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView textViewCompanyName;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCompanyName = itemView.findViewById(R.id.row_dialog_change_company);
        }
    }
}
