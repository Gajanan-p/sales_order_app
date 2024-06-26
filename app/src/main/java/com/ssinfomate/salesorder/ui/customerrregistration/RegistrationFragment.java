package com.ssinfomate.salesorder.ui.customerrregistration;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.acounttype.AccountTypeDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.brokerlist.BrokerDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.category.CategoryDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.discount.DiscountDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.IListener;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.pricelist.PriceListDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.saletype.SaleTypeDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.gender.GenderDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.gender.GenderModel;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.gender.IGenderListener;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.satation.StationListDialog;
import com.ssinfomate.salesorder.ui.customerrregistration.dialogs.tranpoterlist.TransporterDialog;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.utils.DynamicServerURL;
import com.ssinfomate.salesorder.weservices.WebServiceClient;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.AccountTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.BrokerListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.CategoryModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.DiscountModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.PriceListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.RequestSaveCustomerRegistrationModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.SaleTypeModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.SaveCustomerRegistrationModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.StationListModel;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.TransporterListModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationFragment extends Fragment implements View.OnClickListener,
        IListener , IGenderListener {


    AppCompatEditText editTextCustomerName,editTextContactPerson,editTextGSTNo,editTextAddress,editTextPhoneNo,
                      editTextMobileNo, editTextEmail;
    AppCompatTextView editTextCategory,editTextSaleType, editTextAccountType,editTextPriceList,editTextStation;
    AppCompatButton buttonCancel,buttonSave,buttonAddMoreInfo;
    AppCompatTextView editTextGender,editTextDiscount, editTextPercentage,textViewBrokerList, textViewTransporter;
    private DiscountDialog discountDialog;
    private AccountTypeDialog accountTypeDialog;
    private SaleTypeDialog saleTypeDialog;
    private CategoryDialog categoryDialog;
    private PriceListDialog priceListDialog;
    private GenderDialog genderDialog;
    private ArrayList<DiscountModel> listDiscountModel;
    private ArrayList<AccountTypeModel> listAccountTypeModel;
    private ArrayList<StationListModel> stationListModels;
    private ArrayList<SaleTypeModel> listSaleTypeModel;
    private ArrayList<PriceListModel>listPriceList;
    private ArrayList<BrokerListModel>listBrokerListModel;
    private ArrayList<TransporterListModel>listTransporterListModel;
    private StationListDialog stationListDialog;
    private BrokerDialog brokerDialog;
    private TransporterDialog transporterDialog;
    GenderModel tempGenderModel;
    LinearLayout ContainerAddMoreInfo;

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view =  inflater.inflate(R.layout.registration_fragment, container, false);

        editTextCustomerName = view.findViewById(R.id.edit_registration_customer_name);
        editTextContactPerson = view.findViewById(R.id.edit_registration_contact_person);
        editTextCategory= view.findViewById(R.id.edit_registration_category);
        editTextCategory.setOnClickListener(this);
        editTextSaleType = view.findViewById(R.id.edit_registration_sale_type);
        editTextSaleType.setOnClickListener(this);
        editTextAccountType= view.findViewById(R.id.edit_registration_account_type);
        editTextAccountType.setOnClickListener(this);
        editTextGSTNo= view.findViewById(R.id.edit_registration_gst_no);
        editTextPriceList= view.findViewById(R.id.edit_registration_price_list);
        editTextPriceList.setOnClickListener(this);
        editTextAddress= view.findViewById(R.id.edit_registration_address);
        editTextStation= view.findViewById(R.id.edit_registration_station);
        editTextStation.setOnClickListener(this);
        editTextPhoneNo= view.findViewById(R.id.edit_registration_phone_no);
        editTextMobileNo= view.findViewById(R.id.edit_registration_mobile_no);
        editTextEmail = view.findViewById(R.id.edit_registration_email);
        editTextDiscount= view.findViewById(R.id.edit_registration_discount);
        editTextDiscount.setOnClickListener(this);
        editTextPercentage = view.findViewById(R.id.edit_registration_percentage);
        editTextGender = view.findViewById(R.id.edit_registration_gender);
        editTextGender.setOnClickListener(this);
        buttonCancel = view.findViewById(R.id.button_registration_cancel);
        buttonCancel.setOnClickListener(this);
        buttonSave = view.findViewById(R.id.button_registration_save);
        buttonSave.setOnClickListener(this);
        textViewBrokerList = view.findViewById(R.id.edit_registration_broker_name);
        textViewBrokerList.setOnClickListener(this);
        textViewTransporter = view.findViewById(R.id.edit_registration_transporter_name);
        textViewTransporter.setOnClickListener(this);
        ContainerAddMoreInfo = view.findViewById(R.id.layout_registration_add_more_info);
        buttonAddMoreInfo = view.findViewById(R.id.button_registration_add_more_information);
        buttonAddMoreInfo.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      //  mViewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onResume() {
        super.onResume();
        getDiscountDataFromServer();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.edit_registration_category:{
                getCategoryData(0);
                break;
            }
            case R.id.edit_registration_sale_type:{
                getSaleTypeDateFromServer();
                break;
            }
            case R.id.edit_registration_gender:{
                onGenderData(0);
                break;
            }
            case R.id.edit_registration_account_type:{
                getAccountTypeDateFromServer();
                break;
            }
            case R.id.edit_registration_price_list:{
                getPriceListDateFromServer();
                break;
            }
            case R.id.edit_registration_discount:{
                getDiscountData(listDiscountModel);
                break;
            }
            case R.id.button_registration_save:{
                if (!TextUtils.isEmpty(editTextCustomerName.getText())
                        && !TextUtils.isEmpty(editTextContactPerson.getText())
                        && !TextUtils.isEmpty(editTextPhoneNo.getText())
                        && !TextUtils.isEmpty(editTextAddress.getText())
                        && !TextUtils.isEmpty(editTextMobileNo.getText())) {
                    createCustomerData();
                    ContainerAddMoreInfo.setVisibility(View.GONE);
                }else {Toast.makeText(getContext(),"Fill all fields properly!",Toast.LENGTH_LONG).show();}
                break;
            }
            case R.id.edit_registration_station:{
                getStationListDateFromServer();
                break;
            }
            case R.id.button_registration_cancel:{
               getActivity().onBackPressed();
            }
            case R.id.edit_registration_broker_name:{
                getBrokerDataFromServer();
                break;
            }
            case R.id.edit_registration_transporter_name:{
                getTransporterListDateFromServer();
                break;
            }
            case R.id.button_registration_add_more_information:{
                ContainerAddMoreInfo.setVisibility(View.VISIBLE);
                break;
            }
        }
    }

//---------------------------------------------------------------------------------------------------------------
    public void getCategoryData(int position){
        categoryDialog = new CategoryDialog(getContext(),
                CategoryModel.getCategoryModelList(),
                RegistrationFragment.this,
                position);
        categoryDialog.show();
    }
    public void setCategoryData(){
        ArrayList<CategoryModel> categoryModels = CategoryModel.getCategoryModelList();
        editTextCategory.setText(categoryModels.get(0).getCategoryName());
    }
    @Override
    public void onCategoryClicked(CategoryModel categoryModel, int position) {
        editTextCategory.setText("  "+categoryModel.getCategoryName());
        categoryDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void onGenderData(int position) {
        genderDialog = new GenderDialog(
                getContext(),
                GenderModel.getGenderModelList(),
                RegistrationFragment.this,
                position
        );
        genderDialog.show();
    }
    @Override
    public void onGenderClick(GenderModel genderModel,int position) {
        this.tempGenderModel=genderModel;
        editTextGender.setText("  "+genderModel.getName());
        genderDialog.dismiss();
    }

//---------------------------------------------------------------------------------------------------------------
    public void getAccountTypeDateFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<AccountTypeModel>> accountTypeCall = WebServiceClient
                .getCustRegServiceData()
                .getAccountTypeData();
        accountTypeCall.enqueue(new Callback<ArrayList<AccountTypeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AccountTypeModel>> call, Response<ArrayList<AccountTypeModel>> response) {
                if (response.isSuccessful()){
                    listAccountTypeModel = response.body();
                    accountTypeDialog = new AccountTypeDialog(getContext(),
                            listAccountTypeModel,
                            RegistrationFragment.this);
                    accountTypeDialog.show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<AccountTypeModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onAccountTypeClicked(AccountTypeModel accountTypeModel, int position) {
        AppPreference.setAccountTypePreferences(getContext(),accountTypeModel);
        editTextAccountType.setText("  "+accountTypeModel.getAcclgrpName());
        accountTypeDialog.dismiss();
    }

//---------------------------------------------------------------------------------------------------------------
    public void getSaleTypeDateFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<SaleTypeModel>> saleTypeCall = WebServiceClient
                .getCustRegServiceData()
                .getSaleTypeData();
        saleTypeCall.enqueue(new Callback<ArrayList<SaleTypeModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SaleTypeModel>> call, Response<ArrayList<SaleTypeModel>> response) {
                if (response.isSuccessful()){
                    listSaleTypeModel = response.body();
                    saleTypeDialog = new SaleTypeDialog(getContext(),
                            listSaleTypeModel,
                            RegistrationFragment.this);
                    saleTypeDialog.show();
                }
            }
            @Override
            public void onFailure(Call<ArrayList<SaleTypeModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onSaleTypeClicked(SaleTypeModel saleTypeModel, int position) {
        AppPreference.setSaleTypePreferences(getContext(),saleTypeModel);
        editTextSaleType.setText("  "+saleTypeModel.getLedName());
        saleTypeDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void getPriceListDateFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<PriceListModel>> priceListCall = WebServiceClient
                .getCustRegServiceData()
                .getPriceListData();
        priceListCall.enqueue(new Callback<ArrayList<PriceListModel>>() {
            @Override
            public void onResponse(Call<ArrayList<PriceListModel>> call, Response<ArrayList<PriceListModel>> response) {
                if (response.isSuccessful()){
                    listPriceList = response.body();
                    priceListDialog = new PriceListDialog(getContext(),
                            listPriceList,
                            RegistrationFragment.this
                    );
                    priceListDialog.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<PriceListModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onPriceListClicked(PriceListModel priceListModel, int position) {
        AppPreference.setPriceListPreferences(getContext(),priceListModel);
        editTextPriceList.setText("  "+priceListModel.getRatecatName());
        priceListDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void getStationListDateFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<StationListModel>> stationArrayListCall = WebServiceClient
                .getCustRegServiceData()
                .getStationListData();
        stationArrayListCall.enqueue(new Callback<ArrayList<StationListModel>>() {
            @Override
            public void onResponse(Call<ArrayList<StationListModel>> call, Response<ArrayList<StationListModel>> response) {
                if (response.isSuccessful()){
                    stationListModels = response.body();
                    stationListDialog = new StationListDialog(getContext(),
                            stationListModels,
                            RegistrationFragment.this
                    );
                    stationListDialog.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<StationListModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onStationNameClicked(StationListModel stationListModel, int position) {
        AppPreference.setStationListPreferences(getContext(),stationListModel);
        editTextStation.setText("  "+stationListModel.getStnName());
        stationListDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void getBrokerDataFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<BrokerListModel>> callBrokerListModel = WebServiceClient
                .getCustRegServiceData()
                .getBrokerListData();
        callBrokerListModel.enqueue(new Callback<ArrayList<BrokerListModel>>() {
            @Override
            public void onResponse(Call<ArrayList<BrokerListModel>> call, Response<ArrayList<BrokerListModel>> response) {
                if (response.isSuccessful()){
                    listBrokerListModel = response.body();
                    brokerDialog = new BrokerDialog(getContext(),
                            listBrokerListModel,
                            RegistrationFragment.this
                    );
                    brokerDialog.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<BrokerListModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onBrokerNameClicked(BrokerListModel brokerListModel, int position) {
        AppPreference.setBrokerListPreferences(getContext(),brokerListModel);
        textViewBrokerList .setText("  "+brokerListModel.getLedName());
        brokerDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void getTransporterListDateFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<TransporterListModel>> callTransporterListModel = WebServiceClient
                .getCustRegServiceData()
                .getTransporterListData();
        callTransporterListModel.enqueue(new Callback<ArrayList<TransporterListModel>>() {
            @Override
            public void onResponse(Call<ArrayList<TransporterListModel>> call, Response<ArrayList<TransporterListModel>> response) {
                if (response.isSuccessful()){
                    listTransporterListModel = response.body();
                    transporterDialog = new TransporterDialog(getContext(),
                            listTransporterListModel,
                            RegistrationFragment.this);
                    transporterDialog.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<TransporterListModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    @Override
    public void onTransporterNameClicked(TransporterListModel transporterListModel, int position) {
        AppPreference.setTransporterListPreferences(getContext(),transporterListModel);
        textViewTransporter.setText("  "+transporterListModel.getLedName());
        transporterDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void getDiscountDataFromServer(){
        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<ArrayList<DiscountModel>> discountTypeCall = WebServiceClient
                .getCustRegServiceData()
                .getDiscountData();
        discountTypeCall.enqueue(new Callback<ArrayList<DiscountModel>>() {
            @Override
            public void onResponse(Call<ArrayList<DiscountModel>> call, Response<ArrayList<DiscountModel>> response) {
                if (response.isSuccessful()){
                    listDiscountModel = response.body();
                    AppPreference.setDiscountPreferences(getContext(),listDiscountModel.get(0));
                    editTextDiscount.setText(listDiscountModel.get(0).getTxtmtdsName());
                    editTextPercentage.setText("Percentage="+"  "+listDiscountModel.get(0).getTax1LedPerc()+" %");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<DiscountModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
    public void getDiscountData(ArrayList<DiscountModel> discountModels){
        discountDialog = new DiscountDialog(getContext(),
                discountModels,
                RegistrationFragment.this
        );
        discountDialog.show();
    }
    @Override
    public void onDiscountClicked(DiscountModel discountModel, int position) {
        AppPreference.setDiscountPreferences(getContext(),discountModel);
        editTextDiscount.setText(discountModel.getTxtmtdsName());
        editTextPercentage.setText("  "+"Percentage="+"  "+discountModel.getTax1LedPerc()+" %");
        discountDialog.dismiss();
    }
//---------------------------------------------------------------------------------------------------------------
    public void createCustomerData(){
        RequestSaveCustomerRegistrationModel requestModel = new RequestSaveCustomerRegistrationModel();
        AccountTypeModel accountTypeModel = AppPreference.getAccountTypePreferences(getContext());
        PriceListModel priceListModel = AppPreference.getPriceListPreferences(getContext());
        SaleTypeModel saleTypeModel = AppPreference.getSaleTypePreferences(getContext());
        DiscountModel discountModel = AppPreference.getDiscountPreferences(getContext());
        BrokerListModel brokerListModel = AppPreference.getBrokerListPreferences(getContext());
        TransporterListModel transporterListModel = AppPreference.getTransporterListPreferences(getContext());
        StationListModel stationListModel = AppPreference.getStationListPreferences(getContext());
        requestModel.setCoBrId("01");
        requestModel.setCreatedBy("1");
        requestModel.setCustomername(editTextCustomerName.getText().toString());
        requestModel.setCoperson(editTextContactPerson.getText().toString());
        requestModel.setGender(tempGenderModel.getId());
        requestModel.setOaddress(editTextAddress.getText().toString());
        requestModel.setOstnkey(stationListModel.getStnKey());
        requestModel.setOtel1(editTextPhoneNo.getText().toString());
        requestModel.setoEmail(editTextEmail.getText().toString());
        requestModel.setOmobile1(editTextMobileNo.getText().toString());
        requestModel.setAcclgrpkey(accountTypeModel.getAcclgrpKey());
        requestModel.setPricelistid(priceListModel.getRatecatId());
        requestModel.setBrokerKey(brokerListModel.getLedKey());
        requestModel.setTrspKey(transporterListModel.getLedKey());
        requestModel.setSalesledkey(saleTypeModel.getLedKey());
        if (!TextUtils.isEmpty(editTextGSTNo.getText())) {
            requestModel.setGstnno(editTextGSTNo.getText().toString());
        }else {
            requestModel.setGstnno("Null");
        }
        requestModel.setTaxtmdts(discountModel.getTxtmtdsKey());


        DynamicServerURL serverURL=AppPreference.getServerUrlDataPreferences(getContext());
        Call<SaveCustomerRegistrationModel> customerRegistrationModelCall = WebServiceClient
                .getCustRegServiceData()
                .setSaveCustomerRegistrationData(requestModel);
        customerRegistrationModelCall.enqueue(new Callback<SaveCustomerRegistrationModel>() {
            @Override
            public void onResponse(Call<SaveCustomerRegistrationModel> call, Response<SaveCustomerRegistrationModel> response) {
                if (response.isSuccessful()){
                    Toast.makeText(getContext(),response.body().getMsg(),Toast.LENGTH_LONG).show();
                    clearAllFields();
                }
            }

            @Override
            public void onFailure(Call<SaveCustomerRegistrationModel> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
//-----------------------------------------------------------------------------------------------------------------
    public void clearAllFields(){
        editTextCustomerName.setText("");editTextContactPerson.setText("");editTextGender.setText("");editTextCategory.setText("");editTextSaleType.setText("");
        editTextAccountType.setText("");editTextGSTNo.setText("");editTextPriceList.setText("");editTextAddress.setText("");editTextStation.setText("");
        editTextPhoneNo.setText("");editTextMobileNo.setText("");editTextEmail.setText("");editTextDiscount.setText("");editTextPercentage.setText("");
        textViewBrokerList.setText("");textViewTransporter.setText("");
    }
}