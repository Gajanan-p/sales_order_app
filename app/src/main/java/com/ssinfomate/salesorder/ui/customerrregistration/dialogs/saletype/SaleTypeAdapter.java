package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.saletype;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.SaleTypeModel;

import java.util.ArrayList;

public class SaleTypeAdapter extends RecyclerView.Adapter<SaleTypeAdapter.MyViewHolder>implements Filterable {
    ArrayList<SaleTypeModel> userList;
    ArrayList<SaleTypeModel> filteredUserList;
    Context context;
    IListener iListener;
    int position;
    public SaleTypeAdapter(Context context, ArrayList<SaleTypeModel> userArrayList,
                         IListener iListener
    ) {
        this.context = context;
        this.userList = userArrayList;
        this.filteredUserList = userArrayList;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_sale_type, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onSaleTypeClicked(filteredUserList.get(myViewHolder.getAdapterPosition()),myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        SaleTypeModel model = filteredUserList.get(position);
        viewHolder.userName.setText(model.getLedName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onSaleTypeClicked(model, position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return filteredUserList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredUserList = userList;

                } else {

                    ArrayList<SaleTypeModel> tempFilteredList = new ArrayList<>();

                    for (SaleTypeModel model : userList) {
                        if (model.getLedName().length() > 0) {
                            // search for user title
                            if(model.getLedName().length()<searchString.length()){

                            }
                            else {if(model.getLedName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {

                                tempFilteredList.add(model);
                            }}
                        }
                    }
                    filteredUserList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredUserList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredUserList = (ArrayList<SaleTypeModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView userName;
        private AppCompatTextView textViewId;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView)view.findViewById(R.id.row_dialog_sale_type);

        }
    }
}
