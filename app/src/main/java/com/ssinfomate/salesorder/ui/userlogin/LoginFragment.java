package com.ssinfomate.salesorder.ui.userlogin;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.textfield.TextInputEditText;
import com.ssinfomate.salesorder.MainActivity;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.weservices.WebServiceClient;
import com.ssinfomate.salesorder.weservices.userloginmodel.ChangeCompanyModel;
import com.ssinfomate.salesorder.weservices.userloginmodel.RequestUser;
import com.ssinfomate.salesorder.weservices.userloginmodel.UserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements View.OnClickListener,IChangeCompany {


    TextInputEditText editTextLoginName;
    TextInputEditText editTextPassword;
    TextInputEditText textViewCompanyName;
    Button buttonSignIn, buttonCancel;
    AppCompatTextView textViewForgetPassword;
    private ArrayList<UserModel> userModels;
    NavController navController;
    ChangeCompanyDialog companyDialog;
    private ArrayList<ChangeCompanyModel>companyModelsList;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.login_fragment, container, false);

        editTextLoginName = view.findViewById(R.id.inputUsername);
        editTextPassword = view.findViewById(R.id.inputPassword);
        textViewCompanyName = view.findViewById(R.id.inputCompanyName);
        textViewCompanyName.setOnClickListener(this);

        buttonSignIn = view.findViewById(R.id.button_login);
        buttonSignIn.setOnClickListener(this);

        buttonCancel = view.findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // mViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
    }


    public void checkCredentialWithServer(){
        // progressDialog = createProgressDialog(getContext());
        RequestUser user = new RequestUser();
        ChangeCompanyModel CoBr=AppPreference.getChangeCompanyListPreferences(getContext());
        if(!TextUtils.isEmpty(editTextLoginName.getText())
                && !TextUtils.isEmpty(editTextPassword.getText())){
            user.setLoginName(editTextLoginName.getText().toString());
            user.setUserPwd(editTextPassword.getText().toString());
            user.setCobrId(CoBr.getCobrId());

            Call<ArrayList<UserModel>> listUser= WebServiceClient
                    .getUserLoginService()
                    .getUserModel(user);
            listUser.enqueue(new Callback<ArrayList<UserModel>>() {
                @Override
                public void onResponse(Call<ArrayList<UserModel>> call, Response<ArrayList<UserModel>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<UserModel> userModels = response.body();
//                    SharedPreferences.Editor editor=AppPreference.sharedPreferences.edit();
                        if (userModels.get(0).getIsLogin() != null) {
                            navController.navigate(R.id.action_nav_login_to_nav_home);
                            UserModel userModel = userModels.get(0);
                            AppPreference.setLoginDataPreferences(getContext(), userModel);
                            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                            Intent intent = new Intent(getActivity(), MainActivity.class);
                            startActivity(intent);
                            getActivity().finish();
                            if (!TextUtils.isEmpty(editTextLoginName.getText()) && (!TextUtils.isEmpty(editTextPassword.getText()))) {
                            } else {
                                Toast.makeText(getContext(), "No Login Data Here.....", Toast.LENGTH_SHORT).show();
                            }
                            Log.i("", response.body().get(0).getMsg().toString());
                            Toast.makeText(getContext(), response.body().get(0).getMsg().toString(), Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), response.body().get(0).getMsg().toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ArrayList<UserModel>> call, Throwable t) {
                    Log.e("Login",t.getStackTrace().toString());
                    // progressDialog.dismiss();
                }
            });

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_login: {
               // checkCredentialWithServer();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
                getActivity().finish();
                break;
            }
            case R.id.inputCompanyName:{
                getCompanyListDataFromServer();
                break;
            }
        }
    }

    public void getCompanyListDataFromServer(){
        Call<ArrayList<ChangeCompanyModel>> callCompanyList = WebServiceClient
                .getUserLoginService()
                .getChangeCompany();
        callCompanyList.enqueue(new Callback<ArrayList<ChangeCompanyModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ChangeCompanyModel>> call, Response<ArrayList<ChangeCompanyModel>> response) {
                if (response.isSuccessful()){
                    companyModelsList = response.body();
                    companyDialog = new ChangeCompanyDialog(getContext(),
                            companyModelsList,
                            LoginFragment.this);
                    companyDialog.show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<ChangeCompanyModel>> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }

    @Override
    public void onChangeCompanyName(ChangeCompanyModel changeCompanyModel, int position) {
        AppPreference.setChangeCompanyListPreferences(getContext(),changeCompanyModel);
        textViewCompanyName.setText(changeCompanyModel.getCobrName());
        companyDialog.dismiss();
    }
}