package com.ssinfomate.salesorder.ui.orderproduct;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.ssinfomate.salesorder.MainActivity;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.weservices.WebServiceClient;
import com.ssinfomate.salesorder.weservices.orderproductmodel.BookOrderModel;
import com.ssinfomate.salesorder.weservices.orderproductmodel.RequestBookOrderModel;
import com.ssinfomate.salesorder.weservices.userloginmodel.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderProductFragment extends Fragment implements
        View.OnClickListener {


    private int defaultIndex = 0; // Keep the default scanner
    private int dataLength = 0;
    private String statusString = "";

    private boolean bSoftTriggerSelected = false;
    private boolean bDecoderSettingsChanged = false;
    private boolean bExtScannerDisconnected = false;
    private final Object lock = new Object();

    AppCompatEditText editTextBarcode;
    AppCompatTextView textViewTotal,textViewTotalMrp,textViewGrossAmt;
    AppCompatButton buttonCancel, buttonSave, buttonPreview;
    AppCompatButton buttonOk;
    ImageView buttonScanBarcode;
    RecyclerView listItemBill;
    AppCompatImageView imageViewProduct;
    private ProductBillingAdapter billingAdapter;
    private ArrayList<BookOrderModel> bookOrderModelsList;
    public static OrderProductFragment newInstance() {
        return new OrderProductFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.order_product_fragment, container, false);

        editTextBarcode = view.findViewById(R.id.edit_order_product_barcode);
        textViewTotal = view.findViewById(R.id.text_order_product_total);
        textViewTotalMrp = view.findViewById(R.id.text_order_product_mrp_total);
        textViewGrossAmt = view.findViewById(R.id.text_order_product_gross_total_amt);
        buttonScanBarcode = view.findViewById(R.id.img_order_product_camera_scan_barcode);
        buttonScanBarcode.setOnClickListener(this);
        listItemBill = view.findViewById(R.id.recycle_order_product_bill_list);
        buttonCancel = view.findViewById(R.id.button_order_product_list_cancel);
        buttonCancel.setOnClickListener(this);
        buttonSave = view.findViewById(R.id.button_order_product_list_save);
        buttonSave.setOnClickListener(this);
        buttonPreview = view.findViewById(R.id.button_order_product_list_preview);
        buttonPreview.setOnClickListener(this);
        buttonOk = view.findViewById(R.id.button_order_product_ok);
        buttonOk.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //mViewModel = new ViewModelProvider(this).get(OrderProductViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_order_product_camera_scan_barcode:{
                ((MainActivity) getActivity()).startScanActivity(editTextBarcode);
                break;
            }
            case R.id.button_order_product_list_cancel:{
                getActivity().onBackPressed();
                break;
            }
            case R.id.button_order_product_ok:{
                getProductOrderData();
                break;
            }
//            case R.id.img_order_product_img: {
//                imageViewProduct.setScaleType(AppCompatImageView.ScaleType.FIT_XY);
//                requireActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//             //   requireActivity().getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//             ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
//            }
        }
    }
    void getProductOrderData(){
        UserModel userModel = AppPreference.getLoginDataPreferences(getContext());
        RequestBookOrderModel requestBookOrderModel = new RequestBookOrderModel();
        requestBookOrderModel.setCobrId(userModel.getCobrids());
        requestBookOrderModel.setBarcode(editTextBarcode.getText().toString());

        Call<ArrayList<BookOrderModel>> callBookOrderList = WebServiceClient
                .getBookingSalesServiceData()
                .getBookOrderList(requestBookOrderModel);
        callBookOrderList.enqueue(new Callback<ArrayList<BookOrderModel>>() {
            @Override
            public void onResponse(Call<ArrayList<BookOrderModel>> call, Response<ArrayList<BookOrderModel>> response) {
                if (response.isSuccessful()){
                    bookOrderModelsList = response.body();
                    getProductOrderList();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BookOrderModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    void getProductOrderList(){
       // billingAdapter = new ProductBillingAdapter()
    }
}