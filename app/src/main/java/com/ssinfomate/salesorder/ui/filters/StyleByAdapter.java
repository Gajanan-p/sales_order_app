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
import com.ssinfomate.salesorder.weservices.masters.StyleListModel;

import java.util.ArrayList;

public class StyleByAdapter extends RecyclerView.Adapter<StyleByAdapter.MyViewHolder>implements Filterable {

    ArrayList<StyleListModel> styleList;
    ArrayList<StyleListModel> filteredStyleList;
    Context context;
    IFiltersListener iFiltersListener;
    int position;

    public StyleByAdapter(Context context, ArrayList<StyleListModel> styleListArrayList,
                              IFiltersListener iFiltersListener
    ) {
        this.context = context;
        this.styleList = styleListArrayList;
        this.filteredStyleList = styleListArrayList;
        this.iFiltersListener = iFiltersListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_filter_style_list, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iFiltersListener.onStyleNameClicked(filteredStyleList.get(myViewHolder.getAdapterPosition()), myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        StyleListModel model = filteredStyleList.get(position);
        viewHolder.userName.setText(model.getStyleCode());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iFiltersListener.onStyleNameClicked(model, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filteredStyleList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {
                    filteredStyleList = styleList;
                } else {

                    ArrayList<StyleListModel> tempFilteredList = new ArrayList<>();

                    for (StyleListModel model : styleList) {
                        if (model.getStyleCode().length() > 0) {
                            // search for user title
                            if (model.getStyleCode().length() < searchString.length()) {

                            } else {
                                if (model.getStyleCode().substring(0, searchString.length()).toLowerCase().equals(searchString)) {
                                    tempFilteredList.add(model);
                                }
                            }
                        }
                    }
                    filteredStyleList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredStyleList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredStyleList = (ArrayList<StyleListModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView) view.findViewById(R.id.row_filter_style_name_list);
        }
    }
}