package com.ssinfomate.salesorder.ui.userlogin;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ssinfomate.salesorder.MainActivity;
import com.ssinfomate.salesorder.R;
import com.ssinfomate.salesorder.utils.AppPreference;

public class LogOutFragment extends Fragment {

    private LogOutViewModel mViewModel;

    public static LogOutFragment newInstance() {
        return new LogOutFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_log_out, container, false);
        final TextView textView = view.findViewById(R.id.text_logout);
        AppPreference.clearLoginDataPreferences(getContext());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(LogOutViewModel.class);
        // TODO: Use the ViewModel
    }
    @Override
    public void onResume() {
        super.onResume();
        Intent intent=new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}