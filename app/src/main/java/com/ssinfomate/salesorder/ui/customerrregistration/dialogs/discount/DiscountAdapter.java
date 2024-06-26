package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.discount;

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
import com.ssinfomate.salesorder.weservices.custregistrationmodel.DiscountModel;
import java.util.ArrayList;


public class DiscountAdapter extends RecyclerView.Adapter<DiscountAdapter.MyViewHolder> implements Filterable {
    ArrayList<DiscountModel> discountList;
    ArrayList<DiscountModel> filteredDiscountList;
    Context context;
    IListener iListener;

    public DiscountAdapter(Context context, ArrayList<DiscountModel> discountArrayList,
                         IListener iListener
    ) {
        this.context = context;
        this.discountList = discountArrayList;
        this.filteredDiscountList = discountArrayList;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_discount, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onDiscountClicked(filteredDiscountList.get(myViewHolder.getAdapterPosition()),myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        DiscountModel model = filteredDiscountList.get(position);
        viewHolder.userName.setText(model.getTxtmtdsName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onDiscountClicked(model, position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return filteredDiscountList.size();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredDiscountList = discountList;

                } else {

                    ArrayList<DiscountModel> tempFilteredList = new ArrayList<>();

                    for (DiscountModel model : discountList) {
                        if (model.getTxtmtdsName().length() > 0) {
                            // search for user title
                            if(model.getTxtmtdsName().length()<searchString.length()){

                            }
                            else {if(model.getTxtmtdsName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {

                                tempFilteredList.add(model);
                            }}
                        }
                    }
                    filteredDiscountList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredDiscountList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredDiscountList = (ArrayList<DiscountModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView userName;
        private AppCompatTextView textViewId;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView)view.findViewById(R.id.row_dialog_discount_type);
        }
    }
}
