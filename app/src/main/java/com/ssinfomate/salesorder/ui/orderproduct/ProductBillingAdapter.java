package com.ssinfomate.salesorder.ui.orderproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.weservices.orderproductmodel.BookOrderModel;

import java.util.ArrayList;

public class ProductBillingAdapter extends RecyclerView.Adapter<ProductBillingAdapter.MyViewHolder> {
    ArrayList<BookOrderModel> bookOrderModels;
    Context context;

    String sValue,mValue,lValue,xlValue,twoXlValue,threeXlValue,fourXlValue,fiveXlValue,sixXlValue;
    public ProductBillingAdapter(ArrayList<BookOrderModel> bookOrderModels,
                                 Context context)
    {
        this.bookOrderModels = bookOrderModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_amount_bill,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        BookOrderModel model = bookOrderModels.get(position);
        holder.textViewBillNo.setText("01");
        holder.textViewBillBarcode.setText("AB000001");
        holder.textViewBillStyleNo.setText(model.getStyleKey());
        holder.textViewColor.setText(model.getShadeKey());
        holder.textViewSizeS.setText(sValue);
        holder.textViewSizeM.setText(mValue);
        holder.textViewSizeL.setText(lValue);
        holder.textViewSizeXl.setText(xlValue);
        holder.textViewSize2Xl.setText(twoXlValue);
        holder.textViewSize3Xl.setText(threeXlValue);
        holder.textViewSize4Xl.setText(fourXlValue);
        holder.textViewSize5Xl.setText(fiveXlValue);
        holder.textViewSize6Xl.setText(sixXlValue);
        String totalValue = sValue+mValue+lValue+xlValue+twoXlValue
                +threeXlValue+fourXlValue+fiveXlValue+sixXlValue;
        holder.textViewBillTotal.setText(totalValue);
        holder.textViewBillMrp.setText(model.getWsp());
        String totalGrossAmt = totalValue+model.getWsp();
        holder.textViewGrossAmount.setText(totalGrossAmt);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        AppCompatTextView textViewBillNo,textViewBillBarcode,textViewBillStyleNo,textViewColor;
        AppCompatEditText textViewSizeS,textViewSizeM,textViewSizeL,textViewSizeXl,textViewSize2Xl,
                textViewSize3Xl,textViewSize4Xl,textViewSize5Xl,textViewSize6Xl;
        AppCompatTextView textViewBillTotal,textViewBillMrp,textViewGrossAmount;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            textViewBillNo = itemView.findViewById(R.id.row_amount_bill_srno);
            textViewBillBarcode  = itemView.findViewById(R.id.row_amount_bill_barcode);
            textViewBillStyleNo = itemView.findViewById(R.id.row_amount_bill_srno);
            textViewColor = itemView.findViewById(R.id.row_amount_bill_color);
            textViewSizeS = itemView.findViewById(R.id.row_amount_bill_size_s);
            sValue = textViewSizeS.getText().toString();
            textViewSizeM = itemView.findViewById(R.id.row_amount_bill_size_m);
            mValue = textViewSizeM.getText().toString();
            textViewSizeL = itemView.findViewById(R.id.row_amount_bill_size_l);
            lValue = textViewSizeL.getText().toString();
            textViewSizeXl = itemView.findViewById(R.id.row_amount_bill_size_xl);
            xlValue = textViewSizeXl.getText().toString();
            textViewSize2Xl = itemView.findViewById(R.id.row_amount_bill_size_2xl);
            twoXlValue = textViewSize2Xl.getText().toString();
            textViewSize3Xl = itemView.findViewById(R.id.row_amount_bill_size_3xl);
            threeXlValue = textViewSize3Xl.getText().toString();
            textViewSize4Xl = itemView.findViewById(R.id.row_amount_bill_size_4xl);
            fourXlValue = textViewSize4Xl.getText().toString();
            textViewSize5Xl = itemView.findViewById(R.id.row_amount_bill_size_5xl);
            fiveXlValue = textViewSize5Xl.getText().toString();
            textViewSize6Xl = itemView.findViewById(R.id.row_amount_bill_size_6xl);
            sixXlValue = textViewSize6Xl.getText().toString();
            textViewBillTotal = itemView.findViewById(R.id.row_amount_bill_total);
            textViewBillMrp = itemView.findViewById(R.id.row_amount_bill_mrp);
            textViewGrossAmount = itemView.findViewById(R.id.row_amount_bill_gross_amt);
        }
    }
}
