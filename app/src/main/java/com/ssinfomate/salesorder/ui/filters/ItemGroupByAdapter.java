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

import java.util.ArrayList;

public class ItemGroupByAdapter extends RecyclerView.Adapter<ItemGroupByAdapter.MyViewHolder>implements Filterable {

    ArrayList<ItemGroupModel> itemGroupList;
    ArrayList<ItemGroupModel> filteredItemGroupList;
    Context context;
    IFiltersListener iFiltersListener;
    int position;

    public ItemGroupByAdapter(Context context, ArrayList<ItemGroupModel> itemGroupArrayList,
                              IFiltersListener iFiltersListener
    ) {
        this.context = context;
        this.itemGroupList = itemGroupArrayList;
        this.filteredItemGroupList = itemGroupArrayList;
        this.iFiltersListener = iFiltersListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_filter_item_group_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iFiltersListener.onItemGroupNameClicked(filteredItemGroupList.get(myViewHolder.getAdapterPosition()), myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        ItemGroupModel model = filteredItemGroupList.get(position);
        viewHolder.userName.setText(model.getItemgrpName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFiltersListener.onItemGroupNameClicked(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredItemGroupList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredItemGroupList = itemGroupList;

                } else {

                    ArrayList<ItemGroupModel> tempFilteredList = new ArrayList<>();

                    for (ItemGroupModel model : itemGroupList) {
                        if (model.getItemgrpName().length() > 0) {
                            // search for user title
                            if (model.getItemgrpName().length() < searchString.length()) {

                            } else {
                                if (model.getItemgrpName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {
                                    tempFilteredList.add(model);
                                }
                            }
                        }
                    }
                    filteredItemGroupList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredItemGroupList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredItemGroupList = (ArrayList<ItemGroupModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.row_filter_item_group_name_list);
        }
    }
}