package com.ssinfomate.salesorder.ui.saleorder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.ssinfomate.salesorder.R;

public class SaleOrderFragment extends Fragment implements View.OnClickListener {

    AppCompatEditText editTextDeliveryDays, editTextPaymentDays,editTextRemark;
    AppCompatTextView textViewDocNo,textViewDate,textViewCustomerStation,textViewCustomerAddress,textViewConsigneeStation,
                      textViewConsigneeAddress,textViewDeliveryDate,textViewPaymentDueDate,textViewTransporter;
    AppCompatButton buttonNext;
    AppCompatAutoCompleteTextView completeTextViewCustomerName,completeTextViewConsignee;

    public static SaleOrderFragment newInstance() {
        return new SaleOrderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.saleorder_fragment, container, false);

        textViewDocNo = view.findViewById(R.id.text_sale_order_doc_no);
        textViewDate = view.findViewById(R.id.text_sale_order_date);
        textViewCustomerStation = view.findViewById(R.id.text_sale_order_customer_station);
        textViewCustomerAddress = view.findViewById(R.id.text_sale_order_customer_address);
        textViewConsigneeStation = view.findViewById(R.id.text_sale_order_consignee_station);
        textViewConsigneeAddress = view.findViewById(R.id.text_sale_order_consignee_address);
        textViewDeliveryDate = view.findViewById(R.id.text_sale_order_delivery_date);
        textViewPaymentDueDate = view.findViewById(R.id.text_sale_order_payment_due_date);
        textViewTransporter = view.findViewById(R.id.text_sale_order_transporter);
        editTextDeliveryDays = view.findViewById(R.id.edit_sale_order_delivery_days);
        editTextPaymentDays = view.findViewById(R.id.edit_sale_order_payment_days);
        editTextRemark = view.findViewById(R.id.edit_sale_order_remark);
        completeTextViewCustomerName = view.findViewById(R.id.autoComplete_sale_order_customer_name);
        completeTextViewConsignee = view.findViewById(R.id.autoComplete_sale_order_consignee);

        buttonNext = view.findViewById(R.id.button_sale_order_next);
        buttonNext.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(SaleorderViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_sale_order_next:{

            }
        }
    }
}