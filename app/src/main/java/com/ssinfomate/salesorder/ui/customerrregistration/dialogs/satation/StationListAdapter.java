package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.satation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.StationListModel;

import java.util.ArrayList;

public class StationListAdapter extends RecyclerView.Adapter<StationListAdapter.MyViewHolder>implements Filterable {

    ArrayList<StationListModel> stationList;
    ArrayList<StationListModel> filteredStationList;
    Context context;
    IListener iListener;
    int position;

    public StationListAdapter(Context context, ArrayList<StationListModel> userArrayStationList,
                              IListener iListener
    ) {
        this.context = context;
        this.stationList = userArrayStationList;
        this.filteredStationList = userArrayStationList;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_station_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onStationNameClicked(filteredStationList.get(myViewHolder.getAdapterPosition()), myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        StationListModel model = filteredStationList.get(position);
        viewHolder.userName.setText(model.getStnName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onStationNameClicked(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredStationList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredStationList = stationList;

                } else {

                    ArrayList<StationListModel> tempFilteredList = new ArrayList<>();

                    for (StationListModel model : stationList) {
                        if (model.getStnName().length() > 0) {
                            // search for user title
                            if (model.getStnName().length() < searchString.length()) {

                            } else {
                                if (model.getStnName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {
                                    tempFilteredList.add(model);
                                }
                            }
                        }
                    }
                    filteredStationList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredStationList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredStationList = (ArrayList<StationListModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.row_dialog_station_name);
        }
    }
}