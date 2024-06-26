package com.ssinfomate.salesorder.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ssinfomate.salesorder.R;

public class PendingOrderFragment extends Fragment {

//    private PandingOrderViewModel mViewModel;

    public static PendingOrderFragment newInstance() {
        return new PendingOrderFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_panding_order, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(PandingOrderViewModel.class);
        // TODO: Use the ViewModel
    }

}