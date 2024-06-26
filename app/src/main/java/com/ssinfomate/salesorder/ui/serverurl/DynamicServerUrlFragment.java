package com.ssinfomate.salesorder.ui.serverurl;

import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.utils.AppPreference;
import com.ssinfomate.salesorder.utils.DynamicServerURL;
import com.ssinfomate.salesorder.weservices.custregistrationmodel.StationListModel;

public class DynamicServerUrlFragment extends Fragment implements View.OnClickListener {

    AppCompatEditText editTextServerUrl;
    AppCompatButton buttonCancel,buttonSave;
    DynamicServerURL serverUrlViewModel;
    StationListModel serverUrlData;


    public static DynamicServerUrlFragment newInstance() {
        return new DynamicServerUrlFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_server_url, container, false);

        editTextServerUrl = view.findViewById(R.id.edit_dynamic_server_address);
        buttonCancel = view.findViewById(R.id.button_dynamic_server_cancel);
        buttonCancel.setOnClickListener(this);

        buttonSave = view.findViewById(R.id.button_dynamic_server_ok);
        buttonSave.setOnClickListener(this);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(DynamicServerUrlViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.button_dynamic_server_ok){
            if (!TextUtils.isEmpty(editTextServerUrl.getText())) {
                String srt = String.valueOf(editTextServerUrl.getText().toString());
                serverUrlViewModel.setServerURL(srt);
                AppPreference.setServerUrlDataPreferences(getContext(),serverUrlViewModel);
            }
            else{
                Toast.makeText(getContext(), "Fill all fields properly....!", Toast.LENGTH_SHORT).show();
            }
        }
        if (v.getId() == R.id.button_dynamic_server_cancel){
            getActivity().onBackPressed();
        }
    }
}