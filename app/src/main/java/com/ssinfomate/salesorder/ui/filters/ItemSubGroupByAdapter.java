package com.ssinfomate.salesorder.ui.filters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.weservices.masters.ItemGroupModel;
import com.ssinfomate.salesorder.weservices.masters.ItemSubGroupModel;

import java.util.ArrayList;

public class ItemSubGroupByAdapter extends RecyclerView.Adapter<ItemSubGroupByAdapter.MyViewHolder>implements Filterable {

    ArrayList<ItemSubGroupModel> itemSubGroupList;
    ArrayList<ItemSubGroupModel> filteredSubItemGroupList;
    Context context;
    IFiltersListener iFiltersListener;
    int position;

    public ItemSubGroupByAdapter(Context context, ArrayList<ItemSubGroupModel> itemSubGroupArrayStationList,
                              IFiltersListener iFiltersListener
    ) {
        this.context = context;
        this.itemSubGroupList = itemSubGroupArrayStationList;
        this.filteredSubItemGroupList = itemSubGroupArrayStationList;
        this.iFiltersListener = iFiltersListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_filter_item_subgroup_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iFiltersListener.onItemSubGroupNameClicked(filteredSubItemGroupList.get(myViewHolder.getAdapterPosition()), myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        ItemSubGroupModel model = filteredSubItemGroupList.get(position);
        viewHolder.userName.setText(model.getItemsubgrpName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFiltersListener.onItemSubGroupNameClicked(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredSubItemGroupList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredSubItemGroupList = itemSubGroupList;

                } else {

                    ArrayList<ItemSubGroupModel> tempFilteredList = new ArrayList<>();

                    for (ItemSubGroupModel model : itemSubGroupList) {
                        if (model.getItemsubgrpKey().length() > 0) {
                            // search for user title
                            if (model.getItemsubgrpName().length() < searchString.length()) {

                            } else {
                                if (model.getItemsubgrpName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {
                                    tempFilteredList.add(model);
                                }
                            }
                        }
                    }
                    filteredSubItemGroupList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredSubItemGroupList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredSubItemGroupList = (ArrayList<ItemSubGroupModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.row_filter_item_subgroup_name_list);
        }
    }
}