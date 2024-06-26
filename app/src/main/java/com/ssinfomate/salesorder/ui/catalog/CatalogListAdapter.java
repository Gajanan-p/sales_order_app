package com.ssinfomate.salesorder.ui.catalog;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.weservices.catalog.CatalogListViewModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CatalogListAdapter extends RecyclerView.Adapter<CatalogListAdapter.ViewHolder> {
    ArrayList<CatalogListViewModel> catalogListViewModels;
    ICatalogListener iCatalogListener;


    public CatalogListAdapter(ArrayList<CatalogListViewModel> catalogListViewModels,
                              ICatalogListener iCatalogListener)
    {
        this.catalogListViewModels = catalogListViewModels;
        this.iCatalogListener = iCatalogListener;
    }

    @NonNull
    @Override
    public CatalogListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_catalog_list,
                parent,false);

        return new CatalogListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatalogListAdapter.ViewHolder holder, int position) {
        CatalogListViewModel model = catalogListViewModels.get(position);
        holder.textViewCatalogItemName.setText(model.getItemname());
        holder.textViewCatalogPrice.setText(model.getSalerate());
        Picasso.get()
                 .load(model.getStyleimagef())
                .placeholder(R.drawable.polo)
                .fit()
                .into(holder.imageViewItem);
        holder.imageViewShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iCatalogListener.onCatalogShareButton(model);
            }
        });

    }

    @Override
    public int getItemCount() {
        return catalogListViewModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCatalogPrice;
        TextView textViewCatalogItemName;
        ImageView imageViewItem,imageViewShare;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewCatalogItemName = itemView.findViewById(R.id.textView_catalog_item_name);
            textViewCatalogPrice = itemView.findViewById(R.id.textView_catalog_item_price);
            imageViewItem = itemView.findViewById(R.id.image_catalog_item);
            imageViewShare = itemView.findViewById(R.id.image_catalog_share);
        }
    }
}
