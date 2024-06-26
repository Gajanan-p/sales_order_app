package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.tranpoterlist;

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
import com.ssinfomate.salesorder.weservices.custregistrationmodel.TransporterListModel;

import java.util.ArrayList;

public class TransporterAdapter extends RecyclerView.Adapter<TransporterAdapter.MyViewHolder>implements Filterable {
    ArrayList<TransporterListModel> transporterList;
    ArrayList<TransporterListModel> filteredTransporterList;
    Context context;
    IListener iListener;
    int position;

    public TransporterAdapter(Context context, ArrayList<TransporterListModel> userArrayTransporterList,
                              IListener iListener
    ) {
        this.context = context;
        this.transporterList = userArrayTransporterList;
        this.filteredTransporterList = userArrayTransporterList;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_transporter_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onTransporterNameClicked(filteredTransporterList.get(myViewHolder.getAdapterPosition()), myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        TransporterListModel model = filteredTransporterList.get(position);
        viewHolder.userName.setText(model.getLedName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onTransporterNameClicked(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredTransporterList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredTransporterList = transporterList;

                } else {

                    ArrayList<TransporterListModel> tempFilteredList = new ArrayList<>();

                    for (TransporterListModel model : transporterList) {
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
                    filteredTransporterList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredTransporterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredTransporterList = (ArrayList<TransporterListModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (AppCompatTextView) view.findViewById(R.id.row_dialog_transporter_name);

        }
    }
}