package com.ssinfomate.salesorder.ui.customerrregistration.dialogs.acounttype;

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
import com.ssinfomate.salesorder.weservices.custregistrationmodel.AccountTypeModel;

import java.util.ArrayList;

public class AccountTypeAdapter extends RecyclerView.Adapter<AccountTypeAdapter.MyViewHolder>implements Filterable {

    ArrayList<AccountTypeModel> typeModelList;
    ArrayList<AccountTypeModel> filteredTypeModelListList;
    Context context;
    IListener iListener;
    int position;
    public AccountTypeAdapter(Context context, ArrayList<AccountTypeModel> userArrayList,
                         IListener iListener
    ) {
        this.context = context;
        this.typeModelList = userArrayList;
        this.filteredTypeModelListList = userArrayList;
        this.iListener = iListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_account_type, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // for click item listener
                iListener.onAccountTypeClicked(filteredTypeModelListList.get(myViewHolder.getAdapterPosition()),myViewHolder.getAdapterPosition());
            }
        });
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, int position) {
        AccountTypeModel model = filteredTypeModelListList.get(position);
        viewHolder.userName.setText(model.getAcclgrpName());
        viewHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListener.onAccountTypeClicked(model, position);
            }
        });

    }
    @Override
    public int getItemCount() {
        return filteredTypeModelListList.size();
    }


    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String searchString = charSequence.toString();

                if (searchString.isEmpty()) {

                    filteredTypeModelListList = typeModelList;

                } else {

                    ArrayList<AccountTypeModel> tempFilteredList = new ArrayList<>();

                    for (AccountTypeModel model : typeModelList) {
                        if (model.getAcclgrpName().length() > 0) {
                            // search for user title
                            if(model.getAcclgrpName().length()<searchString.length()){

                            }
                            else {if(model.getAcclgrpName().substring(0, searchString.length()).toLowerCase().equals(searchString)) {

                                tempFilteredList.add(model);
                            }}
                        }
                    }
                    filteredTypeModelListList = tempFilteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredTypeModelListList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredTypeModelListList = (ArrayList<AccountTypeModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }



    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView userName;

        public MyViewHolder(View view) {
            super(view);
            userName = (TextView)view.findViewById(R.id.row_dialog_account_type);
        }
    }
}
