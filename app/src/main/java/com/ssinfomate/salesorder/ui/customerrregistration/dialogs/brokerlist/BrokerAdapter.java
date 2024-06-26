package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.brokerlist;

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
import com.ssinfomate.salesorder.weservices.custregistrationmodel.BrokerListModel;

import java.util.ArrayList;

public class BrokerAdapter extends RecyclerView.Adapter<BrokerAdapter.MyViewHolder>implements Filterable {
    ArrayList<BrokerListModel> brokerList;
    ArrayList<BrokerListModel> filteredBrokerList;
    Context context;
    IListener iListener;
    int position;

    public BrokerAdapter(Context context, ArrayList<BrokerListModel> userArrayBrokerListt,
                         IListener iListener
    ) {
        this.context = context;
        this.brokerList = userArrayBrokerListt;
        this.filteredBrokerList = userArrayBrokerListt;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_broker_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onBrokerNameClicked(filteredBrokerList.get(myViewHolder.getAdapterPosition()), myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        BrokerListModel model = filteredBrokerList.get(position);
        viewHolder.userName.setText(model.getLedName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onBrokerNameClicked(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredBrokerList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredBrokerList = brokerList;

                } else {

                    ArrayList<BrokerListModel> tempFilteredList = new ArrayList<>();

                    for (BrokerListModel model : brokerList) {
                        if (model.getLedName().length() > 0) {
                            // search for user title
                            if (model.getLedName().length() < searchString.length()) {

                            } else {
                                if (model.getLedName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {

                                    tempFilteredList.add(model);
                                }
                            }
                        }
                    }
                    filteredBrokerList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredBrokerList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredBrokerList = (ArrayList<BrokerListModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (AppCompatTextView) view.findViewById(R.id.row_dialog_broker_name);

        }
    }
}