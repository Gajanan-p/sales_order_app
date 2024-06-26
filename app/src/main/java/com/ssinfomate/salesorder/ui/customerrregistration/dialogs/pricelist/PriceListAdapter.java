package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.pricelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.PriceListModel;

import java.util.ArrayList;

public class PriceListAdapter extends RecyclerView.Adapter<PriceListAdapter.MyViewHolder>implements Filterable {
    ArrayList<PriceListModel> priceList;
    ArrayList<PriceListModel> filteredPriceList;
    Context context;
    IListener iListener;
    int position;
    public PriceListAdapter(Context context, ArrayList<PriceListModel> userArrayPriceList,
                            IListener iListener
    ) {
        this.context = context;
        this.priceList = userArrayPriceList;
        this.filteredPriceList = userArrayPriceList;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_price_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onPriceListClicked(filteredPriceList.get(myViewHolder.getAdapterPosition()),myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        PriceListModel model = filteredPriceList.get(position);
        viewHolder.userName.setText(model.getRatecatName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onPriceListClicked(model, position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return filteredPriceList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredPriceList = priceList;

                } else {

                    ArrayList<PriceListModel> tempFilteredList = new ArrayList<>();

                    for (PriceListModel model : priceList) {
                        if (model.getRatecatName().length() > 0) {
                            // search for user title
                            if(model.getRatecatName().length()<searchString.length()){

                            }
                            else {if(model.getRatecatName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {

                                tempFilteredList.add(model);
                            }}
                        }
                    }
                    filteredPriceList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredPriceList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredPriceList = (ArrayList<PriceListModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private AppCompatTextView userName;
        public MyViewHolder(View view) {
            super(view);
            userName = (AppCompatTextView)view.findViewById(R.id.row_dialog_price_list);

        }
    }
}
